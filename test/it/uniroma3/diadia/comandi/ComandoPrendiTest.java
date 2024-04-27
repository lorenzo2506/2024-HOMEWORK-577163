package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.FabbricaDiComandi;
import it.uniroma3.diadia.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPrendiTest {

	Partita partita;
	FabbricaDiComandi factory;
	Comando prendi;
	Attrezzo osso;
	Attrezzo libro;
	Stanza stanzaCorrente;
	
	@BeforeEach
	void setUp() {
		this.partita = new Partita();
		this.factory = new FabbricaDiComandiFisarmonica();
		this.libro = new Attrezzo("libro",4);
		this.prendi = new ComandoPrendi();
		this.osso = new Attrezzo("osso",2);
	}
	
	@Test
	void testAddAttrezzo() {
		/*
		 * NT: nella stanza corrente ce già un oggetto "osso"
		 */
		
		stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		stanzaCorrente.addAttrezzo(libro);
		
		prendi = factory.costruisciComando("prendi libro");
		
		assertTrue(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("libro"));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("libro"));
		
		prendi.esegui(partita);
		
		assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("libro"));
		assertFalse(partita.getGiocatore().getBorsa().isEmpty());
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("libro"));
		
		
		prendi.setParametro(osso.getNome());
		
		prendi.esegui(partita);
		

		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("libro"));
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("osso"));

	}
	
	@Test
	void testAddAttrezzoParametroNull() {
		
		stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		stanzaCorrente.addAttrezzo(libro);
		
		prendi = factory.costruisciComando("prendi");
		
		prendi.esegui(partita);
		
		assertTrue(partita.getGiocatore().getBorsa().isEmpty());
		assertFalse(partita.giocatore.getBorsa().hasAttrezzo("libro"));
	}
}
