package com.example.memorydb.user.db;

import com.example.memorydb.db.SimpleDataRepository;
import com.example.memorydb.user.model.UserEntity;
import org.springframework.stereotype.Service;

@Service //내부에 있는 클래스면 이걸 사용하면 됨.
public class UserRepository extends SimpleDataRepository<UserEntity, Long> {
    //UserRepository라는 공간이 생기고, 각각의 데이터들은 Long 타입의 id를 가짐.
    //각각 저장되는 타입은 UserEntity라는 내용으로 저장.

}
