package com.example.projecteksamen.controllers;


import com.example.projecteksamen.models.Reperation;
import com.example.projecteksamen.services.ReperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reperation")
public class ReperationController {

    @Autowired
    ReperationService reperationService;

    @GetMapping("/reperationIndex")
    public String reperationForm(Model model){
        model.addAttribute("reperation",reperationService.fetchAll());
        return "/reperation/reperationIndex";
    }
    @RequestMapping("/Kontaktform")
    public String createReperation(Model model){
        System.out.println("Vis reperation");
        Reperation reperation = new Reperation();
        model.addAttribute("reperation",reperation);
        return "reperation/Kontaktform";
    }
/*
    @PostMapping("/Kontaktform")
    public String createReperation(@ModelAttribute("reperation") Reperation reperation){
        System.out.println("Opret reperation");
        reperation.setFirst_Name(reperation.getFirst_Name());
        reperation.setLast_Name(reperation.getLast_Name());
        reperation.setAddress(reperation.getAddress());
        reperation.setEmail(reperation.getEmail());
        reperation.setPhone_Number(reperation.getPhone_Number());
        reperation.setDamage_Location(reperation.getDamage_Location());
        reperation.setDescription(reperation.getDescription());
        reperationService.save(reperation);
        return "index";

    }*/


}
