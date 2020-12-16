package com.example.projecteksamen.repositories;

import com.example.projecteksamen.models.Pitem;
import com.example.projecteksamen.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PitemRepository extends JpaRepository<Pitem, Integer> {
}
