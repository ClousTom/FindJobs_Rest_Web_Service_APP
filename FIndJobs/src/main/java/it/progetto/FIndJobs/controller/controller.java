package it.progetto.FIndJobs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.progetto.FIndJobs.service.*;

/**
 * In questa classe è presente il RestController, che gestisce ogni singola rotta immessa
 * dal client e facendo le dovute chiamate delle funzioni dalla classe Scanner, 
 * permette la comunicazione tra client e server. 
 * 
 * @author Leonardo Pescetti
 * @author Claudio Tomaiuolo
 */

@RestController
public class controller {
	
	String risp;
	
    /**
     * Rotta di tipo GET che consiglia al Client delle città e dei linguaggi di programmazione su cui fare
     * le ricerche.
     * 
     * @return Una stringa con dei consigli per effettuare le ricerche.
     */
	
	@GetMapping("/help")
	public ResponseEntity<Object> Suggerimento() {
		
		risp = "FindJobs! L'applicazione rest per cercare il lavoro che fa per te! \n"
				+ "Utilizza la struttura delle rotte come indicato su GitHub. \n"
				+ "Ecco dei suggerimenti su delle città che puoi cercare: \n"
				+ "-> London \n"
				+ "-> Seattle \n"
				+ "-> Tokyo \n"
				+ "-> NYC \n"
				+ "-> Boston \n"
				+ "-> San Francisco \n"
				+ "Inoltre ecco dei suggerimenti sui linguaggi di programmazione che puoi cercare: \n"
				+ "-> JavaScript \n"
				+ "-> Python \n"
				+ "-> github \n";
		
		return new ResponseEntity<> (risp, HttpStatus.OK);
	}
	
    /**
     * Rotta di tipo GET che, presa in ingresso una città, restituisce tutte le offerte di lavoro di aziende 
     * che operano in tali città.
     * 
     * 
	* @param CityName Nome della città su cui si vogliono effettuare le ricerche.
	* @return Lista di lavori di imprese che operano in quella città richiesta dal client.	
	*/

	
	@GetMapping("/city/{CityName}")
	public ResponseEntity<Object> RicercaPerCitta(@PathVariable String CityName) {
		
		risp = Scanner.SearchCity(CityName);
		
		return new ResponseEntity<> (risp, HttpStatus.OK);
	}
	
	@GetMapping("/language/{Language}")
	public ResponseEntity<Object> RicercaPerLinguaggio(@PathVariable String Language) {
		
		risp = Scanner.SearchLanguage(Language);
		
		return new ResponseEntity<> (risp, HttpStatus.OK);
	}
	
//	@GetMapping("/remote/{Online}")
//	public ResponseEntity<Object> RicercaLavoriInRemoto(@PathVariable String Online) {
//		
//		risp = Scanner.SearchRemoteJobs();
//		
//		return new ResponseEntity<> (risp, HttpStatus.OK);
//	}
//	
//	@GetMapping("/noremote/{NoOnline}")
//	public ResponseEntity<Object> RicercaLavoriInLocale(@PathVariable String NoOnline) {
//		
//		risp = Scanner.SearchNoRemoteJobs();
//		
//		return new ResponseEntity<> (risp, HttpStatus.OK);
//	}
	
	//inizio modifiche
	@GetMapping("/isremote/{TrueOrFalse}")
	public ResponseEntity<Object> RicercaLavoriInRemoto2(@PathVariable String TrueOrFalse) {
		
		risp = Scanner.RemoteVerify(TrueOrFalse);
		
		return new ResponseEntity<> (risp, HttpStatus.OK);
	}
	 
	@GetMapping("/search/language/{Language}/cities/{City1}")
	public ResponseEntity<Object> RicercaCombinata1(@PathVariable String Language,@PathVariable String City1){
		
		risp=Scanner.CombinedSearch1(Language,City1);
		
		return new ResponseEntity<>(risp, HttpStatus.OK);
	}
		
	@GetMapping("/search/language/{Language}/cities/{City1}/{City2}")
	public ResponseEntity<Object> RicercaCombinata2(@PathVariable String Language,@PathVariable String City1,
	@PathVariable String City2){
		
		risp=Scanner.CombinedSearch1(Language,City1)+Scanner.CombinedSearch1(Language, City2);
		
		return new ResponseEntity<>(risp, HttpStatus.OK);
	}
	
//	@GetMapping("/search/lang/{Language}/cities/{City1}/{City2}/{City3}")
//	public ResponseEntity<Object> RicercaCombinata3(@PathVariable String Language,@PathVariable String City1,
//	@PathVariable String City2, @PathVariable String City3){
//		
//		risp=Scanner.CombinedSearch3(Language,City1,City2,City3);
//		
//		return new ResponseEntity<>(risp, HttpStatus.OK);
//	}
//	
	
	@GetMapping("/search/language/{Language}/cities/{City1}/{City2}/{City3}")
	public ResponseEntity<Object> RicercaCombinata3(@PathVariable String Language,@PathVariable String City1,
	@PathVariable String City2,@PathVariable String City3){
		
		risp=Scanner.CombinedSearch1(Language,City1)+Scanner.CombinedSearch1(Language, City2)
		+Scanner.CombinedSearch1(Language, City3);
		
		return new ResponseEntity<>(risp, HttpStatus.OK);
	}
	
	@GetMapping("/search/language/{Language}/cities/{City1}/{City2}/{City3}/{City4}")
	public ResponseEntity<Object> RicercaCombinata4(@PathVariable String Language,@PathVariable String City1,
	@PathVariable String City2,@PathVariable String City3,@PathVariable String City4){
		
		risp=Scanner.CombinedSearch1(Language,City1)+Scanner.CombinedSearch1(Language, City2)
		+Scanner.CombinedSearch1(Language, City3)+Scanner.CombinedSearch1(Language, City4);
		
		return new ResponseEntity<>(risp, HttpStatus.OK);
	}
	
	@GetMapping("/search/language/{Language}/cities/{City1}/{City2}/{City3}/{City4}/{City5}")
	public ResponseEntity<Object> RicercaCombinata4(@PathVariable String Language,@PathVariable String City1,
	@PathVariable String City2,@PathVariable String City3,@PathVariable String City4,
	@PathVariable String City5){
		
		risp=Scanner.CombinedSearch1(Language,City1)+Scanner.CombinedSearch1(Language, City2)
		+Scanner.CombinedSearch1(Language, City3)+Scanner.CombinedSearch1(Language, City4)
		+Scanner.CombinedSearch1(Language, City5);
		
		return new ResponseEntity<>(risp, HttpStatus.OK);
	}
	
	
	
	
	
	@GetMapping("/search/language/{Language}/cities/{City1}/remote/{TrueOrFalse}")
	public ResponseEntity<Object> RicercaCombinata5(@PathVariable String Language,@PathVariable String City1,
			@PathVariable String TrueOrFalse){
		
		risp=Scanner.CombinedSearch2(Language,City1,TrueOrFalse);
		
		return new ResponseEntity<>(risp, HttpStatus.OK);
	}
	
	@GetMapping("/search/language/{Language}/cities/{City1}/{City2}/remote/{TrueOrFalse}")
	public ResponseEntity<Object> RicercaCombinata6(@PathVariable String Language,@PathVariable String City1,
	@PathVariable String City2,@PathVariable String TrueOrFalse){
		
		risp=Scanner.CombinedSearch2(Language,City1,TrueOrFalse)+
				Scanner.CombinedSearch2(Language,City2,TrueOrFalse);
		
		return new ResponseEntity<>(risp, HttpStatus.OK);
	}
	
	@GetMapping("/search/language/{Language}/cities/{City1}/{City2}/{City3}/remote/{TrueOrFalse}")
	public ResponseEntity<Object> RicercaCombinata7(@PathVariable String Language,@PathVariable String City1,
	@PathVariable String City2,@PathVariable String City3,@PathVariable String TrueOrFalse){
		
		risp=Scanner.CombinedSearch2(Language,City1,TrueOrFalse)+
		Scanner.CombinedSearch2(Language,City2,TrueOrFalse)+
		Scanner.CombinedSearch2(Language,City3,TrueOrFalse);
		
		return new ResponseEntity<>(risp, HttpStatus.OK);
	}
	
	@GetMapping("/search/language/{Language}/cities/{City1}/{City2}/{City3}/{City4}/remote/{TrueOrFalse}")
	public ResponseEntity<Object> RicercaCombinata8(@PathVariable String Language,@PathVariable String City1,
	@PathVariable String City2,@PathVariable String City3,@PathVariable String City4
	,@PathVariable String TrueOrFalse){
		
		risp=Scanner.CombinedSearch2(Language,City1,TrueOrFalse)+
				Scanner.CombinedSearch2(Language,City2,TrueOrFalse)+
				Scanner.CombinedSearch2(Language,City3,TrueOrFalse)+
				Scanner.CombinedSearch2(Language,City4,TrueOrFalse);
		
		return new ResponseEntity<>(risp, HttpStatus.OK);
	}
	
	@GetMapping("/search/language/{Language}/cities/{City1}/{City2}/{City3}/{City4}/{City5}/remote/{TrueOrFalse}")
	public ResponseEntity<Object> RicercaCombinata9(@PathVariable String Language,@PathVariable String City1,
	@PathVariable String City2,@PathVariable String City3,@PathVariable String City4,
	@PathVariable String City5,@PathVariable String TrueOrFalse){
		
		risp=Scanner.CombinedSearch2(Language,City1,TrueOrFalse)+
		Scanner.CombinedSearch2(Language,City2,TrueOrFalse)+
		Scanner.CombinedSearch2(Language,City3,TrueOrFalse)+
		Scanner.CombinedSearch2(Language,City4,TrueOrFalse)+
		Scanner.CombinedSearch2(Language,City5,TrueOrFalse);
		
		return new ResponseEntity<>(risp, HttpStatus.OK);
	}
	

	
	//fine modifiche
}
