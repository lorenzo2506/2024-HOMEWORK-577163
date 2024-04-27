package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class TestStanzaMagica {

	Attrezzo barattolo;
	Attrezzo flauto;
	Stanza stanzaMagica;
	StanzaMagica stanzaMagica2;
	Attrezzo libro;
	Attrezzo pistola;
	
	
	@BeforeEach
	void setUp() {
		
		pistola = new Attrezzo("pistola", 7);
		barattolo = new Attrezzo("barattolo",4);
		flauto = new Attrezzo("flauto", 3);
		stanzaMagica = new StanzaMagica("stanzaMagica",2);
		stanzaMagica2 = new StanzaMagica("stanzaMagica2",2);
		libro = new Attrezzo("libro",4);
	}
	
	@Test
	void testModificaAttrezzo() {
		
		Attrezzo a = stanzaMagica2.modificaAttrezzo(libro);
		assertTrue(a.getNome().equals("orbil"));
		assertEquals(a.getPeso(), libro.getPeso()*2);
	}
	
	@Test
	void testAddAttrezzo() {
		
		stanzaMagica.addAttrezzo(barattolo);
		assertTrue(stanzaMagica.hasAttrezzo("barattolo"));
		
		stanzaMagica.addAttrezzo(libro);
		assertTrue(stanzaMagica.hasAttrezzo("libro"));
		
		stanzaMagica.addAttrezzo(flauto);
		assertTrue(stanzaMagica.hasAttrezzo("otualf"));
		
		stanzaMagica.addAttrezzo(pistola);
		assertTrue(stanzaMagica.hasAttrezzo("alotsip"));
		
		
		assertEquals(pistola.getPeso()*2, stanzaMagica.getAttrezzo("alotsip").getPeso());
	}
}
