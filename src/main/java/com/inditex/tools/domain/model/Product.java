package com.inditex.tools.domain.model;

import java.util.List;

public class Product {
    private Long id;
    private String name;
    private int salesUnits;
    private List<Size> stock;
    private int weightOrder;

    public Product(Long id, String name, int salesUnits, List<Size> stock) {
        this.id = id;
        this.name = name;
        this.salesUnits = salesUnits;
        this.stock = stock;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalesUnits() {
        return salesUnits;
    }

    public void setSalesUnits(int salesUnits) {
        this.salesUnits = salesUnits;
    }

    public List<Size> getStock() {
        return stock;
    }

    public void setStock(List<Size> stock) {
        this.stock = stock;
    }

    public void addWeightOrder(int weightOrder) {
        this.weightOrder += weightOrder;
    }

    public int getWeightOrder() {
        return weightOrder;
    }

    public int getQuantityTotalSize() {
        int quantity = 0;
        for(Size size : stock) {
            quantity += size.getQuantity();
        }
        return quantity;
    }
}
