package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando {
	
	private String direzione;
	private IO console;
	
	@Override
	public void esegui(Partita partita) {
		
		console = new IOConsole();
		
		if(this.direzione==null) {
			console.mostraMessaggio("dove vuoi andare?");
			return;
		}
		Stanza stanzaAdiacente = partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if(stanzaAdiacente==null) {
			console.mostraMessaggio("direzione inesistente");
			return;
		}
		
		partita.getLabirinto().setStanzaCorrente(stanzaAdiacente);
		int cfu = partita.getGiocatore().getCfu();
		partita.getGiocatore().setCfu(cfu--);
	}
	
	@Override
	public void setParametro(String parametro) {
		this.direzione= parametro;
	}
	
	@Override
	public String getNome() {
		return "prendi";
	}
	
	@Override
	public String getParametro() {
		return "";
	}
}