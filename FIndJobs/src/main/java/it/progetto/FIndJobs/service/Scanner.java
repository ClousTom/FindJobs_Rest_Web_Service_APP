package it.progetto.FIndJobs.service;

import java.net.URL;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import it.progetto.FIndJobs.model.Lavori;
import it.progetto.FIndJobs.service.*;

public class Scanner {
	
    static JSONArray Data = new JSONArray();
	static Lavori[] x = new Lavori[10000];
	
	public static void start() throws Exception{
		
		URL url = new URL("https://findwork.dev/api/jobs");
		System.out.println();
		System.out.println("Inizio la scansione delle offerte di lavoro sulla pagina web: "+url);
		
		
		int countPag = 0;
		Data = DownloadData.connect(Data,url,countPag);
		
		x = parseData.pData(Data, x);
//		System.out.println(x[0].toString());
	}
	
	public static String SearchCity(String CityName) {
		String ListaLavori = Filters.City(x,CityName);
		return ListaLavori;
	}
	
	public static String SearchLanguage(String Lang) {
		String ListaLavori = Filters.Language(x,Lang);
		return ListaLavori;
	}
	
	public static String SearchRemoteJobs() {
		String ListaLavori = Filters.RemoteJobs(x);
		return ListaLavori;
	}
	
	public static String SearchNoRemoteJobs() {
		String ListaLavori = Filters.NoRemoteJobs(x);
		return ListaLavori;
	}
	
}
