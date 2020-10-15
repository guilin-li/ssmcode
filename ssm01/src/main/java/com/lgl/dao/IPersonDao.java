package com.lgl.dao;

import com.lgl.domain.Person;

import java.util.List;

public interface IPersonDao {


    List<Person> findAll();
    void save(Person person);

}
