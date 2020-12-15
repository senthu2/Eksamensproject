package com.example.projecteksamen.services;

import com.example.projecteksamen.models.Product;
import com.example.projecteksamen.models.ProductCat;
import com.example.projecteksamen.repositories.ProductCatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCatService {

    @Autowired
    ProductCatRepository productCatRepository;

    public void save(ProductCat productCat){
        productCatRepository.save(productCat);
    }

    public void saveAll(List<ProductCat> productCats){
        productCatRepository.saveAll(productCats);
    }

    public ProductCat fetchById(int id){
        Optional<ProductCat> optional = productCatRepository.findById(id);
        return optional.get();
    }

    public List<ProductCat> fetchAll(){
        return productCatRepository.findAll();
    }

    public void delete(ProductCat productCat) {
        productCatRepository.deleteById(productCat.getId());
    }

}
