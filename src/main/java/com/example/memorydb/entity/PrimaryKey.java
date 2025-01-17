package com.example.memorydb.entity;

//데이터베이스의 고유한 값 (해당 ID를 지정)
public interface PrimaryKey {

    void setId(Long id);
    Long getId();
}
