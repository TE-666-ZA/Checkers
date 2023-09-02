package logics;

public class QueenLogics implements MovementLogics {

  PlayerLogics playerLogics = new PlayerLogics();

  @Override
  public boolean isMoveValid(int[][] board, int row, int col, int selectedRow, int selectedCol) {
    int differentRow = Math.abs(row - selectedRow);
    int differentCol = Math.abs(col - selectedCol);
    if ((differentRow == differentCol) && (board[row][col] == 0)) {
      return true;
    }
    return canKill(board, row, col, selectedRow, selectedCol);
  }

  @Override
  public boolean canKill(int[][] board, int row, int col, int selectedRow, int selectedCol) {
    return false;
  }

  @Override
  public boolean leftBorderLogicForWhite(int[][] board, int row, int col, int selectedRow,
      int selectedCol) {
    return false;
  }

  @Override
  public boolean leftBorderLogicForBlack(int[][] board, int row, int col, int selectedRow,
      int selectedCol) {
    return false;
  }

  @Override
  public boolean rightBorderLogicForWhite(int[][] board, int row, int col, int selectedRow,
      int selectedCol) {
    return false;
  }

  @Override
  public boolean rightBorderLogicForBlack(int[][] board, int row, int col, int selectedRow,
      int selectedCol) {
    return false;
  }

  @Override
  public boolean isTargetCellFree(int[][] board, int row, int col) {
    return false;
  }

  @Override
  public int getCheckerMove() {
    return 0;
  }

  @Override
  public boolean isLeftBorderChecker(int selectedCol) {
    return false;
  }

  @Override
  public boolean isRightBorderChecker(int selectedCol) {
    return false;
  }

  @Override
  public boolean isWhiteCheckerResetToZero() {
    return false;
  }

  @Override
  public boolean isBlackCheckerResetToZero() {
    return false;
  }

  @Override
  public void minusOneWhiteChecker() {

  }

  @Override
  public void minusOneBlackChecker() {

  }

  @Override
  public void checkWhiteVictory() {

  }

  @Override
  public void checkBlackVictory() {

  }

  @Override
  public void gameOverWithWhiteVictory() {

  }

  @Override
  public void gameOverWithBlackVictory() {

  }
}
