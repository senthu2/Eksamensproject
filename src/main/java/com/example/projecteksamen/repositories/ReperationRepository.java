package com.example.projecteksamen.repositories;

import com.example.projecteksamen.models.Reperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReperationRepository extends JpaRepository<Reperation, Integer> {
}
