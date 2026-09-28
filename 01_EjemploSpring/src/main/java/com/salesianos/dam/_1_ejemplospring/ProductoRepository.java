package com.salesianos.dam._1_ejemplospring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Product,Long> {

   /* private final List<Product> products = new ArrayList<>();

    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Optional<Product> getProductByName(String name) {
        return products.stream()
                .filter(p -> p.nombre().equalsIgnoreCase(name))
                .findFirst();
    }

    public boolean deleteProduct(String name) {
        return products.removeIf(p -> p.nombre().equalsIgnoreCase(name));
    }
    */

}