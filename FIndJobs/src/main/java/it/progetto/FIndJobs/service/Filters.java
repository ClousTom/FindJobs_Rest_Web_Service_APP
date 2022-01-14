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
	 * una stringa contenente tutti i lavori che hanno la location richiesta dal client, assieme a diverse
	 * statistiche utili al client che effettua la ricerca.
	 *  
	 * @param x E' l'array contenente tutti i lavori su cui si effettua la richiesta.
	 * @param CityName Città per cui si sta effettuando la ricerca.
	 * @return Stringa che contiene tutti i lavori che soddisfano la condizione di ricerca assieme a delle
	 * statistiche.
	 */
	
	public static String City (Lavori[] x, String CityName){
		int count=0;
		int countRemote=0;
		String risp="";
		for(int i=0;i<x.length;i++) {
			if(x[i].isCity(CityName)) {
				count++;
				risp = risp + x[i].toString();
				if(x[i].isRemote()) {
					countRemote++;
				}
			}
		}
		return "Trovati "+count+" offerte di lavoro a "+CityName+" su "+ x.length +" offerte di lavoro totali ("+(count*100)/x.length +"%).\n"
				+ "In remoto: "+countRemote+"\n"
				+ "In presenza: "+(count-countRemote)+"\n"
				+ risp;
	}
	
	/**
	 * Funzione che effettua una ricerca in base ad un dato linguaggio di programmazione nei vari Lavori, 
	 * e restituisce una stringa contenente tutti i lavori che utilizzano quel linguaggio di programmazione
	 * richiesto dal client insieme a delle statistiche utili al client che effettua la ricerca.
	 *  
	 * @param x E' l'array contenente tutti i lavori su cui si effettua la richiesta.
	 * @param Lang Linguaggio di programmazione per cui si sta effettuando la ricerca.
	 * @return Stringa che contiene tutti i lavori che soddisfano la condizione di ricerca assieme a delle
	 * statistiche
	 * @throws LanguageNotFoundException 
	 */
	
	public static String Language (Lavori[] x, String Lang) {
		int count=0;
		int countRemote=0;
		String risp="";
		for(int i=0;i<x.length;i++) {
			if(x[i].isLang(Lang)) {
				count++;
				risp = risp + x[i].toString();
				if(x[i].isRemote()) {
					countRemote++;
				}
			}
		}
		return "Trovati "+count+" offerte di lavoro con il linguaggio di programmazione "+Lang+" su "+ x.length +" offerte di lavoro totali ("+(count*100)/x.length +"%).\n"
				+ "In remoto: "+countRemote+"\n"
				+ "In presenza: "+(count-countRemote)+"\n"
				+ risp;
	}
	
	/**
	 * Funzione che effettua una ricerca in base alla tipologia di lavoro(distanza/presenza) nei vari Lavori,
	 * e restituisce una stringa contenente tutti i lavori che operano con quella data modalità, assieme a delle
	 * statistiche utili al client che effettua la ricerca.
	 *  
	 * @param x E' l'array contenente tutti i lavori su cui si effettua la richiesta.
	 * @param IsRemote Tipologia di lavoro per cui si sta effettuando la ricerca.
	 * @return Stringa che contiene tutti i lavori che soddisfano la condizione di ricerca assieme a delle
	 * statistiche.
	 */
	
	public static String IsRemoteOrNot(Lavori[] x, String IsRemote ){
		int count=0;
		String risp="";
		if(IsRemote.equals("true")){
			for(int i=0;i<x.length;i++) {
				if(x[i].isRemote()) {
					count++;
					risp = risp + x[i].toString()+"\n";
				}
			}
			risp = "Trovati "+count+" offerte di lavoro in remoto ("+(count*100)/x.length+"%).\n" +risp;
		}
		else if(IsRemote.equals("false")){
			for(int i=0;i<x.length;i++) {
				if(!x[i].isRemote()) {
					count++;
					risp = risp + x[i].toString()+"\n";
				}
			}
			risp = "Trovati "+count+" offerte di lavoro in presenza ("+(count*100)/x.length+"%).\n" +risp;
		}											
		return risp;			
	}		
	
	/**
	 * Questa funzione effettua una ricerca combinata in base a due parametri passati che sono il linguaggio
	 * di programmazione e una città desiderata, e restituisce una stringa contenente tutti i lavori che 
	 * operano in tale città e che utilizzano quel linguaggio di programmazione chiesto dal client.
	 * In più viene restituita una stringa contenente delle statistiche utili al client che effettua la
	 * ricerca.
	 *  
	 * @param x E' l'array contenente tutti i lavori su cui si effettua la richiesta.
	 * @param Lang Linguaggio di programmazione per cui si sta effettuando la ricerca.
	 * @param CityName Città per cui si sta effettuando la ricerca.
	 * @return Stringa che contiene tutti i lavori che soddisfano le condizioni di ricerca assieme a delle
	 * statistiche.
	 */	
	
	public static String FilteredSearch1(Lavori[] x, String Lang, String CityName) {
		String risp="";
		int count=0;
		int countRemote=0;
		for(int i=0;i<x.length;i++) {
			if(x[i].isCity(CityName)){
				if(x[i].isLang(Lang)){
					count++;
					risp=risp+x[i].toString();
					if(x[i].isRemote()) {
						countRemote++;
					}
				}				
			}
		}	
		return "Trovati "+count+" offerte di lavoro a "+CityName+" con il linguaggio di programmazione "+
		Lang+" su "+ x.length +" offerte di lavoro totali.\n"
		+ "In remoto: "+countRemote+"\n"
		+ "In presenza: "+(count-countRemote)+"\n"
		+ risp;		
	}

	/**
	 * Questa funzione effettua una ricerca combinata in base a tre parametri passati che sono il linguaggio
	 * di programmazione e due città desiderate, e restituisce una stringa contenente tutti i lavori che 
	 * operano in tali città e che utilizzano quel linguaggio di programmazione chiesto dal client.
	 * In più viene restituita una stringa contenente delle statistiche utili al client che effettua la
	 * ricerca.
	 *  
	 * @param x E' l'array contenente tutti i lavori su cui si effettua la richiesta.
	 * @param Lang Linguaggio di programmazione per cui si sta effettuando la ricerca.
	 * @param CityName Città per cui si sta effettuando la ricerca.
	 * @param CityName2 Seconda città per cui si sta effettuando la ricerca.
	 * @return Stringa che contiene tutti i lavori che soddisfano le condizioni di ricerca assieme a delle
	 * statistiche.
	 */	
	
	public static String FilteredSearch2(Lavori[] x, String Lang, String CityName, String CityName2) {
		String risp="";
		int count1=0;
		int count2=0;
		int countRemote=0;
		for(int i=0;i<x.length;i++) {
			if(x[i].isCity(CityName)){
				if(x[i].isLang(Lang)){
					count1++;
					risp=risp+x[i].toString();
					if(x[i].isRemote()) {
						countRemote++;
					}
				}				
			}
			else if(x[i].isCity(CityName2)){
				if(x[i].isLang(Lang)){
					count2++;
					risp=risp+x[i].toString();
					if(x[i].isRemote()) {
						countRemote++;
					}
				}				
			}
		}
		return "Trovati "+count1+" offerte di lavoro a "+CityName+" e "+count2+" a "+CityName2+" con il linguaggio di programmazione "+Lang+" su "+ x.length +" offerte di lavoro totali.\n"
				+ "In remoto: "+countRemote+"\n"
				+ "In presenza: "+((count1+count2)-countRemote)+"\n"
				+ risp;
	}
	
	/**
	 * Questa funzione effettua una ricerca combinata in base a quattro parametri passati che sono il linguaggio
	 * di programmazione e tre città desiderate, e restituisce una stringa contenente tutti i lavori che 
	 * operano in tali città e che utilizzano quel linguaggio di programmazione chiesto dal client.
	 * In più viene restituita una stringa contenente delle statistiche utili al client che effettua la
	 * ricerca.
	 *  
	 * @param x E' l'array contenente tutti i lavori su cui si effettua la richiesta.
	 * @param Lang Linguaggio di programmazione per cui si sta effettuando la ricerca.
	 * @param CityName Città per cui si sta effettuando la ricerca.
	 * @param CityName2 Seconda città per cui si sta effettuando la ricerca.
	 * @param CityName3 Terza città per cui si sta effettuando la ricerca.
	 * @return Stringa che contiene tutti i lavori che soddisfano le condizioni di ricerca assieme a delle
	 * statistiche.
	 */	
	
	public static String FilteredSearch3(Lavori[] x, String Lang, String CityName, String CityName2,String
			CityName3) {
		String risp="";
		int count1=0;
		int count2=0;
		int count3=0;
		int countRemote=0;
		for(int i=0;i<x.length;i++) {
			if(x[i].isCity(CityName)){
				if(x[i].isLang(Lang)){
					count1++;
					risp=risp+x[i].toString();
					if(x[i].isRemote()) {
						countRemote++;
					}
				}				
			}
			else if(x[i].isCity(CityName2)){
				if(x[i].isLang(Lang)){
					count2++;
					risp=risp+x[i].toString();
					if(x[i].isRemote()) {
						countRemote++;
					}
				}				
			}
			else if(x[i].isCity(CityName3)){
				if(x[i].isLang(Lang)){
					count3++;
					risp=risp+x[i].toString();
					if(x[i].isRemote()) {
						countRemote++;
					}
				}				
			}
		}
		return "Trovati "+count1+" offerte di lavoro a "+CityName+", "+count2+" offerte di lavoro a "+
			CityName2+" e "+count3+" offerte di lavoro a "+CityName3+" con il linguaggio di programmazione"
			+ " "+Lang+" su "+ x.length +" offerte di lavoro "+ "totali.\n"
				+ "In remoto: "+countRemote+"\n"
				+ "In presenza: "+((count1+count2+count3)-countRemote)+"\n"
				+ risp;
	}
	
	/**
	 * Questa funzione effettua una ricerca combinata in base a cinque parametri passati che sono il linguaggio
	 * di programmazione e quattro città desiderate, e restituisce una stringa contenente tutti i lavori che 
	 * operano in tali città e che utilizzano quel linguaggio di programmazione chiesto dal client.
	 * In più viene restituita una stringa contenente delle statistiche utili al client che effettua la
	 * ricerca.
	 *  
	 * @param x E' l'array contenente tutti i lavori su cui si effettua la richiesta.
	 * @param Lang Linguaggio di programmazione per cui si sta effettuando la ricerca.
	 * @param CityName Città per cui si sta effettuando la ricerca.
	 * @param CityName2 Seconda città per cui si sta effettuando la ricerca.
	 * @param CityName3 Terza città per cui si sta effettuando la ricerca.
	 * @param CityName4 Quarta città per cui si sta effettuando la ricerca.
	 * @return Stringa che contiene tutti i lavori che soddisfano le condizioni di ricerca assieme a delle
	 * statistiche.
	 */	
	
	public static String FilteredSearch4(Lavori[] x, String Lang, String CityName, String CityName2,String
			CityName3,String CityName4) {
		String risp="";
		int count1=0;
		int count2=0;
		int count3=0;
		int count4=0;
		int countRemote=0;
		for(int i=0;i<x.length;i++) {
			if(x[i].isCity(CityName)){
				if(x[i].isLang(Lang)){
					count1++;
					risp=risp+x[i].toString();
					if(x[i].isRemote()) {
						countRemote++;
					}
				}				
			}
			else if(x[i].isCity(CityName2)){
				if(x[i].isLang(Lang)){
					count2++;
					risp=risp+x[i].toString();
					if(x[i].isRemote()) {
						countRemote++;
					}
				}				
			}
			else if(x[i].isCity(CityName3)){
				if(x[i].isLang(Lang)){
					count3++;
					risp=risp+x[i].toString();
					if(x[i].isRemote()) {
						countRemote++;
					}
				}				
			}
			else if(x[i].isCity(CityName4)){
				if(x[i].isLang(Lang)){
					count4++;
					risp=risp+x[i].toString();
					if(x[i].isRemote()) {
						countRemote++;
					}
				}				
			}
		}
		return "Trovati "+count1+" offerte di lavoro a "+CityName+", "+count2+" offerte di lavoro a "+
			CityName2+", "+count3+" offerte di lavoro a "+CityName3+" e "+count4+" offerte di lavoro a "+
		CityName4+" con il linguaggio di programmazione "+Lang+" su "+ x.length +" offerte di lavoro totali.\n"
				+ "In remoto: "+countRemote+"\n"
				+ "In presenza: "+((count1+count2+count3+count4)-countRemote)+"\n"
				+ risp;
	}
	
	/**
	 * Questa funzione effettua una ricerca combinata in base a sei parametri passati che sono il linguaggio
	 * di programmazione e cinque città desiderate, e restituisce una stringa contenente tutti i lavori che 
	 * operano in tali città e che utilizzano quel linguaggio di programmazione chiesto dal client.
	 * In più viene restituita una stringa contenente delle statistiche utili al client che effettua la
	 * ricerca.
	 *  
	 * @param x E' l'array contenente tutti i lavori su cui si effettua la richiesta.
	 * @param Lang Linguaggio di programmazione per cui si sta effettuando la ricerca.
	 * @param CityName Città per cui si sta effettuando la ricerca.
	 * @param CityName2 Seconda città per cui si sta effettuando la ricerca.
	 * @param CityName3 Terza città per cui si sta effettuando la ricerca.
	 * @param CityName4 Quarta città per cui si sta effettuando la ricerca.
	 * @param CityName5 Quarta città per cui si sta effettuando la ricerca.
	 * @return Stringa che contiene tutti i lavori che soddisfano le condizioni di ricerca assieme a delle
	 * statistiche.
	 */	
	
	public static String FilteredSearch5(Lavori[] x, String Lang, String CityName, String CityName2,String
			CityName3,String CityName4,String CityName5) {
		String risp="";
		int count1=0;
		int count2=0;
		int count3=0;
		int count4=0;
		int count5=0;
		int countRemote=0;
		for(int i=0;i<x.length;i++) {
			if(x[i].isCity(CityName)){
				if(x[i].isLang(Lang)){
					count1++;
					risp=risp+x[i].toString();
					if(x[i].isRemote()) {
						countRemote++;
					}
				}				
			}
			else if(x[i].isCity(CityName2)){
				if(x[i].isLang(Lang)){
					count2++;
					risp=risp+x[i].toString();
					if(x[i].isRemote()) {
						countRemote++;
					}
				}				
			}
			else if(x[i].isCity(CityName3)){
				if(x[i].isLang(Lang)){
					count3++;
					risp=risp+x[i].toString();
					if(x[i].isRemote()) {
						countRemote++;
					}
				}				
			}
			else if(x[i].isCity(CityName4)){
				if(x[i].isLang(Lang)){
					count4++;
					risp=risp+x[i].toString();
					if(x[i].isRemote()) {
						countRemote++;
					}
				}				
			}
			else if(x[i].isCity(CityName5)){
				if(x[i].isLang(Lang)){
					count5++;
					risp=risp+x[i].toString();
					if(x[i].isRemote()) {
						countRemote++;
					}
				}				
			}
		}
		return "Trovati "+count1+" offerte di lavoro a "+CityName+", "+count2+" offerte di lavoro a "+
				CityName2+", "+count3+" offerte di lavoro a "+CityName3+", "+count4+" offerte di lavoro a "+
				CityName4+" e "+count5+" offerte di lavoro a "+CityName5+" con il linguaggio di programmazione "
				+Lang+" su "+ x.length +" offerte di lavoro totali.\n"
				+ "In remoto: "+countRemote+"\n"
				+ "In presenza: "+((count1+count2+count3+count4+count5)-countRemote)+"\n"
				+ risp;
	}
	
	/**
	 * Questa funzione effettua una ricerca combinata in base a tre parametri passati che sono il linguaggio
	 * di programmazione, una città desiderata e la tipologia di lavoro(se opera solo in presenza o anche
	 * in remoto) restituendo una stringa contenente tutti i lavori che operano in tale città, con quella 
	 * modalità ed utilizzano quel linguaggio di programmazione chiesto dal client. In più il programma 
	 * restituisce al client una stringa contenente delle statistiche utili a chi effettua la ricerca.
	 *  
	 * @param x E' l'array contenente tutti i lavori su cui si effettua la richiesta.
	 * @param Lang Linguaggio di programmazione per cui si sta effettuando la ricerca.
	 * @param CityName Città per cui si sta effettuando la ricerca.
	 * @param IsRemote Tipologia di lavoro per cui si sta effettuando la ricerca.
	 * @return Stringa che contiene tutti i lavori che soddisfano le condizioni di ricerca, assieme a delle
	 * statistiche.
	 */	
	
	public static String FilteredSearch6(Lavori[] x, String Lang, String CityName, String IsRemote) {
		String risp="";
		String remote="";
		if(IsRemote.equals("true")){
			remote=" in remoto ";
		} else {
			remote=" in presenza ";
		}
		int count=0;
		for(int i=0;i<x.length;i++) {
			if(x[i].isCity(CityName)){
				if(x[i].isLang(Lang)){
					if(IsRemote.equals("true")){					
						count++;
						risp = risp + x[i].toString()+"\n";												
						}
					else if(IsRemote.equals("false"))
					{
						count++;
						risp = risp + x[i].toString()+"\n";	
					}									
				}				
			}
		}		
		return "Trovati "+count+" offerte di lavoro a "+CityName+" con il linguaggio di programmazione "+
			Lang+remote+" su "+ x.length +" offerte di lavoro totali.\n"
			+ risp;
	}	
	
	/**
	 * Questa funzione effettua una ricerca combinata in base a quattro parametri passati che sono il linguaggio
	 * di programmazione, due città desiderate e la tipologia di lavoro(se opera solo in presenza o anche
	 * in remoto) restituendo una stringa contenente tutti i lavori che operano in tali città, con quella 
	 * modalità ed utilizzano quel linguaggio di programmazione chiesto dal client. In più il programma 
	 * restituisce al client una stringa contenente delle statistiche utili a chi effettua la ricerca.
	 *  
	 * @param x E' l'array contenente tutti i lavori su cui si effettua la richiesta.
	 * @param Lang Linguaggio di programmazione per cui si sta effettuando la ricerca.
	 * @param CityName Città per cui si sta effettuando la ricerca.
	 * @param CityName2 Seconda città per cui si sta effettuando la ricerca.
	 * @param IsRemote Tipologia di lavoro per cui si sta effettuando la ricerca.
	 * @return Stringa che contiene tutti i lavori che soddisfano le condizioni di ricerca, assieme a delle
	 * statistiche.
	 */	
	
	public static String FilteredSearch7(Lavori[] x, String Lang, String CityName, String CityName2,
				String IsRemote) {
		String risp="";
		int count1=0;
		int count2=0;
		String remote="";
		if(IsRemote.equals("true")){
			remote=" in remoto ";
		} else {
			remote=" in presenza ";
		}
		for(int i=0;i<x.length;i++) {
			if(x[i].isCity(CityName)){
				if(x[i].isLang(Lang)){
					if(IsRemote.equals("true")){					
						count1++;
						risp = risp + x[i].toString()+"\n";													
						}
					else if(IsRemote.equals("false"))
					{
						count1++;
						risp = risp + x[i].toString()+"\n";	
					}									
				}				
			}
			if(x[i].isCity(CityName2)){
				if(x[i].isLang(Lang)){
					if(IsRemote.equals("true")){					
						count2++;
						risp = risp + x[i].toString()+"\n";													
						}
					else if(IsRemote.equals("false"))
					{
						count2++;
						risp = risp + x[i].toString()+"\n";	
					}									
				}				
			}
		}		
		return "Trovati "+count1+" offerte di lavoro a "+CityName+" e "+count2+" a "+CityName2+
				" con il linguaggio di programmazione "+Lang+remote+" su "+ x.length +" offerte di lavoro totali.\n"
				+ risp;

	}
	
	/**
	 * Questa funzione effettua una ricerca combinata in base a cinque parametri passati che sono il linguaggio
	 * di programmazione, tre città desiderate e la tipologia di lavoro(se opera solo in presenza o anche
	 * in remoto) restituendo una stringa contenente tutti i lavori che operano in tali città, con quella 
	 * modalità ed utilizzano quel linguaggio di programmazione chiesto dal client. In più il programma 
	 * restituisce al client una stringa contenente delle statistiche utili a chi effettua la ricerca.
	 *  
	 * @param x E' l'array contenente tutti i lavori su cui si effettua la richiesta.
	 * @param Lang Linguaggio di programmazione per cui si sta effettuando la ricerca.
	 * @param CityName Città per cui si sta effettuando la ricerca.
	 * @param CityName2 Seconda città per cui si sta effettuando la ricerca.
	 * @param CityName3 Terza città per cui si sta effettuando la ricerca.
	 * @param IsRemote Tipologia di lavoro per cui si sta effettuando la ricerca.
	 * @return Stringa che contiene tutti i lavori che soddisfano le condizioni di ricerca, assieme a delle
	 * statistiche.
	 */	
	
	public static String FilteredSearch8(Lavori[] x, String Lang, String CityName, String CityName2,
			String CityName3, String IsRemote) {
	String risp="";
	int count1=0;
	int count2=0;
	int count3=0;
	String remote="";
	if(IsRemote.equals("true")){
		remote=" in remoto ";
	} else {
		remote=" in presenza ";
	}
	for(int i=0;i<x.length;i++) {
		if(x[i].isCity(CityName)){
			if(x[i].isLang(Lang)){
				if(IsRemote.equals("true")){					
					count1++;
					risp = risp + x[i].toString()+"\n";												
					}
				else if(IsRemote.equals("false"))
				{
					count1++;
					risp = risp + x[i].toString()+"\n";	
				}									
			}				
		}
		if(x[i].isCity(CityName2)){
			if(x[i].isLang(Lang)){
				if(IsRemote.equals("true")){					
					count2++;
					risp = risp + x[i].toString()+"\n";												
					}
				else if(IsRemote.equals("false"))
				{
					count2++;
					risp = risp + x[i].toString()+"\n";	
				}									
			}				
		}
		if(x[i].isCity(CityName3)){
			if(x[i].isLang(Lang)){
				if(IsRemote.equals("true")){					
					count3++;
					risp = risp + x[i].toString()+"\n";												
					}
				else if(IsRemote.equals("false"))
				{
					count3++;
					risp = risp + x[i].toString()+"\n";	
				}									
			}				
		}
	}		
	return "Trovati "+count1+" offerte di lavoro a "+CityName+", "+count2+" offerte di lavoro a "+
			CityName2+" e "+count3+" offerte di lavoro a "+CityName3+" con il linguaggio di programmazione "
			+Lang+remote+" su "+ x.length +" offerte di lavoro totali.\n"
			+ risp;

	}
	
	/**
	 * Questa funzione effettua una ricerca combinata in base a sei parametri passati che sono il linguaggio
	 * di programmazione, quattro città desiderate e la tipologia di lavoro(se opera solo in presenza o anche
	 * in remoto) restituendo una stringa contenente tutti i lavori che operano in tali città, con quella 
	 * modalità ed utilizzano quel linguaggio di programmazione chiesto dal client. In più il programma 
	 * restituisce al client una stringa contenente delle statistiche utili a chi effettua la ricerca.
	 *  
	 * @param x E' l'array contenente tutti i lavori su cui si effettua la richiesta.
	 * @param Lang Linguaggio di programmazione per cui si sta effettuando la ricerca.
	 * @param CityName Città per cui si sta effettuando la ricerca.
	 * @param CityName2 Seconda città per cui si sta effettuando la ricerca.
	 * @param CityName3 Terza città per cui si sta effettuando la ricerca.
	 * @param CityName4 Quarta città per cui si sta effettuando la ricerca.
	 * @param IsRemote Tipologia di lavoro per cui si sta effettuando la ricerca.
	 * @return Stringa che contiene tutti i lavori che soddisfano le condizioni di ricerca, assieme a delle
	 * statistiche.
	 */	
	
	public static String FilteredSearch9(Lavori[] x, String Lang, String CityName, String CityName2,
			String CityName3, String CityName4, String IsRemote) {
	String risp="";
	int count1=0;
	int count2=0;
	int count3=0;
	int count4=0;
	String remote="";
	if(IsRemote.equals("true")){
		remote=" in remoto ";
	} else {
		remote=" in presenza ";
	}
	for(int i=0;i<x.length;i++) {
		if(x[i].isCity(CityName)){
			if(x[i].isLang(Lang)){
				if(IsRemote.equals("true")){					
					count1++;
					risp = risp + x[i].toString()+"\n";													
					}
				else if(IsRemote.equals("false"))
				{
					count1++;
					risp = risp + x[i].toString()+"\n";	
				}									
			}				
		}
		if(x[i].isCity(CityName2)){
			if(x[i].isLang(Lang)){
				if(IsRemote.equals("true")){					
					count2++;
					risp = risp + x[i].toString()+"\n";													
					}
				else if(IsRemote.equals("false"))
				{
					count2++;
					risp = risp + x[i].toString()+"\n";	
				}									
			}				
		}
		if(x[i].isCity(CityName3)){
			if(x[i].isLang(Lang)){
				if(IsRemote.equals("true")){					
					count3++;
					risp = risp + x[i].toString()+"\n";													
					}
				else if(IsRemote.equals("false"))
				{
					count3++;
					risp = risp + x[i].toString()+"\n";	
				}									
			}				
		}
		if(x[i].isCity(CityName4)){
			if(x[i].isLang(Lang)){
				if(IsRemote.equals("true")){					
					count4++;
					risp = risp + x[i].toString()+"\n";													
					}
				else if(IsRemote.equals("false"))
				{
					count4++;
					risp = risp + x[i].toString()+"\n";	
				}									
			}				
		}
	}		
	return "Trovati "+count1+" offerte di lavoro a "+CityName+", "+count2+" offerte di lavoro a "+
			CityName2+", "+count3+" offerte di lavoro a "+CityName3+" e "+count4+" offerte di lavoro a "+
			CityName4+" con il linguaggio di programmazione "+Lang+remote+" su "+ x.length +" offerte di lavoro totali.\n"
			+ risp;
	}
	
	/**
	 * Questa funzione effettua una ricerca combinata in base a sette parametri passati che sono il linguaggio
	 * di programmazione, cinque città desiderate e la tipologia di lavoro(se opera solo in presenza o anche
	 * in remoto) restituendo una stringa contenente tutti i lavori che operano in tali città, con quella 
	 * modalità ed utilizzano quel linguaggio di programmazione chiesto dal client. In più il programma 
	 * restituisce al client una stringa contenente delle statistiche utili a chi effettua la ricerca.
	 *  
	 * @param x E' l'array contenente tutti i lavori su cui si effettua la richiesta.
	 * @param Lang Linguaggio di programmazione per cui si sta effettuando la ricerca.
	 * @param CityName Città per cui si sta effettuando la ricerca.
	 * @param CityName2 Seconda città per cui si sta effettuando la ricerca.
	 * @param CityName3 Terza città per cui si sta effettuando la ricerca.
	 * @param CityName4 Quarta città per cui si sta effettuando la ricerca.
	 * @param CityName5 Quinta città per cui si sta effettuando la ricerca.
	 * @param IsRemote Tipologia di lavoro per cui si sta effettuando la ricerca.
	 * @return Stringa che contiene tutti i lavori che soddisfano le condizioni di ricerca, assieme a delle
	 * statistiche.
	 */	
	
	public static String FilteredSearch10(Lavori[] x, String Lang, String CityName, String CityName2,
			String CityName3, String CityName4,String CityName5, String IsRemote) {
	String risp="";
	int count1=0;
	int count2=0;
	int count3=0;
	int count4=0;
	int count5=0;
	String remote="";
	if(IsRemote.equals("true")){
		remote=" in remoto ";
	} else {
		remote=" in presenza ";
	}
	for(int i=0;i<x.length;i++) {
		if(x[i].isCity(CityName)){
			if(x[i].isLang(Lang)){
				if(IsRemote.equals("true")){					
					count1++;
					risp = risp + x[i].toString()+"\n";													
					}
				else if(IsRemote.equals("false"))
				{
					count1++;
					risp = risp + x[i].toString()+"\n";	
				}									
			}				
		}
		if(x[i].isCity(CityName2)){
			if(x[i].isLang(Lang)){
				if(IsRemote.equals("true")){					
					count2++;
					risp = risp + x[i].toString()+"\n";													
					}
				else if(IsRemote.equals("false"))
				{
					count2++;
					risp = risp + x[i].toString()+"\n";	
				}									
			}				
		}
		if(x[i].isCity(CityName3)){
			if(x[i].isLang(Lang)){
				if(IsRemote.equals("true")){					
					count3++;
					risp = risp + x[i].toString()+"\n";													
					}
				else if(IsRemote.equals("false"))
				{
					count3++;
					risp = risp + x[i].toString()+"\n";	
				}									
			}				
		}
		if(x[i].isCity(CityName4)){
			if(x[i].isLang(Lang)){
				if(IsRemote.equals("true")){					
					count4++;
					risp = risp + x[i].toString()+"\n";													
					}
				else if(IsRemote.equals("false"))
				{
					count4++;
					risp = risp + x[i].toString()+"\n";	
				}									
			}				
		}
		if(x[i].isCity(CityName5)){
			if(x[i].isLang(Lang)){
				if(IsRemote.equals("true")){					
					count5++;
					risp = risp + x[i].toString()+"\n";													
					}
				else if(IsRemote.equals("false"))
				{
					count5++;
					risp = risp + x[i].toString()+"\n";	
				}									
			}				
		}		
	}		
	return "Trovati "+count1+" offerte di lavoro a "+CityName+", "+count2+" offerte di lavoro a "+
			CityName2+", "+count3+" offerte di lavoro a "+CityName3+", "+count4+" offerte di lavoro a "+
			CityName4+" e "+count5+" offerte di lavoro a "+CityName5+" con il linguaggio di programmazione "
			+Lang+remote+" su "+ x.length +" offerte di lavoro totali.\n"
			+ risp;
	}		
}