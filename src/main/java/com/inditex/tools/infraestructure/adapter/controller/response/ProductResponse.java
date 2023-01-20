package com.inditex.tools.infraestructure.adapter.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@Data
public class ProductResponse {

    private Long id;

    private String name;

    private int salesUnits;

    private List<SizeResponse> stock;


}
