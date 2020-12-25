package tech.luigui.katas.puzzle_fighter;

public final class PuzzleFighter {
	private final InputFacade inputFacade;
	
	private final String result;

	PuzzleFighter(String[][] rawInputArr) {
		inputFacade = new InputFacade(rawInputArr);
		result = null;
	}

	public String getResult() {
		return result;
	}
}
