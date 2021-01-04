package tech.luigui.katas.puzzle_fighter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import tech.luigui.katas.puzzle_fighter.model.PieceCoordinate;
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
	private final GameBoardManager gameBoardManager = new GameBoardManager();

	@Test
	void initialStateBoard() {
		Input input = new Input("RB", "");
		GameBoard gameBoard = gameBoardManager.createInitialBoard(input.getPieces());
		OutputFacade outputFacade = new OutputFacade(gameBoard);
		assertEquals(INITIAL_STATE, outputFacade.getGameOutput());
	}

	@Test
	void fallOneBlockStateBoard() {
		Input input = new Input("RB", "");
		GameBoard initialGameBoard = gameBoardManager.createInitialBoard(input.getPieces());
		PieceCoordinate alivePieceCoordinate = initialGameBoard.getAlivePieceCoordinate().fall();
		GameBoard gameBoard = gameBoardManager.update(initialGameBoard,alivePieceCoordinate);
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
