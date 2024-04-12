package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {


	Borsa borsa;
	Borsa borsa2;
	Attrezzo osso;
	Attrezzo chiave;
	Attrezzo lanterna;
	Attrezzo diario;
	
	@BeforeEach
	void setUp() {
		osso = new Attrezzo("osso",3);
		chiave= new Attrezzo("chiave",2);
		lanterna = new Attrezzo("lanterna",4);
		diario = new Attrezzo("diario", 5);
		borsa = new Borsa(10);
		borsa2 = new Borsa(10);
	}
	
	@Test
	void testAddAttrezzo() {
		
		assertTrue(borsa.isEmpty());
		assertTrue(borsa.addAttrezzo(osso));
		assertFalse(borsa.isEmpty());
		assertTrue(borsa.hasAttrezzo("osso"));
		
		assertEquals(borsa.getAttrezzo("osso").getNome(),osso.getNome());
		
		assertEquals(borsa.removeAttrezzo("osso").getNome(), osso.getNome());
		
		assertTrue(borsa.isEmpty());
		
		
		
	}
	
	@Test 
	void testRemoveAttrezzo() {
		
		assertTrue(borsa2.addAttrezzo(lanterna));
		assertFalse(borsa2.isEmpty());
		
		assertEquals(borsa2.removeAttrezzo("lanterna").getNome(), lanterna.getNome());
		assertTrue(borsa2.isEmpty());	
		
		assertTrue(borsa2.addAttrezzo(chiave));
		assertTrue(borsa2.hasAttrezzo("chiave"));
		assertTrue(borsa2.addAttrezzo(osso));
		assertTrue(borsa2.hasAttrezzo("osso"));
		assertFalse(borsa2.isEmpty());
		
		assertEquals(borsa2.removeAttrezzo("osso").getNome(), osso.getNome());
		assertFalse(borsa2.isEmpty());
		assertFalse(borsa2.hasAttrezzo("osso"));
		assertTrue(borsa2.hasAttrezzo("chiave"));

		assertEquals(borsa2.removeAttrezzo("chiave").getNome(), chiave.getNome());
		assertFalse(borsa2.hasAttrezzo("chiave"));
		assertTrue(borsa2.isEmpty());
		
		
		borsa2.addAttrezzo(diario);
		borsa2.addAttrezzo(lanterna);
		assertTrue(borsa2.hasAttrezzo("diario"));
		assertTrue(borsa2.hasAttrezzo("lanterna"));
		
		borsa2.removeAttrezzo("diario");
		assertTrue(borsa2.hasAttrezzo("lanterna"));
		assertFalse(borsa2.isEmpty());

	}

}
