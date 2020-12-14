package com.example.projecteksamen.repositories;

import com.example.projecteksamen.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM product p WHERE p.p_category LIKE %?1%", nativeQuery = true)
    public List<Product> search(String keyword);
}

