package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {


	Borsa borsa;
	Borsa borsa2;
	Attrezzo osso;
	Attrezzo chiave;
	Attrezzo lanterna;
	Attrezzo diario;
	
	@BeforeEach
	void setUp() {
		osso = new Attrezzo("osso",3);
		chiave= new Attrezzo("chiave",2);
		lanterna = new Attrezzo("lanterna",4);
		diario = new Attrezzo("diario", 5);
		borsa = new Borsa(10);
		borsa2 = new Borsa(10);
	}
	
	@Test
	void testAddAttrezzo() {
		
		assertTrue(borsa.isEmpty());
		assertTrue(borsa.addAttrezzo(osso));
		assertFalse(borsa.isEmpty());
		assertTrue(borsa.hasAttrezzo("osso"));
		
		assertEquals(borsa.getAttrezzo("osso").getNome(),osso.getNome());
		
		assertEquals(borsa.removeAttrezzo("osso").getNome(), osso.getNome());
		
		assertTrue(borsa.isEmpty());
		
		
		
	}
	
	@Test 
	void testRemoveAttrezzo() {
		
		assertTrue(borsa2.addAttrezzo(lanterna));
		assertFalse(borsa2.isEmpty());
		
		assertEquals(borsa2.removeAttrezzo("lanterna").getNome(), lanterna.getNome());
		assertTrue(borsa2.isEmpty());	
		
		assertTrue(borsa2.addAttrezzo(chiave));
		assertTrue(borsa2.hasAttrezzo("chiave"));
		assertTrue(borsa2.addAttrezzo(osso));
		assertTrue(borsa2.hasAttrezzo("osso"));
		assertFalse(borsa2.isEmpty());
		
		assertEquals(borsa2.removeAttrezzo("osso").getNome(), osso.getNome());
		assertFalse(borsa2.isEmpty());
		assertFalse(borsa2.hasAttrezzo("osso"));
		assertTrue(borsa2.hasAttrezzo("chiave"));

		assertEquals(borsa2.removeAttrezzo("chiave").getNome(), chiave.getNome());
		assertFalse(borsa2.hasAttrezzo("chiave"));
		assertTrue(borsa2.isEmpty());
		
		
		borsa2.addAttrezzo(diario);
		borsa2.addAttrezzo(lanterna);
		assertTrue(borsa2.hasAttrezzo("diario"));
		assertTrue(borsa2.hasAttrezzo("lanterna"));
		
		borsa2.removeAttrezzo("diario");
		assertTrue(borsa2.hasAttrezzo("lanterna"));
		assertFalse(borsa2.isEmpty());

	}
	
	@Test
	void testContenutoOrdinatoPerPeso() {
		
		borsa.addAttrezzo(chiave);
		borsa.addAttrezzo(lanterna);
		borsa.addAttrezzo(osso);
		List<Attrezzo> list = borsa.getContenutoOrdinatoPerPeso();
		assertTrue(list.get(0).getNome().equals("chiave"));
		assertTrue(list.get(1).getNome().equals("osso"));
		assertTrue(list.get(2).getNome().equals("lanterna"));

	}
	
	@Test
	void testContenutoOrdinatoPerNome() {
		borsa.addAttrezzo(chiave);
		borsa.addAttrezzo(lanterna);
		borsa.addAttrezzo(osso);
		SortedSet<Attrezzo> tmp = borsa.getContenutoOrdinatoPerNome();
		for(Attrezzo a: tmp) {
			int i=0;
			assertTrue(a.getPeso()>i);
			i=a.getPeso();
		}	
	}
	
	void testContenutoRaggruppatoPerPeso() {
		
		Attrezzo chiave2= new Attrezzo("chiave2",2);
		Attrezzo chiave3 = new Attrezzo("chiave3",2);
		Attrezzo diario2 = new Attrezzo("diario2",5);
		Attrezzo diario3 = new Attrezzo("diario3",5);
		Attrezzo diario4 = new Attrezzo("diario4",5);
		Attrezzo osso2 = new Attrezzo("osso2",3);
		
		borsa.addAttrezzo(chiave);
		borsa.addAttrezzo(chiave2);
		borsa.addAttrezzo(diario2);
		borsa.addAttrezzo(osso);
		borsa.addAttrezzo(chiave3);
		borsa.addAttrezzo(diario4);
		borsa.addAttrezzo(osso2);
		borsa.addAttrezzo(diario3);
		borsa.addAttrezzo(lanterna);
		
		
		Map<Integer, Set<Attrezzo>> mappa = borsa.getContenutoRaggruppatoPerPeso();
		
		Set<Attrezzo> tmp = new TreeSet();
		
		tmp.add(chiave);
		tmp.add(chiave2);
		tmp.add(chiave3);
		assertTrue(mappa.get(2).contains(tmp));
		
		tmp = new TreeSet();
		tmp.add(osso);
		tmp.add(osso2);
		assertTrue(mappa.get(3).contains(tmp));
		
		tmp = new TreeSet();
		tmp.add(diario);
		tmp.add(diario2);
		tmp.add(diario3);
		tmp.add(diario4);
		assertTrue(mappa.get(5).contains(tmp));
	}

}
