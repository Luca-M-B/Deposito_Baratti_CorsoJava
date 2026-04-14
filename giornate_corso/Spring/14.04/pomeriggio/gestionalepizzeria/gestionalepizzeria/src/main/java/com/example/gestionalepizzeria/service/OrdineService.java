package com.example.gestionalepizzeria.service;

import com.example.gestionalepizzeria.model.Ordine;
import com.example.gestionalepizzeria.model.Pizza;
import com.example.gestionalepizzeria.repository.OrdineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrdineService {

    @Autowired
    private OrdineRepository ordineRepository;

    public List<Ordine> findAll() {
        return ordineRepository.findAll();
    }

    public Optional<Ordine> findById(Long id) {
        return ordineRepository.findById(id);
    }

    public Ordine save(Ordine ordine) {
        if (ordine.getUtente() != null && ordine.getUtente().isAdmin()) {
            throw new RuntimeException("Gli amministratori non possono effettuare ordini.");
        }

        if (ordine.getDataOrdine() == null) {
            ordine.setDataOrdine(LocalDateTime.now());
        }

        if (ordine.getPrezzoTotale() == null || ordine.getPrezzoTotale() == 0.0) {
            double total = 0.0;
            if (ordine.getListaPizze() != null) {
                for (Pizza p : ordine.getListaPizze()) {
                    if (p.getPrezzo() != null) {
                        total += p.getPrezzo();
                    }
                }
            }
            ordine.setPrezzoTotale(total);
        }

        return ordineRepository.save(ordine);
    }

    public void deleteById(Long id) {
        ordineRepository.deleteById(id);
    }
}
