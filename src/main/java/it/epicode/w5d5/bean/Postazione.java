package it.epicode.w5d5.bean;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Component("postazione")
@Data
public class Postazione {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    @Enumerated(EnumType.STRING)
    private Stato stato;
    private int numeroMassimoOccupanti;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "edificio_fk")
    private Edificio edificio;

    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioni;


}
