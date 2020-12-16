package com.example.projecteksamen.services;

import com.example.projecteksamen.models.Pitem;
import com.example.projecteksamen.models.Product;
import com.example.projecteksamen.repositories.PitemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PitemService {

    @Autowired
    PitemRepository pitemRepository;

    public void save(Pitem pitem){
        pitemRepository.save(pitem);
    }

    public void saveAll(List<Pitem> pitems){
        pitemRepository.saveAll(pitems);
    }

    public Pitem fetchById(int id){
        Optional<Pitem> optional = pitemRepository.findById(id);
        return optional.get();
    }

    public List<Pitem> fetchAll(){
        return pitemRepository.findAll();
    }

    public void delete(Pitem pitem) {
        pitemRepository.deleteById(pitem.getId());
    }
}
