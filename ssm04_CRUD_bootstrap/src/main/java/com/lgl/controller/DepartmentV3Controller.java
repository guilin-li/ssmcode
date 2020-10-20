package com.lgl.controller;

import com.lgl.domain.Department;
import com.lgl.domain.Result;
import com.lgl.service.IDepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/deptv3") //写在类上面指定当前模块路径
public class DepartmentV3Controller {
    private static final Logger l = LoggerFactory.getLogger(DepartmentV3Controller.class);
    @Autowired
    private IDepartmentService departmentService;//controller调用 service层
    /*@RequestMapping(path="/xx")
     public 返回值类型 方法名(参数){ //页面提交过来的请求参数
        //..
        返回值类型决定返回给浏览器的内容
    }
     */
    @RequestMapping(path="/listUI",method = RequestMethod.GET)
    public String listUI(){

        return "list_depts";
    }

    //地址上带UI表示打开页面，不带的表示返回数据
    @RequestMapping(path="/list",method = RequestMethod.GET)
    public @ResponseBody
    //将list调jackson转成json字符串
    Object list(){
        //业务逻辑 调用查找所有的部门的方法
        List<Department> list =  departmentService.findAllDepartments();
        return Result.init(200,"",list);//返回对象需要被转成json字符串
    }
    @RequestMapping(path="/delete",method = RequestMethod.GET)
    public @ResponseBody  Object delete(Integer did){
        //获取did，执行对该条记录的删除
        l.info("delete did="+did);
        try {
            departmentService.deleteDepartmentById(did);
            return Result.init(200,"删除成功",null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.init(-200,"删除失败",null);
    }

    //保存一般是使用post提交
    @RequestMapping(path="/add",method = RequestMethod.POST)
    public @ResponseBody Object add(Department dept){
        l.info("add department="+dept);
        try {
            departmentService.saveDepartment(dept);
            return  Result.init(200,"添加成功",null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  Result.init(-200,"添加失败",null);
    }
    @RequestMapping(path = "/find", method = RequestMethod.GET)
    public @ResponseBody
    Object find(Integer did) {
        l.info("find did=" + did);//打数据
        if (did != null) {
            Department dept = departmentService.findDepartmentById(did);//查询回显需要的数据
            if (dept != null) {
                return Result.init(200, null, dept);//转成json返回页面
            }
        }
        return Result.init(-200, "没有查询结果", null);
    }
    @RequestMapping(path = "/update", method = RequestMethod.POST)
    @ResponseBody
    Object update(Department dept){
        l.info("update dept="+dept);
        try {
            departmentService.updateDepartmentById(dept);
            return Result.init(200, "更新成功", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.init(-200, "更新失败", null);
    }

    @RequestMapping(path="/tempUI")
    public String tempUI() {
        return "temp";
    }
}


