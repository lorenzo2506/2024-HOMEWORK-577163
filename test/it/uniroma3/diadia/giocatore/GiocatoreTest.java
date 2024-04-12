package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GiocatoreTest {

	Giocatore giocatore;
	
	@BeforeEach
	void setUp() {
		this.giocatore =new Giocatore();
	}
	
	@Test
	void testSetCfu()
	{
		this.giocatore.setCfu(5);
        assertEquals(5 , this.giocatore.getCfu());

	}
	
	@Test
	void testGetBorsa() {
		assertNotNull(this.giocatore.getBorsa());
	}

}
