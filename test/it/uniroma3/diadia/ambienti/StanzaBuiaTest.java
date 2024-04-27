package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {

	
	Stanza stanzaBuia;
	Attrezzo pass;
	Attrezzo libro;
	
	@BeforeEach
	void setUp() {
		stanzaBuia = new StanzaBuia("stanzaBuia","pass");
		pass = new Attrezzo("pass",5);
		libro = new Attrezzo("libro",3);
	}
	
	
	@Test
	void testGetDescrizione() {
		
		assertTrue(stanzaBuia.getDescrizione().equals("qui c'e' un buio pesto"));
		
		stanzaBuia.addAttrezzo(libro);
		
		assertTrue(stanzaBuia.getDescrizione().equals("qui c'e' un buio pesto"));
		
		stanzaBuia.addAttrezzo(pass);
		
		assertFalse(stanzaBuia.getDescrizione().equals("qui c'e' un buio pesto"));

	}

}
