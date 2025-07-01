package com.henriqueapi.carros.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarroResponseDTO {

    private Long id;
    private String nome;
    private String marca;
    private String cor;
    private int ano;

}
