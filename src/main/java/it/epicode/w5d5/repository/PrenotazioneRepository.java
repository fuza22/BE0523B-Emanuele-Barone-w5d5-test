package it.epicode.w5d5.repository;

import it.epicode.w5d5.bean.Postazione;
import it.epicode.w5d5.bean.Prenotazione;
import it.epicode.w5d5.bean.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {

    public Prenotazione findById(int id);


    @Query("select count(p) > 0 from Prenotazione p where p.postazione = :postazione and p.dataPrenotazione = :dataPrenotazione")
    boolean verificaPrenotazione(Postazione postazione, LocalDate dataPrenotazione);

    @Query("select count(p) > 0 from Prenotazione p where p.utente = :utente and p.dataPrenotazione = :dataPrenotazione")
    boolean verificaDisponibilitaUtente(Utente utente, LocalDate dataPrenotazione);
}
