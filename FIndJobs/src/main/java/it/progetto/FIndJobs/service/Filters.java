package it.progetto.FIndJobs.service;

import it.progetto.FIndJobs.model.Lavori;

public class Filters {

	public static String RemoteJobs (Lavori[] x){
		String risp="";
		for(int i=0;i<x.length;i++) {
			if(x[i].isRemote()) {
				risp = risp + x[i].toString();
			}
		}
		return risp;
	}
	
	public static String NoRemoteJobs (Lavori[] x){
		String risp="";
		for(int i=0;i<x.length;i++) {
			if(!x[i].isRemote()) {
				risp = risp + x[i].toString();
			}
		}
		return risp;
	}
	
	public static String City (Lavori[] x, String CityName){
		String risp="";
		for(int i=0;i<5000;i++) {
			if(x[i].isCity(CityName)) {
				risp = risp + x[i].toString();
			}
		}
		return risp;
	}
	
	public static String Language (Lavori[] x, String Lang){
		String risp="";
		for(int i=0;i<5000;i++) {
			if(x[i].isLang(Lang)) {
				risp = risp + x[i].toString();
			}
		}
		return risp;
	}
	
}
