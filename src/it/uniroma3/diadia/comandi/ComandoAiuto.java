package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

public class ComandoAiuto implements Comando{

	private String[] elencoComandi = {"vai", "aiuto", "guarda", "posa", "prendi", "fine"};;
	private IO console;
	
	@Override
	public void esegui(Partita partita) {
		
		console = new IOConsole();
		for(int i=0; i< elencoComandi.length; i++) 
			console.mostraMessaggio(elencoComandi[i]+" ");
		console.mostraMessaggio("\n");
	}
	
	@Override
	public void setParametro(String parametro) {
		
	}
	

	@Override
	public String getNome() {
		return "aiuto";
	}
	
	@Override
	public String getParametro() {
		return "";
	}
	
}
