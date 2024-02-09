package it.epicode.w5d5.service;

import it.epicode.w5d5.bean.Postazione;
import it.epicode.w5d5.bean.Prenotazione;
import it.epicode.w5d5.bean.Utente;
import it.epicode.w5d5.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.server.ExportException;
import java.time.LocalDate;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public void salvaPrenotazione(Prenotazione prenotazione) throws Exception, IllegalStateException{
//        verificaCampi(prenotazione);

        LocalDate dataPrenotazione = prenotazione.getDataPrenotazione();
        Postazione postazione = prenotazione.getPostazione();
        boolean postazioneOccupata = prenotazioneRepository.verificaPrenotazione(postazione, dataPrenotazione);
        boolean disponibilitaUtente = prenotazioneRepository.verificaDisponibilitaUtente(prenotazione.getUtente(), dataPrenotazione);

        if(postazioneOccupata){

            throw new IllegalStateException("La postazione è occupata, scegli un'altro giorno.");

        }

        if(disponibilitaUtente){

            throw new IllegalStateException("Hai già una prenotazione attiva per la data selezionata.");

        }

        prenotazioneRepository.save(prenotazione);

    }


    public void aggiornaPrenotazione(Prenotazione prenotazione){

        Prenotazione p = prenotazioneRepository.findById(prenotazione.getId());
        p.setUtente(prenotazione.getUtente());
        p.setPostazione(prenotazione.getPostazione());
        prenotazioneRepository.save(prenotazione);

    }

    public Prenotazione cercaPrenotazionePerId(int id){

        return prenotazioneRepository.findById(id);

    }


    public void cancellaPrenotazione(int id){

        prenotazioneRepository.deleteById(id);

    }

    public void verificaCampi(Prenotazione p) throws Exception{

        if(p.getDataPrenotazione() == null){

            throw new Exception("Imposta una data per effettuare una prenotazione.");

        }

        if(p.getPostazione() == null){

            throw new Exception("Associa una postazione per effettuare una prenotazione.");

        }

        if(p.getUtente() == null){

            throw new Exception("Associa un utente alla prenotazione.");

        }

    }

}
