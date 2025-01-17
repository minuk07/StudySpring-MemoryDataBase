package com.example.memorydb.config;

import com.example.memorydb.user.db.UserRepository;
import org.springframework.context.annotation.Configuration;

//@Configuration //Spring이 시작될 때 Configuration을 찾아서 특정한 내용들을 spring context라는 영역에 new 생성자를 통해 객체를 만들어줌.
//public class DataBaseConfig {
//
//    public UserRepository userRepository() { //이제부터 bin으로 만들어지면서 spring에 의해서 관리됨.
//        return new UserRepository();
//    }
//}
