package tech.luigui.katas.puzzle_fighter.model;

public final class GameBoardConstants {

	private final int numberOfRows = 12;
	private final int numberOfColumns = 6;
	private final int blockFallColumn = 3;
	private final int lastRow = numberOfRows-1;
	private final int lastColumn = numberOfColumns-1;

	public int getNumberOfRows() {
		return numberOfRows;
	}
	public int getNumberOfColumns() {
		return numberOfColumns;
	}
	public int getBlockFallColumn() {
		return blockFallColumn;
	}
	public int getLastRow() {
		return lastRow;
	}
	public  int getLastColumn() {
        return lastColumn;
    }
}
