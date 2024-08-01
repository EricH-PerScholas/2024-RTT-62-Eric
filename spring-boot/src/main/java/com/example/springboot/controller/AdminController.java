package com.example.springboot.controller;

import com.example.springboot.database.entity.User;
import com.example.springboot.security.AuthenticatedUserUtilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    private AuthenticatedUserUtilities authenticatedUserUtilities;


    @GetMapping("/dashboard")
    public ModelAndView dashboard() throws Exception {
        ModelAndView response = new ModelAndView("admin/dashboard");

        User user = authenticatedUserUtilities.getCurrentUser();
        log.debug(user.toString());

        return response;
    }


}
