package com.inditex.tools.infraestructure.adapter.persistance.repository;

import com.inditex.tools.domain.model.Product;
import com.inditex.tools.infraestructure.adapter.persistance.crud.ProductCrudRepository;
import com.inditex.tools.infraestructure.adapter.persistance.mapper.ProductMapper;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@NoArgsConstructor
@Repository
public class ProductRepository implements com.inditex.tools.domain.repository.ProductRepository {

    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Override
    public List<Product> getProducts() {
        return ProductMapper.toDomains(productCrudRepository.findAll());
    }
}
