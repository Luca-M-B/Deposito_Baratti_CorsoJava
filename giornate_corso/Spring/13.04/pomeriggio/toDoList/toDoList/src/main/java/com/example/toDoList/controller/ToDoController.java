package com.example.toDoList.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.toDoList.ToDoListApplication;
import com.example.toDoList.model.EnumStatoTask;
import com.example.toDoList.model.ToDo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    private final ToDoListApplication toDoListApplication;

    private List<ToDo> agenda = new ArrayList<>();
    private Long idCounter = 0L;

    ToDoController(ToDoListApplication toDoListApplication) {
        this.toDoListApplication = toDoListApplication;
    }

    @GetMapping
    public List<ToDo> getAll() {
        // con il get ottengo l'agenda ordinata per priorità da ALTA a BASSA
        return agenda.stream().sorted(Comparator.comparingInt((ToDo t) -> t.getPriorita().getLivello())).toList();
    }

    @PostMapping
    public ToDo aggiungiToDo(@RequestBody ToDo toDo) {
        toDo.setId(++idCounter);
        agenda.add(toDo);
        return toDo;
    }

    @GetMapping("/{id}")
    public ToDo getById(@PathVariable Long id) {
        return agenda.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }

    @PutMapping("/{id}")
    public ToDo aggiorna(@PathVariable Long id, @RequestBody ToDo modificato) {
        for (ToDo t : agenda) {
            if (t.getId().equals(id)) {

                EnumStatoTask statoCorrente = t.getStato();
                EnumStatoTask nuovoStato = modificato.getStato();

                if (nuovoStato != null && !cambioStato(statoCorrente, nuovoStato)) {
                    throw new IllegalStateException("Transizione di stato non consentita");
                }

                t.setTitolo(modificato.getTitolo());
                t.setDescrizione(modificato.getDescrizione());

                if (nuovoStato != null) {
                    t.setStato(nuovoStato);
                }

                return t;
            }
        }

        throw new IllegalArgumentException("Task non trovato");
    }

    @DeleteMapping("/{id}")
    public String elimina(@PathVariable Long id) {
        agenda.removeIf(t -> t.getId().equals(id));
        return "Nota eliminata in agenda";
    }

    private boolean cambioStato(EnumStatoTask statoCorrente, EnumStatoTask nuovoStato) {

        if (statoCorrente == EnumStatoTask.TO_DO) {
            return nuovoStato == EnumStatoTask.IN_PROGRESS || nuovoStato == EnumStatoTask.CANCELLED;
        }

        if (statoCorrente == EnumStatoTask.IN_PROGRESS) {
            return nuovoStato == EnumStatoTask.DONE || nuovoStato == EnumStatoTask.CANCELLED;
        }

        if (statoCorrente == EnumStatoTask.DONE || statoCorrente == EnumStatoTask.CANCELLED) { // done e cancelled non
                                                                                               // consetito
            // procedere
            return false;
        }

        return false;
    }

}
