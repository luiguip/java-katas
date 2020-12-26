package tech.luigui.katas.puzzle_fighter.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class GameBoard {

	private final GameBoardConstants gameBoardConstants; 
	private final PieceEnum[][] pieceEnumMatrix;
	
	public GameBoard(){
		gameBoardConstants = new GameBoardConstants();
		pieceEnumMatrix = initateSpaceListList(gameBoardConstants.getNumberOfColumns(), gameBoardConstants.getNumberOfRows());
	}
	
//	GameBoard(PieceEnum[][] pieceEnumMatrixPreviousTurn) {
//		
//	}

	private PieceEnum[][] initateSpaceListList(int columns, int rows) {
		return IntStream.range(0, rows)
						.mapToObj(i -> initiateRow(columns))
						.toArray(PieceEnum[][]::new);
	}
	
	private PieceEnum[] initiateRow(int columns) {
		return IntStream.range(0, columns)
						.mapToObj(i -> PieceEnum.EMPTY)
						.toArray(PieceEnum[]::new);
	}

	public PieceEnum[][] getPieceEnumMatrix() {
		return pieceEnumMatrix;
	}
}
