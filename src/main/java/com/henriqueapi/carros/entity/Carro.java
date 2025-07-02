package com.henriqueapi.carros.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_carros")
@Data
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String marca;
    private String cor;
    private int ano;

}
