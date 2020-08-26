package com.htd.controller;

import com.htd.dto.UserLoginDto;
import com.htd.dto.UserModifyDto;
import com.htd.dto.UserRegisterDto;
import com.htd.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService service;

    @GetMapping("/info")
    public ResponseEntity<?> getAllData(){
        return new ResponseEntity<>(service.getAllData(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> insertUser(@RequestBody final UserRegisterDto dto){
        return new ResponseEntity<>(service.insertUser(dto), HttpStatus.ACCEPTED);
    }

//   @PostMapping("/login")
//   public ResponseEntity<?> loginUser(@RequestBody final UserLoginDto dto){
//        return new ResponseEntity<>(service.loginUser(dto), HttpStatus.ACCEPTED);
//   }


    @PutMapping("/modify/{id}")
    public ResponseEntity<?> modifyUser(
            @PathVariable Long id
            ,@RequestBody final UserModifyDto dto){
        return new ResponseEntity<>(service.modifyUser(dto,id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        return new ResponseEntity<>(service.deleteUser(id), HttpStatus.ACCEPTED);
    }

}
