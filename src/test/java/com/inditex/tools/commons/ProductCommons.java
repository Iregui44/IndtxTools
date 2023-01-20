package com.inditex.tools.commons;

import com.inditex.tools.domain.model.Product;
import com.inditex.tools.domain.model.Size;

import java.util.List;

public class ProductCommons {
    public static List<Product> getProducts() {
        Product product1 = new Product(Long.valueOf(1), "V-NECH BASIC SHIRT", 100, List.of(
                new Size(Long.valueOf(1), "S", 4),
                new Size(Long.valueOf(2), "M", 9),
                new Size(Long.valueOf(3), "L", 0)

        ));
        Product product2 = new Product(Long.valueOf(2), "CONTRASTING FABRIC T-SHIRT", 50, List.of(
                new Size(Long.valueOf(1), "S", 35),
                new Size(Long.valueOf(2), "M", 9),
                new Size(Long.valueOf(3), "L", 9)

        ));
        Product product3 = new Product(Long.valueOf(3), "RAISED PRINT T-SHIRT", 80, List.of(
                new Size(Long.valueOf(1), "S", 20),
                new Size(Long.valueOf(2), "M", 2),
                new Size(Long.valueOf(3), "L", 20)

        ));
        Product product4 = new Product(Long.valueOf(4), "PLEATED T-SHIRT", 3, List.of(
                new Size(Long.valueOf(1), "S", 25),
                new Size(Long.valueOf(2), "M", 30),
                new Size(Long.valueOf(3), "L", 10)

        ));
        Product product5 = new Product(Long.valueOf(5), "CONTRASTING LACE T-SHIRT", 650, List.of(
                new Size(Long.valueOf(1), "S", 0),
                new Size(Long.valueOf(2), "M", 1),
                new Size(Long.valueOf(3), "L", 0)

        ));
        Product product6 = new Product(Long.valueOf(6), "SLOGAN T-SHIRT", 20, List.of(
                new Size(Long.valueOf(1), "S", 9),
                new Size(Long.valueOf(2), "M", 2),
                new Size(Long.valueOf(3), "L", 5)

        ));
        return List.of(product1, product2, product3, product4, product5, product6);
    }

}
