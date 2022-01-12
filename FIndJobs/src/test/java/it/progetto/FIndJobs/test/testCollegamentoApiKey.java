package it.progetto.FIndJobs.test;
import java.lang.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URL;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.progetto.FIndJobs.*;
import it.progetto.FIndJobs.model.Lavori;

/**
 * 
 *
 * @author Leonardo Pescetti
 * @author Claudio Tomaiuolo
 */

	class testCollegamentoApiKey {

	
		private String url1;
		private String url2;
		
	@BeforeEach
	void setUp() throws Exception {
		url1=new String("https://findwork.dev/api/jobs");
		url2=new String("https://findwork.dev/api/jobss");
	}

	@BeforeAll
	public void before() {
		System.out.println("Inizio dei vari test...");
	}
	
	
	@Test
	void test1() {
		assertEquals("https://findwork.dev/api/jobs" , url1.toString());
	}
	
	@Test
	void test2() {
		
		assertEquals("https://findwork.dev/api/jobs" , url2.toString());
	}
	
//	@Test
//	void test3() {
//		NullPointerException exception = assertThrows(NullPointerException.class, () ->{
//		url2.ImmettereLink(null);
//		});
//		
//		assertEquals("Link vuoto! ", exception.getMessage());
//	}

	@AfterAll
	public void after() {
		System.out.println("Fine dei vari test.");
	}
	
	
}
