package com.inditex.tools.infraestructure.adapter.controller;

import com.inditex.tools.application.query.FindByCriteriaQuery;
import com.inditex.tools.application.service.FindByCriteriaService;
import com.inditex.tools.commons.ProductCommons;
import com.inditex.tools.domain.model.Product;
import com.inditex.tools.domain.repository.ProductRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductControllerTest {

    @Test
    void handleSuccessfully() {
        List<Product> productList = ProductCommons.getProducts();
        ProductRepository productRepository = mock(ProductRepository.class);
        when(productRepository.getProducts()).thenReturn(productList);

        FindByCriteriaService findByCriteriaService = new FindByCriteriaService(productRepository);
        FindByCriteriaQuery findByCriteriaQuery = new FindByCriteriaQuery(3, 2);
        List<Product> productsResult = findByCriteriaService.handle(findByCriteriaQuery);
        Assert.assertEquals(Long.valueOf(5), productsResult.get(0).getId());
        Assert.assertEquals(Long.valueOf(1), productsResult.get(1).getId());
        Assert.assertEquals(Long.valueOf(3), productsResult.get(2).getId());
        Assert.assertEquals(Long.valueOf(2), productsResult.get(3).getId());
        Assert.assertEquals(Long.valueOf(4), productsResult.get(4).getId());
        Assert.assertEquals(Long.valueOf(6), productsResult.get(5).getId());
    }

    @Test
    void handleNoFound() {
        ProductRepository productRepository = mock(ProductRepository.class);
        when(productRepository.getProducts()).thenReturn(null);

        FindByCriteriaService findByCriteriaService = new FindByCriteriaService(productRepository);
        FindByCriteriaQuery findByCriteriaQuery = new FindByCriteriaQuery(3, 2);
        List<Product> productsResult = findByCriteriaService.handle(findByCriteriaQuery);
        Assert.assertNull(productsResult);

    }

}