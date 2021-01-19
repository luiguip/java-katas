package tech.luigui.katas.puzzle_fighter.model;

public class AlivePieceCoordinate {

	private final int x0;
	private final int x1;
	private final int y0;
	private final int y1;
	private final PositionEnum positionEnum;

	public AlivePieceCoordinate(int x0, int x1, int y0, int y1, PositionEnum positionEnum) {
		this.x0 = x0;
		this.x1 = x1;
		this.y0 = y0;
		this.y1 = y1;
		this.positionEnum = positionEnum;
	}

	public AlivePieceCoordinate(AlivePieceCoordinate alivePieceCoordinate) {
		positionEnum = alivePieceCoordinate.getPositionEnum();
		x0 = alivePieceCoordinate.getX0();
		x1 = alivePieceCoordinate.getX1();
		y0 = alivePieceCoordinate.getY0();
		y1 = alivePieceCoordinate.getY1();
	}

	public AlivePieceCoordinate(AlivePieceCoordinate alivePieceCoordinate, int horizontalMove, int verticalMove) {
		positionEnum = alivePieceCoordinate.getPositionEnum();
		x0 = alivePieceCoordinate.getX0() + horizontalMove;
		x1 = alivePieceCoordinate.getX1() + horizontalMove;
		y0 = alivePieceCoordinate.getY0() + verticalMove;
		y1 = alivePieceCoordinate.getY1() + verticalMove;
	}

	public AlivePieceCoordinate(AlivePieceCoordinate alivePieceCoordinate, PositionEnum positionEnum) {
	  this.positionEnum = positionEnum;
		x0 = alivePieceCoordinate.getX0();
		x1 = alivePieceCoordinate.getX1();
		y0 = alivePieceCoordinate.getY0();
		y1 = alivePieceCoordinate.getY1();
	}

	public AlivePieceCoordinate rotate(int horizontalDiff, int verticalDiff, PositionEnum positionEnum) {
		return new AlivePieceCoordinate(x0 + horizontalDiff, x1, y0 + verticalDiff, y1, positionEnum);
	}

	public AlivePieceCoordinate down() {
		return new AlivePieceCoordinate(this, 0, -1);
	}

	public AlivePieceCoordinate left() {
		return new AlivePieceCoordinate(this, -1, 0);
	}

	public AlivePieceCoordinate up() {
		return new AlivePieceCoordinate(this, 0, 1);
	}

	public AlivePieceCoordinate right() {
		return new AlivePieceCoordinate(this, 1, 0);
	}

	public PositionEnum getPositionEnum() {
		return positionEnum;
	}

	public int getX0() {
		return x0;
	}

	public int getX1() {
		return x1;
	}

	public int getY0() {
		return y0;
	}

	public int getY1() {
		return y1;
	}
}
