package tech.luigui.katas.puzzle_fighter.model;

public class PieceCoordinate {

	GameBoardConstants gameBoardConstants = new GameBoardConstants();
	private int x0;
	private int x1;
	private int y0;
	private int y1;
	private PositionEnum positionEnum;


	public PieceCoordinate() {
		positionEnum = PositionEnum.UP;
		x0 = gameBoardConstants.getBlockFallColumn();
		x1 = x0;
		y0 = gameBoardConstants.getLastRow();
		y1 = y0-1;
	}

	private PieceCoordinate(PieceCoordinate alivePieceCoordinate, int horizontalMove, int verticalMove) {
		positionEnum = alivePieceCoordinate.getPositionEnum();
		x0 = alivePieceCoordinate.getX0() + horizontalMove;
		x1 = alivePieceCoordinate.getX1() + horizontalMove;
		y0 = alivePieceCoordinate.getY0() + verticalMove;
		y1 = alivePieceCoordinate.getY1() + verticalMove;
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

	public PieceCoordinate rotateCounterClockwise() {
		if(isAtLeftAndHorizontallyAligned()) {
		  rightDown();
		  positionEnum = PositionEnum.UP;
		} else if(isBelowAndVerticallyAligned()) {
		  rightUp();
		  positionEnum = PositionEnum.LEFT;
		} else if(isAtRightAndHorizontallyAligned()) {
		  leftUp();
		  positionEnum = PositionEnum.DOWN;
		} else if(isOnAndVerticaallyAligned()) {
		  leftDown();
		  positionEnum = PositionEnum.RIGHT;
		} else {
			throw new IllegalStateException("Invalid Piece locations");
		}
		return this;
	}

	private boolean isAtLeftAndHorizontallyAligned() {
		return isAtLeft() && isHorizontallyAligned();
	}

	private boolean isAtRightAndHorizontallyAligned() {
		return isAtRight() && isHorizontallyAligned();
	}

	private boolean isBelowAndVerticallyAligned() {
		return isBelow() && isVerticallyAligned();
	}

	private boolean isOnAndVerticaallyAligned() {
		return isOn() && isVerticallyAligned();
	}

	private boolean isVerticallyAligned() {
		return x0 == x1;
	}

	private boolean isHorizontallyAligned() {
		return y0 == y1;
	}

	private boolean isAtLeft() {
		return x1 < x0;
	}

	private  boolean isAtRight() {
		return x1 > x0;
	}

	private boolean isBelow() {
		return y1 < y0;
	}

	private boolean isOn() {
		return y1 > y0;
	}

	private PieceCoordinate leftUp() {
		x1--;
		y1++;
		return this;
	}

	private PieceCoordinate rightUp() {
		x1++;
		y1++;
		return this;
	}

	private PieceCoordinate leftDown() {
		x1--;
		y1--;
		return this;
	}

	private PieceCoordinate rightDown() {
		x1++;
		y1--;
		return this;
	}

	public PositionEnum getPositionEnum() {
		return positionEnum;
	}

	public int getX0() {
		return x0;
	}

	public void setX0(int x0) {
		this.x0 = x0;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY0() {
		return y0;
	}

	public void setY0(int y0) {
		this.y0 = y0;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}
}
