package it.progetto.FIndJobs.service;

import it.progetto.FIndJobs.model.Lavori;

/**
 * 
 *
 * @author Leonardo Pescetti
 * @author Claudio Tomaiuolo
 */

public class Filters {
		
	public static String City (Lavori[] x, String CityName){
		String risp="";
		for(int i=0;i<6000;i++) {
			if(x[i].isCity(CityName)) {
				risp = risp + x[i].toString();
			}
		}
		return risp;
	}
	
	public static String Language (Lavori[] x, String Lang){
		String risp="";
		for(int i=0;i<6000;i++) {
			if(x[i].isLang(Lang)) {
				risp = risp + x[i].toString();
			}
		}
		return risp;
	}
	
	//inizio modifica
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
	//fine modica
	
	
	//inizio modifica
	
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
	
	
	//fine modifica
	
}
