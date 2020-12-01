package com.example.projecteksamen.models;

import javax.persistence.*;

@Entity
@Table(name = "p_item")
public class Pitem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_item_id")
    private Integer id;

    @Column(name = "p_item_name")
    private String name;

    @Column(name = "p_item_imgURL")
    private String pitemURL;

    @Column(name = "p_item_description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_cat_id")
    private ProductCat productCat;

    public Pitem(Integer id, String name, String pitemURL, String description, ProductCat productCat) {
        this.id = id;
        this.name = name;
        this.pitemURL = pitemURL;
        this.description = description;
        this.productCat = productCat;
    }

    public Pitem() {
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

    public String getPitemURL() {
        return pitemURL;
    }

    public void setPitemURL(String pitemURL) {
        this.pitemURL = pitemURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductCat getProductCat() {
        return productCat;
    }

    public void setProductCat(ProductCat productCat) {
        this.productCat = productCat;
    }
}


