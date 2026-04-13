package com.example.toDoList.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDo {

    private Long id;
    private String titolo;
    private String descrizione;
    private EnumStatoTask stato = EnumStatoTask.TO_DO;
    private EnumPriorita priorita = EnumPriorita.BASSA;

}
