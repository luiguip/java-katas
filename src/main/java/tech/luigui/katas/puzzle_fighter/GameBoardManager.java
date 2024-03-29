package tech.luigui.katas.puzzle_fighter;

import tech.luigui.katas.puzzle_fighter.model.AlivePieceCoordinate;
import tech.luigui.katas.puzzle_fighter.model.GameBoard;
import tech.luigui.katas.puzzle_fighter.model.GameBoardConstants;
import tech.luigui.katas.puzzle_fighter.model.PieceEnum;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameBoardManager {

    private final GameBoardConstants gameBoardConstants = new GameBoardConstants();
    int column = gameBoardConstants.getBlockFallColumn();
    int row = gameBoardConstants.getLastRow();

    public GameBoard createInitialBoard(List<PieceEnum> pieceEnumList, AlivePieceCoordinate alivePieceCoordinate) {
        PieceEnum[][] pieceEnumMatrix = initiateInitialPieceEnumMatrix(pieceEnumList, column, row);
        return new GameBoard(pieceEnumMatrix, pieceEnumList, alivePieceCoordinate);
    }

    public GameBoard initTurn(GameBoard gameBoard, List<PieceEnum> pieceEnumList, AlivePieceCoordinate alivePieceCoordinate) {
       return initUpdate(gameBoard, pieceEnumList, alivePieceCoordinate);
    }

    private GameBoard initUpdate(GameBoard previousGameBoard, List<PieceEnum> pieceEnumList, AlivePieceCoordinate alivePieceCoordinate) {
        PieceEnum[][] pieceEnumMatrix = updatePieceEnumMatrix(previousGameBoard.getPieceEnumMatrix(),
          pieceEnumList,
          alivePieceCoordinate);
        return new GameBoard(pieceEnumMatrix, pieceEnumList, alivePieceCoordinate);
    }

    public GameBoard update(GameBoard previousGameBoard, AlivePieceCoordinate alivePieceCoordinate) {
        PieceEnum[][] pieceEnumMatrix = updatePieceEnumMatrix(previousGameBoard.getPieceEnumMatrix(),
                previousGameBoard.getAlivePieceEnumList(),
                previousGameBoard.getAlivePieceCoordinate(),
                alivePieceCoordinate);
        return new GameBoard(pieceEnumMatrix, previousGameBoard.getAlivePieceEnumList(), alivePieceCoordinate);
    }

    private PieceEnum[][] initateSpaceListList(int columns, int rows) {
        return IntStream.range(0, rows)
                .mapToObj(i -> initiateRow(columns))
                .toArray(PieceEnum[][]::new);
    }

    private PieceEnum[] initiateRow(int columns) {
        return IntStream.range(0, columns)
                .mapToObj(i -> PieceEnum.EMPTY)
                .toArray(PieceEnum[]::new);
    }

    public PieceEnum[][] initiateInitialPieceEnumMatrix(List<PieceEnum> pieceEnumList, int column, int row) {
        PieceEnum[][] pieceEnumMatrix = initateSpaceListList(gameBoardConstants.getNumberOfColumns(), gameBoardConstants.getNumberOfRows());
        pieceEnumMatrix[row][column] = pieceEnumList.get(0);
        pieceEnumMatrix[row - 1][column] = pieceEnumList.get(1);
        return pieceEnumMatrix;
    }

    private PieceEnum[][] updatePieceEnumMatrix(PieceEnum[][] pieceEnumMatrix,
                                                List<PieceEnum> pieceEnumList,
                                                AlivePieceCoordinate previousAliveAlivePieceCoordinate,
                                                AlivePieceCoordinate alivePieceCoordinate) {
        PieceEnum[][] removedPreviousAlivePiece = removePreviousAlivePiece(pieceEnumMatrix, previousAliveAlivePieceCoordinate);
        return updatePieceEnumMatrix(removedPreviousAlivePiece, pieceEnumList, alivePieceCoordinate);
    }

    private PieceEnum[][] removePreviousAlivePiece(PieceEnum[][] pieceEnumMatrix,
                                                   AlivePieceCoordinate previousAliveAlivePieceCoordinate) {
        List<PieceEnum> pieceEnumList = emptyPieceEnumEntry();
        return updatePieceEnumMatrix(pieceEnumMatrix, pieceEnumList, previousAliveAlivePieceCoordinate);
    }

    private PieceEnum[][] updatePieceEnumMatrix(PieceEnum[][] pieceEnumMatrix, List<PieceEnum> pieceEnumList,
                                                AlivePieceCoordinate alivePieceCoordinate) {
        pieceEnumMatrix[alivePieceCoordinate.getY0()][alivePieceCoordinate.getX0()] = pieceEnumList.get(0);
        pieceEnumMatrix[alivePieceCoordinate.getY1()][alivePieceCoordinate.getX1()] = pieceEnumList.get(1);
        return pieceEnumMatrix;
    }

    private List<PieceEnum> emptyPieceEnumEntry() {
        return IntStream.range(0, 2).mapToObj(i -> PieceEnum.EMPTY).collect(Collectors.toList());

    }
}