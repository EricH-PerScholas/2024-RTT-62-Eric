package com.example.springboot.form;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateProductFormBean {

    // this will be populated when we are editing a product
    // it will be null if this is a create product
    private Integer id;

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Description is required")
    private String description;

    @NotNull(message = "Price is required")
    private Double price;

    @NotEmpty(message = "Image URL is required")
    private String imageUrl;

}
