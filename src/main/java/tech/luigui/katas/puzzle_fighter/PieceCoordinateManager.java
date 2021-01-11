package tech.luigui.katas.puzzle_fighter;

import tech.luigui.katas.puzzle_fighter.model.GameBoardConstants;
import tech.luigui.katas.puzzle_fighter.model.PieceCoordinate;
import tech.luigui.katas.puzzle_fighter.model.PositionEnum;

public class PieceCoordinateManager {

  private final GameBoardConstants gameBoardConstants = new GameBoardConstants();

  public PieceCoordinate down(PieceCoordinate pieceCoordinate) {
    return pieceCoordinate.down();
  }

  public PieceCoordinate left(PieceCoordinate pieceCoordinate) {
    return pieceCoordinate.left();
  }

  public  PieceCoordinate up(PieceCoordinate pieceCoordinate) {
    return pieceCoordinate.up();
  }

  public PieceCoordinate right(PieceCoordinate pieceCoordinate) {
    return pieceCoordinate.right();
  }

  public PieceCoordinate initialPieceCoordinate() {
    PositionEnum positionEnum = PositionEnum.UP;
    int x0 = gameBoardConstants.getBlockFallColumn();
    int y0 = gameBoardConstants.getLastRow();
    int y1 = y0-1;
    return new PieceCoordinate(x0, x0, y0, y1, positionEnum);
  }
  public PieceCoordinate rotateCounterClockwise(PieceCoordinate pieceCoordinate) {
    if(isAtLeftAndHorizontallyAligned(pieceCoordinate)) {
      return rightDown(pieceCoordinate, PositionEnum.DOWN);
    } else if(isBelowAndVerticallyAligned(pieceCoordinate)) {
      return rightUp(pieceCoordinate, PositionEnum.RIGHT);
    } else if(isAtRightAndHorizontallyAligned(pieceCoordinate)) {
      return leftUp(pieceCoordinate, PositionEnum.UP);
    } else if(isOnAndVerticaallyAligned(pieceCoordinate)) {
      return leftDown(pieceCoordinate, PositionEnum.LEFT);
    } else {
      throw new IllegalStateException("Invalid Piece locations");
    }
  }

  public PieceCoordinate rotateClockwise(PieceCoordinate pieceCoordinate) {
    if(isAtLeftAndHorizontallyAligned(pieceCoordinate)) {
      return rightUp(pieceCoordinate, PositionEnum.UP);
    } else if(isBelowAndVerticallyAligned(pieceCoordinate)) {
      return leftUp(pieceCoordinate, PositionEnum.LEFT);
    } else if(isAtRightAndHorizontallyAligned(pieceCoordinate)) {
      return leftDown(pieceCoordinate, PositionEnum.DOWN);
    } else if(isOnAndVerticaallyAligned(pieceCoordinate)) {
      return rightDown(pieceCoordinate, PositionEnum.RIGHT);
    } else {
      throw new IllegalStateException("Invalid Piece locations");
    }
  }

  private boolean isAtLeftAndHorizontallyAligned(PieceCoordinate pieceCoordinate) {
    return isAtLeft(pieceCoordinate) && isHorizontallyAligned(pieceCoordinate);
  }

  private boolean isAtRightAndHorizontallyAligned(PieceCoordinate pieceCoordinate) {
    return isAtRight(pieceCoordinate) && isHorizontallyAligned(pieceCoordinate);
  }

  private boolean isBelowAndVerticallyAligned(PieceCoordinate pieceCoordinate) {
    return isBelow(pieceCoordinate) && isVerticallyAligned(pieceCoordinate);
  }

  private boolean isOnAndVerticaallyAligned(PieceCoordinate pieceCoordinate) {
    return isOn(pieceCoordinate) && isVerticallyAligned(pieceCoordinate);
  }

  private boolean isVerticallyAligned(PieceCoordinate pieceCoordinate) {
    return pieceCoordinate.getX0() == pieceCoordinate.getX1();
  }

  private boolean isHorizontallyAligned(PieceCoordinate pieceCoordinate) {
    return pieceCoordinate.getY0() == pieceCoordinate.getY1();
  }

  private boolean isAtLeft(PieceCoordinate pieceCoordinate) {
    return pieceCoordinate.getX0() > pieceCoordinate.getX1();
  }

  private  boolean isAtRight(PieceCoordinate pieceCoordinate) {
    return pieceCoordinate.getX0() < pieceCoordinate.getX1();
  }

  private boolean isBelow(PieceCoordinate pieceCoordinate) {
    return pieceCoordinate.getY0() > pieceCoordinate.getY1();
  }

  private boolean isOn(PieceCoordinate pieceCoordinate) {
    return pieceCoordinate.getY0() < pieceCoordinate.getY1();
  }

  private PieceCoordinate leftUp(PieceCoordinate pieceCoordinate, PositionEnum positionEnum) {
    return pieceCoordinate.rotate(-1, 1, positionEnum);
  }

  private PieceCoordinate rightUp(PieceCoordinate pieceCoordinate, PositionEnum positionEnum) {
    return pieceCoordinate.rotate( 1, 1,positionEnum);
  }

  private PieceCoordinate leftDown(PieceCoordinate pieceCoordinate, PositionEnum positionEnum) {
    return pieceCoordinate.rotate(-1,-1, positionEnum);
  }

  private PieceCoordinate rightDown(PieceCoordinate pieceCoordinate, PositionEnum positionEnum) {
    return pieceCoordinate.rotate(1, -1, positionEnum);
  }
}
