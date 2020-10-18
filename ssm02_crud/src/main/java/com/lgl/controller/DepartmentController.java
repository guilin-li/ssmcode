package com.lgl.controller;

import com.lgl.domain.Department;
import com.lgl.service.IDepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/dept")
public class DepartmentController {
    private static  final Logger l = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private IDepartmentService iDepartmentService;
    @RequestMapping(path ="/list",method = RequestMethod.GET)
    public String list(Model model){
        List<Department> depts = iDepartmentService.findAllDepartments();
        l.info("list   depts="+depts);
        //数据添加到页面
        model.addAttribute("depts",depts);
        return "list_depts";
    }

    @RequestMapping(path="/addUI",method = RequestMethod.GET)
    public String addUI(){
        l.info("addUI ");
        return "add_dept";
    }


    @RequestMapping(path ="/save",method = RequestMethod.POST)
    public String save(Department dept,Model model){
        if (dept.getDname() != null && !"".equals(dept.getDname())) {
            iDepartmentService.saveDepartment(dept);
            l.info("save dept="+dept);
            return "redirect:/dept/list";
        }else{
            model.addAttribute("error_msg","部门名称不能为空");
            return "forward:/error.jsp";
        }

    }

    //delete
    @RequestMapping(path = "/delete",method = RequestMethod.GET)
    public String delete(Integer did){
        l.info("delete  did = "+did);
        iDepartmentService.deleteDepartmentById(did);
        return "redirect:/dept/list";
    }


    //updateUI?did=23
    @RequestMapping(path = "/updateUI",method = RequestMethod.GET)
    public String updateUI(Integer did,Model model){
        l.info("updateUI did = "+did);
        Department department = iDepartmentService.findDepartmentById(did);
        model.addAttribute("dept",department);
        return "update_dept";
    }

    //update
    @RequestMapping(path="/update",method = RequestMethod.POST)
    public String update(Department dept){
        //打印
        l.info("update  dept="+dept);
        //调用service
        iDepartmentService.updateDepartmentById(dept);//
        //跳到查询页面
        return "redirect:/dept/list";
    }

}


