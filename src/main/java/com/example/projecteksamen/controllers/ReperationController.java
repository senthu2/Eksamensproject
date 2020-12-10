package com.example.projecteksamen.controllers;


import com.example.projecteksamen.models.Reperation;
import com.example.projecteksamen.services.ReperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/reperationCreate")
    public String createReperation(Model model){
        System.out.println("Vis reperation");
        Reperation reperation = new Reperation();
        model.addAttribute("reperation",reperation);
        return "reperation/reperationCreate";
    }

    @PostMapping("/reperationCreate")
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
        return "reperation/reperationCreate";

    }

    @RequestMapping("/delete")
    public String deleteReperation(@RequestParam int id){
        Reperation reperation = reperationService.fetchById(id);
        reperationService.delete(reperation);
        return "redirect:/reperation/reperationIndex";
        }

    @GetMapping("/view")
    public String viewReperation(@RequestParam int id, Model model){
        model.addAttribute("reperation",reperationService.fetchById(id));
        return "/reperation/reperationView";
    }
}
