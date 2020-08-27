package com.htd.controller;

import com.htd.dto.PlaceAddDto;
import com.htd.dto.PlaceModifyDto;
import com.htd.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PlaceController {
    private final PlaceService service;
    //명소의 정보 넣기

    @GetMapping("showplace")
    public ResponseEntity<?> showPlace(){
        return new ResponseEntity<>(service.showPlace(), HttpStatus.ACCEPTED);
    }

    @PostMapping("addplace")
    public ResponseEntity<?> addPlace(@RequestBody final PlaceAddDto placeAddDto){
        return new ResponseEntity<>(service.addPlace(1L,placeAddDto), HttpStatus.ACCEPTED);
    }
    @DeleteMapping("delete")
    public ResponseEntity<?> deletePlace(@RequestParam("id") final Long id){
         final Long deletedPlaceId = service.deletePlace(id);
        return deletedPlaceId > 0
                ? new ResponseEntity<>(deletedPlaceId, HttpStatus.OK)
                : new ResponseEntity<>(deletedPlaceId, HttpStatus.BAD_REQUEST);
    }
//
//    @PutMapping("/modify/{id}")
//    public ResponseEntity<?> modifyPlace(
//            @PathVariable Long id
//            , @RequestBody final PlaceModifyDto placeModifyDto){
//        return new ResponseEntity<>(service.modifyPlace(placeModifyDto, id ), HttpStatus.ACCEPTED);
//    }

}
