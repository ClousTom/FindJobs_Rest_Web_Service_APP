package it.progetto.FIndJobs.model;
import java.lang.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import it.progetto.FIndJobs.service.parseData;

/**
 * In questa classe sono presenti tutti i metodi che permettono il collegamento web con la pagina contentente
 * l'elenco di tutti i lavori: "https://findwork.dev/api/jobs", effettua l'accesso all'API e posiziona tutti
 * i lavori in un Array, che verrà utilizzato dopo dal controller per fare le richieste desiderate dal client
 *
 * @author Leonardo Pescetti
 * @author Claudio Tomaiuolo
 */

	public class CollegamentoApiKey{
		
		/*
		* 
		* 
		* 
		* 
		* @param 
		* @return 	
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
				
				if (data_obj.get("next") != null) {
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
//							Thread.sleep(500);
						    Data = connect(Data, url, countPag);
						  }
				}
				
			}  catch (Exception e) {
	    	 	e.printStackTrace();
	     	}
			return Data;
		}
		
		/*
		* Questa funzione effettua l'autenticazione API utilizzando 3 headers, il più importante è quello che
		* contiene l'API KEY
		*  
		* @param 
		* @return 	
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

		/*
		* 
		* 
		* 
		* 
		* @param 
		* @return 	
		*/
		
		public static void start() throws Exception{
			
			URL url = new URL("https://findwork.dev/api/jobs");
			
			System.out.println();
			System.out.println("Inizio la scansione delle offerte di lavoro sulla pagina web: "+url);
			
			JSONArray Data = new JSONArray();
			int countPag = 0;
			Data = connect(Data,url,countPag);
			
			Lavori[] x = new Lavori[Data.size()];
			x = parseData.pData(Data, x);
//			System.out.println(x[0].toString());
			
//			Filters.RemoteJobs(x);
//			Filters.NoRemoteJobs(x);
//			Filters.CitySearch(x);
//			Filters.LanguageSearch(x);
			
		}
				
		//funzione per junit test
		
//		public static void ImmettereLink(String s) {
//			if (s==null) throw new NullPointerException("Immettere il link nella classe CollegamentoApiKey!");
//		}
		
}