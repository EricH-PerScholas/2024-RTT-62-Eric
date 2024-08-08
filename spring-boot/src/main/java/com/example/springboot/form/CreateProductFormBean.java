package com.example.springboot.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateProductFormBean {

    private String name;
    private String description;
    private Double price;
    private String imageUrl;

}
