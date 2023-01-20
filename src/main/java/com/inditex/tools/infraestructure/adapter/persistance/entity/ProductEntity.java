package com.inditex.tools.infraestructure.adapter.persistance.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name="PRODUCTS")
public class ProductEntity {

    @Id
    @Column(name="ID")
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name="SALES_UNITS")
    private int salesUnits;

    @Column(name="STOCK_S")
    private int stockS;

    @Column(name="STOCK_M")
    private int stockM;

    @Column(name="STOCK_l")
    private int StockL;

}
