package com.example.projecteksamen.controllers;

import com.example.projecteksamen.models.Reperation;
import com.example.projecteksamen.models.User;
import com.example.projecteksamen.repositories.UserRepository;
import com.example.projecteksamen.services.ReperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ReperationService reperationService;


    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "user/signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        return "user/register_success";
    }
    @GetMapping("/users")
    public String listUsers() {
        return "indexManager";
    }

    @GetMapping("/reperationCreateManager")
    public String createReperation(Model model){
        System.out.println("Vis reperation");
        Reperation reperation = new Reperation();
        model.addAttribute("reperation",reperation);
        return "reperation/reperationCreateManager";
    }

    @PostMapping("/reperationCreateManager")
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
        return "reperation/reperationCreateManager";

    }

    @GetMapping("/omOsManager")
    public String omOs(){
        return "omOsManager";
    }

    @GetMapping("/KontaktInfoManager")
    public String kontaktInfo(){
        return "KontaktInfoManager";
    }


}


