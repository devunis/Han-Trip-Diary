package com.webserver.shoppingmall.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("hello/{name}")
    public String greeting(@PathVariable("name") final String name) {
        return "hello " + name;
    }
}
