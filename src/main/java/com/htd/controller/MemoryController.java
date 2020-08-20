package com.htd.controller;

import com.htd.service.MemoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class MemoryController {
    private final MemoryService service;
}
