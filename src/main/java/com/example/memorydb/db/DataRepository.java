package com.example.memorydb.db;

import java.util.List;
import java.util.Optional;

//CRUD 기능을 하는 Repository
public interface DataRepository<T, ID> extends Repository<T, ID> {

    //Create, Update ID가 존재하면 update, 없으면 save
    T save(T data); //abstract class

    //Read
    Optional<T> findById(ID id); //ID를 받아서 해당 데이터를 리턴

    List<T> findAll();

    //Delete
    void delete(ID id);
}
