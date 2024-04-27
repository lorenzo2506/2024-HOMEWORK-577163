package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	public Labirinto labirinto;
	private boolean finita;
	public Giocatore giocatore;
	
	public Partita(){
		this.labirinto = new Labirinto();
		this.finita = false;
		this.giocatore = new Giocatore();
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	public Giocatore getGiocatore() {
		return this.giocatore;
	}

	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.labirinto.getStanzaCorrente()== this.labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	public boolean giocatoreIsVivo() {
		return giocatore.getCfu()!=0;
	}

	
}
