package com.inditex.tools.infraestructure.adapter.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@Data
public class SizeResponse {

    private String name;

    private int quantity;
}
