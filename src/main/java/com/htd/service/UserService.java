package com.htd.service;

import com.htd.dto.UserModifyDto;
import com.htd.dto.UserRegisterDto;
import com.htd.model.Role;
import com.htd.model.User;
import com.htd.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {
    private final UserRepository repository;

    @Transactional
    public List<User> getAllData() {
        return repository.findAll();
    }

    @Transactional
    public Long insertUser(final UserRegisterDto udto) {
        return repository.save(
                udto.toUserEntity()).getId();
    }

    @Transactional
    public Long modifyUser(UserModifyDto userModifyDto, Long id) {
        User user = repository.getOne(id);
        user.setEmail(userModifyDto.getEmail());
        user.setName(userModifyDto.getName());
        user.setPwd(userModifyDto.getPwd());
        log.info(userModifyDto.getPwd());
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
            return 6787L;
        }
  }
}
