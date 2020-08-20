package com.htd.controller;

import com.htd.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class PlaceController {
    private final PlaceService service;
}
