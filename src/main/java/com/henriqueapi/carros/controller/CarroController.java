package com.henriqueapi.carros.controller;

import com.henriqueapi.carros.dtos.CarroRequestDTO;
import com.henriqueapi.carros.dtos.CarroResponseDTO;
import com.henriqueapi.carros.services.CarroService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.henriqueapi.carros.repository.CarroRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/api/carros")
public class CarroController {

    @Autowired
    private CarroRepository repository;

    @Autowired
    private CarroService service;

    @GetMapping
    public ResponseEntity<List<CarroResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<CarroResponseDTO> create(@RequestBody CarroRequestDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarroResponseDTO> update (@PathVariable Long id, @RequestBody CarroRequestDTO dto){
        try{
            CarroResponseDTO response = service.update(id, dto);
            return ResponseEntity.ok(response);
        } catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
