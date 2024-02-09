package it.epicode.w5d5.bean;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ListResourceBundle;

@Entity
@Component("utente")
@Data
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String nome;
    private String cognome;
    private String email;

    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioni;


}
