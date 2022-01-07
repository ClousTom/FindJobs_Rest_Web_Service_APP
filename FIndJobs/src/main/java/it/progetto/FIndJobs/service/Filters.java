package it.progetto.FIndJobs.service;

import it.progetto.FIndJobs.model.Lavori;

/**
 * Questa classe contiene tutti i vari filtri di ricerca richiesti dal client.
 *
 * @author Leonardo Pescetti
 * @author Claudio Tomaiuolo
 */

public class Filters {
		
	/**
	 * Funzione che effettua una ricerca in base ad una data location nei vari Lavori, e restituisce
	 * una stringa contenente tutti i lavori che hanno la location richiesta dal client.
	 *  
	 * @param x E' l'array contenente tutti i lavori su cui si effettua la richiesta.
	 * @param CityName Città per cui si sta effettuando la ricerca.
	 * @return Stringa che contiene tutti i lavori che soddisfano la condizione di ricerca.
	 */
	
	public static String City (Lavori[] x, String CityName){
		String risp="";
		for(int i=0;i<6000;i++) {
			if(x[i].isCity(CityName)) {
				risp = risp + x[i].toString();
			}
		}
		return risp;
	}
	
	/**
	 * Funzione che effettua una ricerca in base ad un dato linguaggio di programmazione nei vari Lavori, 
	 * e restituisce una stringa contenente tutti i lavori che utilizzano quel linguaggio di programmazione
	 * richiesto dal client.
	 *  
	 * @param x E' l'array contenente tutti i lavori su cui si effettua la richiesta.
	 * @param Lang Linguaggio di programmazione per cui si sta effettuando la ricerca.
	 * @return Stringa che contiene tutti i lavori che soddisfano la condizione di ricerca.
	 */
	
	public static String Language (Lavori[] x, String Lang){
		String risp="";
		for(int i=0;i<6000;i++) {
			if(x[i].isLang(Lang)) {
				risp = risp + x[i].toString();
			}
		}
		return risp;
	}
	
	/**
	 * Funzione che effettua una ricerca in base alla tipologia di lavoro(distanza/presenza) nei vari Lavori,
	 * e restituisce una stringa contenente tutti i lavori che operano con quella data modalità.
	 *  
	 * @param x E' l'array contenente tutti i lavori su cui si effettua la richiesta.
	 * @param IsRemote Tipologia di lavoro per cui si sta effettuando la ricerca.
	 * @return Stringa che contiene tutti i lavori che soddisfano la condizione di ricerca.
	 */
	
	public static String IsRemoteOrNot(Lavori[] x, String IsRemote ){
		String risp="";
		if(IsRemote.equals("true")){
		for(int i=0;i<6000;i++) {
			if(x[i].isRemote()) {
				risp = risp + x[i].toString()+"\n";}
			}
		}
		else if(IsRemote.equals("false")){for(int i=0;i<6000;i++) {
			if(!x[i].isRemote()) {
				risp = risp + x[i].toString()+"\n";
			}
		}				
		}											
		return risp;			
	}		
	
	/**
	 * Questa funzione effettua una ricerca combinata in base a due parametri passati che sono il linguaggio
	 * di programmazione e una città desiderata, e restituisce una stringa contenente tutti i lavori che 
	 * operano in tali città e che utilizzano quel linguaggio di programmazione chiesto dal client.
	 *  
	 * @param x E' l'array contenente tutti i lavori su cui si effettua la richiesta.
	 * @param Lang Linguaggio di programmazione per cui si sta effettuando la ricerca.
	 * @param CityName Città per cui si sta effettuando la ricerca.
	 * @return Stringa che contiene tutti i lavori che soddisfano le condizioni di ricerca.
	 */	
	
	public static String FilteredSearch1(Lavori[] x, String Lang, String CityName) {
		String risp="";
		for(int i=0;i<6000;i++) {
			if(x[i].isCity(CityName)){
				if(x[i].isLang(Lang)){
					risp=risp+x[i].toString();
				}				
			}
		}		
		return risp;
	}
	
	/**
	 * Questa funzione effettua una ricerca combinata in base a tre parametri passati che sono il linguaggio
	 * di programmazione, una città desiderata e la tipologia di lavoro(se opera solo in presenza o anche
	 * in remoto) restituendo una stringa contenente tutti i lavori che operano in tali città, con quella 
	 * modalità ed utilizzano quel linguaggio di programmazione chiesto dal client.
	 *  
	 * @param x E' l'array contenente tutti i lavori su cui si effettua la richiesta.
	 * @param Lang Linguaggio di programmazione per cui si sta effettuando la ricerca.
	 * @param CityName Città per cui si sta effettuando la ricerca.
	 * @param IsRemote Tipologia di lavoro per cui si sta effettuando la ricerca.
	 * @return Stringa che contiene tutti i lavori che soddisfano le condizioni di ricerca.
	 */	
	
	public static String FilteredSearch2(Lavori[] x, String Lang, String CityName, String IsRemote) {
		String risp="";
		for(int i=0;i<6000;i++) {
			if(x[i].isCity(CityName)){
				if(x[i].isLang(Lang)){
					if(IsRemote.equals("true")){
						if(x[i].isRemote()) {
							risp = risp + x[i].toString()+"\n";}
						}
					else if(IsRemote.equals("false"))
					{
						if(!x[i].isRemote()) {
							risp = risp + x[i].toString()+"\n";
						}
					}									
				}				
			}
		}		
		return risp;
	}	
}