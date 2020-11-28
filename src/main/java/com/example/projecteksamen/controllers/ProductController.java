package com.example.projecteksamen.controllers;

import com.example.projecteksamen.models.Product;
import com.example.projecteksamen.services.PitemService;
import com.example.projecteksamen.services.ProductCatService;
import com.example.projecteksamen.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    ProductCatService productCatService;
    @Autowired
    PitemService pitemService;

    @GetMapping("productIndex")
    public String product(Model model){
        model.addAttribute("products", productService.fetchAll());
        return "product/productIndex";
    }

    @RequestMapping("/create")
    public String createProductS(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "product/createProduct";
    }

    @PostMapping("/createProduct")
    public String createProduct(@ModelAttribute("product") Product product){
        product.setCategory(product.getCategory());
        product.setDescription(product.getDescription());
        productService.save(product);
        return "redirect:/product/productIndex";
    }
}
