package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;

public class ComandoGuarda implements Comando{

	IO console;
	@Override
	public void esegui(Partita partita) {
		
		console = new IOConsole();
		console.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
	}
	
	@Override
	public void setParametro(String parametro) {
		
	}
	
	@Override
	public String getNome() {
		return "guarda";
	}
	
	@Override
	public String getParametro() {
		return "";
	}
	
}
