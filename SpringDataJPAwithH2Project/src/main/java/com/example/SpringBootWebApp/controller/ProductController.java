package com.example.SpringBootWebApp.controller;

import com.example.SpringBootWebApp.model.Product;
import com.example.SpringBootWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @RequestMapping("/products")
    public List<Product> getproducts(){
        return service.getproducts();
    }

    @GetMapping("/products/{prodId}")
    public Product getproductbyId(@PathVariable int prodId) {
        return service.getProductById(prodId);
    }

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Product prod){
        service.addProduct(prod);
    }

    @PutMapping("/updateProduct")
    public void updateProduct(Product prod){
        service.updateProduct(prod);
    }

    @DeleteMapping("/deleteProduct/{prodId}")
    public void deleteProductbyId(@PathVariable int prodId) {
         service.deleteProductbyId(prodId);
    }
}
