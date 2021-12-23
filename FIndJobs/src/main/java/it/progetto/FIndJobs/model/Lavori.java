package it.progetto.FIndJobs.model;
import java.util.Vector;

//import javax.lang.model.element.VariableElement;
//import javax.tools.Diagnostic;

/** Questa classe descrive le proprietà e varie info di ogni lavoro
 * 
 * 
 */

public class Lavori {
	
	public long id;
	public String company_name;
	public String location;
	public boolean remote;
	public String text;
	public String date_posted;
	public Vector<String> keywords=new Vector<String>();
	public String source;
	
	
	//costruttore oggetto
//	public Lavori() {      USATA SOLO PER L'EREDITARIETA', da eliminare nel caso non si usano superclassi
//		super();
//	}
	
	//costruttore dell'oggetto id
	
	public Lavori(long id) {
		this.id=id;
		this.company_name=null;
		this.location=null;
		this.remote=false;
		this.text=null;
		this.date_posted=null;
		this.keywords=null;
		this.source=null;
		
	
	}

//costruttore dell'oggetto location
	
	public Lavori(String location) {
		this.id=0;
		this.company_name=null;
		this.location=location;
		this.remote=false;
		this.text=null;
		this.date_posted=null;
		this.keywords=null;
		this.source=null;
	}
	
//costruttore dell'oggetto keywords
	
	public Lavori( Vector<String> keywords) {
	this.id=0;
	this.company_name=null;
	this.location=null;
	this.remote=false;
	this.text=null;
	this.date_posted=null;
	this.keywords=keywords;
	this.source=null;
}
	
//costruttore degli oggetti remote e source	
	public Lavori(boolean remote,String source ) {
		this.id=0;
		this.company_name=null;
		this.location=null;
		this.remote=remote;
		this.text=null;
		this.date_posted=null;
		this.keywords=null;
		this.source=source;
	}
	
	
//costruttore degli oggetti date_posted e source	
	public Lavori(String date_posted,String source ) {
		this.id=0;
		this.company_name=null;
		this.location=null;
		this.remote=false;
		this.text=null;
		this.date_posted=date_posted;
		this.keywords=null;
		this.source=source;
	}
	
	
//costruttore completo con tutti gli oggetti della classe lavori	
	public Lavori(long id, String company_name,String location, boolean remote,String text,String date_posted,Vector<String> keywords,String source) {
		this.id=id;
		this.company_name=company_name;
		this.location=location;
		this.remote=remote;
		this.text=text;
		this.date_posted=date_posted;
		this.keywords=keywords;
		this.source=source;
	}
	
	
	
	
	


	//getters e setters della classe lavori
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public boolean isRemote() {
		return remote;
	}
	public void setRemote(boolean remote) {
		this.remote = remote;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getDate_posted() {
		return date_posted;
	}
	public void setDate_posted(String date_posted) {
		this.date_posted = date_posted;
	}
	public Vector<String> getKeywords() {
		return keywords;
	}
	public void setKeywords(Vector<String> keywords) {
		this.keywords = keywords;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	
	
	
	
	
	
	
}
