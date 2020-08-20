package com.htd.service;

import com.htd.repository.MemoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemoryService {
    private final MemoryRepository repository;
}
