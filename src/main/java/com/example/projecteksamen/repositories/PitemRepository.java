package com.example.projecteksamen.repositories;

import com.example.projecteksamen.models.Pitem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PitemRepository extends JpaRepository<Pitem, Integer> {
}
