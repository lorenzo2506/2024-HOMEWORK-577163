package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatorePerNome;
import it.uniroma3.diadia.attrezzi.ComparatorePrimaPesoPoiNome;

public class Borsa {
	
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private List<Attrezzo> attrezzi;
	private int pesoMax;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new ArrayList<>();
	}
	
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo!=null && (this.getPeso() < attrezzo.getPeso()+this.getPesoMax()) )
			return this.attrezzi.add(attrezzo);
		return false;
	}
	
	
	public int getPesoMax() {
		return this.pesoMax;
	}
	
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		for(Attrezzo a: this.attrezzi)
			if(a.getNome().equals(nomeAttrezzo))
				return a;
		return null;
	}
	
	
	public int getPeso() {		
			int peso=0;
			for(Attrezzo a: this.attrezzi)
				peso += a.getPeso();
			return peso;
		}
	
	
	
	public boolean isEmpty() {
		return this.attrezzi.size() == 0;
	}
	
	
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		
		for(Attrezzo a: this.attrezzi)
			if(a.getNome().equals(nomeAttrezzo)) {
				this.attrezzi.remove(a);
				return a;
			}
		return null;
	}
		
	
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			
			for(Attrezzo a: this.attrezzi)
				s.append(a.toString()+" ");
		}
		else
			s.append("Borsa vuota");
		
		return s.toString();
		}
	
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		Collections.sort(this.attrezzi);
		return this.attrezzi;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		ComparatorePerNome c = new ComparatorePerNome();
		TreeSet<Attrezzo> ss = new TreeSet<>();
		Collections.sort(this.attrezzi,c);
		ss.addAll(this.attrezzi);
		return ss;
	}
	
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		
		Map<Integer, Set<Attrezzo>> coppia = new HashMap();
		List<Attrezzo> lista = this.getContenutoOrdinatoPerPeso();
		Set<Attrezzo> tmp = new TreeSet();
		int peso=0;
		
		for(Attrezzo a: lista) {
			if(peso==a.getPeso())
				tmp.add(a);
			else {
				coppia.put(peso, tmp);
				tmp = new TreeSet();
				peso=a.getPeso();
			}
		}
		
		return coppia;
	}
	
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		ComparatorePrimaPesoPoiNome c = new ComparatorePrimaPesoPoiNome();
		TreeSet<Attrezzo> ss = new TreeSet<>();
		Collections.sort(this.attrezzi,c);
		ss.addAll(this.attrezzi);
		return ss;
	}
}
