package com.inditex.tools.infraestructure.adapter.persistance.mapper;

import com.inditex.tools.domain.model.Product;
import com.inditex.tools.domain.model.Size;
import com.inditex.tools.infraestructure.adapter.persistance.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {

    public static Product toDomain(ProductEntity productEntity) {
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setName(productEntity.getName());
        product.setSalesUnits(productEntity.getSalesUnits());
        List<Size> sizes = List.of(
                new Size("S", productEntity.getStockS()),
                new Size("M", productEntity.getStockM()),
                new Size("L", productEntity.getStockL())
        );
        product.setStock(sizes);
        return product;
    }

    public static List<Product> toDomains(List<ProductEntity> productEntities) {
        if(productEntities ==  null) return null;
        List<Product> products = new ArrayList<>();
        for(ProductEntity productEntity :  productEntities) {
            products.add(toDomain(productEntity));
        }
        return products;
    }

}