package tech.luigui.katas.puzzle_fighter.model;

public class PieceCoordinate {

	private final int x0;
	private final int x1;
	private final int y0;
	private final int y1;
	private final PositionEnum positionEnum;

	public PieceCoordinate(int x0, int x1, int y0, int y1, PositionEnum positionEnum) {
		this.x0 = x0;
		this.x1 = x1;
		this.y0 = y0;
		this.y1 = y1;
		this.positionEnum = positionEnum;
	}

	public PieceCoordinate(PieceCoordinate alivePieceCoordinate) {
		positionEnum = alivePieceCoordinate.getPositionEnum();
		x0 = alivePieceCoordinate.getX0();
		x1 = alivePieceCoordinate.getX1();
		y0 = alivePieceCoordinate.getY0();
		y1 = alivePieceCoordinate.getY1();
	}

	public PieceCoordinate(PieceCoordinate alivePieceCoordinate, int horizontalMove, int verticalMove) {
		positionEnum = alivePieceCoordinate.getPositionEnum();
		x0 = alivePieceCoordinate.getX0() + horizontalMove;
		x1 = alivePieceCoordinate.getX1() + horizontalMove;
		y0 = alivePieceCoordinate.getY0() + verticalMove;
		y1 = alivePieceCoordinate.getY1() + verticalMove;
	}

	public PieceCoordinate(PieceCoordinate pieceCoordinate, PositionEnum positionEnum) {
	  this.positionEnum = positionEnum;
		x0 = pieceCoordinate.getX0();
		x1 = pieceCoordinate.getX1();
		y0 = pieceCoordinate.getY0();
		y1 = pieceCoordinate.getY1();
	}

	public PieceCoordinate rotate(int horizontalDiff, int verticalDiff, PositionEnum positionEnum) {
		return new PieceCoordinate(x0, this.x1+ horizontalDiff, y0, this.y1 + verticalDiff, positionEnum);
	}

	public PieceCoordinate down() {
		return new PieceCoordinate(this, 0, -1);
	}

	public PieceCoordinate left() {
		return new PieceCoordinate(this, -1, 0);
	}

	public  PieceCoordinate up() {
		return new PieceCoordinate(this, 0, 1);
	}

	public PieceCoordinate right() {
		return new PieceCoordinate(this, 1, 0);
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
