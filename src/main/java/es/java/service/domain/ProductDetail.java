package es.java.service.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name="tbl_product_detail")
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Size(min = 1)
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "availability", nullable = false)
    private Boolean availability;
}
