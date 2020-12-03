package com.example.projecteksamen;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(){
        return "index3";
    }

    @GetMapping("/KontaktInfo")
    public String kontaktInfo(){
        return "KontaktInfo";
    }
    @GetMapping("/omOs")
    public String omOs(){
        return "omOs";
    }
    @GetMapping("/Counter")
    public String counter(){
        return "Counter";
    }
    @GetMapping("/index2")
    public String index2(){
        return "index2";
    }
}
