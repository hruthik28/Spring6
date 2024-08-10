package com.example.SpringBootWebApp.service;

import com.example.SpringBootWebApp.model.Product;
import com.example.SpringBootWebApp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

//    List<Product> products = Arrays.asList(
//            new Product(101, "Iphone", 50000),
//            new Product(102, "Sony Camera", 4000)
//    );
//    ArrayList<Product> products = new ArrayList<>(Arrays.asList(
//            new Product(101, "Iphone", 50000),
//            new Product(102, "Sony Camera", 40000),
//            new Product(103, "JBL Mic", 10000)
//    ));


    public List<Product> getproducts(){
        return repo.findAll();
    }

    public Product getProductById(int prodId) {
        return repo.findById(prodId).orElse(new Product());
    }

    public void addProduct(Product prod){
        repo.save(prod);
    }

    public void updateProduct(Product prod) {
        repo.save(prod);
    }

    public void deleteProductbyId(int prodId) {
        repo.deleteById(prodId);
    }
}
