package tech.luigui.katas.puzzle_fighter.model;

public class AlivePieceCoordinate {

	GameBoardConstants gameBoardConstants = new GameBoardConstants();
	private int x0;
	private int x1;
	private int y0;
	private int y1;
	private boolean horizontal;


	public AlivePieceCoordinate() {
		horizontal = false;
		x0 = gameBoardConstants.getBlockFallColumn();
		x1 = x0;
		y0 = gameBoardConstants.getLastRow();
		y1 = y0-1;
	}

	private AlivePieceCoordinate(AlivePieceCoordinate alivePieceCoordinate, int horizontalMove, int verticalMove) {
		horizontal = alivePieceCoordinate.isHorizontal();
		x0 = alivePieceCoordinate.getX0() + horizontalMove;
		x1 = alivePieceCoordinate.getX1() + horizontalMove;
		y0 = alivePieceCoordinate.getY0() + verticalMove;
		y1 = alivePieceCoordinate.getY1() + verticalMove;
	}

	public AlivePieceCoordinate fall() {
		return new AlivePieceCoordinate(this, 0, -1);
	}

	public AlivePieceCoordinate moveLeft() {
		return new AlivePieceCoordinate(this, -1, 0);
	}

	public AlivePieceCoordinate moveRight(AlivePieceCoordinate alivePieceCoordinate) {
		return new AlivePieceCoordinate(alivePieceCoordinate, 1, 0);
	}

//	public AlivePieceCoordinate rotateCounterClockwise(AlivePieceCoordinate alivePieceCoordinate) {
//		return new AlivePieceCoordinate(alivePieceCoordinate, 1, 0);
//	}

	public boolean isHorizontal() {
		return horizontal;
	}
	
	public boolean isVertical() {
		return !horizontal;
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
