package com.inditex.tools.application.port;

import com.inditex.tools.application.query.FindByCriteriaQuery;
import com.inditex.tools.domain.model.Product;

import java.util.List;

public interface IFindByCriteriaPort {

    List<Product> handle(FindByCriteriaQuery findByCriteriaQuery);

}
