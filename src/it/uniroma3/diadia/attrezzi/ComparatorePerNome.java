package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

public class ComparatorePerNome implements Comparator<Attrezzo>{

	@Override
	public int compare(Attrezzo a1, Attrezzo a2) {
		if(a1.getNome().compareTo(a2.getNome())>0 )
			return 1;
		else if(a1.getNome().equals(a2.getNome()))
			return 0;
		return -1;
	}
}
