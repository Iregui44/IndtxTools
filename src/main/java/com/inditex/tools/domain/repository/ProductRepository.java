package com.inditex.tools.domain.repository;

import com.inditex.tools.domain.model.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getProducts();
}
