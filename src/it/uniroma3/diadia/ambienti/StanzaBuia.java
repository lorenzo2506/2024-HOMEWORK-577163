package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{

	String nomeAttrezzoIlluminante;
	
	public StanzaBuia(String nome, String attrezzo) {
		
		super(nome);
		this.nomeAttrezzoIlluminante=attrezzo;
	}
	
	@Override
	public String getDescrizione() {
		
		if(hasAttrezzo(this.nomeAttrezzoIlluminante))
			return super.getDescrizione();
		
		return "qui c'e' un buio pesto";
	}
}
