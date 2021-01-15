package tech.luigui.katas.puzzle_fighter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import tech.luigui.katas.puzzle_fighter.model.GameBoard;
import tech.luigui.katas.puzzle_fighter.model.Input;

class OutputFacadeTests {

	private final String EMPTY_BOARD = 
			"      \n      \n      \n      \n      \n      \n      \n      \n      \n      \n      \n      ";
	private final String INITIAL_STATE = 
			"   R  \n   B  \n      \n      \n      \n      \n      \n      \n      \n      \n      \n      ";
	private final String ONE_FALL_STATE =
			"      \n   R  \n   B  \n      \n      \n      \n      \n      \n      \n      \n      \n      ";
	private final String NO_MOVE =
			"      \n      \n      \n      \n      \n      \n      \n      \n      \n      \n   R  \n   B  ";
	private final GameManager gameManager = new GameManager();

	@Test
	void initialStateBoard() {
		Input input = new Input("RB", "");
		GameBoard gameBoard = gameManager.initGameBoard(input.getPieces());
		OutputFacade outputFacade = new OutputFacade(gameBoard);
		assertEquals(INITIAL_STATE, outputFacade.getGameOutput());
	}

	@Test
	void fallOneBlockStateBoard() {
		Input input = new Input("RB", "");
		GameBoard initialGameBoard = gameManager.initGameBoard(input.getPieces());
		GameBoard gameBoard = gameManager.fall(initialGameBoard);
		OutputFacade outputFacade = new OutputFacade(gameBoard);
		assertEquals(ONE_FALL_STATE, outputFacade.getGameOutput());
	}
	
//	@Test
//	void noMoveBoard() {
//		Input input = new Input("RB", "");
//		assertEquals(NO_MOVE, outputFacadeEmptyBoard.getGameOutput());
//	}
//	
	
}
