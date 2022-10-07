package com.product;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "product_tbl")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "unit_Of_Measure")
    private String unitOfMeasure;
    @Column(name = "launch_date")
    private String launchDate;


}
