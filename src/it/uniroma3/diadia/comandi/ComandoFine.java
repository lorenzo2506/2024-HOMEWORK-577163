package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;

public class ComandoFine implements Comando{

	IO console;
	
	@Override
	public void esegui(Partita partita) {
		
		console = new IOConsole();
		partita.setFinita();
		console.mostraMessaggio("Grazie di aver giocato");
	}
	
	@Override
	public void setParametro(String parametro) {
		
	}
	
	@Override
	public String getNome() {
		return "fine";
	}
	
	@Override
	public String getParametro() {
		return "";
	}
}
