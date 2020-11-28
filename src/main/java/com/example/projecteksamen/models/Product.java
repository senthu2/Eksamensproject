package com.example.projecteksamen.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    @Column(name = "p_category")
    private String category;

    @Column(name = "p_image_URL")
    private String imgURL;

    @Column(name = "p_description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "product")
    private List<ProductCat> productCat = new ArrayList<>();

    public Product() {

    }

    public void addProductCat(ProductCat newProductCat){
        newProductCat.setProduct(this);
        productCat.add(newProductCat);
    }

    public void removeProductCat(ProductCat oldProductCat){
        productCat.remove(oldProductCat);
        oldProductCat.setProduct(null);
    }

//    public ProductCat(){
//
//    }

    public Product(Integer id, String category, String imgURL, String description, List<ProductCat> productCat) {
        this.id = id;
        this.category = category;
        this.imgURL = imgURL;
        this.description = description;
        this.productCat = productCat;
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

    public List<ProductCat> getProductCat() {
        return productCat;
    }

    public void setProductCat(List<ProductCat> productCat) {
        this.productCat = productCat;
    }
}
