package com.example.memorydb.db;

import com.example.memorydb.entity.Entity;

import java.util.*;
import java.util.stream.Collectors;

//메모리 타입의 repository
//상속받는 애들이 구현을 해도 되고 안해도 되는 형태로 만들어줌.
abstract public class SimpleDataRepository<T extends Entity, ID extends Long> implements DataRepository<T, ID>{
    //T extends Entity : Entity를 상속받은 애들만 이 타입에 지정해줄 수 있음.
    //ID extends Long : ID에 대한 타입은 Long  타입으로 제한.
    //저장공간
    private List<T> dataList = new ArrayList<T>();

    private static long index = 0;

    private Comparator<T> sort =  new Comparator<T>() { //sorting
        @Override
        public int compare(T o1, T o2) {
            return Long.compare(o1.getId(), o2.getId());
        }
    };


    //CRUD 실제 구현체
    //Create
    @Override
    public T save(T data) {

        if(Objects.isNull(data)){
            throw new RuntimeException("Data is null"); //데이터가 null이면 안된다고 지정.
        }

        //데이터가 이미 있는지 확인해야 됨
        var prevData = dataList.stream()
                .filter(it -> { //현재 들어있는 데이터의 getId와 데이터의 getId가 동일한 경우
                    return it.getId().equals(data.getId());
                })
                .findFirst(); //조건을 만족하는 첫번째 요소를 Optional 형태로 반환.

        if(prevData.isPresent()){//Update
            //기존 데이터가 있는경우
            dataList.remove(prevData.get()); //삭제하고
            dataList.add(data); //집어 넣음.
        }
        else { //기존 데이터가 없는 경우(Create)
            index++;
            //unique한 id를 지정해줘야 함.
            data.setId(index); //Entity로 제한해둠.
            dataList.add(data);
        }

        return data;
    }

    //Read
    @Override
    public Optional<T> findById(ID id){ //id의 타입을 Long으로 제한해둠.
        return dataList.stream()
                .filter(it ->{ //List에 들어있는 id와 찾고자하는 id가 동일하면 return
                    return (it.getId().equals(id));
                })
                .findFirst();
    }

    @Override
    public List<T> findAll() {
        return dataList.stream() //정렬해서 리턴
                .sorted(sort)
                .collect(Collectors.toList());
    }

    //Delete
    @Override
    public void delete(ID id) {
        var deleteEntity = dataList.stream()
                .filter(it ->{ //List에 들어있는 id와 찾고자하는 id가 동일하면 return
                    return (it.getId().equals(id));
                })
                .findFirst();

        if (deleteEntity.isPresent()) {
            dataList.remove(deleteEntity.get());
        }
    }
}
