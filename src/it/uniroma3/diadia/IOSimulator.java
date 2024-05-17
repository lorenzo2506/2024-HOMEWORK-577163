package it.uniroma3.diadia;

import java.util.List;
import java.util.ArrayList;

public class IOSimulator implements IO {
	
	private List<String> outPut;
	private List<String> inPut;
	
	public IOSimulator() {
		this.outPut = new ArrayList<>();
		this.inPut = new ArrayList<>();
	}
	
	
	@Override
	public void mostraMessaggio(String messaggio) {	
		this.outPut.add(messaggio);
		
		/*System.out.println(messaggio);		//	QUESTI COMANDI STAMPANO TUTTI GLI OUTPUT DEL SIMULATORE IN CONSOLE
		System.out.println(" ");*/				//  SONO SOLO PER SFIZIO, DEVONO RIMANERE DISABILITATI	
	}

	
	
	@Override
	public String leggiRiga() {
		return this.inPut.get( this.outPut.lastIndexOf(this.inPut));
		
	}
	/**
	 * Restituisce tutto l'output del codice in un un'unica stringa
	 * @return String
	 */
	
	/**
	 * Prende come parametro un array di Comandi sequenziali
	 * che verranno inseriti nel codice dal simulatore
	 * @param demo
	 */
	public void setInput(List<String> demo ) {
		this.inPut=demo;
	}
	/**
	 * Verifica se una determinata stringa � contenuta nell'output
	 * FINORA NON UTILIZZATA
	 * @param parolaDaCercare
	 * @return
	 */
	public boolean hasParola(String parolaDaCercare) {
		for(String str: this.outPut)
			if(str.equals(parolaDaCercare))
				return true;
		return false;
	}
	
	
	
	public String getOutput() {
		StringBuilder risultato = new StringBuilder();
		for(String str: this.outPut)
			if(str!=null)
				risultato.append("\n"+str);
		return risultato.toString();
	}


	
	
}