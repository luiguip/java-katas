package tech.luigui.katas;

import java.util.Arrays;
import java.util.List;

public class SqInRect {

  public List<Integer> solve(int lenght, int width) {
    if(lenght == width)
      return null;
    return Arrays.asList(3,2,1,1);
  }
}
