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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductDAO productDao;

    @GetMapping("/create")
    public ModelAndView createProduct(@RequestParam(required = false) Integer id) {
        ModelAndView response = new ModelAndView("product/create");

        // if the id is not null then we are editing a product
        if ( id != null ) {
            // get the product from the database
            Product product = productDao.findById(id);

            // setting the database data on the form
            CreateProductFormBean form = new CreateProductFormBean();
            form.setId(product.getId());
            form.setName(product.getProductName());
            form.setDescription(product.getProductDescription());
            form.setPrice(product.getBuyPrice());
            form.setImageUrl(product.getImageUrl());

            response.addObject("form", form);
        }

        return response;
    }

    @GetMapping("/createSubmit")
    public ModelAndView createProductSubmit(@Valid CreateProductFormBean form, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView("product/create");

        log.info(form.toString());

        if (bindingResult.hasErrors()) {
            response.addObject("bindingResult", bindingResult);
            return response;
        }

        // setting the form data on the database entity
        // we are going to make the assumption that this is an edit and we are going to
        // attempt to load this from the database
        //Product product = new Product();
        Product product = productDao.findById(form.getId());
        if ( product == null ) {
            // it was not in the database
            product = new Product();
        }

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

        form.setId(product.getId());
        response.addObject("form", form);

        // if you want to redirect to another page
        //response.setView("redirect:/someohterurl?id=" + product.getId());

        return response;
    }


}
