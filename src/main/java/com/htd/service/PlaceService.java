package com.htd.service;

import com.htd.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PlaceService {
    private final PlaceRepository service;
}
