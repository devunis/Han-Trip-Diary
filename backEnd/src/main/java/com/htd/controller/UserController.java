package com.htd.controller;

import com.htd.dto.UserLoginDto;
import com.htd.dto.UserModifyDto;
import com.htd.dto.UserRegisterDto;
import com.htd.dto.UserResponseDto;
import com.htd.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService service;


    @GetMapping("/member")
    public ResponseEntity<?> getAllData(){
        return new ResponseEntity<>(service.getAllData(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/member")
    public ResponseEntity<?> insertUser(@RequestBody final UserRegisterDto dto){
        return new ResponseEntity<>(service.insertUser(dto), HttpStatus.CREATED);
    }

   @PostMapping("/login")
   public ResponseEntity<?> loginUser(@RequestBody final UserLoginDto dto){
        return new ResponseEntity<>(service.loginUser(dto), HttpStatus.OK);
   }

   @PostMapping("/authenticate")
   public ResponseEntity<?> createAuthenticationToken(@RequestBody UserLoginDto dto) throws Exception {
        return ResponseEntity.ok(service.authenticate(dto));
   }


    @PutMapping("/member/{id}")
    public ResponseEntity<?> modifyUser(
            @PathVariable Long id
            ,@RequestBody final UserModifyDto dto){
        return new ResponseEntity<>(service.modifyUser(dto,id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/member/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        return new ResponseEntity<>(service.deleteUser(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("member/{id}")
    public ResponseEntity<?> findAllUserDiaries(@PathVariable Long id) {
        return new ResponseEntity<>(service.findAllUserDiaries(id), HttpStatus.OK);
    }
}
