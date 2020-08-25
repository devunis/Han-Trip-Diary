package com.htd.service;

import com.htd.dto.UserLoginDto;
import com.htd.dto.UserModifyDto;
import com.htd.dto.UserRegisterDto;
import com.htd.jwt.JwtTokenProvider;
import com.htd.model.Role;
import com.htd.model.User;
import com.htd.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public List<User> getAllData() {
        return repository.findAll();
    }

    @Transactional
    public Long insertUser(final UserRegisterDto dto) {
        return repository.save(
                User.builder()
                        .uid(dto.getUid())
                        .pwd(encoder.encode(dto.getPwd()))
                        .email(dto.getEmail())
                        .name(dto.getName())
                        .role(Role.GUEST)
                        .build()
                ).getId();
    }

    @Transactional
    public Long modifyUser(UserModifyDto dto, Long id) {
        User user = repository.getOne(id);
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setPwd(encoder.encode(dto.getPwd()));
        log.info(dto.getPwd());
        log.info(user.getPwd());
        return user.getId();
    }

  @Transactional
  public Long deleteUser(final Long id){
        try{
           User temp = repository.getOne(id);
           repository.delete(temp);
           return temp.getId();
        }catch(Exception e){
            return Long.MIN_VALUE;
        }
  }

    public String login(UserLoginDto dto) {
        User user = repository.findByUidOrEmail(dto.getUid(), dto.getUid())
                .orElseThrow(()-> new IllegalArgumentException("아이디를 찾을 수 없습니다."));
        if (!encoder.matches(dto.getPwd(), user.getPwd())){
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        return jwtTokenProvider.createToken(user.getUsername(),new ArrayList<>(Collections.singleton(user.getRole().toString())));
    }
}
