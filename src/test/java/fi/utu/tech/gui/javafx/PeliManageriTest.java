package fi.utu.tech.gui.javafx;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PeliManageriTest {

	@Test
	void rollTest() {
		PeliManageri manageri = new PeliManageri();
		int arvo = manageri.roll();
		assertTrue(arvo<=6 && arvo>=1, "Nopan arvon pitäisi olla väliltä 1-6");
	}

}
