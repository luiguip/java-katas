package tech.luigui.katas.puzzle_fighter.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class GameBoard {

	private final PieceEnum[][] pieceEnumMatrix;
	private final AlivePieceCoordinate alivePieceCoordinate;
	private final List<PieceEnum> alivePieceEnumList;

	public GameBoard(GameBoard gameBoard) {
		this(gameBoard.getPieceEnumMatrix(), gameBoard.getAlivePieceEnumList(), gameBoard.getAlivePieceCoordinate());
	}

	public GameBoard(PieceEnum[][] pieceEnumMatrix, List<PieceEnum> pieceEnumList, AlivePieceCoordinate alivePieceCoordinate) {
		this.pieceEnumMatrix = pieceEnumMatrix;
		this.alivePieceEnumList = pieceEnumList;
		this.alivePieceCoordinate = alivePieceCoordinate;
	}

	public PieceEnum[][] getPieceEnumMatrix() {
		return pieceEnumMatrix;
	}

	public AlivePieceCoordinate getAlivePieceCoordinate() {
		return alivePieceCoordinate;
	}

	public List<PieceEnum> getAlivePieceEnumList() {
		return alivePieceEnumList;
	}
}
