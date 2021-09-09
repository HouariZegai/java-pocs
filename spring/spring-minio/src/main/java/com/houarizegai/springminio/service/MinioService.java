package com.houarizegai.springminio.service;

import com.houarizegai.springminio.config.MinioConfigProperties;
import com.houarizegai.springminio.exception.MinioException;
import io.minio.*;
import io.minio.errors.*;
import io.minio.messages.Item;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class MinioService {

    private final MinioClient minioClient;
    private final MinioConfigProperties minioConfigProperties;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<Item> getLists() {
        ListObjectsArgs args = ListObjectsArgs.builder()
                .bucket(minioConfigProperties.getBucket())
                .prefix("")
                .recursive(false)
                .build();

        Iterable<Result<Item>> results = minioClient.listObjects(args);

        return StreamSupport.stream(results.spliterator(), true)
                .map(this::extractItem)
                .collect(Collectors.toList());
    }

    public InputStream get(String object) {
        GetObjectArgs args = GetObjectArgs.builder()
                .bucket(minioConfigProperties.getBucket())
                .object(object)
                .build();
        try {
            return minioClient.getObject(args);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new MinioException(e.getMessage(), e);
        }
    }

    public void put(String object, InputStream file) {
        try {
            PutObjectArgs args = PutObjectArgs.builder()
                    .bucket(minioConfigProperties.getBucket())
                    .object(object)
                    .stream(file, file.available(), -1)
                    .build();
            minioClient.putObject(args);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new MinioException(e.getMessage(), e);
        }
    }

    public void remove(String object) {
        try {
            RemoveObjectArgs args = RemoveObjectArgs.builder()
                    .bucket(minioConfigProperties.getBucket())
                    .object(object)
                    .build();
            minioClient.removeObject(args);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new MinioException(e.getMessage(), e);
        }
    }

    private Item extractItem(Result<Item> item) {
        try {
            return item.get();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new MinioException(e.getMessage(), e);
        }
    }
}
