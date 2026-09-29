package com.salesianos.dam.demo;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/monument")
public class MonumentoController {

    private final MonumentoRepository monumentoRepository;

    @GetMapping
    public ResponseEntity<List<Monumento>> obtenerTodos() {
        List<Monumento> monumentos = monumentoRepository.findAll();

        if (monumentos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(monumentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Monumento> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.of(monumentoRepository.findById(id));


    }

    @PostMapping
    public ResponseEntity<Monumento> crearProducto(@RequestBody Monumento monumento) {

        if (StringUtils.hasText(monumento.getNombre())) {
            return ResponseEntity.status(201).
                    body(monumentoRepository.save(monumento));
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Monumento> actualizarMonumento(@PathVariable Long id,
                                                         @RequestBody Monumento monumento) {
        return monumentoRepository.findById(id)
                .map(m -> {
                    m.setNombre(monumento.getNombre());
                    m.setDescripcion(monumento.getDescripcion());
                    return ResponseEntity.ok(monumentoRepository.save(m));
                })
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping
    public ResponseEntity<Monumento> borrarMonumento(@PathVariable Long id){
        monumentoRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}




