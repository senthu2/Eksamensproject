package com.example.projecteksamen.models;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/** Annoterer at dette er et table i databasen */
@Entity
@Table(name = "gallery")
public class Gallery {

    /** Annoterer at dette er primary key (@Id)
     * med auto increment (@GeneratedValue)
     * og hvad navnet på dens kolonne i table er (@Column)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gallery_id")
    private Integer id;

    @Column(name = "g_category")
    private String category;

    @Column(name = "g_image_URL")
    private String imgURL;

    @Column(name = "g_description")
    private String description;

    /** Annoterer at der er et one to many relationship med Equipment objekter,
     * dvs. at for hver activity er der "uendeligt" meget equipment.
     * "orphanRemoval" sørger for at et Equipment objekt altid har et tilhørende Activity objekt
     * hvis ikke fjernes Equipment objektet fra databasen næste gang der bliver kaldt på databasen
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "gallery")
    private List<Gitem> gitem = new ArrayList<>();

    public void addGitem(Gitem newGitem){
        newGitem.setGallery(this);
        gitem.add(newGitem);
    }

    public void removeGitem(Gitem oldGitem){
        gitem.remove(oldGitem);
        oldGitem.setGallery(null);
    }

    /** Constructors + getters og setters */
    public Gallery() {
    }

    public Gallery(Integer id, String category, String imgURL, String description, List<Gitem> gitem) {
        this.id = id;
        this.category = category;
        this.imgURL = imgURL;
        this.description = description;
        this.gitem = gitem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Gitem> getGitem() {
        return gitem;
    }

    public void setGitem(List<Gitem> gitem) {
        this.gitem = gitem;
    }
}