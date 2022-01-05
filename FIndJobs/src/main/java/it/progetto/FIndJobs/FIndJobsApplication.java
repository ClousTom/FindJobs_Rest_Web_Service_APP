package it.progetto.FIndJobs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.progetto.FIndJobs.service.*;

/**
 * Classe che avvia l'applicazione Spring 
 * E fa partire lo scanner che scarica tutti i dati dalla pagina web: "https://findwork.dev/api/jobs/"
 *
 * @author Leonardo Pescetti
 * @author Claudio Tomaiuolo
 */

@SpringBootApplication
public class FIndJobsApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(FIndJobsApplication.class, args);
		Scanner.start();
		
	/**
	 * Apparirà in console l'avvio dell'applicazione spring mostrando
	 * lo stato di avanzamento dello scanner delle pagine web 	
	 */
	
	}
}