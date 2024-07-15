package com.example.springboot.form;


import lombok.*;

@Getter
@Setter
@ToString
public class CreateEmployeeFormBean {

    private String email;
    private String firstName;
    private String lastName;

    // we are going to make this data type an integer because we know we want to write to the database as an integer
    private Integer reportsTo;

}
