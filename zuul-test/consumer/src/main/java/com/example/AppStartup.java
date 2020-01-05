package com.example;

import com.example.remote.BookRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartup implements CommandLineRunner {

    @Autowired
    private BookRemoteService bookRemoteService;

    @Override
    public void run(String... args) throws Exception {
        String book = bookRemoteService.getBook(1);
        System.out.println(book);
    }
}
