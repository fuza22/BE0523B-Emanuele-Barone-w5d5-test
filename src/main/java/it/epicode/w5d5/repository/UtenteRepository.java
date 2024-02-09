package it.epicode.w5d5.repository;

import it.epicode.w5d5.bean.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Integer> {

    public List<Utente> findById(int id);



}
