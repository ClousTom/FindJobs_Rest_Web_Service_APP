package it.progetto.FIndJobs.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Vector;
import java.net.HttpURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

	/**
	 * Lo scopo di questa classe è stabilire la connessione con la pagina:"https://findwork.dev/api/jobs/",
	 * scarica i dati e crea il JSONArray contenente i dati.
	 *
	 * @author Leonardo Pescetti
	 * @author Claudio Tomaiuolo
	 */

public class DownloadData {

	/**
	 * Questa funzione preso il JSONArray e l'url, scarica i dati dall'url e li mette in un buffer, li legge 
	 * tutti e li inserisce in una stringa. Con un JSONParser separa tutte le stringhe mettendoli dentro un 
	 * JSONObject. Quest'ultimo viene diviso(viene preso solo il campo results) e convertito in un JSONArray,
	 * che verrà man a mano inserito all'interno di Data che contiene il Dataset completo.
	 * Infine l'If viene utilizzato per determinare se si è arrivati alla fine della pagina, per poi stabilire 
	 * la connessione con la pagina successiva utilizzando due funzioni ricorsive.
	 * 
	 * @param Data JSONArray da riempire.
	 * @param urlConn URl da cui si effettuerà la connessione.
	 * @param countPag contatore delle pagine.
	 * @return JSONArray riempito.
	 */
	
	public static JSONArray getData(JSONArray Data, HttpURLConnection urlConn, int countPag){
		try {
		
			String line;
    		BufferedReader reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "UTF-8"));
    		line = reader.readLine();
            
            JSONParser parse = new JSONParser();
            JSONObject data_obj = (JSONObject) parse.parse(line);
			
            JSONArray temp = (JSONArray) data_obj.get("results");
			Data.addAll(temp);
			
			if (data_obj.get("next") == null) {
				System.out.println();
				System.out.println("Scansionate "+countPag+" pagine. Trovate "+Data.size()+" offerte di lavoro.");
				return Data;
			} else {  
				URL url = new URL((String) data_obj.get("next"));
				
						if (countPag==20 || countPag==40 || countPag==60) {
					    System.out.println();
					    System.out.println("Scansionate "+countPag+" pagine...");
						Thread.sleep(10000);
					    Data = connect(Data, url, countPag);
					  } else {
//						Thread.sleep(500);
					    Data = connect(Data, url, countPag);
					  }
			}
			
		}  catch (Exception e) {
    	 	e.printStackTrace();
     	}
		return Data;
	}
	
	/**
	 * Questa funzione preso l'url iniziale si connette alla pagina, esegue l'autorizzazione con il Token API 
	 * Key. Creato il collegamento questa funzione verrà utilizzata da GetData per acquisire tutto il Dataset.
	 * 
	 * @param Data Dataset contenente i lavori.
	 * @param url URl della pagina da cui si vuole effettuare il download dei dati.
	 * @param countPag Contatore delle pagine.
	 */
	
	public static JSONArray connect(JSONArray Data, URL url, int countPag) {
		try {
			HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
			urlConn.setRequestProperty("Authorization","Token cb6ed7937f423f6e700ab45dfdfd3b8ad553cde7");
			urlConn.setRequestProperty("Accept","*/*");
			urlConn.setRequestProperty("Connection","keep-alive");
			countPag++;
			
			//Getting the response code
	        int responsecode = urlConn.getResponseCode();
	        if (responsecode != 200) {
	            throw new RuntimeException("HttpResponseCode: " + responsecode);
	        } else {
	        	Data = getData(Data, urlConn, countPag);
	        }
		}  catch (Exception e) {
    	 	e.printStackTrace();
     	}
		return Data;
	}
	
	
}
