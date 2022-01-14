package it.progetto.FIndJobs.controller;



import javax.tools.Diagnostic;

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
	
	String answer;
    /**
     * Rotta di tipo GET che consiglia al Client delle città e dei linguaggi di programmazione su cui fare
     * le ricerche.
     * 
     * @return Una stringa con dei consigli per effettuare le ricerche.
     */
	
	@GetMapping("/help")
	public ResponseEntity<Object> Suggerimento() {
		
		answer = "FindJobs! L'applicazione rest per cercare il lavoro che fa per te! \n"
				+ "Utilizza la struttura delle rotte come indicato su GitHub. \n"
				+ "Ecco dei suggerimenti su delle città che puoi cercare: \n"
				+ "-> London \n"
				+ "-> Seattle \n"
				+ "-> Tokyo \n"
				+ "-> NYC \n"
				+ "-> Boston \n"
				+ "Inoltre ecco dei suggerimenti sui linguaggi di programmazione che puoi cercare: \n"
				+ "-> JavaScript \n"
				+ "-> Python \n"
				+ "-> github \n";
		
		return new ResponseEntity<> (answer, HttpStatus.OK);
	}
	
    /**
     * Rotta di tipo GET che, presa in ingresso una città, restituisce tutte le offerte di lavoro di aziende 
     * che operano in tali città.
     * Il risultato della ricerca sarà composto dai vari lavori che avranno la seguente struttura:
     * 
     * 
	* @param CityName Nome della città su cui si vogliono effettuare le ricerche.
	* @return Lista di lavori di imprese che operano in quella città richiesta dal client.	
	*/

	
	@GetMapping("/city/{CityName}")
	public ResponseEntity<Object> RicercaPerCitta(@PathVariable String CityName) {
		
		answer = Scanner.SearchCity(CityName);
		
		return new ResponseEntity<> (answer, HttpStatus.OK);

	}
	
   /** Si avrà una serie di risposte dal server strutturate nel modo seguente:
	* {
	*	Id:102905
	*	Role:Senior Node.js Full-stack developer
	*	Company name:Blueprint.store
	*	Company number of employees:null
	*	Employment type:null
	*	Location:London, UK
	*	Remote:true
	*	Logo:null
	*	Url:https://findwork.dev/102905/senior-nodejs-full-stack-developer-at-blueprintstore
	*	Text:Salary depending on experience [...].
	*	Date posted:2022-01-05T16:33:18Z
	*	Keywords:redux, aws, gcp
	*	Source:Hn
	*	}	
	*/
	
	
	
	/**
     * Rotta di tipo GET che, preso in ingresso un linguaggio di programmazione, restituisce
     * tutte le offerte di lavoro di aziende che lavorano con quei linguaggi di programmazione.
     * 
     * 
	* @param Language Nome del linguaggio di programmazione su cui si vogliono effettuare le ricerche.
	* @return Lista di lavori di imprese che utilizzano quel linguaggio richiesto dal client.	
	*/
	
	@GetMapping("/language/{Language}")
	public ResponseEntity<Object> RicercaPerLinguaggio(@PathVariable String Language) {
		
		answer = Scanner.SearchLanguage(Language);
		
		return new ResponseEntity<> (answer, HttpStatus.OK);		 	
	}
	
	/**
     * Rotta di tipo GET che, preso in ingresso true o false, restituisce se "true" la lista di lavori che 
     * operano anche con il lavoro a distanza; mentre se "false" restituisce la lista di lavori che non operano
     * con il lavoro a distanza.
     * 
	* @param TrueOrFalse Richiesta per la ricerca dei lavori a distanza o in presenza.
	* @return Lista di lavori di imprese che operano o meno(a seconda della scelta del client) a distanza.
	*/	

	@GetMapping("/isremote/{TrueOrFalse}")
	public ResponseEntity<Object> RicercaLavoriInRemoto2(@PathVariable String TrueOrFalse) {
		
		if (!TrueOrFalse.toLowerCase().equals("true") && !TrueOrFalse.toLowerCase().equals("false")){
			answer = "Hai commesso un errore nella ricerca.";
		} else answer = Scanner.RemoteVerify(TrueOrFalse);
		
		return new ResponseEntity<> (answer, HttpStatus.OK);
	}
	 
	/**
     * Rotta di tipo GET, che presi in ingresso un linguaggio di programmazione e una città, restituisce al
     * client la lista di lavori che operano in quella città ed utilizzano quel linguaggio di programmazione.
     * 
	* @param Language Nome del linguaggio di programmazione su cui si vogliono effettuare le ricerche.
	* @param City1 Nome della città su cui si vogliono effettuare le ricerche.
	* @return Lista di lavori di imprese che operano nella città scelta dal client, con quel linguaggio di
	* programmazione scelto dal client.
	*/
	
	@GetMapping("/search/language/{Language}/cities/{City1}")
	public ResponseEntity<Object> RicercaCombinata1(@PathVariable String Language,@PathVariable String City1){
		
		answer=Scanner.CombinedSearch1(Language,City1);
		
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}
		
	/**
     * Rotta di tipo GET, che presi in ingresso un linguaggio di programmazione e 2 città, restituisce al
     * client la lista di lavori che operano in tali città ed utilizzano quel linguaggio di programmazione.
     * 
	* @param Language Nome del linguaggio di programmazione su cui si vogliono effettuare le ricerche.
	* @param City1 Nome della prima città su cui si vogliono effettuare le ricerche.
	* @param City2 Nome della seconda città su cui si vogliono effettuare le ricerche.
	* @return Lista di lavori di imprese che operano nelle città scelte dal client, con quel linguaggio di
	* programmazione scelto dal client.
	*/
	
	@GetMapping("/search/language/{Language}/cities/{City1}/{City2}")
	public ResponseEntity<Object> RicercaCombinata2(@PathVariable String Language,@PathVariable String City1,
	@PathVariable String City2){
		
		//answer=Scanner.CombinedSearch1(Language,City1)+Scanner.CombinedSearch1(Language, City2);
		answer=Scanner.CombinedSearch2(Language, City1, City2);
		
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}
	
	/**
     * Rotta di tipo GET, che presi in ingresso un linguaggio di programmazione e 3 città, restituisce al
     * client la lista di lavori che operano in tali città ed utilizzano quel linguaggio di programmazione.
     * 
	* @param Language Nome del linguaggio di programmazione su cui si vogliono effettuare le ricerche.
	* @param City1 Nome della prima città su cui si vogliono effettuare le ricerche.
	* @param City2 Nome della seconda città su cui si vogliono effettuare le ricerche.
	* @param City3 Nome della terza città su cui si vogliono effettuare le ricerche.
	* @return Lista di lavori di imprese che operano nelle città scelte dal client, con quel linguaggio di
	* programmazione scelto dal client.
	*/
	
	@GetMapping("/search/language/{Language}/cities/{City1}/{City2}/{City3}")
	public ResponseEntity<Object> RicercaCombinata3(@PathVariable String Language,@PathVariable String City1,
	@PathVariable String City2,@PathVariable String City3){
		
		answer=Scanner.CombinedSearch3(Language, City1, City2, City3);
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}
	
	/**
     * Rotta di tipo GET, che presi in ingresso un linguaggio di programmazione e 4 città, restituisce al
     * client la lista di lavori che operano in tali città ed utilizzano quel linguaggio di programmazione.
     * 
	* @param Language Nome del linguaggio di programmazione su cui si vogliono effettuare le ricerche.
	* @param City1 Nome della prima città su cui si vogliono effettuare le ricerche.
	* @param City2 Nome della seconda città su cui si vogliono effettuare le ricerche.
	* @param City3 Nome della terza città su cui si vogliono effettuare le ricerche.
	* @param City4 Nome della quarta città su cui si vogliono effettuare le ricerche.
	* @return Lista di lavori di imprese che operano nelle città scelte dal client, con quel linguaggio di
	* programmazione scelto dal client.
	*/
	
	@GetMapping("/search/language/{Language}/cities/{City1}/{City2}/{City3}/{City4}")
	public ResponseEntity<Object> RicercaCombinata4(@PathVariable String Language,@PathVariable String City1,
	@PathVariable String City2,@PathVariable String City3,@PathVariable String City4){
		
		answer=Scanner.CombinedSearch4(Language, City1, City2, City3, City4);
		
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}
	
	/**
     * Rotta di tipo GET, che presi in ingresso un linguaggio di programmazione e 5 città, restituisce al
     * client la lista di lavori che operano in tali città ed utilizzano quel linguaggio di programmazione.
     * 
	* @param Language Nome del linguaggio di programmazione su cui si vogliono effettuare le ricerche.
	* @param City1 Nome della prima città su cui si vogliono effettuare le ricerche.
	* @param City2 Nome della seconda città su cui si vogliono effettuare le ricerche.
	* @param City3 Nome della terza città su cui si vogliono effettuare le ricerche.
	* @param City4 Nome della quarta città su cui si vogliono effettuare le ricerche.
	* @param City5 Nome della quinta città su cui si vogliono effettuare le ricerche.
	* @return Lista di lavori di imprese che operano nelle città scelte dal client, con quel linguaggio di
	* programmazione scelto dal client.
	*/
	
	@GetMapping("/search/language/{Language}/cities/{City1}/{City2}/{City3}/{City4}/{City5}")
	public ResponseEntity<Object> RicercaCombinata5(@PathVariable String Language,@PathVariable String City1,
	@PathVariable String City2,@PathVariable String City3,@PathVariable String City4,
	@PathVariable String City5){
		
		answer=Scanner.CombinedSearch5(Language,City1,City2,City3,City4,City5);
		
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}
	
	/**
     * Rotta di tipo GET, che presi in ingresso un linguaggio di programmazione, una città e la tipologia
     * di lavoro(se a distanza o meno, sempre scrivendo "true" o "false" nella rotta), restituisce al client
     * la lista di lavori che operano in quella città, utilizzano quel linguaggio di programmazione e
     * svolgono il lavoro in remoto o solo in presenza.
     * 
     * @param Language Nome del linguaggio di programmazione su cui si vogliono effettuare le ricerche.
     * @param City1 Nome della città su cui si vogliono effettuare le ricerche.
     * @param TrueOrFalse Richiesta per la ricerca dei lavori a distanza o in presenza.
     * @return Lista di lavori di imprese che operano nella città scelta dal client, con quel linguaggio di
     * programmazione scelto dal client e che operino nella modalità(distanza  o presenza) scelta dal client.
     */
	
	@GetMapping("/search/language/{Language}/cities/{City1}/remote/{TrueOrFalse}")
	public ResponseEntity<Object> RicercaCombinata6(@PathVariable String Language,@PathVariable String City1,
			@PathVariable String TrueOrFalse){
		
		if (!TrueOrFalse.toLowerCase().equals("true") && !TrueOrFalse.toLowerCase().equals("false")){
			answer = "Hai commesso un errore nella ricerca.";
		} else answer=Scanner.CombinedSearch6(Language,City1,TrueOrFalse);
		
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}
	
	/**
     * Rotta di tipo GET, che presi in ingresso un linguaggio di programmazione, 2 città e la tipologia
     * di lavoro(se a distanza o meno, sempre scrivendo "true" o "false" nella rotta), restituisce al client
     * la lista di lavori che operano in quelle città, utilizzano quel linguaggio di programmazione e
     * svolgono il lavoro in remoto o solo in presenza.
     * 
     * @param Language Nome del linguaggio di programmazione su cui si vogliono effettuare le ricerche.
     * @param City1 Nome della prima città su cui si vogliono effettuare le ricerche.
     * @param City2 Nome della seconda città su cui si vogliono effettuare le ricerche.
     * @param TrueOrFalse Richiesta per la ricerca dei lavori a distanza o in presenza.
     * @return Lista di lavori di imprese che operano nelle città scelte dal client, con quel linguaggio di
     * programmazione scelto dal client e che operino nella modalità(distanza  o presenza) scelta dal client.
     */
	
	@GetMapping("/search/language/{Language}/cities/{City1}/{City2}/remote/{TrueOrFalse}")
	public ResponseEntity<Object> RicercaCombinata7(@PathVariable String Language,@PathVariable String City1,
	@PathVariable String City2,@PathVariable String TrueOrFalse){
		
		if (!TrueOrFalse.toLowerCase().equals("true") && !TrueOrFalse.toLowerCase().equals("false")){
			answer = "Hai commesso un errore nella ricerca.";
		} else answer=Scanner.CombinedSearch7(Language,City1,City2,TrueOrFalse);
		
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}
	
	/**
     * Rotta di tipo GET, che presi in ingresso un linguaggio di programmazione, 3 città e la tipologia
     * di lavoro(se a distanza o meno, sempre scrivendo "true" o "false" nella rotta), restituisce al client
     * la lista di lavori che operano in quelle città, utilizzano quel linguaggio di programmazione e
     * svolgono il lavoro in remoto o solo in presenza.
     * 
     * @param Language Nome del linguaggio di programmazione su cui si vogliono effettuare le ricerche.
     * @param City1 Nome della prima città su cui si vogliono effettuare le ricerche.
     * @param City2 Nome della seconda città su cui si vogliono effettuare le ricerche.
     * @param City3 Nome della terza città su cui si vogliono effettuare le ricerche.
     * @param TrueOrFalse Richiesta per la ricerca dei lavori a distanza o in presenza.
     * @return Lista di lavori di imprese che operano nelle città scelte dal client, con quel linguaggio di
     * programmazione scelto dal client e che operino nella modalità(distanza  o presenza) scelta dal client.
     */
	
	@GetMapping("/search/language/{Language}/cities/{City1}/{City2}/{City3}/remote/{TrueOrFalse}")
	public ResponseEntity<Object> RicercaCombinata8(@PathVariable String Language,@PathVariable String City1,
	@PathVariable String City2,@PathVariable String City3,@PathVariable String TrueOrFalse){
		
		if (!TrueOrFalse.toLowerCase().equals("true") && !TrueOrFalse.toLowerCase().equals("false")){
			answer = "Hai commesso un errore nella ricerca.";
		} else answer=Scanner.CombinedSearch8(Language,City1,City2,City3,TrueOrFalse);
		
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}
	
	/**
     * Rotta di tipo GET, che presi in ingresso un linguaggio di programmazione, 4 città e la tipologia
     * di lavoro(se a distanza o meno, sempre scrivendo "true" o "false" nella rotta), restituisce al client
     * la lista di lavori che operano in quelle città, utilizzano quel linguaggio di programmazione e
     * svolgono il lavoro in remoto o solo in presenza.
     * 
     * @param Language Nome del linguaggio di programmazione su cui si vogliono effettuare le ricerche.
     * @param City1 Nome della prima città su cui si vogliono effettuare le ricerche.
     * @param City2 Nome della seconda città su cui si vogliono effettuare le ricerche.
     * @param City3 Nome della terza città su cui si vogliono effettuare le ricerche.
     * @param City4 Nome della quarta città su cui si vogliono effettuare le ricerche.
     * @param TrueOrFalse Richiesta per la ricerca dei lavori a distanza o in presenza.
     * @return Lista di lavori di imprese che operano nelle città scelte dal client, con quel linguaggio di
     * programmazione scelto dal client e che operino nella modalità(distanza  o presenza) scelta dal client.
     */
	
	@GetMapping("/search/language/{Language}/cities/{City1}/{City2}/{City3}/{City4}/remote/{TrueOrFalse}")
	public ResponseEntity<Object> RicercaCombinata9(@PathVariable String Language,@PathVariable String City1,
	@PathVariable String City2,@PathVariable String City3,@PathVariable String City4
	,@PathVariable String TrueOrFalse){
		
		if (!TrueOrFalse.toLowerCase().equals("true") && !TrueOrFalse.toLowerCase().equals("false")){
			answer = "Hai commesso un errore nella ricerca.";
		} else answer=Scanner.CombinedSearch9(Language,City1,City2,City3,City4,TrueOrFalse);
		
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}

	/**
     * Rotta di tipo GET, che presi in ingresso un linguaggio di programmazione, 5 città e la tipologia
     * di lavoro(se a distanza o meno, sempre scrivendo "true" o "false" nella rotta), restituisce al client
     * la lista di lavori che operano in quelle città, utilizzano quel linguaggio di programmazione e
     * svolgono il lavoro in remoto o solo in presenza.
     * 
     * @param Language Nome del linguaggio di programmazione su cui si vogliono effettuare le ricerche.
     * @param City1 Nome della prima città su cui si vogliono effettuare le ricerche.
     * @param City2 Nome della seconda città su cui si vogliono effettuare le ricerche.
     * @param City3 Nome della terza città su cui si vogliono effettuare le ricerche.
     * @param City4 Nome della quarta città su cui si vogliono effettuare le ricerche.
     * @param City5 Nome della quinta città su cui si vogliono effettuare le ricerche.
     * @param TrueOrFalse Richiesta per la ricerca dei lavori a distanza o in presenza.
     * @return Lista di lavori di imprese che operano nelle città scelte dal client, con quel linguaggio di
     * programmazione scelto dal client e che operino nella modalità(distanza  o presenza) scelta dal client.
     */	
	
	@GetMapping("/search/language/{Language}/cities/{City1}/{City2}/{City3}/{City4}/{City5}/remote/{TrueOrFalse}")
	public ResponseEntity<Object> RicercaCombinata10(@PathVariable String Language,@PathVariable String City1,
	@PathVariable String City2,@PathVariable String City3,@PathVariable String City4,
	@PathVariable String City5,@PathVariable String TrueOrFalse){
		
		if (!TrueOrFalse.toLowerCase().equals("true") && !TrueOrFalse.toLowerCase().equals("false")){
			answer = "Hai commesso un errore nella ricerca.";
		} else answer=Scanner.CombinedSearch10(Language,City1,City2,City3,City4,City5,TrueOrFalse);
		
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}
}
