package com.salesianos.dam._1_ejemplospring;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductoRepository productoRepository;

    public ResponseEntity<Product> addProduct (@RequestBody Product product){
        if(StringUtils.hasText(product.getNombre())){
            return ResponseEntity.status(201)
                    .body(productoRepository.save(product));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product>findById(@PathVariable Long id){
        return ResponseEntity.of(productoRepository.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product>updateProduct(@PathVariable Long id,
    @RequestBody Product product){

        return productoRepository.findById(id)
                .map(p -> {
                    p.setNombre(product.getNombre());
                    p.setPrecio(product.getPrecio());
                    return ResponseEntity.ok(productoRepository.save(p));
        }).orElse(
                ResponseEntity.notFound().build()
                );


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product>deleteProduct(@PathVariable Long id){
        productoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /*
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productoRepository.addProduct(product));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> result = productoRepository.getProducts();
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String name) {
        boolean deleted = productoRepository.deleteProduct(name);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    */

}
