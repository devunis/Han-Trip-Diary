package com.htd.controller;

import com.htd.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService service;

}
