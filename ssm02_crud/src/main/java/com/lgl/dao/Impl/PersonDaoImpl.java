package com.lgl.dao.Impl;

import com.lgl.dao.IPersonDao;
import com.lgl.domain.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//  @Repository
@Deprecated
public class PersonDaoImpl implements IPersonDao {
    @Override
    public List<Person> findAll() {
        System.out.println("findAll dao");
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person p = new Person("jack"+i,100.00);
            p.setId(i);
            list.add(p);
        }
        return list;
    }

    @Override
    public void save(Person person) {

        System.out.println("save dao");
    }
}

