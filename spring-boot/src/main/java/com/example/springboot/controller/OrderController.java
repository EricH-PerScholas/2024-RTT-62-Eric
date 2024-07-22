package com.example.springboot.controller;

import com.example.springboot.database.dao.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.util.*;

@Slf4j
@Controller
public class OrderController {

    @Autowired
    private OrderDAO orderDao;

    @GetMapping("/order/orderdetail")
    public ModelAndView orderDetail(@RequestParam Integer orderId) {
        ModelAndView response = new ModelAndView("order/orderdetail");

        List<Map<String,Object>> orderDetails = orderDao.getOrderDetails(orderId);
        response.addObject("orderDetails", orderDetails);

        return response;
    }


}
