package com.example.SpringBootWebApp.service;

import com.example.SpringBootWebApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

//    List<Product> products = Arrays.asList(
//            new Product(101, "Iphone", 50000),
//            new Product(102, "Sony Camera", 4000)
//    );
    ArrayList<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101, "Iphone", 50000),
            new Product(102, "Sony Camera", 40000),
            new Product(103, "JBL Mic", 10000)
    ));


    public ArrayList<Product> getproducts(){
        return products;
    }

    public Product getProductById(int prodId) {
        return products.stream()
                .filter(p -> p.getProdId() == prodId)
                .findFirst()
                .orElse(new Product(prodId, "No Item found", 0));
    }

    public void addProduct(Product prod){
        products.add(prod);
    }

    public void updateProduct(Product prod) {
        int index = 0;
        for (Product p: products){
            if(p.getProdId() == prod.getProdId()){
                break;
            } else {
                index += 1;
            }
        }
        products.set(index, prod);
    }

    public void deleteProductbyId(int prodId) {
        int index = 0;
        for (Product p: products){
            if(p.getProdId() == prodId){
                break;
            } else {
                index += 1;
            }
        }
        products.remove(index);
    }
}
