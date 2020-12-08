package com.example.projecteksamen.services;


import com.example.projecteksamen.models.Reperation;

import com.example.projecteksamen.repositories.ReperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReperationService {

    @Autowired
    ReperationRepository reperationRepository;

    public void save(Reperation reperation){
        reperationRepository.save(reperation);
    }

    public void saveAll(List<Reperation> reperations){
        reperationRepository.saveAll(reperations);
    }

    public Reperation fetchById(int id){
        Optional<Reperation> optional = reperationRepository.findById(id);
        return optional.get();
    }

    public List<Reperation> fetchAll(){
        return reperationRepository.findAll();
    }

    public void delete(Reperation reperation) {
        reperationRepository.deleteById(reperation.getId());
    }
}



