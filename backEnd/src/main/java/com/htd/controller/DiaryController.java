package com.htd.controller;

import com.htd.dto.DiaryModifyDto;
import com.htd.dto.DiaryShowDto;
import com.htd.dto.DiaryWriteDto;
import com.htd.dto.UserResponseDto;
import com.htd.service.DiaryService;
import com.htd.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class DiaryController {
    private final DiaryService diaryService;
    private final UserService userService;

    @PostMapping("diary")
    public ResponseEntity<Long> writeDiary(@RequestBody DiaryWriteDto dto){
        return new ResponseEntity<>(diaryService.writeDiary(1L, dto),
                HttpStatus.CREATED);
    }

    @GetMapping("diary")
    public ResponseEntity<List<DiaryShowDto>> showDiaries() {
        return ResponseEntity.ok(diaryService.showDiary());
    }

    @PutMapping("diary/{id}")
    public ResponseEntity<?> modifyDiary(
            @PathVariable Long id
            ,@RequestBody final DiaryModifyDto dto){
        return new ResponseEntity<>(diaryService.modifyDiary(dto, id),HttpStatus.ACCEPTED);

    }

}
