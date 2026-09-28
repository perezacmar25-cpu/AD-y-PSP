package com.salesianos.dam._1_ejemplospring;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductoRepository {

    private List<Product> products;

    public ProductoRepository() {
        this.products = new ArrayList<>();
    }

    @PostMapping
    public Product addProduct(Product product){

        products.add(product);
        return product;


    }

    public  List<Product> getProducts(){
        return products;
    }
}
