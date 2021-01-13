package tech.luigui.katas.puzzle_fighter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tech.luigui.katas.puzzle_fighter.model.GameBoard;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

  @Test
  void gameTestInput1() {
    final String[][] input = {{"YY","BALLL"},{"RR","AALL"}};
    final String expected =
      "      \n      \n      \n      \n      \n      \n      \n      \n      \n      \nYR    \nYR    ";
    GameBoard gameBoard = new Game(input).playGame();
    assertEquals(expected, new OutputFacade(gameBoard).getGameOutput());
  }

  @Test
  void gameTestInput2() {
    final String[][] input = {{"YY","BALLL"},{"RR","AALL"}, {"BB", "BR"}};
    final String expected =
      "      \n      \n      \n      \n      \n      \n      \n      \n      \n      \nYR    \nYR BB ";
    GameBoard gameBoard = new Game(input).playGame();
    assertEquals(expected, new OutputFacade(gameBoard).getGameOutput());
  }

}
