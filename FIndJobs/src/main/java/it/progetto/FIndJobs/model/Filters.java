package it.progetto.FIndJobs.model;
import java.util.Vector;

/**
 * 
 *
 * @author Leonardo Pescetti
 * @author Claudio Tomaiuolo
 */

public class Filters {

	public static void RemoteJobs (Lavori[] x){
		for(int i=0;i<x.length;i++) {
			if(x[i].isRemote()) {
				System.out.println(x[i].isRemote()+" "+i);
			}
		}
	}
	
	public static void NoRemoteJobs (Lavori[] x){
		for(int i=0;i<x.length;i++) {
			if(!x[i].isRemote()) {
				System.out.println(x[i].isRemote()+" "+i);
			}
		}
	}
	
	public static void CitySearch (Lavori[] x){
		String city="Austin";
		for(int i=0;i<x.length;i++) {
			if(x[i].isCity(city)) {
				System.out.println(x[i].getLocation()+" "+i);
			}
		}
	}
	
	public static void LanguageSearch (Lavori[] x){
		String lang="javascript";
		for(int i=0;i<x.length;i++) {
			if(x[i].isLang(lang)) {
				System.out.println(i+" "+lang);
			}
		}
		
	}
}
