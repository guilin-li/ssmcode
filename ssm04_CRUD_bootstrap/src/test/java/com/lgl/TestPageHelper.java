package com.lgl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
public class TestPageHelper {
    @Autowired
    private IDepartmentService departmentService;

    private static final Logger l = LoggerFactory.getLogger(TestPageHelper.class);
    @Test
    public void test01(){

        //调用分页插件只要两行代码
        PageHelper.startPage(1,10);//参1：当前页 参2 每页记录数

        //我们只需要做一个最简单的查询
        List<Department> list = departmentService.findAllDepartments();

        PageInfo<Department> pageInfo = new PageInfo<>(list);

        l.info("test01 pageInfo="+pageInfo);

    }
}
