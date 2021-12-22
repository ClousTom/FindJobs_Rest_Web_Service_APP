package it.progetto.FIndJobs.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


	public class CollegamentoApiKey{
		
		

		public static void link()throws Exception{
		URL url = new URL("https://findwork.dev/api/jobs");
		
		URLConnection urlConn = url.openConnection();
		urlConn.setRequestProperty("Authorization","Token cb6ed7937f423f6e700ab45dfdfd3b8ad553cde7");
		urlConn.setRequestProperty("Accept","*/*");
		urlConn.setRequestProperty("Connection","keep-alive");
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "UTF-8"));
		String line;
		line = reader.readLine();
		System.out.println(line);	
		}	
}
	
    

