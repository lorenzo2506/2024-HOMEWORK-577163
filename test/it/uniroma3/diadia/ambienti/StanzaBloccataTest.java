package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {

	
	Attrezzo pass;
	Attrezzo osso;
	Stanza stanzaBloccata;
	Stanza atrio;
	Stanza biblioteca;
	
	@BeforeEach
	void setUp() {
		
		pass = new Attrezzo("pass",5);
		osso = new Attrezzo("osso", 3);
		
		stanzaBloccata = new StanzaBloccata("stanzaBloccata", "nord", "pass");
		atrio = new Stanza("atrio");
		biblioteca = new Stanza("biblioteca");
		
	}
	
	
	@Test
	void testStanzaAdiacente() {
		
		stanzaBloccata.impostaStanzaAdiacente("nord", atrio);
		stanzaBloccata.impostaStanzaAdiacente("sud", biblioteca);
		
		assertEquals(stanzaBloccata.getStanzaAdiacente("nord"), stanzaBloccata);
		assertEquals(stanzaBloccata.getStanzaAdiacente("sud"), biblioteca);
		
		stanzaBloccata.addAttrezzo(osso);
		assertEquals(stanzaBloccata.getStanzaAdiacente("nord"), stanzaBloccata);
		
		stanzaBloccata.addAttrezzo(pass);
		assertEquals(stanzaBloccata.getStanzaAdiacente("nord"), atrio);
	}
	
	
	@Test
	void testGetDescrizione() {
		
		stanzaBloccata.impostaStanzaAdiacente("nord", atrio);
		
		assertTrue(stanzaBloccata.getDescrizione().contains("DIREZIONE BLOCCATA!"));
		
		stanzaBloccata.addAttrezzo(pass);
		
		assertFalse(stanzaBloccata.getDescrizione().contains("DIREZIONE BLOCCATA!"));
	}
}
