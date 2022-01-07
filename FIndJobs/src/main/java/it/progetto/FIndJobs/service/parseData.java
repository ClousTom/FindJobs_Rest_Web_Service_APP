package it.progetto.FIndJobs.service;

import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import it.progetto.FIndJobs.model.Lavori;

/**
 * Questa classe cha lo scopo di creare l'array che conterrà tutti i dati. 
 *
 * @author Leonardo Pescetti
 * @author Claudio Tomaiuolo
 */

public class parseData {
	
	/**
	 * Questo metodo prende tutti i valori contenuti in keywords e li inserisce in un vettore di stringhe.
	 * 
	 * @param obj Elementi che la funzione prenderà per costruire il vettore.
	 * return Vettore di stringhe contenente tutte le keywords.
	 */
	
	public static Vector<String> keywords(JSONObject obj){
		JSONArray arr = (JSONArray) obj.get("keywords");
		Vector<String> v = new Vector<String>(); 
		for (int i=0; i<arr.size();i++) {
			v.add((String)arr.get(i));
		}
		return v;
	}
	
	/**
	 * Questo metodo prende il JSONArray data contenente tutti i dati appena acquisiti dal 
	 * sito :"https://findwork.dev/api/jobs/" ed un vettore Lavori, inizialmente vuoto.
	 * Viene inizializzato un JSONObject che prenderà poi gli elementi dal JSONArray. Inizia un for che per
	 * ogni posizione i-esima del vettore Lavori, verranno passate tutte le componenti della posizione i-esima
	 * del JSONArray. Cosi facendo il JSONArray viene "svuotato" dentro il vettore della classe Lavori.
	 * Questo metodo richiama poi la funzione keywords che si occupa di prelevare tutti i dati contenuti
	 * in keywords posizionandoli in un vettore. Che verrà poi restituito al vettore Lavori che mi sto creando.
	 * 
	 * @param Data JSONArray di partenza che contiene tutti i dati.
	 * @param x Array della classe lavori che andrò a riempire con i dati passati da Data.
	 * @return Array completo di tutti i dati.
	 */
	
	public static Lavori[] pData(JSONArray Data, Lavori[] x) throws Exception{
		JSONObject obj = new JSONObject();
		
		for (int i=0; i<Data.size(); i++) {
			
			x[i] = new Lavori();
			obj = (JSONObject) Data.get(i);
			
			x[i].setId((long) obj.get("id"));
			x[i].setRole((String) obj.get("role"));
			x[i].setCompany_name((String) obj.get("company_name"));
			x[i].setCompany_num_employees((String) obj.get("company_num_employees"));
			x[i].setEmployment_type((String) obj.get("employment_type"));
			x[i].setLocation((String) obj.get("location"));
			x[i].setRemote((boolean) obj.get("remote"));
			x[i].setLogo((String) obj.get("logo"));
			x[i].setUrl((String) obj.get("url"));
			x[i].setText((String) obj.get("text"));
			x[i].setDate_posted((String) obj.get("date_posted"));
		
			x[i].setKeywords(keywords(obj));
		
			x[i].setSource((String) obj.get("source"));
		}
		return x;
	}

}
