package com.htd.service;

import com.htd.dto.PlaceAddDto;
import com.htd.dto.PlaceModifyDto;
import com.htd.dto.PlaceShowDto;
import com.htd.model.Diary;
import com.htd.model.Place;
import com.htd.repository.DiaryRepository;
import com.htd.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PlaceService {
    private final PlaceRepository placeRepository;
    private final DiaryRepository diaryRepository;

    @Transactional
    public List<PlaceShowDto> showPlace() {
        return placeRepository.findAll().stream()
                .map(PlaceShowDto::placeShowDtoMapper)
                .collect(Collectors.toList());
    }

    @Transactional
    public Object addPlace(final Long diaryId, PlaceAddDto placeAddDto) {

        Diary diary = diaryRepository.findById(diaryId)
                .orElseThrow(() -> new RuntimeException("no place"));
        Place place = placeRepository.save(
                Place.builder()
                .call(placeAddDto.getCall())
                .description(placeAddDto.getDescription())
                .name(placeAddDto.getName())
                .picture(placeAddDto.getPicture())
                .tag(placeAddDto.getTag())
                .build());
        place.setMemory(diary);
        diary.getPlaces().add(place);
        return place.getName();

    }

    @Transactional
    public Long deletePlace(final Long id) {
           if(placeRepository.existsById(id))
               placeRepository.deleteById(id);
           return id;
    }


//    @Transactional
//    public Object modifyPlace(PlaceModifyDto placeModifyDto, Long id) {
//    }
}
