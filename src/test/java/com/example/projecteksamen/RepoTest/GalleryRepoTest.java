package com.example.projecteksamen.RepoTest;

import com.example.projecteksamen.models.Gallery;
import com.example.projecteksamen.repositories.GalleryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class GalleryRepoTest {

    @Autowired
    GalleryRepository galleryRepository;

    @Test
    public void gallerySavedTest(){
        //Tester om Gallery bliver gemt
        int expected = 1;

        Gallery gallery = new Gallery();
        galleryRepository.save(gallery);
        int actual = galleryRepository.findAll().size();
        System.out.println("Antal gemte: "+galleryRepository.findAll().size());
        assertEquals(expected, actual);
    }

    @Test
    public void galleryIsDeletedTest(){
        //Tester om gallery bliver slettet
        int expected = 0;

        Gallery gallery = new Gallery();
        galleryRepository.save(gallery);

        //Tager index 0 og sætter den til gallery1
        Gallery gallery1 = galleryRepository.findAll().get(0);
        galleryRepository.delete(gallery1);
        int actual = galleryRepository.findAll().size();

        assertEquals(expected, actual);
    }

    @Test
    public void galleryCategoryIsUpdatedTest(){
        String expected = "Køkken";

        //Laver ny gallery, så den kan opdateres senere
        Gallery gallery = new Gallery();
        gallery.setCategory("Bad");
        galleryRepository.save(gallery);

        //Sætter index(0) = gallery1 og sætter Category til køkken
        Gallery gallery1 = galleryRepository.findAll().get(0);
        gallery.setCategory("Køkken");
        galleryRepository.save(gallery1);
        System.out.println("Ny Category: " + gallery1.getCategory());

        String actual = galleryRepository.findAll().get(0).getCategory();

        assertEquals(expected, actual);

    }

}
