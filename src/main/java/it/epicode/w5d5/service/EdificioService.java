package it.epicode.w5d5.service;


import it.epicode.w5d5.bean.Edificio;
import it.epicode.w5d5.repository.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    public void salvaEdificio(Edificio edificio){

        edificioRepository.save(edificio);

    }

    public void aggiornaEdificio(Edificio edificio){

        Edificio e = edificioRepository.findById(edificio.getId()).get();
        e.setNome(edificio.getNome());
        e.setCitta(edificio.getCitta());
        e.setPostazioni(edificio.getPostazioni());
        e.setIndirizzo(edificio.getIndirizzo());
        edificioRepository.save(edificio);

    }

    public Edificio cercaEdificioPerId(int id){

        return edificioRepository.findById(id).get();

    }


    public void cancellaEdificio(int id){

        edificioRepository.deleteById(id);

    }
}
