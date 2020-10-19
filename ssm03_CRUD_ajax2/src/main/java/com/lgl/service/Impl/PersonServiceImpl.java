package com.lgl.service.Impl;

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
        List<Person> list = iPersonDao.findAll();
//        System.out.println("findAll");
        return list;
    }

    @Override
    public void savePerson(Person person) {
        iPersonDao.save(person);
//        System.out.println("savePerson");

    }

    @Override
    public void savePersons(List<Person> person) {
        for (int i = 0;i<person.size();i++){
            if(i==2){
                System.out.println(1/0);
            }
            iPersonDao.save(person.get(i));
        }

    }
}
