package com.lgl;

import com.lgl.dao.IPersonDao;
import com.lgl.domain.Person;
import com.lgl.service.IPersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestDataSource {
    private static  final Logger log = Logger.getLogger(TestDataSource.class.getName());
    @Autowired
    IPersonDao dao;
    @Test
    public void test01() throws SQLException {
        List<Person> data = dao.findAll();
        System.out.println(data);

    }
    @Test
    public void test02() throws SQLException {
        Person p =  new Person("hello",2000.00);
        dao.save(p);
    }

}
