package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;

public class ComandoNonValido implements Comando{

	IO console;
	
	@Override
	public void esegui(Partita partita) {
		
		console = new IOConsole();
		console.mostraMessaggio("Comando non valido!");
	}
	
	@Override
	public void setParametro(String parametro) {
	}
	
	@Override
	public String getNome() {
		return "nonValido";
	}
	
	@Override
	public String getParametro() {
		return "";
	}
}
