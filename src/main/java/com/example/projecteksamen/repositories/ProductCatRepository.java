package com.example.projecteksamen.repositories;

import com.example.projecteksamen.models.Product;
import com.example.projecteksamen.models.ProductCat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCatRepository extends JpaRepository<ProductCat, Integer> {
}
