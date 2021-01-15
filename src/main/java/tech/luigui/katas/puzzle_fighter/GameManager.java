package tech.luigui.katas.puzzle_fighter;

import tech.luigui.katas.puzzle_fighter.model.AlivePieceCoordinate;
import tech.luigui.katas.puzzle_fighter.model.GameBoard;
import tech.luigui.katas.puzzle_fighter.model.GameBoardConstants;
import tech.luigui.katas.puzzle_fighter.model.PieceEnum;

import java.util.List;

public final class GameManager {

  private final GameBoardConstants gameBoardConstants = new GameBoardConstants();
	private final GameBoardManager gameBoardManager = new GameBoardManager();
	private final PieceCoordinateManager pieceCoordinateManager = new PieceCoordinateManager();

	public GameBoard initGameBoard(List<PieceEnum> pieceEnumList) {
		AlivePieceCoordinate alivePieceCoordinate = pieceCoordinateManager.initialPieceCoordinate();
		return gameBoardManager.createInitialBoard(pieceEnumList, alivePieceCoordinate);
	}

	public GameBoard initTurn(GameBoard gameBoard, List<PieceEnum> pieceEnumList) {
		AlivePieceCoordinate alivePieceCoordinate = pieceCoordinateManager.initialPieceCoordinate();
		return  gameBoardManager.initTurn(gameBoard, pieceEnumList, alivePieceCoordinate);
	}

	public GameBoard moveLeft(GameBoard gameBoard) {
		GameBoard afterMoveGameBoard = new GameBoard(gameBoard);
		if(hasEmptyPieceAtLeft(gameBoard)){
			AlivePieceCoordinate previousAlivePieceCoordinate = gameBoard.getAlivePieceCoordinate();
			AlivePieceCoordinate alivePieceCoordinate = pieceCoordinateManager.left(previousAlivePieceCoordinate);
			afterMoveGameBoard =  gameBoardManager.update(gameBoard, alivePieceCoordinate);
		}
		return afterMoveGameBoard;
	}

	public boolean hasEmptyPieceAtLeft(GameBoard gameBoard) {
		AlivePieceCoordinate alivePieceCoordinate = gameBoard.getAlivePieceCoordinate();
		if(alivePieceCoordinate.getX0() == 0 || alivePieceCoordinate.getX1() == 0) {
			return false;
		}
		AlivePieceCoordinate coordinateAtLeft = pieceCoordinateManager.left(alivePieceCoordinate);
		PieceEnum[] pieceEnumArray = getPieceEnumFromPieceMatrix(gameBoard, coordinateAtLeft);
		return isPieceEnumEmpty(pieceEnumArray);
	}
	public GameBoard moveRight(GameBoard gameBoard) {
		GameBoard afterMoveGameBoard = new GameBoard(gameBoard);
		if(hasEmptyPieceAtRight(gameBoard)){
			AlivePieceCoordinate previousAlivePieceCoordinate = gameBoard.getAlivePieceCoordinate();
			AlivePieceCoordinate alivePieceCoordinate = pieceCoordinateManager.right(previousAlivePieceCoordinate);
			afterMoveGameBoard =  gameBoardManager.update(gameBoard, alivePieceCoordinate);
		}
		return afterMoveGameBoard;
	}

	public boolean hasEmptyPieceAtRight(GameBoard gameBoard) {
		AlivePieceCoordinate alivePieceCoordinate = gameBoard.getAlivePieceCoordinate();
		if(alivePieceCoordinate.getX0() == gameBoardConstants.getLastColumn() ||
				alivePieceCoordinate.getX1() == gameBoardConstants.getLastColumn()) {
			return false;
		}
		AlivePieceCoordinate coordinateAtRight = pieceCoordinateManager.left(alivePieceCoordinate);
		PieceEnum[] pieceEnumArray = getPieceEnumFromPieceMatrix(gameBoard, coordinateAtRight);
		return isPieceEnumEmpty(pieceEnumArray);
	}

	public GameBoard rotateCounterClockwise(GameBoard gameBoard) {
		GameBoard afterMoveGameBoard = new GameBoard(gameBoard);
		if(hasEmptyPieceAtCounterClockDirection(gameBoard)) {
			AlivePieceCoordinate previousAlivePieceCoordinate = gameBoard.getAlivePieceCoordinate();
			AlivePieceCoordinate alivePieceCoordinate = pieceCoordinateManager.rotateCounterClockwise(previousAlivePieceCoordinate);
			afterMoveGameBoard = gameBoardManager.update(gameBoard, alivePieceCoordinate);
		}
		return afterMoveGameBoard;
	}

	private boolean hasEmptyPieceAtCounterClockDirection(GameBoard gameBoard) {
		AlivePieceCoordinate alivePieceCoordinate = gameBoard.getAlivePieceCoordinate();
		switch (alivePieceCoordinate.getPositionEnum()) {
			case UP:
				return hasEmptyPieceAtLeft(gameBoard);
			case LEFT:
				return hasEmptyPieceEnumBelow(gameBoard);
			case DOWN:
				return hasEmptyPieceAtRight(gameBoard);
			case RIGHT:
				return hasEmptyPieceAtTop(gameBoard);
			default:
				throw new IllegalStateException();
		}
	}

	public GameBoard rotateClockwise(GameBoard gameBoard) {
		GameBoard afterMoveGameBoard = new GameBoard(gameBoard);
		if(hasEmptyPieceClockDirection(gameBoard)) {
			AlivePieceCoordinate previousAlivePieceCoordinate = gameBoard.getAlivePieceCoordinate();
			AlivePieceCoordinate alivePieceCoordinate = pieceCoordinateManager.rotateClockwise(previousAlivePieceCoordinate);
			afterMoveGameBoard = gameBoardManager.update(gameBoard, alivePieceCoordinate);
		}
		return afterMoveGameBoard;
  }

	public boolean hasEmptyPieceClockDirection(GameBoard gameBoard) {
	  AlivePieceCoordinate alivePieceCoordinate = gameBoard.getAlivePieceCoordinate();
	  switch (alivePieceCoordinate.getPositionEnum()) {
			case UP:
				return hasEmptyPieceAtRight(gameBoard);
			case LEFT:
				return hasEmptyPieceAtTop(gameBoard);
			case DOWN:
				return hasEmptyPieceAtLeft(gameBoard);
			case RIGHT:
				return hasEmptyPieceEnumBelow(gameBoard);
			default:
				throw new IllegalStateException();
		}
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
		AlivePieceCoordinate coordinateBelow = pieceCoordinateManager.down(alivePieceCoordinate);
		PieceEnum[] pieceEnumArray = getPieceEnumFromPieceMatrix(gameBoard, coordinateBelow);
		return isPieceEnumEmpty(pieceEnumArray);
	}

	private boolean hasEmptyPieceAtTop(GameBoard gameBoard) {
		AlivePieceCoordinate alivePieceCoordinate = gameBoard.getAlivePieceCoordinate();
		if(alivePieceCoordinate.getX0() == gameBoardConstants.getLastRow() ||
			alivePieceCoordinate.getX1() == gameBoardConstants.getLastRow()) {
			return false;
		}
		AlivePieceCoordinate coordinateAtTop = pieceCoordinateManager.up(alivePieceCoordinate);
		PieceEnum[] pieceEnumArray = getPieceEnumFromPieceMatrix(gameBoard, coordinateAtTop);
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
		return (pieceEnumArray[0] == PieceEnum.EMPTY && pieceEnumArray[1] == PieceEnum.EMPTY);
	}

	public GameBoard fall(GameBoard gameBoard) {
		AlivePieceCoordinate previousAlivePieceCoordinate = gameBoard.getAlivePieceCoordinate();
		AlivePieceCoordinate alivePieceCoordinate = pieceCoordinateManager.down(previousAlivePieceCoordinate);
		return gameBoardManager.update(gameBoard, alivePieceCoordinate);
	}
}
