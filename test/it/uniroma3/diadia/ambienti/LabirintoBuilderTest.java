package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LabirintoBuilderTest {

	LabirintoBuilder lab;

	
	@BeforeEach
	void setUp() {
		lab = new LabirintoBuilder();
	}
	
	
	@Test
	void testAddStanzaIniziale() {
		
		lab.addStanzaIniziale("Atrio");
		assertTrue(lab.getStanzaCorrente().getNome().equals("Atrio"));
		assertTrue(lab.getUltimaStanzaAggiunta().getNome().equals("Atrio"));
		assertEquals(lab.getStanza("Atrio").getNome(), "Atrio");

	}
	
	
	@Test
	void testAddStanza() {
		
		lab.addStanza("Laboratorio");
		assertTrue(lab.getUltimaStanzaAggiunta().getNome().equals("Laboratorio"));
		assertFalse(lab.getUltimaStanzaAggiunta().getNome().equals("Laboratorioo"));
		lab.addStanza("Cucina");
		assertTrue(lab.getUltimaStanzaAggiunta().getNome().equals("Cucina"));
		
		assertEquals(lab.getStanza("Laboratorio").getNome(), "Laboratorio");
		assertEquals(lab.getStanza("Cucina").getNome(), "Cucina");

	}
	
	@Test
	void testAddStanzaVincente() {
		
		lab.addStanzaVincente("Atrio");
		assertTrue(lab.getStanzaVincente().getNome().equals("Atrio"));
		assertTrue(lab.getUltimaStanzaAggiunta().getNome().equals("Atrio"));
		assertEquals(lab.getStanza("Atrio").getNome(), "Atrio");
	}
	
	
	@Test
	void testAddAttrezzo() {
		lab.addStanza("Atrio").addAttrezzo("spada", 5);
		assertEquals(lab.getUltimaStanzaAggiunta().getAttrezzo("spada").getNome(),"spada");
		assertEquals(lab.getUltimaStanzaAggiunta().getAttrezzo("spada").getPeso(),5);

	}
}
