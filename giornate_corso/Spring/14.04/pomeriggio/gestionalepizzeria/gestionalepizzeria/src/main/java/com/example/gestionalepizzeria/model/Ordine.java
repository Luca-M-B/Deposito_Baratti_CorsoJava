package com.example.gestionalepizzeria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ordini")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ordine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Utente utente;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ordini_pizze", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "pizza_id"))
    private List<Pizza> listaPizze;

    private Double prezzoTotale;

    private LocalDateTime dataOrdine;
}
