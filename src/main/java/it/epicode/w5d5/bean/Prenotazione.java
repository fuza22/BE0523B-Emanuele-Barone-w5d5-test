package it.epicode.w5d5.bean;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Entity
@Component("prenotazione")
@Data
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private LocalDate dataPrenotazione;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "utente_fk")
    private Utente utente;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "postazione_fk")
    private Postazione postazione;





}
