package tech.luigui.katas.puzzle_fighter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import tech.luigui.katas.puzzle_fighter.model.Input;

public final class InputFacade {
	private final List<Input> inputList;

	InputFacade(String[][] rawinputArr) {
		inputList = Arrays.stream(rawinputArr)
							.map(rawInput -> new Input(rawInput[0], rawInput[1]))
							.collect(Collectors.toList());
	}

	public List<Input> getInputList() {
		return inputList;
	}
}
