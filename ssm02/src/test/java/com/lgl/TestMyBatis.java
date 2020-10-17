package com.lgl;

import com.lgl.dao.IPersonDao;
import com.lgl.domain.Person;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMyBatis {
    private SqlSession session;
    @Before
    public void init(){
    InputStream in = TestMyBatis.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml");
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
    session = factory.openSession();
    }
    @After
    public void desory(){
        session.commit();
        session.close();
    }

    @Test
    public void test01(){
        //核心对象session
//        System.out.println(session);
        IPersonDao dao = session.getMapper(IPersonDao.class);
        List<Person> list = dao.findAll();
        System.out.println(list);
    }
    @Test
    public void test02(){
        //核心对象session
//        System.out.println(session);
        IPersonDao dao = session.getMapper(IPersonDao.class);
        dao.save(new Person("tony",2000.00));

    }
}
