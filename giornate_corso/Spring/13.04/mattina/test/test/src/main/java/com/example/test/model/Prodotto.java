package com.example.test.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Prodotto {

    private Long id;
    private String nome;
    private double prezzo;

}