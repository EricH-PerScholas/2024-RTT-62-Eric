package com.example.springboot.controller;

import com.example.springboot.database.dao.ProductDAO;
import com.example.springboot.database.entity.Product;
import com.example.springboot.form.CreateProductFormBean;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductDAO productDao;

    @GetMapping("/create")
    public ModelAndView createProduct() {
        ModelAndView response = new ModelAndView("product/create");
        return response;
    }

    @GetMapping("/createSubmit")
    public ModelAndView createProductSubmit(@Valid CreateProductFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView("product/create");

        log.info(form.toString());

        if (bindingResult.hasErrors()) {
            response.addObject("bindingResult", bindingResult);
            response.addObject("form", form);
            return response;
        }

        Product product = new Product();
        product.setProductName(form.getName());
        product.setProductDescription(form.getDescription());
        product.setBuyPrice(form.getPrice());
        product.setImageUrl(form.getImageUrl());

        // this is just to make it work with classic models
        product.setMsrp(100.0);
        product.setProductCode("code");
        product.setProductLineId(1);
        product.setProductScale("1:1");
        product.setProductVendor("vendor");
        product.setQuantityInStock(100);


        // save the product to the database
        productDao.save(product);

        return response;
    }


}
