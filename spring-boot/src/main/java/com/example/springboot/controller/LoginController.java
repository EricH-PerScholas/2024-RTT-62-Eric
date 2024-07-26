package com.example.springboot.controller;

import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Slf4j
@Controller
public class LoginController {



    @GetMapping("/create-account")
    public ModelAndView createAccount() {
        ModelAndView response = new ModelAndView("auth/create-account");

        return response;
    }



}
