package com.example.projecteksamen.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_cat")
public class ProductCat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_cat_id")
    private Integer id;

    @Column(name = "product_cat_name")
    private String name;

    @Column(name = "product_cat_description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

//    @ManyToMany(fetch = FetchType.LAZY)
//    private List<Pitem> pitem = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "productCat")
    private List<Pitem> pitem = new ArrayList<>();

    public void addPitem(Pitem newPitem){
        newPitem.setProductCat(this);
        pitem.add(newPitem);
    }

    public void remowePitem(Pitem oldPitem){
        pitem.remove(oldPitem);
        oldPitem.setProductCat(null);
    }

    public ProductCat() {
    }

    public ProductCat(Integer id, String name, String description, Product product, List<Pitem> pitem) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.product = product;
        this.pitem = pitem;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Pitem> getPitem() {
        return pitem;
    }

    public void setPitem(List<Pitem> pitem) {
        this.pitem = pitem;
    }
}
