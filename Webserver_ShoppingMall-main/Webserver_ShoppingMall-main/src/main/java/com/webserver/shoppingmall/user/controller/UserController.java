package com.webserver.shoppingmall.user.controller;

import com.webserver.shoppingmall.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

}
