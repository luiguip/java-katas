package tech.luigui.katas;

import java.util.stream.IntStream;

public class SquaresInRectangle {

    public static int solve(int x, int y) {
        return IntStream.rangeClosed(1, Math.min(x, y))
                .map(i -> SquaresInRectangle.countSquares(x, y, i))
                .sum();
    }

    public static int countSquares(int x, int y, int squareX) {
        var nAxisX = x - squareX + 1;
        var nAxisY = y - squareX + 1;
        return nAxisX * nAxisY;
    }
}
