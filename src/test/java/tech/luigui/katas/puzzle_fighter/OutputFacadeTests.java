package tech.luigui.katas.puzzle_fighter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import tech.luigui.katas.puzzle_fighter.model.GameBoard;

class OutputFacadeTests {

	private final String EMPTY_BOARD = 
			"      \n      \n      \n      \n      \n      \n      \n      \n      \n      \n      \n      ";
	private final GameBoard emptyGameBoard = new GameBoard();
	private final OutputFacade outputFacadeEmptyBoard = new OutputFacade(emptyGameBoard);
	
	@Test
	void testEmptyBoard() {
		assertEquals(EMPTY_BOARD, outputFacadeEmptyBoard.getGameOutput());
	}
	
	
	
}
