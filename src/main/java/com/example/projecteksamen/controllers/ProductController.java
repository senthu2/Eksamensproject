package com.example.projecteksamen.controllers;

import com.example.projecteksamen.models.*;
import com.example.projecteksamen.services.PitemService;
import com.example.projecteksamen.services.ProductCatService;
import com.example.projecteksamen.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String product(Model model, @Param("keyword") String keyword){
        //List<Product> listProducts = productService.listAll(keyword);
        model.addAttribute("products", productService.listAll(keyword));
        model.addAttribute("keyword", keyword);


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
//    @ResponseBody()
    public String deleteProduct(@RequestParam int id){
        Product product = productService.fetchById(id);
        productService.delete(product);
        return "redirect:/gallery/galleryIndex";
//        return product.getCategory()+"\n"+product.getDescription()+" /"+product.getImgURL()+"\nDeleted";
    }

        /*------------------------------------------
                    ProductCat methods
        -------------------------------------------*/

    @GetMapping("/{id}/productCat")
    public String viewProductCat(Model model, @PathVariable int id){
        Product product = productService.fetchById(id);
        model.addAttribute("productCat", product.getProductCat());
        model.addAttribute("product", product);
        model.addAttribute("newProductCat", new ProductCat());
        return "productCat/productCat";


    }

    @RequestMapping("/createC")
    public String createC(Model model){
        ProductCat productCat = new ProductCat();
        model.addAttribute("cat", productCat);
        model.addAttribute("products", productService.fetchAll());
        return "productCat/createProductCat";
    }

    @PostMapping("/createCat")
    public String createCat(@ModelAttribute("productCat") ProductCat productCat){
        productCat.setProduct(productCat.getProduct());
        productCat.setName(productCat.getName());
        productCat.setDescription(productCat.getDescription());
        productCat.setCatURL(productCat.getCatURL());
        productCatService.save(productCat);
        return "redirect:/product/productIndex";
    }

    @GetMapping("/editCat")
    public String editCat(Model model, @RequestParam int id){
        model.addAttribute("productCat", productCatService.fetchById(id));
        return "productCat/editProductCat";
    }

    @PostMapping("/updateCat")
    public String commitEditCat(@RequestParam int id, @RequestParam String name,
                                @RequestParam String description, @RequestParam String catURL){

        //changes
        ProductCat productCat = productCatService.fetchById(id);
        productCat.setName(name);
        productCat.setDescription(description);
        productCat.setCatURL(catURL);

        productCatService.save(productCat);
        return "redirect:/product/productIndex";
    }

    @RequestMapping("/deleteCat")
//    @ResponseBody()
    public String deleteCat(@RequestParam int id) {
        ProductCat productCat = productCatService.fetchById(id);
        productCatService.delete(productCat);
        return "redirect:/product/productIndex";
//        return gallery.getCategory()+"\n"+gallery.getDescription()+" / "+gallery.getImgURL()+"\nDeleted";
    }

            /*------------------------------------------
                        Product item methods
            -------------------------------------------*/

    @GetMapping("/{id}/pitem")
    public String viewPitem(Model model, @PathVariable int id){
        ProductCat productCat = productCatService.fetchById(id);
        model.addAttribute("pitem", productCat.getPitem());
        model.addAttribute("productCat", productCat);
        model.addAttribute("newPitem", new Pitem());
        return "pitem/pitem";
    }

    @RequestMapping("/createP")
    public String createP(Model model){
        Pitem pitem = new Pitem();
        model.addAttribute("pitem", pitem);
        model.addAttribute("product", productService.fetchAll());
        model.addAttribute("productCat", productCatService.fetchAll());
        return "pitem/createPitem";
    }

    @PostMapping("/createPitem")
    public String createPitem(@ModelAttribute("pitem") Pitem pitem){
        pitem.setProductCat(pitem.getProductCat());
        pitem.setName(pitem.getName());
        pitem.setDescription(pitem.getDescription());
        pitem.setPitemURL(pitem.getPitemURL());
        pitemService.save(pitem);
        return "redirect:/product/productIndex";
    }

    @GetMapping("/editP")
    public String editP(Model model, @RequestParam int id){
        model.addAttribute("pitem", pitemService.fetchById(id));
        return "pitem/editPitem";
    }

    @PostMapping("/updateP")
    public String commitEditP(@RequestParam int id, @RequestParam String name,
                              @RequestParam String description, @RequestParam String pitemURL){

        //changes
        Pitem pitem = pitemService.fetchById(id);
        pitem.setName(name);
        pitem.setDescription(description);
        pitem.setPitemURL(pitemURL);

        pitemService.save(pitem);
        return "redirect:/product/productIndex";
    }

    @RequestMapping("/deletePitem")
//    @ResponseBody()
    public String deletePitem(@RequestParam int id) {
        Pitem pitem = pitemService.fetchById(id);
        pitemService.delete(pitem);
        return "redirect:/product/productIndex";
//        return gallery.getCategory()+"\n"+gallery.getDescription()+" / "+gallery.getImgURL()+"\nDeleted";
    }
}
