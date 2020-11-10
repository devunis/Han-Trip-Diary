package com.webserver.shoppingmall.user.service.impl;

import com.webserver.shoppingmall.user.repository.UserRepository;
import com.webserver.shoppingmall.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
}
