package com.lgl.dao.Impl;

import com.lgl.dao.IPersonDao;
import com.lgl.domain.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDaoImpl implements IPersonDao {
    @Override
    public List<Person> findAll() {
        System.out.println("findAll dao");
        return null;
    }

    @Override
    public void save(Person person) {

        System.out.println("save dao");
    }
}

