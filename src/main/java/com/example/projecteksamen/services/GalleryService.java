package com.example.projecteksamen.services;

import com.example.projecteksamen.models.Gallery;
import com.example.projecteksamen.repositories.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GalleryService {

    @Autowired
    GalleryRepository galleryRepository;

    public void save(Gallery gallery){
        galleryRepository.save(gallery);
    }

    public void saveAll(List<Gallery> galleries){
        galleryRepository.saveAll(galleries);
    }

    public Gallery fetchById(int id){
        Optional<Gallery> optional = galleryRepository.findById(id);
        return optional.get();
    }

    public List<Gallery> fetchAll(){
        return galleryRepository.findAll();
    }

    public void delete(int id){
        galleryRepository.deleteById(id);
    }

    public void delete(Gallery gallery){
        galleryRepository.delete(gallery);
    }

//    public void delete(Gallery gallery) {
//        galleryRepository.deleteById(gallery.getId());
//    }
}
