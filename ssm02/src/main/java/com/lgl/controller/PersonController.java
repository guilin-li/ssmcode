package com.lgl.controller;

import com.lgl.domain.Person;
import com.lgl.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private IPersonService personService;

    @RequestMapping (path = "/list",method = RequestMethod.GET)
    public String list(Model model){
        List<Person> list = personService.findAll();
        System.out.println("list() list= "+list);

        model.addAttribute("list",list);
        return "list";
    }

}
