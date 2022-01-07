package it.progetto.FIndJobs.service;

import java.net.URL;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import it.progetto.FIndJobs.model.Lavori;
import it.progetto.FIndJobs.service.*;

/**
 * Lo scopo di questa classe è accumulare tutti i dati presi dal sito:"https://findwork.dev/api/jobs/",
 * e caricati in un vettore. 
 *
 * @author Leonardo Pescetti
 * @author Claudio Tomaiuolo
 */


public class Scanner {
	
	/**
	 * Vengono definiti inzialmente un JSONArray e un vettore oggetti della classe lavori.
	 */
	
    static JSONArray Data = new JSONArray();
	static Lavori[] x = new Lavori[10000];
	
	/**
	 * Questa funzione ha lo scopo di inizializzare la connessione nella pagina:"https://findwork.dev/api/jobs".
	 * Definendo un URL lo si va a lanciare nella classe DownloadData che scaricherà tramite dalla funzione
	 * connect i dati e li passerà nel JSONArray.
	 * Successivamente il JSONArray viene passato alla funzione pData che trasforma il JSONArray ad un vettore
	 * di oggetti della classe lavori.
	 * Il countPage ha lo scopo di contare le pagine che il programma andrà ad indicizzare durante il download.
	 */
	
	public static void start() throws Exception{
		
		URL url = new URL("https://findwork.dev/api/jobs");
		System.out.println();
		System.out.println("Inizio la scansione delle offerte di lavoro sulla pagina web: "+url);
		
		
		int countPag = 0;
		Data = DownloadData.connect(Data,url,countPag);
		
		x = parseData.pData(Data, x);
//		System.out.println(x[0].toString());
	}
	
	/**
	 * Questa funzione(che viene poi invocata dal RestController), presa in ingresso una stringa contenente
	 * la città che l'utente vuole cercare, ha lo scopo di lanciare la funzione City dalla classe lavori(che
	 * con l'equals restituirà l'oggetto Lavoro che opera in tale città) e inserirà tutti quegli oggetti che
	 * soddisfano tale requisito in una stringa ListaLavori.
	 * 
	 * @param CityName Città richiesta dal client da cui si effettua la ricerca.
	 * @return Lista dei lavori che operano in tale città.
	 */
	
	public static String SearchCity(String CityName) {
		String ListaLavori = Filters.City(x,CityName);
		return ListaLavori;
	}
	
	/**
	 * Questa funzione(che viene poi invocata dal RestController), presa in ingresso una stringa contenente
	 * un linguaggio di programmazione che l'utente vuole cercare, ha lo scopo di lanciare la funzione Lang
	 * dalla classe lavori(che con l'equals restituirà l'oggetto Lavoro che utilizza quel linguaggio) e 
	 * inserirà tutti quegli oggetti che soddisfano tale requisito in una stringa ListaLavori.
	 * 
	 * @param Lang Linguaggio di programmazione richiesto dal client da cui si effettua la ricerca.
	 * @return Lista dei lavori che utilizza quel linguaggio.
	 */
	
	public static String SearchLanguage(String Lang) {
		String ListaLavori = Filters.Language(x,Lang);
		return ListaLavori;
	}
		
	/**
	 * Questa funzione(che viene poi invocata dal RestController), presa in ingresso una stringa contenente
	 * la tipologia di lavoro(remoto o non) che l'utente vuole cercare, ha lo scopo di lanciare la funzione
	 * IsRemoteOrNot dalla classe lavori(che con l'equals restituirà l'oggetto Lavoro che opera in tale
	 * modalità) e inserirà tutti quegli oggetti che soddisfano tale requisito in una stringa ListaLavori.
	 * 
	 * @param IsRemote Tipologia di lavoro richiesto dal client da cui si effettua la ricerca.
	 * @return Lista dei lavori che operano in tale modalità.
	 */
	
	public static String RemoteVerify(String IsRemote) {
		String ListaLavori = Filters.IsRemoteOrNot(x, IsRemote);
		return ListaLavori;
	}
	
	/*
	 * Questa funzione(che viene poi invocata dal RestController), prese in ingresso due stringhe contenenti
	 * il linguaggio di programmazione e la città che l'utente vuole cercare, ha lo scopo di lanciare la
	 * funzione FilteredSearch dalla classe lavori(che con l'equals restituirà l'oggetto Lavoro che opera
	 * in tale città ed utilizza quel linguaggio di programmazione) e inserirà tutti quegli oggetti 
	 * che soddisfano tali requisiti in una stringa ListaLavori.
	 * 
	 * @param Lang Linguaggio di programmazione richiesto dal client da cui si effettua la ricerca.
	 * @param CityName Città richiesta dal client da cui si effettua la ricerca.
	 * @return Lista dei lavori che soddisfano tali condizioni di ricerca.
	 */
	
	public static String CombinedSearch1(String Lang,String CityName) {
		String ListaLavori=Filters.FilteredSearch1(x, Lang, CityName);
		return ListaLavori;
	}
	
	/**
	 * Questa funzione(che viene poi invocata dal RestController), prese in ingresso tre stringhe contenenti
	 * sia il linguaggio di programmazione sia la città che l'utente vuole cercare e sia la tipologia
	 * del lavoro(se in remoto o no), ha lo scopo di lanciare la funzione FilteredSearch2 dalla classe
	 * lavori(che con l'equals restituirà l'oggetto Lavoro che opera in tale città, utilizza quel linguaggio
	 * di programmazione ed opera in quella modalità) e inserirà tutti quegli oggetti che soddisfano tali
	 * requisiti in una stringa ListaLavori.
	 * 
	 * @param Lang Linguaggio di programmazione richiesto dal client da cui si effettua la ricerca.
	 * @param CityName Città richiesta dal client da cui si effettua la ricerca.
     * @param IsRemote Tipologia di lavoro richiesto dal client da cui si effettua la ricerca.
	 * @return Lista dei lavori che soddisfano tali condizioni di ricerca.
	 */
	
	public static String CombinedSearch2(String Lang,String CityName,String IsRemote) {
		String ListaLavori=Filters.FilteredSearch2(x, Lang, CityName, IsRemote);
		return ListaLavori;
	}
}