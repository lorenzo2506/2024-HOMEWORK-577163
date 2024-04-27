package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected{

	protected int contatoreAttrezziPosati;
	protected int sogliaMagica;
	static final protected int SOGLIA_MAGICA_DEFAULT=3;
	
	public StanzaMagicaProtected(String nome, int sogliaMagica) {
		
		super(nome);
		this.sogliaMagica = sogliaMagica;
		this.contatoreAttrezziPosati = 0;
	}
	
	public StanzaMagicaProtected(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}
	
	public Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		
		StringBuilder nomeInvertito;
		
		int pesoAttrezzo = attrezzo.getPeso()*2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		
		attrezzo = new Attrezzo(nomeInvertito.toString(), pesoAttrezzo);
		
		return attrezzo;
	}
	
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		
		if(attrezzo != null) {
			contatoreAttrezziPosati++;
			if(this.contatoreAttrezziPosati > this.sogliaMagica) {
				this.modificaAttrezzo(attrezzo);
			}
			
			if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
	        	this.attrezzi[numeroAttrezzi] = attrezzo;
	        	this.numeroAttrezzi++;
	        	return true;
	        }
		}
		return false;
	}
}
