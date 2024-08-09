package com.example.springboot.database.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
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

    // this is allowing hibernate to make this query
    // select e.* from customers c, employee e where c.sales_rep_employee_id = e.id and c.id = (this.id);
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "sales_rep_employee_id", nullable = true)
    private Employee employee;


    // you can only use a primitive type if the column is not nullable
    // if the column is nullable then you have to use the Integer wrapper class because a primitive
    // can not be set to null
    // Because we added the @ManyToOne annotation (just above) this column is now considered a duplicate in hibernate
    // by adding the insertable = false and the updatable = false we are essentially turning this into a read only variable!!!!!
    // this will happen for any FK that we use with a @ManyToOne annotation
    @Column(name = "sales_rep_employee_id", insertable = false, updatable = false)
    private Integer salesRepEmployeeId;

    // when there is a DECIMAL type in the database it should be a Double in java
    // hibernate or other tools will guide you towards using a BigDecimal, while technically possible you are increasing
    // your own hardship by using a BigDecimal
    @Column(name = "credit_limit", columnDefinition = "DECIMAL")
    private Double creditLimit;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(customerName, customer.customerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerName);
    }
}
