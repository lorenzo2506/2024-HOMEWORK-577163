package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;


public class ComandoPrendi implements Comando{

	String nomeAttrezzo;
	private IO console;
	
	@Override
	public void esegui(Partita partita) {
		
		console = new IOConsole();
		if(nomeAttrezzo==null)
			console.mostraMessaggio("Che attrezzo vuoi prendere?");
		
		Attrezzo a=null;
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		
		if(stanzaCorrente.hasAttrezzo(this.nomeAttrezzo)==false )
			console.mostraMessaggio("l'attrezzo "+ nomeAttrezzo + " non e' in " + stanzaCorrente.getNome());
		
		else {
			a=stanzaCorrente.getAttrezzo(this.nomeAttrezzo);
			partita.getGiocatore().getBorsa().addAttrezzo(a);
	
			if(stanzaCorrente.removeAttrezzo(a));
				console.mostraMessaggio("OPERAZIONE COMPLETATA");
		}
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
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
