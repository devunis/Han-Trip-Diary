package com.htd.controller;

import com.htd.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class FriendController {
    private final FriendService friendService;

    @PostMapping("friend/{follow1}/{follow2}")
    public ResponseEntity<?> addFriend(@PathVariable final Long follow1, @PathVariable final Long follow2){
        return new ResponseEntity<>(friendService.addFriend(follow1, follow2), HttpStatus.ACCEPTED);
    }
}
