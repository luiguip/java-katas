package tech.luigui.katas.puzzle_fighter.model;

import java.util.List;

public final class GameBoard {

	private final PieceEnum[][] pieceEnumMatrix;
	private final PieceCoordinate alivePieceCoordinate;
	private final List<PieceEnum> alivePieceEnumList;

	public GameBoard(GameBoard gameBoard) {
		this(gameBoard.getPieceEnumMatrix(), gameBoard.getAlivePieceEnumList(), gameBoard.getAlivePieceCoordinate());
	}

	public GameBoard(PieceEnum[][] pieceEnumMatrix, List<PieceEnum> pieceEnumList, PieceCoordinate alivePieceCoordinate) {
		this.pieceEnumMatrix = pieceEnumMatrix;
		this.alivePieceEnumList = pieceEnumList;
		this.alivePieceCoordinate = alivePieceCoordinate;
	}

	public PieceEnum[][] getPieceEnumMatrix() {
		return pieceEnumMatrix;
	}

	public PieceCoordinate getAlivePieceCoordinate() {
		return alivePieceCoordinate;
	}

	public List<PieceEnum> getAlivePieceEnumList() {
		return alivePieceEnumList;
	}
}
