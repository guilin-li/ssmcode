package com.lgl;

import com.lgl.domain.Person;
import com.lgl.service.IPersonService;
import com.lgl.service.impl.PersonServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestPersonService {
    private static final Logger log = Logger.getLogger(TestPersonService.class.getName());
    @Autowired
    IPersonService personService;
    @Test
    public void test01(){
        //创建业务对象
//        IPersonService personService = new PersonServiceImpl();
        //调用查询
        log.info(personService+"");

        List<Person> list = personService.findAll();
        log.info(list+"");

        //调用保存
        Person person = new Person("jack",1000.00);
        personService.savePerson(person);
        List<Person> list1 = personService.findAll();
        log.info(list1+"");

    }
    @Test
    public void test02(){
        System.out.println(personService);

    }
    @Test
    public void test03(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("jack22",5000.00));
        personList.add(new Person("rose22",56000.00));
        personList.add(new Person("jack22",58000.00));

        personService.savePersons(personList);
    }
}
