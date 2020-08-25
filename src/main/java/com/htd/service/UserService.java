package com.htd.service;

import com.htd.dto.UserModifyDto;
import com.htd.dto.UserRegisterDto;
import com.htd.model.Role;
import com.htd.model.User;
import com.htd.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;

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
}
