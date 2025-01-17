package com.example.memorydb.user.service;

import com.example.memorydb.user.db.UserRepository;
import com.example.memorydb.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //서비스 로직이 들어가는 빈의 영역(데이터 클래스의 영역이다)
@RequiredArgsConstructor //스프링이 자동으로 UserRepository를 찾아줘야 함.(생성자로부터 주입받겠다)
public class UserService {

    @Autowired
    private final UserRepository userRepository; //UserService라는 객체가 생성될때 여기로 주입해줌.

    public UserEntity save(UserEntity user){

        //save
        return userRepository.save(user); //이 save는 SimpleRepository의 save임.
    }

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public void delete(Long id){
        userRepository.delete(id);
    }

    public Optional<UserEntity> findById(Long id){
        return userRepository.findById(id);
    }

}
