package com.example.gestionalepizzeria.config;

import com.example.gestionalepizzeria.model.Ingrediente;
import com.example.gestionalepizzeria.model.Utente;
import com.example.gestionalepizzeria.repository.IngredienteRepository;
import com.example.gestionalepizzeria.repository.PizzaRepository;
import com.example.gestionalepizzeria.repository.UtenteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UtenteRepository utenteRepository,
            IngredienteRepository ingredienteRepository,
            PizzaRepository pizzaRepository) {
        return args -> {
            // utenti iniziali
            if (utenteRepository.count() == 0) {
                utenteRepository.save(new Utente(null, "Mario Rossi", false));
                utenteRepository.save(new Utente(null, "Luigi Verdi", false));
                utenteRepository.save(new Utente(null, "Admin Pizzeria", true));
            }

            // ingredienti e prezzi iniziali
            if (ingredienteRepository.count() == 0) {
                ingredienteRepository.save(new Ingrediente(null, "Mozzarella", 1.5));
                ingredienteRepository.save(new Ingrediente(null, "Funghi", 3.0));
                ingredienteRepository.save(new Ingrediente(null, "Salsiccia", 2.5));
                ingredienteRepository.save(new Ingrediente(null, "Prosciutto Cotto", 2.0));
                ingredienteRepository.save(new Ingrediente(null, "Prosciutto Crudo", 3.0));
                ingredienteRepository.save(new Ingrediente(null, "Basilico", 0.5));
                ingredienteRepository.save(new Ingrediente(null, "Olive", 1.0));
                ingredienteRepository.save(new Ingrediente(null, "Carciofini", 1.5));
                ingredienteRepository.save(new Ingrediente(null, "Patate", 1.5));
                ingredienteRepository.save(new Ingrediente(null, "Wurstel", 1.0));
                ingredienteRepository.save(new Ingrediente(null, "Gorgonzola", 1.5));
                ingredienteRepository.save(new Ingrediente(null, "Rucola", 0.5));
                ingredienteRepository.save(new Ingrediente(null, "Salmone", 4.0));
                ingredienteRepository.save(new Ingrediente(null, "Nutella", 2.5));
            }

        };
    }
}
