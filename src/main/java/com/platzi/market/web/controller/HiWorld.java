package com.platzi.market.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sayHi")
public class HiWorld {
    @GetMapping("/")
    public String sayHi() {
        return "Hi There! :)";
    }
}
