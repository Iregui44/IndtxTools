package com.inditex.tools.infraestructure.adapter.persistance.crud;

import com.inditex.tools.infraestructure.adapter.persistance.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCrudRepository extends JpaRepository<ProductEntity, Long> {
}
