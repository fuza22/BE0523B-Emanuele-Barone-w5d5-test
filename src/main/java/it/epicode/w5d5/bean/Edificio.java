package it.epicode.w5d5.bean;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Component
@Data
public class Edificio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String indirizzo;
    private String citta;

    @OneToMany(mappedBy = "edificio")
    private List<Postazione> postazioni;

}
