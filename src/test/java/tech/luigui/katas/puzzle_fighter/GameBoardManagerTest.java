package tech.luigui.katas.puzzle_fighter;

import org.junit.jupiter.api.Test;
import tech.luigui.katas.puzzle_fighter.model.GameBoard;
import tech.luigui.katas.puzzle_fighter.model.Input;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameBoardManagerTest {

    GameBoardManager gameBoardManager = new GameBoardManager();
    GameManager gameManager = new GameManager();

    private final String NO_MOVE =
            "      \n      \n      \n      \n      \n      \n      \n      \n      \n      \n   R  \n   B  ";
    private final String ONE_MOVE_LEFT =
            "  R   \n  B   \n      \n      \n      \n      \n      \n      \n      \n      \n      \n      ";
    private final String ONE_MOVE_RIGHT =
            "    R \n    B \n      \n      \n      \n      \n      \n      \n      \n      \n      \n      ";

    @Test
    void noMovesLeftTest() {
        GameBoard gameBoard = testSetup("RB");
        GameBoard finalGameBoard = gameManager.noMovesLeft(gameBoard);
        assertGameOutput(NO_MOVE, finalGameBoard);
    }

    @Test
    void OneLeftTest(){
        GameBoard gameBoard = testSetup("RB", "L");
        GameBoard finalGameBoard = gameManager.moveLeft(gameBoard);
        assertGameOutput(ONE_MOVE_LEFT, finalGameBoard);
    }

    @Test
    void OneRightTest(){
        GameBoard gameBoard = testSetup("RB", "R");
        GameBoard finalGameBoard = gameManager.moveRight(gameBoard);
        assertGameOutput(ONE_MOVE_RIGHT, finalGameBoard);
    }

    private GameBoard testSetup(String rawPieces) {
        return testSetup(rawPieces, "");
    }

    private GameBoard testSetup(String rawPieces, String rawMovements) {
        Input input = new Input(rawPieces, rawMovements);
        return gameBoardManager.createInitialBoard(input.getPieces());
    }

    private void assertGameOutput(String expected, GameBoard gameBoard) {
        OutputFacade outputFacade = new OutputFacade(gameBoard);
        assertEquals(expected, outputFacade.getGameOutput());
    }
}
