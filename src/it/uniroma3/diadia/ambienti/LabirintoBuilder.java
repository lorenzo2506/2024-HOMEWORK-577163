package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.List;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder implements Labirinto{

	private List<Stanza> stanze;
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private Stanza ultimaStanzaAggiunta;
	
	public LabirintoBuilder() {
		this.stanze = new ArrayList<Stanza>();
	}
	
	
	

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	
	
	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}
	
	
	
	public Stanza getUltimaStanzaAggiunta() {
		return this.ultimaStanzaAggiunta;
	}
	
	
	
	public List<Stanza> getStanze() {
		return this.stanze;
	}
	
	
	
	
	public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
		this.ultimaStanzaAggiunta = new Stanza(nomeStanza);
		this.setStanzaCorrente(ultimaStanzaAggiunta);
		this.stanze.add(stanzaCorrente);
		return this;
		
	}
	
	
	
	public LabirintoBuilder addStanzaVincente(String nomeStanza) {
		this.ultimaStanzaAggiunta = new Stanza(nomeStanza);
		this.stanzaVincente = this.ultimaStanzaAggiunta;
		this.stanze.add(stanzaVincente);
		return this;
	}
	
	
	
	public LabirintoBuilder addStanza(String nomeStanza) {
		this.ultimaStanzaAggiunta = new Stanza(nomeStanza);
		this.stanze.add(ultimaStanzaAggiunta);
		return this;
	}
	
	
	
	public LabirintoBuilder addStanzaBuia(String nomeStanza, String attrezzoIlluminante) {
		this.ultimaStanzaAggiunta = new StanzaBuia(nomeStanza, attrezzoIlluminante);
		this.stanze.add(ultimaStanzaAggiunta);
		return this;
	}
	
	
	
	public LabirintoBuilder addStanzaBloccata(String nome, String direzione, String attrezzo) {
		this.ultimaStanzaAggiunta = new StanzaBloccata(nome,direzione,attrezzo);
		this.stanze.add(ultimaStanzaAggiunta);
		return this;
	}
	
	
	
	public LabirintoBuilder addStanzaMagica(String nomeStanza, int sogliaMagica) {
		this.ultimaStanzaAggiunta = new StanzaMagica(nomeStanza, sogliaMagica);
		this.stanze.add(ultimaStanzaAggiunta);
		return this;
	}
	
	
	
	public LabirintoBuilder addAdiacenza(String nomeStanza1, String nomeStanza2, String direzione) {
		this.getStanza(nomeStanza1).impostaStanzaAdiacente(direzione, getStanza(nomeStanza2));
		return this;
	}
	
	
	
	public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {
		Attrezzo a = new Attrezzo(nomeAttrezzo, peso);
		this.ultimaStanzaAggiunta.addAttrezzo(a);
		return this;
	}
	
	
	
	public Stanza getStanza(String nomeStanza) {
		for(Stanza tmp: this.stanze)
			if(tmp.getNome().equals(nomeStanza))
				return tmp;
		return null;
	}
	
	
	
	public void setStanzaCorrente(Stanza stanza) {
		this.stanzaCorrente = stanza;
	}
}
