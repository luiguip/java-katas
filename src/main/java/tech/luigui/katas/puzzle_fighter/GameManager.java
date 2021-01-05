package tech.luigui.katas.puzzle_fighter;

import tech.luigui.katas.puzzle_fighter.model.PieceCoordinate;
import tech.luigui.katas.puzzle_fighter.model.GameBoard;
import tech.luigui.katas.puzzle_fighter.model.GameBoardConstants;
import tech.luigui.katas.puzzle_fighter.model.PieceEnum;

public final class GameManager {

  private final GameBoardConstants gameBoardConstants = new GameBoardConstants();
	private final GameBoardManager gameBoardManager = new GameBoardManager();

	public GameBoard moveLeft(GameBoard gameBoard) {
		GameBoard afterMoveGameBoard = new GameBoard(gameBoard);
		if(hasEmptyPieceAtLeft(gameBoard)){
			PieceCoordinate alivePieceCoordinate = gameBoard.getAlivePieceCoordinate().left();
			afterMoveGameBoard =  gameBoardManager.update(gameBoard, alivePieceCoordinate);
		}
		return afterMoveGameBoard;
	}

	public boolean hasEmptyPieceAtLeft(GameBoard gameBoard) {
		PieceCoordinate alivePieceCoordinate = gameBoard.getAlivePieceCoordinate();
		if(alivePieceCoordinate.getX0() == 0 || alivePieceCoordinate.getX1() == 0) {
			return false;
		}
		PieceCoordinate coordinateAtLeft = alivePieceCoordinate.left();
		PieceEnum[] pieceEnumArray = getPieceEnumFromPieceMatrix(gameBoard, coordinateAtLeft);
		return isPieceEnumEmpty(pieceEnumArray);
	}
	public GameBoard moveRight(GameBoard gameBoard) {
		GameBoard afterMoveGameBoard = new GameBoard(gameBoard);
		if(hasEmptyPieceAtRight(gameBoard)){
			PieceCoordinate alivePieceCoordinate = gameBoard.getAlivePieceCoordinate().right();
			afterMoveGameBoard =  gameBoardManager.update(gameBoard, alivePieceCoordinate);
		}
		return afterMoveGameBoard;
	}

	public boolean hasEmptyPieceAtRight(GameBoard gameBoard) {
		PieceCoordinate alivePieceCoordinate = gameBoard.getAlivePieceCoordinate();
		if(alivePieceCoordinate.getX0() == gameBoardConstants.getLastColumn() ||
				alivePieceCoordinate.getX1() == gameBoardConstants.getLastColumn()) {
			return false;
		}
		PieceCoordinate coordinateAtRight = alivePieceCoordinate.left();
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
		PieceCoordinate alivePieceCoordinate = gameBoard.getAlivePieceCoordinate();
		if(alivePieceCoordinate.getY0() == 0 || alivePieceCoordinate.getY1() == 0) {
			return false;
		}
		PieceCoordinate coordinateBelow = alivePieceCoordinate.down();
		PieceEnum[] pieceEnumArray = getPieceEnumFromPieceMatrix(gameBoard, coordinateBelow);
		return isPieceEnumEmpty(pieceEnumArray);
	}

	private PieceEnum[] getPieceEnumFromPieceMatrix(GameBoard gameBoard, PieceCoordinate targetCoordinate) {
		PieceEnum[][] pieceEnumMatrix = gameBoard.getPieceEnumMatrix();
		return getPieceEnumFromPieceMatrix(pieceEnumMatrix, targetCoordinate);
	}

	private PieceEnum[] getPieceEnumFromPieceMatrix(PieceEnum[][] pieceEnumMatrix, PieceCoordinate alivePieceCoordinate) {
		PieceEnum[] pieceEnumArray = new PieceEnum[2];
		pieceEnumArray[0] = pieceEnumMatrix[alivePieceCoordinate.getY0()][alivePieceCoordinate.getX0()];
		pieceEnumArray[1] = pieceEnumMatrix[alivePieceCoordinate.getY1()][alivePieceCoordinate.getX1()];
		return pieceEnumArray;
	}

	private boolean isPieceEnumEmpty(PieceEnum[] pieceEnumArray) {
		return (pieceEnumArray[0] == PieceEnum.EMPTY || pieceEnumArray[1] == PieceEnum.EMPTY);
	}

	private GameBoard fall(GameBoard gameBoard) {
		PieceCoordinate alivePieceCoordinate = gameBoard.getAlivePieceCoordinate().down();
		return gameBoardManager.update(gameBoard, alivePieceCoordinate);
	}
}
