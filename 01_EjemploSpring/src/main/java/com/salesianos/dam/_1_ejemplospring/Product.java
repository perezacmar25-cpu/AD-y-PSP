package com.salesianos.dam._1_ejemplospring;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@Builder
    public class Product{

    @Id
    @GeneratedValue
    private int id;
        private String nombre;
        private double precio;
        public Product (int id,String nombre, double precio){}
    }

