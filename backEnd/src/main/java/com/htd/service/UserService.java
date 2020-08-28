package com.htd.service;

import com.htd.dto.UserLoginDto;
import com.htd.dto.UserModifyDto;
import com.htd.dto.UserRegisterDto;

import com.htd.jwt.JwtTokenProvider;
import com.htd.dto.UserResponseDto;
import com.htd.model.Friend;
import com.htd.model.Role;
import com.htd.model.User;
import com.htd.repository.FriendRepository;
import com.htd.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {
    private final UserRepository repository;
    private final FriendRepository friendRepository;
    private final PasswordEncoder encoder;
    private final JwtTokenProvider jwtTokenProvider;


    @Transactional
    public List<UserResponseDto> getAllData() {
        return repository.findAll().stream()
                .map(UserResponseDto::userResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long insertUser(final UserRegisterDto dto) {
        User user = repository.save(
                User.builder()
                        .username(dto.getUsername())
                        .pwd(encoder.encode(dto.getPwd()))
                        .email(dto.getEmail())
                        .name(dto.getName())
                        .build());
        user.setFriends(friendRepository.save(
                Friend.builder()
                        .friendList(new ArrayList<>())
                        .build()));
        return user.getId();
    }

    @Transactional
    public Long modifyUser(UserModifyDto dto, Long id) {
        User user = repository.getOne(id);
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setPwd(encoder.encode(dto.getPwd()));
        return user.getId();
    }

  @Transactional
  public Long deleteUser(final Long id){
        User temp = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("not found exception..."));
        repository.deleteById(id);
        return temp.getId();
  }
    @Transactional
    public String loginUser(UserLoginDto dto) {
        User user = repository.findByUsernameOrEmail(dto.getUsername(), dto.getUsername())
                .orElseThrow(() -> new RuntimeException("can't find username : " + dto.getUsername() ));
        if (! encoder.matches(dto.getPwd(), user.getPassword())){
            throw new RuntimeException("wrong password! ");
        }
        return jwtTokenProvider.createToken(user.getUsername(), user.getRoles());

    }
        @Transactional
        public UserResponseDto findAllUserDiaries(Long userId) {
            User user = repository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("can't find user id : " + userId));

            return UserResponseDto.userResponseDto(user);
        }
}
