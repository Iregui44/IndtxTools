package com.inditex.tools.infraestructure.adapter.controller.mapper;

import com.inditex.tools.domain.model.Size;
import com.inditex.tools.infraestructure.adapter.controller.response.SizeResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SizeMapper {

    public SizeResponse toSizeResponse(Size size);

    public List<SizeResponse> toSizeResponses(List<Size> sizes);
}
