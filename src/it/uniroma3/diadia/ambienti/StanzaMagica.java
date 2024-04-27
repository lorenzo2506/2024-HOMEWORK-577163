package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza{

	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	static final private int SOGLIA_MAGICA_DEFAULT=3;
	
	public StanzaMagica(String nome, int sogliaMagica) {
		
		super(nome);
		this.sogliaMagica = sogliaMagica;
		this.contatoreAttrezziPosati = 0;
	}
	
	public StanzaMagica(String nome) {
		
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
				attrezzo = this.modificaAttrezzo(attrezzo);
			}
			
			return super.addAttrezzo(attrezzo);
		}
		return false;
	}
}
