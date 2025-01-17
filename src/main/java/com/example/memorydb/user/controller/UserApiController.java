package com.example.memorydb.user.controller;

import com.example.memorydb.user.model.UserEntity;
import com.example.memorydb.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Http Request가 들어오는 내용을 처리하고 Response를 처리하는 영역.
@RequestMapping("api/user")
@RequiredArgsConstructor //생성자 메소드로 채워달라는 어노테이션
public class UserApiController {

    private final UserService userService; //userService를 스프링으로부터 주입받음.

    @PutMapping("") //update도 활용
    public UserEntity create(
            @RequestBody UserEntity userEntity
    ){
        return userService.save(userEntity); //사용자로부터 들어온 내용을 save하고 리턴
    }

    @GetMapping("/all")
    public List<UserEntity> findAll(){
        return userService.findAll();
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    @GetMapping("/id/{id}")
    public UserEntity findOne(@PathVariable Long id){
        var response = userService.findById(id);
        return response.get(); //null 값이 리턴될 수 있도록
    }

    @GetMapping("/score/{score}")
    public List<UserEntity> findOverScore(@PathVariable int score){
        return userService.filtersScore(score);
    }
}
