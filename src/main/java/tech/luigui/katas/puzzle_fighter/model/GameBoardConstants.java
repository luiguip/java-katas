package tech.luigui.katas.puzzle_fighter.model;

public class GameBoardConstants {

	private static final int numberOfRows = 12;
	private static final int numberOfColumns = 6;

	private static final int blockFallColumn = 3;
	private static final int lastRow = numberOfRows-1;

	public static int getNumberOfRows() {
		return numberOfRows;
	}
	public static int getNumberOfColumns() {
		return numberOfColumns;
	}

	public static int getBlockFallColumn() {
		return blockFallColumn;
	}
	public static int getLastRow() {
		return lastRow;
	}
}
