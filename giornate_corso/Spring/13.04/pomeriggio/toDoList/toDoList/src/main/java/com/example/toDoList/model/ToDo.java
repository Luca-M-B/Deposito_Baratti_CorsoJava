package com.example.toDoList.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titolo;
    private String descrizione;

    @Enumerated(EnumType.STRING)
    private EnumStatoTask stato = EnumStatoTask.TO_DO;

    @Enumerated(EnumType.STRING)
    private EnumPriorita priorita = EnumPriorita.BASSA;

}
