package com.example.projecteksamen.services;

import com.example.projecteksamen.models.Product;
import com.example.projecteksamen.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void save(Product product){
        productRepository.save(product);
    }

    public void saveAll(List<Product> products){
        productRepository.saveAll(products);
    }

    public Product fetchById(int id){
        Optional<Product> optional = productRepository.findById(id);
        return optional.get();
    }

    public List<Product> fetchAll(){
        return productRepository.findAll();
    }

    public void delete(Product product) {
        productRepository.deleteById(product.getId());
    }
}
