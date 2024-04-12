package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""  /*+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'."*/;
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "posa", "prendi"};

	private Partita partita;
	private IOConsole console;

	public DiaDia() {
		this.partita = new Partita();
		this.console = new IOConsole();
	}

	public void gioca() {
		String istruzione; 
		
		console.mostraMessaggio(MESSAGGIO_BENVENUTO);	
		do		
			istruzione = console.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} 
		else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		
		else if(comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		
		else
			console.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			console.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			console.mostraMessaggio(elencoComandi[i]+" ");
		console.mostraMessaggio("\n");
	}
	
	private void posa(String nomeAttrezzo) {
		
		if(nomeAttrezzo==null)
				console.mostraMessaggio("Che attrezzo vuoi posare?");
		
		Attrezzo a = null;
		a = this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		
		if(a==null)
			console.mostraMessaggio("l'attrezzo " + nomeAttrezzo+ " non e' in borsa");
		
		else {
		
			if(this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(a) == true)
				console.mostraMessaggio("OPERAZIONE COMPLETATA");
			
			else
				console.mostraMessaggio("OPERAZIONE NON RIUSCITA");
		}
		
		console.mostraMessaggio(this.partita.getLabirinto().getStanzaCorrente().getDescrizione());
		console.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());

	}
	
	
	private void prendi(String nomeAttrezzo) {
		
		if(nomeAttrezzo==null)
				console.mostraMessaggio("Che attrezzo vuoi prendere?");
		
		Attrezzo a=null;
		Stanza stanzaCorrente = this.partita.getLabirinto().getStanzaCorrente();
		
		if(stanzaCorrente.hasAttrezzo(nomeAttrezzo)==false )
			console.mostraMessaggio("l'attrezzo "+ nomeAttrezzo + " non e' in " + stanzaCorrente.getNome());
		
		else {
			a=stanzaCorrente.getAttrezzo(nomeAttrezzo);
			this.partita.getGiocatore().getBorsa().addAttrezzo(a);

			if(stanzaCorrente.removeAttrezzo(a));
				console.mostraMessaggio("OPERAZIONE COMPLETATA");
		}
		
		console.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());
		console.mostraMessaggio(this.partita.getLabirinto().getStanzaCorrente().getDescrizione());
	}
	
	

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			System.out.println("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			console.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		console.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		console.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		console.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}