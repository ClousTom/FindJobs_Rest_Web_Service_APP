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
	static Lavori[] lavori;
	
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
		lavori = new Lavori[Data.size()];
		lavori = parseData.pData(Data, lavori);
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
		String ListaLavori = Filters.City(lavori,CityName);
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
	 * @throws LanguageNotFoundException 
	 */
	
	public static String SearchLanguage(String Lang)  {
		String ListaLavori = Filters.Language(lavori,Lang);
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
		String ListaLavori = Filters.IsRemoteOrNot(lavori, IsRemote);
		return ListaLavori;
	}
	
	/**
	 * Questa funzione(che viene poi invocata dal RestController), prese in ingresso due stringhe contenenti
	 * il linguaggio di programmazione e la città che l'utente vuole cercare, ha lo scopo di lanciare la
	 * funzione FilteredSearch dalla classe filters(che con l'equals restituirà l'oggetto Lavoro che opera
	 * in tale città ed utilizza quel linguaggio di programmazione) e inserirà tutti quegli oggetti 
	 * che soddisfano tali requisiti in una stringa ListaLavori.
	 * 
	 * @param Lang Linguaggio di programmazione richiesto dal client da cui si effettua la ricerca.
	 * @param CityName Città richiesta dal client da cui si effettua la ricerca.
	 * @return Lista dei lavori che soddisfano tali condizioni di ricerca.
	 */
	
	public static String CombinedSearch1(String Lang,String CityName) {
		String ListaLavori=Filters.FilteredSearch1(lavori, Lang, CityName);
		return ListaLavori;
	}
	
	/**
	 * Questa funzione(che viene poi invocata dal RestController), prese in ingresso tre stringhe contenenti
	 * il linguaggio di programmazione e le due città che l'utente vuole cercare, ha lo scopo di lanciare la
	 * funzione FilteredSearch2 dalla classe filters(che con l'equals restituirà l'oggetto Lavoro che opera
	 * in tali città ed utilizza quel linguaggio di programmazione) e inserirà tutti quegli oggetti 
	 * che soddisfano tali requisiti in una stringa ListaLavori.
	 * 
	 * @param Lang Linguaggio di programmazione richiesto dal client da cui si effettua la ricerca.
	 * @param CityName Città richiesta dal client da cui si effettua la ricerca.
	 * @param CityName2 Seconda città richiesta dal client da cui si effettua la ricerca.
	 * @return Lista dei lavori che soddisfano tali condizioni di ricerca.
	 */
	
	public static String CombinedSearch2(String Lang,String CityName,String CityName2) {
		String ListaLavori=Filters.FilteredSearch2(lavori, Lang, CityName,CityName2);
		return ListaLavori;
	}
	
	/**
	 * Questa funzione(che viene poi invocata dal RestController), prese in ingresso quattro stringhe contenenti
	 * il linguaggio di programmazione e le tre città che l'utente vuole cercare, ha lo scopo di lanciare la
	 * funzione FilteredSearch3 dalla classe filters(che con l'equals restituirà l'oggetto Lavoro che opera
	 * in tali città ed utilizza quel linguaggio di programmazione) e inserirà tutti quegli oggetti 
	 * che soddisfano tali requisiti in una stringa ListaLavori.
	 * 
	 * @param Lang Linguaggio di programmazione richiesto dal client da cui si effettua la ricerca.
	 * @param CityName Città richiesta dal client da cui si effettua la ricerca.
	 * @param CityName2 Seconda città richiesta dal client da cui si effettua la ricerca.
	 * @param CityName3 Terza città richiesta dal client da cui si effettua la ricerca.
	 * @return Lista dei lavori che soddisfano tali condizioni di ricerca.
	 */
	
	public static String CombinedSearch3(String Lang,String CityName,String CityName2,String CityName3) {
		String ListaLavori=Filters.FilteredSearch3(lavori, Lang, CityName,CityName2,CityName3);
		return ListaLavori;
	}
	
	/**
	 * Questa funzione(che viene poi invocata dal RestController), prese in ingresso cinque stringhe contenenti
	 * il linguaggio di programmazione e le quattro città che l'utente vuole cercare, ha lo scopo di lanciare la
	 * funzione FilteredSearch4 dalla classe filters(che con l'equals restituirà l'oggetto Lavoro che opera
	 * in tali città ed utilizza quel linguaggio di programmazione) e inserirà tutti quegli oggetti 
	 * che soddisfano tali requisiti in una stringa ListaLavori.
	 * 
	 * @param Lang Linguaggio di programmazione richiesto dal client da cui si effettua la ricerca.
	 * @param CityName Città richiesta dal client da cui si effettua la ricerca.
	 * @param CityName2 Seconda città richiesta dal client da cui si effettua la ricerca.
	 * @param CityName3 Terza città richiesta dal client da cui si effettua la ricerca.
	 * @param CityName4 Quarta città richiesta dal client da cui si effettua la ricerca.
	 * @return Lista dei lavori che soddisfano tali condizioni di ricerca.
	 */
	
	public static String CombinedSearch4(String Lang,String CityName,String CityName2,String CityName3,
			String CityName4) {
		String ListaLavori=Filters.FilteredSearch4(lavori, Lang, CityName, CityName2, CityName3, CityName4);
		return ListaLavori;
	}
	
	/**
	 * Questa funzione(che viene poi invocata dal RestController), prese in ingresso sei stringhe contenenti
	 * il linguaggio di programmazione e le cinque città che l'utente vuole cercare, ha lo scopo di lanciare la
	 * funzione FilteredSearch5 dalla classe filters(che con l'equals restituirà l'oggetto Lavoro che opera
	 * in tali città ed utilizza quel linguaggio di programmazione) e inserirà tutti quegli oggetti 
	 * che soddisfano tali requisiti in una stringa ListaLavori.
	 * 
	 * @param Lang Linguaggio di programmazione richiesto dal client da cui si effettua la ricerca.
	 * @param CityName Città richiesta dal client da cui si effettua la ricerca.
	 * @param CityName2 Seconda città richiesta dal client da cui si effettua la ricerca.
	 * @param CityName3 Terza città richiesta dal client da cui si effettua la ricerca.
	 * @param CityName4 Quarta città richiesta dal client da cui si effettua la ricerca.
	 * @param CityName5 Quinta città richiesta dal client da cui si effettua la ricerca.
	 * @return Lista dei lavori che soddisfano tali condizioni di ricerca.
	 */
	
	public static String CombinedSearch5(String Lang,String CityName,String CityName2,String CityName3,
			String CityName4,String CityName5) {
		String ListaLavori=Filters.FilteredSearch5(lavori, Lang, CityName, CityName2, CityName3, CityName4,
				CityName5);
		return ListaLavori;
	}
	
	/**
	 * Questa funzione(che viene poi invocata dal RestController), prese in ingresso tre stringhe contenenti
	 * il linguaggio di programmazione, la città che l'utente vuole cercare e la tipologia di lavoro(remoto o
	 * non) ha lo scopo di lanciare la funzione FilteredSearch6 dalla classe filters(che con l'equals
	 * restituirà l'oggetto Lavoro che opera in tale città, utilizza quel linguaggio di programmazione ed opera
	 * in remoto o meno) e inserirà tutti quegli oggetti che soddisfano tali requisiti in una stringa
	 * ListaLavori.
	 * 
	 * @param Lang Linguaggio di programmazione richiesto dal client da cui si effettua la ricerca.
	 * @param CityName Città richiesta dal client da cui si effettua la ricerca.
	 * @param IsRemote Tipologia di lavoro richiesta dal client per cui si effettua la ricerca.
	 * @return Lista dei lavori che soddisfano tali condizioni di ricerca.
	 */
	
	public static String CombinedSearch6(String Lang,String CityName,String IsRemote) {
			String ListaLavori=Filters.FilteredSearch6(lavori, Lang, CityName, IsRemote);
			return ListaLavori;
		}
	
	
	/**
	 * Questa funzione(che viene poi invocata dal RestController), prese in ingresso quattro stringhe contenenti
	 * il linguaggio di programmazione, le due città che l'utente vuole cercare e la tipologia di lavoro(remoto o
	 * non) ha lo scopo di lanciare la funzione FilteredSearch7 dalla classe filters(che con l'equals
	 * restituirà l'oggetto Lavoro che opera in tali città, utilizza quel linguaggio di programmazione ed opera
	 * in remoto o meno) e inserirà tutti quegli oggetti che soddisfano tali requisiti in una stringa
	 * ListaLavori.
	 * 
	 * @param Lang Linguaggio di programmazione richiesto dal client da cui si effettua la ricerca.
	 * @param CityName Città richiesta dal client da cui si effettua la ricerca.
	 * @param CityName2 Seconda città richiesta dal client da cui si effettua la ricerca.
	 * @param IsRemote Tipologia di lavoro richiesta dal client per cui si effettua la ricerca.
	 * @return Lista dei lavori che soddisfano tali condizioni di ricerca.
	 */
	
	public static String CombinedSearch7(String Lang,String CityName,String CityName2,String IsRemote) {
		String ListaLavori=Filters.FilteredSearch7(lavori, Lang, CityName, CityName2, IsRemote);
		return ListaLavori;
		
	}
	
	/**
	 * Questa funzione(che viene poi invocata dal RestController), prese in ingresso cinque stringhe contenenti
	 * il linguaggio di programmazione, le tre città che l'utente vuole cercare e la tipologia di lavoro(remoto o
	 * non) ha lo scopo di lanciare la funzione FilteredSearch8 dalla classe filters(che con l'equals
	 * restituirà l'oggetto Lavoro che opera in tali città, utilizza quel linguaggio di programmazione ed opera
	 * in remoto o meno) e inserirà tutti quegli oggetti che soddisfano tali requisiti in una stringa
	 * ListaLavori.
	 * 
	 * @param Lang Linguaggio di programmazione richiesto dal client da cui si effettua la ricerca.
	 * @param CityName Città richiesta dal client da cui si effettua la ricerca.
	 * @param CityName2 Seconda città richiesta dal client da cui si effettua la ricerca.
	 * @param CityName3 Terza città richiesta dal client da cui si effettua la ricerca.
	 * @param IsRemote Tipologia di lavoro richiesta dal client per cui si effettua la ricerca.
	 * @return Lista dei lavori che soddisfano tali condizioni di ricerca.
	 */
	
	public static String CombinedSearch8(String Lang,String CityName,String CityName2,String CityName3,
			String IsRemote) {
		String ListaLavori=Filters.FilteredSearch8(lavori, Lang, CityName, CityName2, CityName3, IsRemote);
		return ListaLavori;
		
	}
	
	/**
	 * Questa funzione(che viene poi invocata dal RestController), prese in ingresso sei stringhe contenenti
	 * il linguaggio di programmazione, le quattro città che l'utente vuole cercare e la tipologia di lavoro(remoto o
	 * non) ha lo scopo di lanciare la funzione FilteredSearch9 dalla classe filters(che con l'equals
	 * restituirà l'oggetto Lavoro che opera in tali città, utilizza quel linguaggio di programmazione ed opera
	 * in remoto o meno) e inserirà tutti quegli oggetti che soddisfano tali requisiti in una stringa
	 * ListaLavori.
	 * 
	 * @param Lang Linguaggio di programmazione richiesto dal client da cui si effettua la ricerca.
	 * @param CityName Città richiesta dal client da cui si effettua la ricerca.
	 * @param CityName2 Seconda città richiesta dal client da cui si effettua la ricerca.
	 * @param CityName3 Terza città richiesta dal client da cui si effettua la ricerca.
	 * @param CityName4 Quarta città richiesta dal client da cui si effettua la ricerca.
	 * @param IsRemote Tipologia di lavoro richiesta dal client per cui si effettua la ricerca.
	 * @return Lista dei lavori che soddisfano tali condizioni di ricerca.
	 */
	
	public static String CombinedSearch9(String Lang,String CityName,String CityName2,String CityName3,
			String CityName4, String IsRemote) {
		String ListaLavori=Filters.FilteredSearch9(lavori, Lang, CityName, CityName2, CityName3,
				CityName4,IsRemote);
		return ListaLavori;
		
	}
	
	/**
	 * Questa funzione(che viene poi invocata dal RestController), prese in ingresso sette stringhe contenenti
	 * il linguaggio di programmazione, le cinque città che l'utente vuole cercare e la tipologia di lavoro(remoto o
	 * non) ha lo scopo di lanciare la funzione FilteredSearch10 dalla classe filters(che con l'equals
	 * restituirà l'oggetto Lavoro che opera in tali città, utilizza quel linguaggio di programmazione ed opera
	 * in remoto o meno) e inserirà tutti quegli oggetti che soddisfano tali requisiti in una stringa
	 * ListaLavori.
	 * 
	 * @param Lang Linguaggio di programmazione richiesto dal client da cui si effettua la ricerca.
	 * @param CityName Città richiesta dal client da cui si effettua la ricerca.
	 * @param CityName2 Seconda città richiesta dal client da cui si effettua la ricerca.
	 * @param CityName3 Terza città richiesta dal client da cui si effettua la ricerca.
	 * @param CityName4 Quarta città richiesta dal client da cui si effettua la ricerca.
	 * @param CityName5 Quinta città richiesta dal client da cui si effettua la ricerca.
	 * @param IsRemote Tipologia di lavoro richiesta dal client per cui si effettua la ricerca.
	 * @return Lista dei lavori che soddisfano tali condizioni di ricerca.
	 */
	
	public static String CombinedSearch10(String Lang,String CityName,String CityName2,String CityName3,
			String CityName4,String CityName5, String IsRemote) {
		String ListaLavori=Filters.FilteredSearch10(lavori, Lang, CityName, CityName2, CityName3,
				CityName4,CityName5,IsRemote);
		return ListaLavori;
		
	}
	
	
}