package com.inditex.tools.application.service;

import com.inditex.tools.application.query.FindByCriteriaQuery;
import com.inditex.tools.commons.ProductCommons;
import com.inditex.tools.domain.model.Product;
import com.inditex.tools.domain.model.Size;
import com.inditex.tools.domain.repository.ProductRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindByCriteriaServiceTest {

    @Test
    void handle_WhenNoProductsAreFoundThenReturnEmpty() {
        ProductRepository productRepository = mock(ProductRepository.class);
        when(productRepository.getProducts()).thenReturn(new ArrayList<>());

        FindByCriteriaService findByCriteriaService = new FindByCriteriaService(productRepository);
        FindByCriteriaQuery findByCriteriaQuery = new FindByCriteriaQuery(0, 0);
        Assert.assertEquals(0, findByCriteriaService.handle(findByCriteriaQuery).size());
    }

    @Test
    void handle_WhenNoCriteriaIsFoundThenReturnUnorderedProducts() {
        List<Product> productList = ProductCommons.getProducts();
        ProductRepository productRepository = mock(ProductRepository.class);
        when(productRepository.getProducts()).thenReturn(productList);

        FindByCriteriaService findByCriteriaService = new FindByCriteriaService(productRepository);
        FindByCriteriaQuery findByCriteriaQuery = new FindByCriteriaQuery(0, 0);
        Assert.assertEquals(productList, findByCriteriaService.handle(findByCriteriaQuery));
    }

    @Test
    void handle_WhenSalesUnitCriteriaIsFoundThenReturnOrderedProductsBySalesUnit() {
        List<Product> productList = ProductCommons.getProducts();
        ProductRepository productRepository = mock(ProductRepository.class);
        when(productRepository.getProducts()).thenReturn(productList);

        FindByCriteriaService findByCriteriaService = new FindByCriteriaService(productRepository);
        FindByCriteriaQuery findByCriteriaQuery = new FindByCriteriaQuery(2, 0);
        List<Product> productsResult = findByCriteriaService.handle(findByCriteriaQuery);
        Assert.assertEquals(Long.valueOf(5), productsResult.get(0).getId());
        Assert.assertEquals(Long.valueOf(1), productsResult.get(1).getId());
        Assert.assertEquals(Long.valueOf(3), productsResult.get(2).getId());
        Assert.assertEquals(Long.valueOf(2), productsResult.get(3).getId());
        Assert.assertEquals(Long.valueOf(6), productsResult.get(4).getId());
        Assert.assertEquals(Long.valueOf(4), productsResult.get(5).getId());
    }

    @Test
    void handle_WhenQuantityTotalSizeCriteriaIsFoundThenReturnOrderedProductsByStock() {
        List<Product> productList = ProductCommons.getProducts();
        ProductRepository productRepository = mock(ProductRepository.class);
        when(productRepository.getProducts()).thenReturn(productList);

        FindByCriteriaService findByCriteriaService = new FindByCriteriaService(productRepository);
        FindByCriteriaQuery findByCriteriaQuery = new FindByCriteriaQuery(0, 2);
        List<Product> productsResult = findByCriteriaService.handle(findByCriteriaQuery);
        Assert.assertEquals(Long.valueOf(4), productsResult.get(0).getId());
        Assert.assertEquals(Long.valueOf(2), productsResult.get(1).getId());
        Assert.assertEquals(Long.valueOf(3), productsResult.get(2).getId());
        Assert.assertEquals(Long.valueOf(6), productsResult.get(3).getId());
        Assert.assertEquals(Long.valueOf(1), productsResult.get(4).getId());
        Assert.assertEquals(Long.valueOf(5), productsResult.get(5).getId());
    }

    @Test
    void handle_WhenBothCriteriaAreFoundThenReturnOrderedProductsByWeight() {
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

}