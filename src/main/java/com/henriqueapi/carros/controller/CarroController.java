package com.henriqueapi.carros.controller;

import com.henriqueapi.carros.entity.Carro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.henriqueapi.carros.repository.CarroRepository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/carros")
public class CarroController {

    @Autowired
    private CarroRepository repository;

    @GetMapping
    public ResponseEntity<List<Carro>> list(){
        List<Carro> result = repository.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> getCarroById(@PathVariable Long id) {
        Optional<Carro> carro = repository.findById(id);
        if (carro.isPresent()) {
            return ResponseEntity.ok(carro.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Carro carro) {
        Carro savedCarro = repository.save(carro);
        return ResponseEntity.status(201).body("Carro criado com sucesso!");
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Carro> update(@PathVariable Long id, @RequestBody Carro updatedCarro) {
        Optional<Carro> existingCarro = repository.findById(id);
        if (existingCarro.isPresent()) {
            Carro carro = existingCarro.get();
            carro.setNome(updatedCarro.getNome());
            carro.setMarca(updatedCarro.getMarca());
            carro.setAno(updatedCarro.getAno());
            carro.setCor(updatedCarro.getCor());
            Carro savedCarro = repository.save(carro);
            return ResponseEntity.ok(savedCarro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Carro> existingCarro = repository.findById(id);
        if (existingCarro.isPresent()) {
            repository.delete(existingCarro.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
