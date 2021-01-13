package tech.luigui.katas.puzzle_fighter;

import tech.luigui.katas.puzzle_fighter.model.GameBoard;
import tech.luigui.katas.puzzle_fighter.model.Input;
import tech.luigui.katas.puzzle_fighter.model.MovementEnum;
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
    GameBoard turnGameBoard = gameBoard;
    for(MovementEnum movementEnum: input.getMovements()){
      turnGameBoard = move(turnGameBoard, movementEnum);
      turnGameBoard = gameManager.fall(turnGameBoard);
    }
    return gameManager.noMovesLeft(turnGameBoard);
  }

  private GameBoard move(GameBoard gameBoard, MovementEnum movementEnum) {
    switch(movementEnum){
      case LEFT:
        return gameManager.moveLeft(gameBoard);
      case RIGHT:
        return gameManager.moveRight(gameBoard);
      case ROTATE_CLOCKWISE:
        return gameManager.rotateClockwise(gameBoard);
      case ROTATE_COUNTERCLOCKWISE:
        return gameManager.rotateCounterClockwise(gameBoard);
      case NO_MOVE:
        return gameBoard;
      default:
        throw new IllegalStateException("Invalid MovementEnum");
    }
  }
}
