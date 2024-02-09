package it.epicode.w5d5.service;



import it.epicode.w5d5.bean.Postazione;
import it.epicode.w5d5.bean.Tipo;
import it.epicode.w5d5.repository.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    public void salvaPostazione(Postazione postazione){

        postazioneRepository.save(postazione);

    }

    public void aggiornaPostazione(Postazione postazione){

        Postazione p = postazioneRepository.findById(postazione.getId());
        p.setDescrizione(postazione.getDescrizione());
        p.setEdificio(postazione.getEdificio());
        p.setStato(postazione.getStato());
        p.setTipo(postazione.getTipo());
        p.setNumeroMassimoOccupanti(postazione.getNumeroMassimoOccupanti());
        p.setPrenotazioni(postazione.getPrenotazioni());
        postazioneRepository.save(p);

    }

    public Postazione cercaPostazionePerId(int id){

        return postazioneRepository.findById(id);

    }


    public void cancellaPrenotazione(int id){

        postazioneRepository.deleteById(id);

    }

    public List<Postazione> cercaTipoECitta(Tipo tipoPostazione, String citta){

        return postazioneRepository.cercaPerTipoECitta(tipoPostazione, citta);

    }


}
