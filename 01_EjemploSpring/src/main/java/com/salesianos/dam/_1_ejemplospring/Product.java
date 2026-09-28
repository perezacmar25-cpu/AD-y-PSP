package com.salesianos.dam._1_ejemplospring;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Entity
    @Data
    @NoArgsConstructor
    public class Product{

        @Id
        private int id;
        private String nombre;
        private double precio;
        public Product (int id,String nombre, double precio){}
    }

