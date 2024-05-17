package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza{

	private String nomeDirezione;
	private String nomeAttrezzo;
	
	public StanzaBloccata(String nome, String direzione, String attrezzo) {
		
		super(nome);
		this.nomeAttrezzo=attrezzo;
		this.nomeDirezione=direzione;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String dir) {
		
		if(hasAttrezzo(nomeAttrezzo) || !(dir.equals(nomeDirezione)))
			return super.getStanzaAdiacente(dir);
		
		return this;
	}
	
	
	@Override
	public String getDescrizione() {
		
		StringBuilder risultato = new StringBuilder();
    	risultato.append(this.getNome());
    	
    	risultato.append("\nUscite: ");
    	for (String direzione : this.getDirezioni())
    		if(direzione.equals(this.nomeDirezione) && !(this.hasAttrezzo(nomeAttrezzo)))
    			risultato.append(" "+"DIREZIONE BLOCCATA!");
    		else
    			risultato.append(" " + direzione);
    	
    	risultato.append("\nAttrezzi nella stanza: ");
    	for (Attrezzo attrezzo : this.getAttrezzi())
    		risultato.append(attrezzo.toString()+" ");
    	
    	
    	return risultato.toString();
	}
}
