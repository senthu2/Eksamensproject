package com.example.projecteksamen.repositories;

import com.example.projecteksamen.models.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/** et interface der nedarver fra et Data Java Persistence API af typen Activity
 * den anden type (Integer) er til for API'et kan identificere hvilken type primary key er.
 */
@Repository
public interface GalleryRepository extends JpaRepository<Gallery, Integer> {

}
