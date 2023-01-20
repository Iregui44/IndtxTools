package com.inditex.tools.infraestructure.adapter.controller.mapper;

import com.inditex.tools.domain.model.Product;
import com.inditex.tools.infraestructure.adapter.controller.response.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SizeMapper.class})
public interface ProductMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "salesUnits", source = "salesUnits")
    @Mapping(target = "stock", source="stock")
    public ProductResponse toProductResponse(Product product);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "salesUnits", source = "salesUnits")
    @Mapping(target = "stock", source="stock")
    public List<ProductResponse> toProductResponses(List<Product> products);
}
