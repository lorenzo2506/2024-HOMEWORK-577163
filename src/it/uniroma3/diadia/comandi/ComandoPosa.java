package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;


public class ComandoPosa implements Comando{

	String nomeAttrezzo;
	private IO console;
	
	@Override
	public void esegui(Partita partita) {
		
		console = new IOConsole();

		if(nomeAttrezzo==null)
			console.mostraMessaggio("Che attrezzo vuoi posare?");
	
		Attrezzo a = null;
		a = partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		
		if(a==null)
			console.mostraMessaggio("l'attrezzo " + nomeAttrezzo+ " non e' in borsa");
		
		else {
			console.mostraMessaggio(a.getNome());
			if(partita.getLabirinto().getStanzaCorrente().addAttrezzo(a) == true)
				console.mostraMessaggio("OPERAZIONE COMPLETATA");
			
			else
				console.mostraMessaggio("OPERAZIONE NON RIUSCITA");
		}
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
	
	@Override
	public String getNome() {
		return "posa";
	}
	
	@Override
	public String getParametro() {
		return "";
	}
}
