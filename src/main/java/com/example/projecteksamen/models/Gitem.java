package com.example.projecteksamen.models;

import javax.persistence.*;

@Entity
@Table(name = "g_item")
public class Gitem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "g_item_id")
    private Integer id;

    @Column(name = "g_item_name")
    private String name;

    @Column(name = "g_item_description")
    private String description;

    @Column(name = "g_item_imgURL")
    private String gitemURL;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "gallery_id", nullable = false, updatable = true, referencedColumnName = "gallery_id")
    private Gallery gallery;

    public Gitem(){

    }

    public Gitem(Integer id, String name, String description, String gitemURL, Gallery gallery){
        this.id = id;
        this.name = name;
        this.description = description;
        this.gitemURL = gitemURL;
        this.gallery = gallery;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGitemURL() {
        return gitemURL;
    }

    public void setGitemURL(String gitemURL) {
        this.gitemURL = gitemURL;
    }

    public Gallery getGallery() {
        return gallery;
    }

    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }
}
