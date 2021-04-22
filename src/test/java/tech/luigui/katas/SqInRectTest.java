package tech.luigui.katas;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SqInRectTest {
  private SqInRect sqInRect = new SqInRect();
  List<Integer> expectedSquares = Arrays.asList(3,2,1,1);

  @Test
  void solveTest(){
    assertEquals(expectedSquares, sqInRect.solve(5,3));
    assertNull(sqInRect.solve(5,5));
  }

  @Test
  void calculateSquaresTest() {
    assertEquals(expectedSquares, sqInRect.calculateSquares(5, 3));
  }
}
