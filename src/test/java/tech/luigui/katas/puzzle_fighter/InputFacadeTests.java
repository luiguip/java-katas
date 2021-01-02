package tech.luigui.katas.puzzle_fighter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import tech.luigui.katas.puzzle_fighter.model.Input;

public class InputFacadeTests {
	
	private String[][] input = PuzzleFighterModelTest.getFixedTestsMoves()[0];
	private List<Input> expected = generateData();
	private InputFacade inputFacade = new InputFacade(input);
	private	List<Input> result = inputFacade.getInputList();
	
	private List<Input> generateData() {
		List<Input> expected = new ArrayList<>();
		expected.add(new Input("BR","LLL"));
		expected.add(new Input("BY","LL"));
		expected.add(new Input("BG","ALL"));
		expected.add(new Input("BY","BRR"));
		expected.add(new Input("RR","AR"));
		expected.add(new Input("GY","A"));
		expected.add(new Input("BB","AALLL"));
		expected.add(new Input("GR","A"));
		expected.add(new Input("RY","LL"));
		expected.add(new Input("GG","L"));
		expected.add(new Input("GY","BB"));
		expected.add(new Input("bR","ALLL"));
		expected.add(new Input("gy","AAL"));
		return expected;
	}
	
	@Test
	void InputFacadeTestSize() {
		assertEquals(result.size(), expected.size());
		result.removeAll(expected);
		assertEquals(0, result.size());
	}
}