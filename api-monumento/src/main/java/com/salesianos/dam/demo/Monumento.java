package com.salesianos.dam.demo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Monumento {

    @Id @GeneratedValue
    private Long id;

    private String codigo;

    private String ciudad;

    private String pais;

    private double longitud;

    private String nombre;

    private String descripcion;

    private String url;
}
