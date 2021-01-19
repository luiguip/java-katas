package tech.luigui.katas.puzzle_fighter;

import tech.luigui.katas.puzzle_fighter.model.AlivePieceCoordinate;
import tech.luigui.katas.puzzle_fighter.model.Coordinate;

public class CoordinateManager {

  PieceCoordinateManager pieceCoordinateManager = new PieceCoordinateManager();

  public Coordinate[] down(AlivePieceCoordinate alivePieceCoordinate) {
    Coordinate coordinate0;
    Coordinate coordinate1;
    Coordinate[] coordinates;
    switch(alivePieceCoordinate.getPositionEnum()){
      case DOWN:
        coordinate0 = new Coordinate(alivePieceCoordinate.getX0(), alivePieceCoordinate.getY0() - 1);
        return new Coordinate[]{coordinate0};
      case UP:
        coordinate1 = new Coordinate(alivePieceCoordinate.getX1(), alivePieceCoordinate.getY1() - 1);
        return new Coordinate[]{coordinate1};
      case RIGHT:
      case LEFT:
        coordinate0 = new Coordinate(alivePieceCoordinate.getX0(), alivePieceCoordinate.getY0() - 1);
        coordinate1 = new Coordinate(alivePieceCoordinate.getX1(), alivePieceCoordinate.getY1() - 1);
        return new Coordinate[]{coordinate0, coordinate1};
      default:
        throw new IllegalStateException("Invalid PositionEnum");
    }
  }

  public Coordinate[] left(AlivePieceCoordinate alivePieceCoordinate) {
    Coordinate coordinate0;
    Coordinate coordinate1;
    Coordinate[] coordinates;
    switch(alivePieceCoordinate.getPositionEnum()){
      case LEFT:
        coordinate0 = new Coordinate(alivePieceCoordinate.getX0() - 1, alivePieceCoordinate.getY0());
        return new Coordinate[]{coordinate0};
      case RIGHT:
        coordinate1 = new Coordinate(alivePieceCoordinate.getX1() - 1, alivePieceCoordinate.getY1());
        return new Coordinate[]{coordinate1};
      case DOWN:
      case UP:
        coordinate0 = new Coordinate(alivePieceCoordinate.getX0() - 1, alivePieceCoordinate.getY0());
        coordinate1 = new Coordinate(alivePieceCoordinate.getX1() - 1, alivePieceCoordinate.getY1());
        return new Coordinate[]{coordinate0, coordinate1};
      default:
        throw new IllegalStateException("Invalid PositionEnum");
    }
  }

  public Coordinate[] right(AlivePieceCoordinate alivePieceCoordinate) {
    Coordinate coordinate0;
    Coordinate coordinate1;
    Coordinate[] coordinates;
    switch(alivePieceCoordinate.getPositionEnum()){
      case RIGHT:
        coordinate0 = new Coordinate(alivePieceCoordinate.getX0() + 1, alivePieceCoordinate.getY0());
        return new Coordinate[]{coordinate0};
      case LEFT:
        coordinate1 = new Coordinate(alivePieceCoordinate.getX1() + 1, alivePieceCoordinate.getY1());
        return new Coordinate[]{coordinate1};
      case DOWN:
      case UP:
        coordinate0 = new Coordinate(alivePieceCoordinate.getX0() + 1, alivePieceCoordinate.getY0());
        coordinate1 = new Coordinate(alivePieceCoordinate.getX1() + 1, alivePieceCoordinate.getY1());
        return new Coordinate[]{coordinate0, coordinate1};
      default:
        throw new IllegalStateException("Invalid PositionEnum");
    }
  }
}
