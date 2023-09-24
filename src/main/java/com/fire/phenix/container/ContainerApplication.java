package com.fire.phenix.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Hello world!
 */
@EnableAsync
@EnableCaching
@EnableScheduling
@SpringBootApplication
public class ContainerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ContainerApplication.class, args);
    }
}
