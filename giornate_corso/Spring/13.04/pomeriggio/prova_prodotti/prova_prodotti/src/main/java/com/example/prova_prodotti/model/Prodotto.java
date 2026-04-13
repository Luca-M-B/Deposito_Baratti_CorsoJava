package com.example.prova_prodotti.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prodotto {

    private Long id;
    private String nome;
    private double prezzo;

}