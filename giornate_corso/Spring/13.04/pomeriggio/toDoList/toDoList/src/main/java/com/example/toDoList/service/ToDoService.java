package com.example.toDoList.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.toDoList.ToDoRepository;
import com.example.toDoList.model.EnumStatoTask;
import com.example.toDoList.model.ToDo;

@Service
public class ToDoService {

    private final ToDoRepository repository;

    public ToDoService(ToDoRepository repository) {
        this.repository = repository;
    }

    public List<ToDo> getAll() {
        List<ToDo> lista = new ArrayList<>();
        repository.findAll().forEach(lista::add);
        lista.sort((t1, t2) -> Integer.compare(t1.getPriorita().getLivello(), t2.getPriorita().getLivello()));
        return lista;
    }

    public Optional<ToDo> getById(Long id) {
        return repository.findById(id);
    }

    public ToDo create(ToDo nuovo) {
        return repository.save(nuovo);
    }

    public Optional<ToDo> update(Long id, ToDo modificato) {
        return repository.findById(id).map(t -> {
            EnumStatoTask statoCorrente = t.getStato();
            EnumStatoTask nuovoStato = modificato.getStato();

            if (nuovoStato != null && !cambioStato(statoCorrente, nuovoStato)) {
                throw new IllegalStateException("Transizione di stato non consentita");
            }

            if (modificato.getTitolo() != null) {
                t.setTitolo(modificato.getTitolo());
            }
            if (modificato.getDescrizione() != null) {
                t.setDescrizione(modificato.getDescrizione());
            }
            if (modificato.getPriorita() != null) {
                t.setPriorita(modificato.getPriorita());
            }
            if (nuovoStato != null) {
                t.setStato(nuovoStato);
            }
            
            return repository.save(t);
        });
    }

    private boolean cambioStato(EnumStatoTask statoCorrente, EnumStatoTask nuovoStato) {
        if (statoCorrente == EnumStatoTask.TO_DO) {
            return nuovoStato == EnumStatoTask.IN_PROGRESS || nuovoStato == EnumStatoTask.CANCELLED;
        }
        if (statoCorrente == EnumStatoTask.IN_PROGRESS) {
            return nuovoStato == EnumStatoTask.DONE || nuovoStato == EnumStatoTask.CANCELLED;
        }
        return false;
    }

    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}