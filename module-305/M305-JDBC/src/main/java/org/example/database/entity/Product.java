package org.example.database.entity;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "productline_id")
    private Integer productLineId;

    @Column(name = "product_scale")
    private String productScale;

    @Column(name = "product_vendor")
    private String productVendor;

    @Column(name = "product_description", columnDefinition="TEXT")
    private String productDescription;

    @Column(name = "quantity_in_stock", columnDefinition = "SMALLINT")
    private Integer quantityInStock;

    @Column(name = "buy_price", columnDefinition = "DECIMAL")
    private Double buyPrice;

    @Column(name = "msrp", columnDefinition = "DECIMAL")
    private Double msrp;


}
