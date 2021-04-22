package tech.luigui.katas;

import java.util.ArrayList;
import java.util.List;

public class SqInRect {

  public List<Integer> solve(int length, int width) {
    if(length == width)
      return null;
    return calculateSquares(length, width);
  }

  public List<Integer> calculateSquares(int length, int width) {
    int actualLength = length;
    int actualWidth = width;
    List<Integer> squares = new ArrayList<>();
    while(actualLength > 0 && actualLength > 0) {
      squares.add(Math.min(actualLength, actualWidth));
      if(actualLength < actualWidth)
        actualWidth -= actualLength;
      else
        actualLength -= actualWidth;
    }
    return squares;
  }
}
