package com.lgl.service.impl;

import com.lgl.dao.IPersonDao;
import com.lgl.domain.Person;
import com.lgl.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {
    @Autowired
    private IPersonDao iPersonDao;
    @Override
    public List<Person> findAll() {
//        System.out.println("findAll");
        List<Person> list = iPersonDao.findAll();
        return list;
    }

    @Override
    public void savePerson(Person person) {
//        System.out.println("savePerson");
        iPersonDao.save(person);


    }

    @Override
    public void savePersons(List<Person> persons) {
        for (int i=0;i < persons.size();i++){
            if (i==3){
                System.out.println(1/0);
            }
            iPersonDao.save(persons.get(i));
        }
    }
}
