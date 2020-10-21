package com.example.third.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloword {
    @GetMapping
    public String sayhello(){
        return "hello merwa you can do it";
    }
}
