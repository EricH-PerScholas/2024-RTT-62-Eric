package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    // this URL is going to be localhost:8080/customer/list
    @GetMapping("/search")
    public ModelAndView list() {
       return null;
    }

    @GetMapping("/detail")
    public ModelAndView detail() {
       return null;
    }

}
