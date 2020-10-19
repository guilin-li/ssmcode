package com.lgl;

import com.lgl.domain.Department;
import com.lgl.service.IDepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestDepartmentService {
    private static final Logger l = LoggerFactory.getLogger(TestDepartmentService.class);
    @Autowired
    IDepartmentService service;

    @Test
    public void test01() {//
        List<Department> list = service.findAllDepartments();
        l.info("test01 list=" + list);
    }
    @Test
    public void test02() {//
        Department dept = new Department("UI设计部门2");
        service.saveDepartment(dept);
    }
    @Test
    public void test03() {//

        service.deleteDepartmentById(1);
    }

    @Test
    public void test04() {//
        Department dept = new Department();
        dept.setDid(3);
        dept.setDname("最牛部门");
        service.updateDepartmentById(dept);
    }
    @Test
    public void test05() {//为了方便用户修改，会在打开修改页面时做一个回显
        //获取id，查找数据，再将数据带到页面赋值

        Department dept = service.findDepartmentById(4);
        l.info("test05 dept="+dept);
    }



}


