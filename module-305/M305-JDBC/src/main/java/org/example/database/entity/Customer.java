package org.example.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "contact_firstname")
    private String contactFirstname;

    @Column(name = "contact_lastname")
    private String contactLastname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "country")
    private String country;

    // you can only use a primitive type if the column is not nullable
    // if the column is nullable then you have to use the Integer wrapper class because a primitive
    // can not be set to null
    @Column(name = "sales_rep_employee_id")
    private Integer salesRepEmployeeId;

    // when there is a DECIMAL type in the database it should be a Double in java
    // hibernate or other tools will guide you towards using a BigDecimal, while technically possible you are increasing
    // your own hardship by using a BigDecimal
    @Column(name = "credit_limit", columnDefinition = "DECIMAL")
    private Double creditLimit;

}
