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

    @PostMapping("/update")
    public String commitEdit(@ModelAttribute("product") Product product, @RequestParam int id){

        product.setCategory(product.getCategory());
        product.setDescription(product.getDescription());
        product.setImgURL(product.getImgURL());

        productService.save(product);
        return "redirect:/product/productIndex";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam int id){
        model.addAttribute("product", productService.fetchById(id));
        return "product/editProduct";
    }

    @RequestMapping("/delete")
    @ResponseBody()
    public String deleteProduct(@RequestParam int id){
        Product product = productService.fetchById(id);
        productService.delete(product);
        return product.getCategory()+"\n"+product.getDescription()+" /"+product.getImgURL()+"\nDeleted";
    }
}
