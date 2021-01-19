package tech.luigui.katas.puzzle_fighter;

import tech.luigui.katas.puzzle_fighter.model.GameBoardConstants;
import tech.luigui.katas.puzzle_fighter.model.AlivePieceCoordinate;
import tech.luigui.katas.puzzle_fighter.model.PositionEnum;

public class PieceCoordinateManager {

  private final GameBoardConstants gameBoardConstants = new GameBoardConstants();

  public AlivePieceCoordinate down(AlivePieceCoordinate alivePieceCoordinate) {
    return alivePieceCoordinate.down();
  }

  public AlivePieceCoordinate left(AlivePieceCoordinate alivePieceCoordinate) {
    return alivePieceCoordinate.left();
  }

  public AlivePieceCoordinate up(AlivePieceCoordinate alivePieceCoordinate) {
    return alivePieceCoordinate.up();
  }

  public AlivePieceCoordinate right(AlivePieceCoordinate alivePieceCoordinate) {
    return alivePieceCoordinate.right();
  }

  public AlivePieceCoordinate initialPieceCoordinate() {
    PositionEnum positionEnum = PositionEnum.UP;
    int x0 = gameBoardConstants.getBlockFallColumn();
    int y0 = gameBoardConstants.getLastRow();
    int y1 = y0-1;
    return new AlivePieceCoordinate(x0, x0, y0, y1, positionEnum);
  }

  public AlivePieceCoordinate rotateCounterClockwise(AlivePieceCoordinate alivePieceCoordinate) {
    switch(alivePieceCoordinate.getPositionEnum()) {
      case UP:
        return leftDown(alivePieceCoordinate, PositionEnum.LEFT);
      case LEFT:
        return rightDown(alivePieceCoordinate, PositionEnum.DOWN);
      case DOWN:
        return rightUp(alivePieceCoordinate, PositionEnum.RIGHT);
      case RIGHT:
        return leftUp(alivePieceCoordinate, PositionEnum.UP);
      default:
        throw new IllegalStateException("Invalid position enum");
    }
  }

  public AlivePieceCoordinate rotateClockwise(AlivePieceCoordinate alivePieceCoordinate) {
    switch(alivePieceCoordinate.getPositionEnum()) {
      case UP:
        return rightDown(alivePieceCoordinate, PositionEnum.RIGHT);
      case LEFT:
        return rightUp(alivePieceCoordinate, PositionEnum.UP);
      case DOWN:
        return leftUp(alivePieceCoordinate, PositionEnum.LEFT);
      case RIGHT:
        return leftDown(alivePieceCoordinate, PositionEnum.DOWN);
      default:
        throw new IllegalStateException("Invalid position enum");
    }
  }

  private boolean isAtLeftAndHorizontallyAligned(AlivePieceCoordinate alivePieceCoordinate) {
    return isAtLeft(alivePieceCoordinate) && isHorizontallyAligned(alivePieceCoordinate);
  }

  private boolean isAtRightAndHorizontallyAligned(AlivePieceCoordinate alivePieceCoordinate) {
    return isAtRight(alivePieceCoordinate) && isHorizontallyAligned(alivePieceCoordinate);
  }

  private boolean isBelowAndVerticallyAligned(AlivePieceCoordinate alivePieceCoordinate) {
    return isBelow(alivePieceCoordinate) && isVerticallyAligned(alivePieceCoordinate);
  }

  private boolean isOnAndVerticaallyAligned(AlivePieceCoordinate alivePieceCoordinate) {
    return isOn(alivePieceCoordinate) && isVerticallyAligned(alivePieceCoordinate);
  }

  private boolean isVerticallyAligned(AlivePieceCoordinate alivePieceCoordinate) {
    return alivePieceCoordinate.getX0() == alivePieceCoordinate.getX1();
  }

  private boolean isHorizontallyAligned(AlivePieceCoordinate alivePieceCoordinate) {
    return alivePieceCoordinate.getY0() == alivePieceCoordinate.getY1();
  }

  private boolean isAtLeft(AlivePieceCoordinate alivePieceCoordinate) {
    return alivePieceCoordinate.getX0() > alivePieceCoordinate.getX1();
  }

  private  boolean isAtRight(AlivePieceCoordinate alivePieceCoordinate) {
    return alivePieceCoordinate.getX0() < alivePieceCoordinate.getX1();
  }

  private boolean isBelow(AlivePieceCoordinate alivePieceCoordinate) {
    return alivePieceCoordinate.getY0() > alivePieceCoordinate.getY1();
  }

  private boolean isOn(AlivePieceCoordinate alivePieceCoordinate) {
    return alivePieceCoordinate.getY0() < alivePieceCoordinate.getY1();
  }

  private AlivePieceCoordinate leftUp(AlivePieceCoordinate alivePieceCoordinate, PositionEnum positionEnum) {
    return alivePieceCoordinate.rotate(-1, 1, positionEnum);
  }

  private AlivePieceCoordinate rightUp(AlivePieceCoordinate alivePieceCoordinate, PositionEnum positionEnum) {
    return alivePieceCoordinate.rotate( 1, 1,positionEnum);
  }

  private AlivePieceCoordinate leftDown(AlivePieceCoordinate alivePieceCoordinate, PositionEnum positionEnum) {
    return alivePieceCoordinate.rotate(-1,-1, positionEnum);
  }

  private AlivePieceCoordinate rightDown(AlivePieceCoordinate alivePieceCoordinate, PositionEnum positionEnum) {
    return alivePieceCoordinate.rotate(1, -1, positionEnum);
  }
}
