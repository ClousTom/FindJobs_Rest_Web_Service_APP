package it.progetto.FIndJobs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.progetto.FIndJobs.service.*;

@RestController
public class controller {
	
	String risp;

	@GetMapping("/prova/nome/{CityName}")
	public ResponseEntity<Object> RicercaPerCitta(@PathVariable String CityName) {
		
		risp = Scanner.SearchCity(CityName);
		
		return new ResponseEntity<> (risp, HttpStatus.OK);
	}
	
	@GetMapping("/prova/nome/{Language}")
	public ResponseEntity<Object> RicercaPerLinguaggio(@PathVariable String Language) {
		
		risp = Scanner.SearchLanguage(Language);
		
		return new ResponseEntity<> (risp, HttpStatus.OK);
	}
	
	@GetMapping("/prova/nome/{Online}")
	public ResponseEntity<Object> RicercaLavoriInRemoto(@PathVariable String Online) {
		
		risp = Scanner.SearchRemoteJobs();
		
		return new ResponseEntity<> (risp, HttpStatus.OK);
	}
	
	@GetMapping("/prova/nome/{NoOnline}")
	public ResponseEntity<Object> RicercaLavoriInLocale(@PathVariable String NoOnline) {
		
		risp = Scanner.SearchNoRemoteJobs();
		
		return new ResponseEntity<> (risp, HttpStatus.OK);
	}
	
}
