package com.henriqueapi.carros.repository;

import com.henriqueapi.carros.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {

}
