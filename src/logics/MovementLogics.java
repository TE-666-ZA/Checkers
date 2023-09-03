package logics;

public interface MovementLogics {

  boolean isMoveValid(int[][] board, int row, int col, int selectedRow, int selectedCol);

  boolean canKill(int[][] board, int row, int col, int selectedRow, int selectedCol);

  boolean leftBorderLogicForWhite(
      int[][] board, int row, int col, int selectedRow, int selectedCol);

  boolean leftBorderLogicForBlack(
      int[][] board, int row, int col, int selectedRow, int selectedCol);

  boolean rightBorderLogicForWhite(
      int[][] board, int row, int col, int selectedRow, int selectedCol);

  boolean rightBorderLogicForBlack(
      int[][] board, int row, int col, int selectedRow, int selectedCol);

  boolean isTargetCellFree(int targetCell);

  int getCheckerMove();

  boolean isLeftBorderChecker(int selectedCol);

  boolean isRightBorderChecker(int selectedCol);

}
