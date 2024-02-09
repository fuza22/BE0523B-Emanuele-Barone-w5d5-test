package it.epicode.w5d5;

import it.epicode.w5d5.bean.*;
import it.epicode.w5d5.service.EdificioService;
import it.epicode.w5d5.service.PostazioneService;
import it.epicode.w5d5.service.PrenotazioneService;
import it.epicode.w5d5.service.UtenteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@PropertySource("application.properties")
public class Runner implements CommandLineRunner {


    @Autowired
    private EdificioService edificioService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private PrenotazioneService prenotazioneService;
    @Autowired
    private UtenteService utenteService;


    private Logger logger = LoggerFactory.getLogger("w5d5");

    @Override
    public void run(String... args) throws Exception {

        logger.info("Runner");

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(W5d5Application.class);
        try {
            logger.info("Stampa");

            Edificio edificio1 = ctx.getBean(Edificio.class);
            edificio1.setNome("Edificio A");
            edificio1.setCitta("Palermo");
            edificio1.setIndirizzo("Via Tal de Tali,1");
            edificioService.salvaEdificio(edificio1);

            Postazione postazione1 = ctx.getBean(Postazione.class);
            postazioneService.salvaPostazione(postazione1);


            Prenotazione prenotazione1 = ctx.getBean(Prenotazione.class);
            prenotazione1.setDataPrenotazione(LocalDate.of(2024, 2, 9));
            prenotazione1.setPostazione(postazioneService.cercaPostazionePerId(52));
            prenotazioneService.salvaPrenotazione(prenotazione1);


            Utente utente1 = ctx.getBean(Utente.class);
            utenteService.salvaUtente(utente1);
        }catch (IllegalStateException e){

            logger.error(e.getMessage());

        }
    }
}
