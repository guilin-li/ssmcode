package com.lgl;

import com.lgl.domain.Person;
import com.lgl.service.IPersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestPersonService {
    private static  final Logger log = Logger.getLogger(TestPersonService.class.getName());
    @Autowired
    IPersonService personService;
    @Test
    public void test01(){

//        IPersonService personService = new PersonServiceImpl();
        log.info(personService+"");
        List<Person> list = personService.findAll();

        log.info(list+"");
        Person person = new Person("jack",100.00);
        personService.savePerson(person);

        List<Person> list1 = personService.findAll();
        log.info(list1+"");
    }

    @Test
    public void test02(){
        System.out.println(personService);

    }

}
