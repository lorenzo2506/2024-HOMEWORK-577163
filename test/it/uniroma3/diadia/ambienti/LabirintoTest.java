package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LabirintoTest {

	Labirinto lab;
	Stanza atrio2;
	Stanza biblioteca2;
	
	@BeforeEach
	void setUp() {
		
		lab = new Labirinto();
		atrio2 = new Stanza("Atrio");
		biblioteca2 = new Stanza("Biblioteca");
	}
	
	@Test
	void testStanzaVincente() {
		assertEquals(biblioteca2.getNome(), lab.getStanzaVincente().getNome());
	}
	
	@Test
	void testStanzaCorrente() {
		assertEquals(atrio2.getNome(), lab.getStanzaCorrente().getNome());
		
		lab.setStanzaCorrente(biblioteca2);
		
		assertEquals(biblioteca2.getNome(), lab.getStanzaCorrente().getNome());
	}
	
	
	@Test
	void testStanzaAdiacente() {
		
		assertEquals(biblioteca2.getNome(), lab.getStanzaCorrente().getStanzaAdiacente("nord").getNome());

	}

}
