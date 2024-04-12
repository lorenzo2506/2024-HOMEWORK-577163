package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {

	Stanza atrio;
	Stanza biblioteca;
	Stanza cucina;
	Stanza salone;
	
	Attrezzo osso;
	Attrezzo chiave;
	Attrezzo lanterna;
	
	@BeforeEach
	void setUp() {
		atrio = new Stanza("atrio");
		biblioteca = new Stanza("biblioteca");
		cucina = new Stanza("cucina");
		salone = new Stanza("salone");
		
		osso = new Attrezzo("osso",3);
		chiave= new Attrezzo("chiave",2);
		lanterna = new Attrezzo("lanterna",4);
	}
	
	@Test
	void testStanzaAdiacente() {
		
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		biblioteca.impostaStanzaAdiacente("ovest", cucina);
		cucina.impostaStanzaAdiacente("sud", salone);
		salone.impostaStanzaAdiacente("est", atrio);
		
		
		assertEquals(atrio.getStanzaAdiacente("nord"), biblioteca);
		assertEquals(biblioteca.getStanzaAdiacente("ovest").getNome(), cucina.getNome());
		assertEquals(cucina.getStanzaAdiacente("sud").getNome(), salone.getNome());
		assertEquals(salone.getStanzaAdiacente("est").getNome(), atrio.getNome());
	
	}
	
	@Test
	void testAddAttrezzi() {
		
		assertTrue(atrio.isEmpty());
		assertFalse(atrio.hasAttrezzo("chiave"));
		atrio.addAttrezzo(chiave);
		assertTrue(atrio.hasAttrezzo("chiave"));
		assertFalse(atrio.isEmpty());

		
		
		biblioteca.addAttrezzo(osso);
		biblioteca.addAttrezzo(chiave);
		assertTrue(biblioteca.hasAttrezzo("osso"));
		assertTrue(biblioteca.hasAttrezzo("chiave"));
		
		assertEquals(biblioteca.getAttrezzo("chiave").getNome(), chiave.getNome());
		assertEquals(biblioteca.getAttrezzo("osso").getNome(), osso.getNome());
		
		assertTrue(biblioteca.hasAttrezzo("chiave"));
		assertTrue(biblioteca.hasAttrezzo("osso"));
	}
	
	@Test
	void testRemoveAttrezzi() {
		
		assertTrue(biblioteca.isEmpty());
		biblioteca.addAttrezzo(osso);
		biblioteca.addAttrezzo(chiave);
		assertEquals(biblioteca.getAttrezzo("chiave").getNome(), chiave.getNome());
		assertEquals(biblioteca.getAttrezzo("osso").getNome(), osso.getNome());
		
		assertTrue(biblioteca.removeAttrezzo(chiave));
		assertFalse(biblioteca.hasAttrezzo("chiave"));
		
		assertFalse(biblioteca.isEmpty());
		assertTrue(biblioteca.removeAttrezzo(osso));
		assertFalse(biblioteca.hasAttrezzo("osso"));
		assertTrue(biblioteca.isEmpty());
	}

}
