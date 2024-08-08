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

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Description is required")
    private String description;

    @NotNull(message = "Price is required")
    private Double price;

    @NotEmpty(message = "Image URL is required")
    private String imageUrl;

}
