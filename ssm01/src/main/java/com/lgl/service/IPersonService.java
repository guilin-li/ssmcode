package com.lgl.service;

import com.lgl.domain.Person;

import java.util.List;

public interface IPersonService {

    List<Person> findAll();

    void savePerson(Person person);

    void savePersons(List<Person> person);
}
