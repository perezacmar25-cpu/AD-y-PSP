package com.salesianos.dam.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MonumentoRepository extends JpaRepository<Monumento,Long> {
}
