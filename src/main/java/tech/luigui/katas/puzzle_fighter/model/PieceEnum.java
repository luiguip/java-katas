package tech.luigui.katas.puzzle_fighter.model;

public enum PieceEnum {

	RED("R"), 
	BLUE("B"), 
	GREEN("G"), 
	YELLOW("Y"),
	CRASH_RED("r"), 
	CRASH_BLUE("b"), 
	CRASH_GREEN("g"), 
	CRASH_YELLOW("y"),
	CRASH_RAINBOW("0");
	
	private final String rawPiece;

	private PieceEnum(String rawPiece) {
		this.rawPiece = rawPiece;
	}
	
	public String getRawPiece() {
		return rawPiece;
	}

	public static PieceEnum getByRawPiece(String rawPiece) {
		switch(rawPiece) {
		case "R":
			return PieceEnum.RED;
		case "B":
			return PieceEnum.BLUE;
		case "G":
			return PieceEnum.GREEN;
		case "Y":
			return PieceEnum.YELLOW;
		case "r":
			return PieceEnum.CRASH_RED;
		case "b":
			return PieceEnum.CRASH_BLUE;
		case "g":
			return PieceEnum.CRASH_GREEN;
		case "y":
			return PieceEnum.CRASH_YELLOW;
		case "0":
			return PieceEnum.CRASH_RAINBOW;
		default:
			throw new IllegalArgumentException();
		}
	}
}
