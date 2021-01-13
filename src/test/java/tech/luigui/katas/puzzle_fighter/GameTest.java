package tech.luigui.katas.puzzle_fighter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.luigui.katas.puzzle_fighter.model.GameBoard;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
  private final String[][] input1 = {{"YY","BALLL"},{"RR","AALL"}};
  private final String expected1 =
    "      \n      \n      \n      \n      \n      \n      \n      \n      \n      \nYR    \nYR    ";

  @Test
  void gameTestInput1() {
    GameBoard gameBoard = new Game(input1).playGame();
    assertEquals(expected1, new OutputFacade(gameBoard).getGameOutput());
  }
}
