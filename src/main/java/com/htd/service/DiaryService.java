package com.htd.service;

import com.htd.dto.DiaryShowDto;
import com.htd.dto.DiaryWriteDto;
import com.htd.dto.UserRegisterDto;
import com.htd.model.Diary;
import com.htd.model.Scope;
import com.htd.model.User;
import com.htd.repository.DiaryRepository;
import com.htd.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DiaryService {
    private final DiaryRepository diaryRepository;
    private final UserRepository userRepository;

    @Transactional
    public List<DiaryShowDto> showDiary() {
        return diaryRepository.findAll().stream()
                .map(DiaryShowDto::diaryShowDtoMapper)
                .collect(Collectors.toList());
    }

    public Long writeDiary(final Long userId, final DiaryWriteDto dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        Diary diary = diaryRepository.save(
                Diary.builder()
                        .title(dto.getTitle())
                        .picture(dto.getPicture())
                        .writer(user)
                        .content(dto.getContent())
                        .scope(Scope.ALL)
                        .build());

        diary.setWriter(user);
        user.getDiaries().add(diary);
        return diary.getId();

    }
//
//    public Long rewriteDiary(){
//
//    }
}
