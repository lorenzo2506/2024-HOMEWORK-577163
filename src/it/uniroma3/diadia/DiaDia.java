package it.uniroma3.diadia;

import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;

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
	private IO console;

	public DiaDia(IO console2) {
		this.partita = new Partita();
		this.console = console2;
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

			Comando comandoDaEseguire;
			FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
			
			comandoDaEseguire = factory.costruisciComando(istruzione);
			comandoDaEseguire.esegui(this.partita);

			if (this.partita.vinta())
				System.out.println("Hai vinto!");
			if (!this.partita.giocatoreIsVivo())
				System.out.println("Hai esaurito i CFU...");

			return this.partita.isFinita();
	}

	public static void main(String[] argc) {
		
		IO console = new IOConsole();
		DiaDia gioco = new DiaDia(console);
		gioco.gioca();
	}
}