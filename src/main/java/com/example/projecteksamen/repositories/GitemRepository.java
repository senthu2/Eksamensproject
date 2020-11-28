package com.example.projecteksamen.repositories;

import com.example.projecteksamen.models.Gitem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GitemRepository extends JpaRepository<Gitem, Integer> {
}
