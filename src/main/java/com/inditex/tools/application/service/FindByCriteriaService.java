package com.inditex.tools.application.service;

import com.inditex.tools.application.port.IFindByCriteriaPort;
import com.inditex.tools.application.query.FindByCriteriaQuery;
import com.inditex.tools.domain.model.Product;
import com.inditex.tools.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindByCriteriaService implements IFindByCriteriaPort {
    private ProductRepository productRepository;

    public FindByCriteriaService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> handle(FindByCriteriaQuery findByCriteriaQuery) {
        List<Product> products = productRepository.getProducts();
        if(products == null || products.isEmpty()) {
            return products;
        }
        products.stream().forEach(product -> applyWeight(findByCriteriaQuery, product));
        return products.stream().sorted(Comparator.comparing(Product::getWeightOrder).reversed()).collect(Collectors.toList());
    }

    private void applyWeight(FindByCriteriaQuery criteria, Product product) {
        if(criteria.getSalesUnits() > 0) {
            product.addWeightOrder(product.getSalesUnits() * criteria.getSalesUnits());
        }
        if(criteria.getRatioStock() > 0) {
            product.addWeightOrder(product.getQuantityTotalSize() * criteria.getRatioStock());
        }
    }

}
