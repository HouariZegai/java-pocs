package com.houarizegai.springminio.controller;

import com.houarizegai.springminio.service.MinioService;
import io.minio.MinioClient;
import io.minio.messages.Item;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.sql.ResultSet;
import java.util.List;

@RestController
@RequestMapping("/api/files")
@RequiredArgsConstructor
public class MinioController {

    private final MinioService minioService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping
    public ResponseEntity<List<Item>> getLists() {
        return ResponseEntity.ok(minioService.getLists());
    }

    @GetMapping("/{object}")
    public void getFileByPath(@PathVariable String object, HttpServletResponse response) {
        InputStream inputStream = minioService.get(object);

        response.addHeader("Content-disposition", "attachment;filename=" + object);
        response.setContentType(URLConnection.guessContentTypeFromName(object));

        try {
            IOUtils.copy(inputStream, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @PostMapping("/{object}")
    public ResponseEntity<String> uploadFile(@PathVariable String object, @RequestParam MultipartFile file) {
        try {
            minioService.put(object, file.getInputStream());

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<>("Cannot read the file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{object}")
    public ResponseEntity<Void> deleteFileByPath(@PathVariable String object) {
        minioService.remove(object);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
