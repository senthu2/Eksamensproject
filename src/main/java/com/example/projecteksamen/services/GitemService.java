package com.example.projecteksamen.services;

import com.example.projecteksamen.models.Gallery;
import com.example.projecteksamen.models.Gitem;
import com.example.projecteksamen.repositories.GitemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GitemService {

    @Autowired
    GitemRepository gitemRepository;

    public void save(Gitem gitem){
        gitemRepository.save(gitem);
    }

    public void saveAll(List<Gitem> gitems){
        gitemRepository.saveAll(gitems);
    }

    public Gitem fetchById(int id){
        Optional<Gitem> optional = gitemRepository.findById(id);
        return optional.get();
    }

    public List<Gitem> fetchAll(){
        return gitemRepository.findAll();
    }

    public void delete(Gitem gitem){
        gitemRepository.deleteById(gitem.getId());
    }

    public List<Gitem> updGitem(String name, String description, String gitemURL, Gallery gallery){
        return gitemRepository.updGitem(name, description, gitemURL, gallery);
    }
}
