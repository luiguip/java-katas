package tech.luigui.katas.puzzle_fighter.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceCoordinateTest {
  private final GameBoardConstants gameBoardConstants = new GameBoardConstants();

//  @Test
//  void initialPieceCoordinateTest() {
//    PieceCoordinate alivePieceCoordinate = new PieceCoordinate();
//    assertEquals(gameBoardConstants.getBlockFallColumn(), alivePieceCoordinate.getX0());
//    assertEquals(gameBoardConstants.getBlockFallColumn(), alivePieceCoordinate.getX1());
//    assertEquals(gameBoardConstants.getLastRow(), alivePieceCoordinate.getY0());
//    assertEquals(gameBoardConstants.getLastRow() - 1, alivePieceCoordinate.getY1());
//  }
//
//  @Test
//  void fallPieceCoordinateTest() {
//    PieceCoordinate alivePieceCoordinate = new PieceCoordinate().down();
//    assertEquals(gameBoardConstants.getBlockFallColumn(), alivePieceCoordinate.getX0());
//    assertEquals(gameBoardConstants.getBlockFallColumn(), alivePieceCoordinate.getX1());
//    assertEquals(gameBoardConstants.getLastRow() - 1, alivePieceCoordinate.getY0());
//    assertEquals(gameBoardConstants.getLastRow() - 2, alivePieceCoordinate.getY1());
//  }
}
