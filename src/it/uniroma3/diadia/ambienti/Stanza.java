package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
*/

public class Stanza {
	
	protected static final int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	
	private String nome;
	private List<Attrezzo> attrezzi;
	private Map<String,Stanza> stanzeAdiacenti;
	
	public Stanza(String nome){
		this.stanzeAdiacenti = new HashMap<>();
		this.attrezzi = new ArrayList<>();
		this.nome = nome;
	}
	
	
	public Stanza getStanzaAdiacente(String direzione) {
		return this.stanzeAdiacenti.get(direzione);
	}
	
	
	void impostaStanzaAdiacente(String direzione, Stanza stanzaAdiacente) {
		this.stanzeAdiacenti.put(direzione,stanzaAdiacente);
	}
    
	
    public String getNome() {
        return this.nome;
    }

   
    public String getDescrizione() {
        return this.toString();
    }

    @Override
    public int hashCode() {
    	return Integer.parseInt(this.nome);
    }
    
    @Override
    public boolean equals(Object o) {
    	Stanza stanza = (Stanza) o;
    	return stanza.getNome() == this.getNome();
    }
    
    public List<Attrezzo> getAttrezzi() {
        return this.attrezzi;
    }

    
    public boolean addAttrezzo(Attrezzo attrezzo) {
    	if(attrezzo!=null && this.attrezzi.size()<NUMERO_MASSIMO_ATTREZZI)
    		return this.attrezzi.add(attrezzo);
    	return false;
    }
    
    
    public boolean removeAttrezzo(Attrezzo attrezzo) {
		if(attrezzo!=null && this.attrezzi.size()>0)
			return this.attrezzi.remove(attrezzo);
		return false;
	}

    
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append(this.nome);
    	risultato.append("\nUscite: ");
    	for (String direzione : this.stanzeAdiacenti.keySet())
    		if (direzione!=null)
    			risultato.append(" " + direzione);
    	risultato.append("\nAttrezzi nella stanza: ");
    	for (Attrezzo attrezzo : this.attrezzi) {
    		if(attrezzo!=null)
    			risultato.append(attrezzo.toString()+" ");
    	}
    	return risultato.toString();
    }

    
	public boolean hasAttrezzo(String nomeAttrezzo) {	
		if(this.attrezzi.size()>0)
			if(this.getAttrezzo(nomeAttrezzo)!=null)
				return true;
		return false;
	}


	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Iterator<Attrezzo> it = this.attrezzi.iterator();
		
		while(it.hasNext()) {
			Attrezzo attrezzoCercato = it.next();
			if(attrezzoCercato.getNome().equals(nomeAttrezzo))
				return attrezzoCercato;
		}
		/*
		 * for(attrezzo a: this.attrezzi)
		 * 	if(a.getNome().equals(nomeAttrezzo))
		 * 		return a;
		 */
		return null;
	}


	public Set<String> getDirezioni() {
		if(this.stanzeAdiacenti.size()>0)
			return this.stanzeAdiacenti.keySet();
		return null;
	}
	
	
	public boolean isEmpty() {
		return this.attrezzi.size()==0;
	}

}