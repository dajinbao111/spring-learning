package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @GetMapping("/getbook/{id}")
    public String getBook(@PathVariable("id") Integer id) {
        String book = "";
        if (id == 1) {
            book = "Go语言核心编程";
        } else if (id == 2) {
            book = "Kubernetes权威指南";
        } else if (id == 3) {
            book = "Docker技术入门与实践";
        } else {
            book = "三体";
        }
        return book;
    }
}
