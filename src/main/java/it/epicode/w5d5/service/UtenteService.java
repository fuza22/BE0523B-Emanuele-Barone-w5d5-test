package it.epicode.w5d5.service;

import it.epicode.w5d5.bean.Utente;
import it.epicode.w5d5.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public void salvaUtente(Utente utente){

        utenteRepository.save(utente);

    }

//    public void aggiornaUtente(Utente utente){
//
//        Utente u = utenteRepository.findById(utente.getId()).get();
//        u.setNome(utente.getNome());
//        u.setCognome(utente.getCognome());
//        u.setEmail(utente.getEmail());
//        u.setUsername(utente.getUsername());
//        u.setPrenotazioni(utente.getPrenotazioni());
//        utenteRepository.save(utente);
//
//    }

//    public Utente cercaUtentePerId(int id){
//
//        return utenteRepository.findById(id).get();
//
//    }


    public void cancellaUtente(int id){

        utenteRepository.deleteById(id);

    }



}
