package tech.luigui.katas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DryingPotatoesTest {

	DryingPotatoes dryingPotatos = new DryingPotatoes();
	
	private void dotest(int p0, int w0, int p1, int expected) {
		assertEquals(expected, dryingPotatos.calculateFinalWeight(w0, p0, p1));
	}
    
	@Test
	public void test() {
		dotest(82, 127, 80, 114);
		dotest(93, 129, 91, 100);
	}
}
