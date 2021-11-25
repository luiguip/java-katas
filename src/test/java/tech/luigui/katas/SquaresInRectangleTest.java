package tech.luigui.katas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquaresInRectangleTest {

    @Test
    void solveTest() {
        Assertions.assertEquals(8, SquaresInRectangle.solve(3,2));
        Assertions.assertEquals(20, SquaresInRectangle.solve(4, 3));
    }

    @Test
    void countSquares() {
        Assertions.assertEquals(6, SquaresInRectangle.countSquares(3, 2, 1));
        Assertions.assertEquals(2, SquaresInRectangle.countSquares(3, 2, 2));
    }
}
