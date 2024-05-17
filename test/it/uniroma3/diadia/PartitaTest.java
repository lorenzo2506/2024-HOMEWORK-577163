package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {

	Partita partita;
	Labirinto lab;
	
	@BeforeEach
	void setUp() {
		this.lab = new LabirintoBuilder();
		this.partita = new Partita(lab);
	}
	
	@Test
	void testGetGiocatore() {
		assertNotNull(partita.getGiocatore());
	}
	
	@Test
	void testGetLabirinto() {
		assertNotNull(partita.getGiocatore());
	}
	
	@Test
	void testVinta()
	{
	  assertNotNull(this.partita.getLabirinto().getStanzaCorrente());
	  assertNotNull(this.partita.getLabirinto().getStanzaVincente());
	}

}
