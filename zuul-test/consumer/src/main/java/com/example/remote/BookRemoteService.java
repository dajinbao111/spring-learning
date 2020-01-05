package com.example.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("test-producer")
public interface BookRemoteService {

    @RequestMapping("/getbook/{id}")
    String getBook(@PathVariable("id") Integer id);
}
