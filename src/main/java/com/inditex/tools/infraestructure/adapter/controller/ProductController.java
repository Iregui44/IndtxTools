package com.inditex.tools.infraestructure.adapter.controller;

import com.inditex.tools.application.port.IFindByCriteriaPort;
import com.inditex.tools.application.query.FindByCriteriaQuery;
import com.inditex.tools.domain.model.Product;
import com.inditex.tools.infraestructure.adapter.controller.mapper.ProductMapper;
import com.inditex.tools.infraestructure.adapter.controller.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private IFindByCriteriaPort findByCriteriaPort;

    @Autowired
    public ProductMapper productMapper;

    @Autowired
    public ProductController(IFindByCriteriaPort findByCriteriaPort) {
        this.findByCriteriaPort = findByCriteriaPort;
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductResponse>> getProductsByCriteria(@RequestParam("weightSalesUnit") int weightSalesUnit , @RequestParam("weightStocks") int weightStocks) {
        FindByCriteriaQuery findByCriteriaQuery = new FindByCriteriaQuery(weightSalesUnit,weightStocks);
        return Optional.ofNullable(this.findByCriteriaPort.handle(findByCriteriaQuery))
                .map(products -> new ResponseEntity<>(productMapper.toProductResponses(products), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }
}
