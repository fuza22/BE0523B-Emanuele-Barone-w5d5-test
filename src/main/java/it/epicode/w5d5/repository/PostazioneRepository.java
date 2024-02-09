package it.epicode.w5d5.repository;

import it.epicode.w5d5.bean.Postazione;
import it.epicode.w5d5.bean.Prenotazione;
import it.epicode.w5d5.bean.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Integer> {

    public Postazione findById(int id);

    @Query("select p from Postazione p where p.tipo = :tipoPostazione and p.edificio.citta = :citta")
    List<Postazione> cercaPerTipoECitta(Tipo tipoPostazione, String citta);

}
