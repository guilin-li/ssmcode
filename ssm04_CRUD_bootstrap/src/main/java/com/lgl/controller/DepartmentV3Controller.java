package com.lgl.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lgl.domain.Department;
import com.lgl.domain.Result;
import com.lgl.service.IDepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/deptv3")
public class DepartmentV3Controller {
    private static final Logger l = LoggerFactory.getLogger(DepartmentV3Controller.class);
    @Autowired
    IDepartmentService iDepartmentService;
    //------------------bootstrap----
    @RequestMapping(path="/tempUI",method = RequestMethod.GET)
    public String tempUI(){
        return "temp";
    }
    @RequestMapping(path="/addUIV3",method = RequestMethod.GET)
    public String addUIV3(){
        return "add_v3";
    }
    @RequestMapping(path="/editUIV3",method = RequestMethod.GET)
    public String editUIV3(){
        return "edit_v3";
    }
    @RequestMapping(path="/listUIV3",method = RequestMethod.GET)
    public String listUIV3(){
        return "list_v3";
    }

    @RequestMapping(path="/pageUI",method = RequestMethod.GET)
    public String pageUI(Model model, Integer currPage, Integer pageSize){//你需要第几页数据，每页数据多条
        l.info("page currPage="+currPage);
        l.info("page pageSize="+pageSize);
        if(currPage==null) {
            currPage=1;
        }
        if(pageSize==null) {
            pageSize=5;
        }
        //给定分页参数
        PageHelper.startPage(currPage,pageSize);

        //一个全查，其他都交给PageInterceptor
        List<Department> list = iDepartmentService.findAllDepartments();

        PageInfo<Department> pi = new PageInfo<>(list);
        model.addAttribute("pi",pi);
        return "list_v3";
    }

}

