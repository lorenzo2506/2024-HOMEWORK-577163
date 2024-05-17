package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.FabbricaDiComandi;
import it.uniroma3.diadia.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class ComandoPosaTest {

	Labirinto lab;
	Partita partita;
	FabbricaDiComandi factory;
	Comando posa;
	Borsa borsa;
	Attrezzo pistola;
	
	@BeforeEach
	void setUp() {
		
		lab = new LabirintoBuilder();
		partita = new Partita(lab);
		factory = new FabbricaDiComandiFisarmonica();
		posa = new ComandoPosa();
		pistola = new Attrezzo("pistola",8);
	}
	
	
	void testPosaAttrezzo() {
		
		borsa = partita.getGiocatore().getBorsa();
		borsa.addAttrezzo(pistola);
		
		posa = factory.costruisciComando("posa pistola");
		assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("pistola"));
		
		posa.esegui(partita);
		
		assertTrue(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("pistola"));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("pistola"));
		
		
	}
}
