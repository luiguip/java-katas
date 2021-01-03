package tech.luigui.katas.puzzle_fighter;

import java.util.List;

import tech.luigui.katas.puzzle_fighter.model.AlivePieceCoordinate;
import tech.luigui.katas.puzzle_fighter.model.GameBoard;
import tech.luigui.katas.puzzle_fighter.model.GameBoardConstants;
import tech.luigui.katas.puzzle_fighter.model.PieceEnum;

public final class GameManager {

	private final GameBoardManager gameBoardManager = new GameBoardManager();

	public GameBoard moveLeft(GameBoard gameBoard) {
		GameBoard afterMoveGameBoard = new GameBoard(gameBoard);
		if(hasEmptyPieceAtLeft(gameBoard)){
			AlivePieceCoordinate alivePieceCoordinate = gameBoard.getAlivePieceCoordinate().moveLeft();
			afterMoveGameBoard =  gameBoardManager.update(gameBoard, alivePieceCoordinate);
		}
		return afterMoveGameBoard;
	}

	public boolean hasEmptyPieceAtLeft(GameBoard gameBoard) {
		AlivePieceCoordinate alivePieceCoordinate = gameBoard.getAlivePieceCoordinate();
		if(alivePieceCoordinate.getX0() == 0 || alivePieceCoordinate.getX1() == 0) {
			return false;
		}
		PieceEnum pieceEnumAtLeft0 = gameBoard.getPieceEnumMatrix()[alivePieceCoordinate.getY0()][alivePieceCoordinate.getX0() - 1];
		PieceEnum pieceEnumAtLeft1 = gameBoard.getPieceEnumMatrix()[alivePieceCoordinate.getY1()][alivePieceCoordinate.getX1() - 1];
		return (pieceEnumAtLeft0 == PieceEnum.EMPTY || pieceEnumAtLeft1 == PieceEnum.EMPTY);
	}
	public GameBoard moveRight(GameBoard gameBoard) {
		GameBoard afterMoveGameBoard = new GameBoard(gameBoard);
		if(hasEmptyPieceAtRight(gameBoard)){
			AlivePieceCoordinate alivePieceCoordinate = gameBoard.getAlivePieceCoordinate().moveRight();
			afterMoveGameBoard =  gameBoardManager.update(gameBoard, alivePieceCoordinate);
		}
		return afterMoveGameBoard;
	}

	public boolean hasEmptyPieceAtRight(GameBoard gameBoard) {
		AlivePieceCoordinate alivePieceCoordinate = gameBoard.getAlivePieceCoordinate();
		if(alivePieceCoordinate.getX0() == GameBoardConstants.getLastColumn() ||
				alivePieceCoordinate.getX1() == GameBoardConstants.getLastColumn()) {
			return false;
		}
		PieceEnum pieceEnumAtRight0 = gameBoard.getPieceEnumMatrix()[alivePieceCoordinate.getY0()][alivePieceCoordinate.getX0() + 1];
		PieceEnum pieceEnumAtRight1 = gameBoard.getPieceEnumMatrix()[alivePieceCoordinate.getY1()][alivePieceCoordinate.getX1() + 1];
		return (pieceEnumAtRight0 == PieceEnum.EMPTY || pieceEnumAtRight1 == PieceEnum.EMPTY);
	}

	public GameBoard noMovesLeft(GameBoard gameBoard) {
		GameBoard finalTurnGameBoard = new GameBoard(gameBoard);
		while(hasEmptyPieceEnumBelow(finalTurnGameBoard)) {
			finalTurnGameBoard = fall(finalTurnGameBoard);
		}
		return finalTurnGameBoard;
	}

	private boolean hasEmptyPieceEnumBelow(GameBoard gameBoard) {
		AlivePieceCoordinate alivePieceCoordinate = gameBoard.getAlivePieceCoordinate();
		if(alivePieceCoordinate.getY0() == 0 || alivePieceCoordinate.getY1() == 0) {
			return false;
		}
		PieceEnum pieceEnumBelow0 = gameBoard.getPieceEnumMatrix()[alivePieceCoordinate.getY0() - 1][alivePieceCoordinate.getX0()];
		PieceEnum pieceEnumBelow1 = gameBoard.getPieceEnumMatrix()[alivePieceCoordinate.getY1() - 1][alivePieceCoordinate.getX1()];
		if(pieceEnumBelow0 == PieceEnum.EMPTY || pieceEnumBelow1 == PieceEnum.EMPTY) {
			return true;
		}
		return false;
	}

	private GameBoard fall(GameBoard gameBoard) {
		AlivePieceCoordinate alivePieceCoordinate = gameBoard.getAlivePieceCoordinate().fall();
		return gameBoardManager.update(gameBoard, alivePieceCoordinate);
	}
}
