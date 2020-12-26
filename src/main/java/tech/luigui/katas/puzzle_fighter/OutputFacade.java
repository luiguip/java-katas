package tech.luigui.katas.puzzle_fighter;

import java.util.Arrays;
import java.util.stream.Collectors;

import tech.luigui.katas.puzzle_fighter.model.GameBoard;
import tech.luigui.katas.puzzle_fighter.model.PieceEnum;

public final class OutputFacade {

	private final String gameOutput;
	
	public OutputFacade(GameBoard gameBoard) {
		gameOutput = generateGameOutputFromGameBoard(gameBoard);
	}
	
	private String generateGameOutputFromGameBoard(GameBoard gameBoard) {
		String[] rows = generateStringRowsFromGameBoardRows(gameBoard);
		return String.join("\n", rows);
	}

	private String[] generateStringRowsFromGameBoardRows(GameBoard gameBoard) {
		return Arrays.stream(gameBoard.getPieceEnumMatrix())
				.map(this::generateStringFromGameboardRow)
				.toArray(String[]::new);
	}

	private String generateStringFromGameboardRow(PieceEnum[] pieceEnumRow) {
		return Arrays.stream(pieceEnumRow)
				.map(pieceEnum -> pieceEnum.getRawPiece())
				.collect(Collectors.joining());
	}

	public String getGameOutput() {
		return gameOutput;
	}
}
