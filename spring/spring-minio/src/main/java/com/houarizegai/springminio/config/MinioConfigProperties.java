package com.houarizegai.springminio.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.minio")
@Getter
@Setter
public class MinioConfigProperties {

    private String url;
    private String accessKey;
    private String secretKey;
    private String bucket;
}
