package com.example.springboot.database.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.query.Page;

import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee {

    @Id // this is telling hibernate this column is the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // this telling hibernate that the PK is auto increment
    @Column(name = "id")
    private Integer id;

    // this essentially a customerDAO.findByEmployeeId(123)
    // select c.* from customers c, employees e where c.sales_rep_employee_id = e.id and c.sales_rep_employee_id = <123>;
    @ToString.Exclude
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Customer> customers;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "office_id", nullable = true)
    private Office office;

    // in essence this field is a read only field and the the database will ignore it on update or insert
    @Column(name = "office_id", insertable = false, updatable = false)
    private Integer officeId;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "extension")
    private String extension;

    @Column(name = "email")
    private String email;

    @Column(name = "reports_to")
    private Integer reportsTo;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "vacation_hours")
    private Integer vacationHours;

    @Column(name = "profile_image_url")
    private String profileImageUrl;


}
