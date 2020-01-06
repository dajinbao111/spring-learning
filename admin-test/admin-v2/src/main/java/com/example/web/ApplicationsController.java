package com.example.web;

import com.example.config.LocalCache;
import com.google.common.collect.ArrayListMultimap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@RestController
public class ApplicationsController {

    @GetMapping("/applications")
    public Collection<Map.Entry<String, String>> applications() {
        return LocalCache.appCache.entries();
    }
}
