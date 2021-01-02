package tech.luigui.katas.puzzle_fighter.model;

public enum MovementEnum {

	LEFT("L"),
	RIGHT("R"),
	ROTATE_COUNTERCLOCKWISE("A"),
	ROTATE_CLOCKWISE("B"),
	NO_MOVE("");

	private final String rawMovement;
	
	private MovementEnum(String rawMovement) {
		this.rawMovement = rawMovement;
	}
	
	public String getRawMovement() {
		return rawMovement;
	}
	
	public static MovementEnum getByRawMovement(String rawMovement) {
		switch(rawMovement) {
			case "L":
				return MovementEnum.LEFT;
			case "R":
				return MovementEnum.RIGHT;
			case "A":
				return MovementEnum.ROTATE_COUNTERCLOCKWISE;
			case "B":
				return MovementEnum.ROTATE_CLOCKWISE;
			case "":
				return MovementEnum.NO_MOVE;
			default:
				throw new IllegalArgumentException();
		}
	}
}
