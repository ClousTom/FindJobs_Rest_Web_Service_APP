package it.progetto.FIndJobs.service;

import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import it.progetto.FIndJobs.model.Lavori;

/**
 * 
 *
 * @author Leonardo Pescetti
 * @author Claudio Tomaiuolo
 */

public class parseData {
	
	public static Vector<String> keywords(JSONObject obj){
		JSONArray arr = (JSONArray) obj.get("keywords");
		Vector<String> v = new Vector<String>(); 
		for (int i=0; i<arr.size();i++) {
			v.add((String)arr.get(i));
		}
		return v;
	}
	
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
