package tech.luigui.katas.puzzle_fighter;

import tech.luigui.katas.puzzle_fighter.model.GameBoard;
import tech.luigui.katas.puzzle_fighter.model.Input;
import tech.luigui.katas.puzzle_fighter.model.PieceCoordinate;
import tech.luigui.katas.puzzle_fighter.model.PieceEnum;

import java.util.List;

public class Game {
  List<Input> inputList;
  GameManager gameManager = new GameManager();

  public Game(String[][] rawInput) {
     inputList = new InputFacade(rawInput).getInputList();
  }

  public GameBoard playGame() {
    List<PieceEnum> pieceEnumList = inputList.get(0).getPieces();
    GameBoard gameBoard = gameManager.initGameBoard(pieceEnumList);
    for(Input input: inputList) {
      pieceEnumList = input.getPieces();
      gameBoard = gameManager.initTurn(gameBoard, pieceEnumList);
      gameBoard = playTurn(gameBoard, input);
    }
    return gameBoard;
  }

  public GameBoard playTurn(GameBoard gameBoard, Input input) {
    return null;
  }
}
