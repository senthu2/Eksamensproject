package com.example.projecteksamen.repositories;

import com.example.projecteksamen.models.ProductCat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCatRepository extends JpaRepository<ProductCat, Integer> {
}
