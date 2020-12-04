package com.example.projecteksamen.repositories;

import com.example.projecteksamen.models.Gallery;
import com.example.projecteksamen.models.Gitem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GitemRepository extends JpaRepository<Gitem, Integer> {

    @Modifying
    @Query(value = "UPDATE Gitem g SET value = g.name = ?, g.description = , g.gitemURL = ? WHERE g.item_gallery_id = ?", nativeQuery = true)
    List<Gitem> updGitem(String name, String description, String gitemURL, Gallery gallery);

}
