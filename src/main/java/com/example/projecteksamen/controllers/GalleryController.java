package com.example.projecteksamen.controllers;

import com.example.projecteksamen.models.Gallery;
import com.example.projecteksamen.models.Project;
import com.example.projecteksamen.services.GalleryService;
import com.example.projecteksamen.services.ProjectService;
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
    ProjectService projectService;

    @GetMapping("galleryIndex")
    public String gallery(Model model){
        model.addAttribute("galleries", galleryService.fetchAll());
        return "gallery/galleryIndex";
    }

    @GetMapping("/create")
    public String createGallery(Model model){
        Gallery gallery = new Gallery();
        gallery.setImgURL("default.jpg");
        model.addAttribute("gallery", gallery);
        return "gallery/createGallery";
    }

    @GetMapping("/createGallery")
    public String createGalleryS(Model model){
        return "project/project";
    }

    @GetMapping("/{id}/project")
    public String viewProject(Model model, @PathVariable int id){
        Gallery gallery = galleryService.fetchById(id);
        model.addAttribute("project", gallery.getProject());
        model.addAttribute("gallery", gallery);
        model.addAttribute("newProject", new Project());
        return "project/project";
    }

    @GetMapping("{id}/project/delete")
    public String deleteProject(@RequestParam("id") String projectId){
        Project project = projectService.fetchById(Integer.parseInt(projectId));
        projectService.delete(project);
        return "redirect:/gallery/{id}/project";
    }

    @GetMapping("/{id}/project/new")
    public String addProject(@ModelAttribute("project") Project project, @PathVariable("id") int id) {
        Gallery gallery = galleryService.fetchById(id);
        project.setGallery(gallery);
        gallery.addProject(project);
        galleryService.save(gallery);
        return "redirect:/gallery/{id}/project";
    }

    //update
}
