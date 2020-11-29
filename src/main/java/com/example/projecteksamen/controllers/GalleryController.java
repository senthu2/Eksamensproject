package com.example.projecteksamen.controllers;

import com.example.projecteksamen.models.Gallery;
import com.example.projecteksamen.models.Gitem;
import com.example.projecteksamen.services.GalleryService;
import com.example.projecteksamen.services.GitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/gallery")
public class GalleryController {

    @Autowired
    GalleryService galleryService;
    @Autowired
    GitemService gitemService;

    @GetMapping("galleryIndex")
    public String gallery(Model model){
        model.addAttribute("galleries", galleryService.fetchAll());
        return "gallery/galleryIndex";
    }

    @RequestMapping("/create")
    public String createGalleryS(Model model){
        Gallery gallery = new Gallery();
        model.addAttribute("gallery", gallery);
        return "gallery/createGallery";
    }

    @PostMapping("/createGallery")
    public String createGallery(@ModelAttribute("gallery") Gallery gallery){
        gallery.setCategory(gallery.getCategory());
        gallery.setDescription(gallery.getDescription());
        gallery.setImgURL(gallery.getImgURL());
        galleryService.save(gallery);
        return "redirect:/gallery/galleryIndex";
    }

    @PostMapping("/update")
    public String commitEdit(@ModelAttribute("gallery") Gallery gallery, @RequestParam int id){

        //changes
        gallery.setCategory(gallery.getCategory());
        gallery.setDescription(gallery.getDescription());
        gallery.setImgURL(gallery.getImgURL());

        galleryService.save(gallery);
        return "redirect:/gallery/galleryIndex";
    }

    /*------------------------------------------
    Responsible for editing of activity
     -------------------------------------------*/
    @GetMapping("/edit")
    public String edit(Model model, @RequestParam int id){
        model.addAttribute("gallery", galleryService.fetchById(id));
        return "gallery/editGallery";
    }

    @RequestMapping("/delete")
    @ResponseBody()
    public String deleteGallery(@RequestParam int id) {
        Gallery gallery = galleryService.fetchById((id));
        galleryService.delete(gallery);
        return gallery.getCategory()+"\n"+gallery.getDescription()+" / "+gallery.getImgURL()+"\nDeleted";
    }

    /*------------------------------------------
                Gallery items methods
     -------------------------------------------*/

    @GetMapping("/{id}/gitem")
    public String viewGitem(Model model, @PathVariable int id){
        Gallery gallery = galleryService.fetchById(id);
        model.addAttribute("gitem", gallery.getGitem());
        model.addAttribute("gallery", gallery);
        model.addAttribute("newGitem", new Gitem());
        return "gitem/gitem";
    }

    @GetMapping("{id}/gitem/delete")
    public String deleteGitem(@RequestParam("id") String gitemId){
        Gitem gitem = gitemService.fetchById(Integer.parseInt(gitemId));
        gitemService.delete(gitem);
        return "redirect:/gallery/{id}/gitem";
    }

    @PostMapping("/{id}/gitem/new")
    public String addGitem(@ModelAttribute("gitem") Gitem gitem, @PathVariable("id") int id) {
        Gallery gallery = galleryService.fetchById(id);
        gitem.setGallery(gallery);
        gallery.addGitem(gitem);
        galleryService.save(gallery);
        return "redirect:/gallery/{id}/gitem";
    }
}
