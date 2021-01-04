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
		AlivePieceCoordinate coordinateAtLeft = alivePieceCoordinate.moveLeft();
		PieceEnum[] pieceEnumArray = getPieceEnumFromPieceMatrix(gameBoard, coordinateAtLeft);
		return isPieceEnumEmpty(pieceEnumArray);
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
		AlivePieceCoordinate coordinateAtRight = alivePieceCoordinate.moveLeft();
		PieceEnum[] pieceEnumArray = getPieceEnumFromPieceMatrix(gameBoard, coordinateAtRight);
		return isPieceEnumEmpty(pieceEnumArray);
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
		AlivePieceCoordinate coordinateBelow = alivePieceCoordinate.fall();
		PieceEnum[] pieceEnumArray = getPieceEnumFromPieceMatrix(gameBoard, coordinateBelow);
		return isPieceEnumEmpty(pieceEnumArray);
	}

	private PieceEnum[] getPieceEnumFromPieceMatrix(GameBoard gameBoard, AlivePieceCoordinate targetCoordinate) {
		PieceEnum[][] pieceEnumMatrix = gameBoard.getPieceEnumMatrix();
		return getPieceEnumFromPieceMatrix(pieceEnumMatrix, targetCoordinate);
	}

	private PieceEnum[] getPieceEnumFromPieceMatrix(PieceEnum[][] pieceEnumMatrix, AlivePieceCoordinate alivePieceCoordinate) {
		PieceEnum[] pieceEnumArray = new PieceEnum[2];
		pieceEnumArray[0] = pieceEnumMatrix[alivePieceCoordinate.getY0()][alivePieceCoordinate.getX0()];
		pieceEnumArray[1] = pieceEnumMatrix[alivePieceCoordinate.getY1()][alivePieceCoordinate.getX1()];
		return pieceEnumArray;
	}

	private boolean isPieceEnumEmpty(PieceEnum[] pieceEnumArray) {
		return (pieceEnumArray[0] == PieceEnum.EMPTY || pieceEnumArray[1] == PieceEnum.EMPTY);
	}

	private GameBoard fall(GameBoard gameBoard) {
		AlivePieceCoordinate alivePieceCoordinate = gameBoard.getAlivePieceCoordinate().fall();
		return gameBoardManager.update(gameBoard, alivePieceCoordinate);
	}
}
