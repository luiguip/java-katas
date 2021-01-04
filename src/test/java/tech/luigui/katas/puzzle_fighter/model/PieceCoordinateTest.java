package tech.luigui.katas.puzzle_fighter.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceCoordinateTest {

    @Test
    void initialPieceCoordinateTest() {
        PieceCoordinate alivePieceCoordinate = new PieceCoordinate();
        assertEquals(GameBoardConstants.getBlockFallColumn(), alivePieceCoordinate.getX0());
        assertEquals(GameBoardConstants.getBlockFallColumn(), alivePieceCoordinate.getX1());
        assertEquals(GameBoardConstants.getLastRow(), alivePieceCoordinate.getY0());
        assertEquals(GameBoardConstants.getLastRow()-1, alivePieceCoordinate.getY1());
    }

    @Test
    void fallPieceCoordinateTest() {
        PieceCoordinate alivePieceCoordinate = new PieceCoordinate().down();
        assertEquals(GameBoardConstants.getBlockFallColumn(), alivePieceCoordinate.getX0());
        assertEquals(GameBoardConstants.getBlockFallColumn(), alivePieceCoordinate.getX1());
        assertEquals(GameBoardConstants.getLastRow()-1, alivePieceCoordinate.getY0());
        assertEquals(GameBoardConstants.getLastRow()-2, alivePieceCoordinate.getY1());
    }
}
