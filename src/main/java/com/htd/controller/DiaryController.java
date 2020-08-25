package com.htd.controller;

import com.htd.dto.DiaryShowDto;
import com.htd.dto.DiaryWriteDto;
import com.htd.dto.UserResponseDto;
import com.htd.service.DiaryService;
import com.htd.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class DiaryController {
    private final DiaryService diaryService;
    private final UserService userService;

    @PostMapping("register")
    public ResponseEntity<Long> showDiary(@RequestBody DiaryWriteDto dto){
        return new ResponseEntity<>(diaryService.writeDiary(1L, dto),
                HttpStatus.CREATED);
    }

    @GetMapping("show")
    public ResponseEntity<List<DiaryShowDto>> showDiaries() {
        return ResponseEntity.ok(diaryService.showDiary());
    }

    @GetMapping("mmm")
    public UserResponseDto findAllUserDiaries() {
        Long userId = 1L;
        return userService.findAllUserDiaries(userId);
    }

}
