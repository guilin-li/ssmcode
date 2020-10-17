package com.lgl.dao;

import com.lgl.domain.Person;

import java.util.List;

public interface IPersonDao {
    //增删改查 crud
    List<Person> findAll();

    void save(Person person);

}
