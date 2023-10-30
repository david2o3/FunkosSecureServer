package com.example.FunkosServicios.controller;

import com.example.FunkosServicios.models.Funko;
import com.example.FunkosServicios.repository.FunkosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funkos")
public class FunkosController {

    @Autowired
    private FunkosRepository funkosRepository;

    @GetMapping("/all")
    public List<Funko> getAllFunkos() {
        return funkosRepository.findAll();
    }

    @GetMapping("/byCod/{cod}")
    public ResponseEntity<Funko> getFunkoByCod(@PathVariable String cod) {
        Funko funko = funkosRepository.findByCod(cod);
        if (funko != null) {
            return ResponseEntity.ok(funko);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/byModelo/{modelo}")
    public List<Funko> getFunkosByModelo(@PathVariable String modelo) {
        return funkosRepository.findByModelo(modelo);
    }

    @GetMapping("/byYear/{year}")
    public List<Funko> getFunkosByYear(@PathVariable int year) {
        return funkosRepository.findByFechaLanzamientoYear(year);
    }

    @PostMapping("/add")
    public ResponseEntity<Funko> addFunko(@RequestBody Funko funko) {
        // Realiza validaciones de datos antes de guardar
        funkosRepository.save(funko);
        return ResponseEntity.status(HttpStatus.CREATED).body(funko);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Funko> updateFunko(@PathVariable Long id, @RequestBody Funko updatedFunko) {
        Funko existingFunko = funkosRepository.findById(id).orElse(null);
        if (existingFunko != null) {
            // Realiza las actualizaciones necesarias en el Funko existente
            funkosRepository.save(existingFunko);
            return ResponseEntity.ok(existingFunko);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFunko(@PathVariable Long id) {
        Funko funko = funkosRepository.findById(id).orElse(null);
        if (funko != null) {
            funkosRepository.delete(funko);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }





}
