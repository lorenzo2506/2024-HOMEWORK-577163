package it.uniroma3.diadia.giocatore;

public class Giocatore {

	Borsa borsa;
	static final private int CFU_INIZIALI = 20;
	private int cfu;
    
	public Giocatore() {
		this.borsa = new Borsa(10);
		this.cfu = CFU_INIZIALI; 
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	public int getCfu() {
		return this.cfu;
	}
	
	public void setCfu(int cfu) {
		this.cfu=cfu;
	}
	
}
