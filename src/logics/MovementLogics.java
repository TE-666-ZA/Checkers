package logics;

import graphics.code.Board;
import javax.swing.JPanel;

public class MovementLogics extends JPanel {

  private int checkerMove;
  private final int WHITECHECKER = 1;
  private final int BLACKCHECKER = 2;
  private int countWhiteChecker = 12;
  private int countBlackChecker = 12;

  public MovementLogics() {
    checkerMove = WHITECHECKER;
  }

  /**
   * Checking the possibility of movement of the checkers
   *
   * @param board       playing field
   * @param row         the position of the row of the cell of the field where we want to move the
   *                    checker
   * @param col         the position of the column of the cell of the field where we want to move
   *                    the checker
   * @param selectedRow the position of the row of the cell of the field from where we want to move
   *                    the checker
   * @param selectedCol the position of the column of the cell of the field from where we want to
   *                    move the checker
   * @return true if the checker can be moved, and false if the checker cannot be moved
   */
  public boolean checkMovement(int[][] board, int row, int col, int selectedRow, int selectedCol) {
    if (checkerMove == WHITECHECKER) {
      if (col == (selectedCol + 1) | col == (selectedCol - 1) && row == (selectedRow + 1)
          && isTargetCellFree(board, row, col)) {
        checkerMove = BLACKCHECKER;
        return true;
      } else {
        return canKill(board, row, col, selectedRow, selectedCol);
      }
    }

    if (checkerMove == BLACKCHECKER) {
      if (col == (selectedCol + 1) | col == (selectedCol - 1) && row == (selectedRow - 1)
          && isTargetCellFree(board, row, col)) {
        checkerMove = WHITECHECKER;
        return true;
      } else {
        return canKill(board, row, col, selectedRow, selectedCol);
      }
    }
    return false;
  }

  /**
   * The opportunity to cut down the opponent's checker
   *
   * @param board       playing field
   * @param row         the position of the row of the cell of the field where we want to move the
   *                    checker
   * @param col         the position of the column of the cell of the field where we want to move
   *                    the checker
   * @param selectedRow the position of the row of the cell of the field from where we want to move
   *                    the checker
   * @param selectedCol the position of the column of the cell of the field from where we want to
   *                    move the checker
   * @return
   */
  private boolean canKill(int[][] board, int row, int col, int selectedRow, int selectedCol) {
    if (checkerMove == WHITECHECKER) {

      if (isLeftBorderChecker(selectedCol)) {
        checkerMove = BLACKCHECKER;
        return leftBorderLogicForWhite(board, row, col, selectedRow, selectedCol);
      } else if (isRightBorderChecker(selectedCol)) {
        checkerMove = BLACKCHECKER;
        return rightBorderLogicForWhite(board, row, col, selectedRow, selectedCol);
      } else if (row == (selectedRow + 2) && col == (selectedCol + 2) && isTargetCellFree(board,
          row, col) && board[selectedRow + 1][selectedCol + 1] != WHITECHECKER) {
        Board.killChecker(selectedRow + 1, selectedCol + 1);
        checkWhiteVictory();
        checkerMove = BLACKCHECKER;
        return true;

      } else if (row == (selectedRow + 2) && col == (selectedCol - 2) && isTargetCellFree(board,
          row, col) && board[selectedRow + 1][selectedCol - 1] != WHITECHECKER) {
        Board.killChecker(selectedRow + 1, selectedCol - 1);
        checkWhiteVictory();
        checkerMove = BLACKCHECKER;
        return true;

      }
    } else {

      if (isLeftBorderChecker(selectedCol)) {
        checkerMove = WHITECHECKER;
        return leftBorderLogicForBlack(board, row, col, selectedRow, selectedCol);
      } else if (isRightBorderChecker(selectedCol)) {
        checkerMove = WHITECHECKER;
        return rightBorderLogicForBlack(board, row, col, selectedRow, selectedCol);
      } else if (row == (selectedRow - 2) && col == (selectedCol + 2) && isTargetCellFree(board,
          row, col) && board[selectedRow - 1][selectedCol + 1] != BLACKCHECKER) {
        Board.killChecker(selectedRow - 1, selectedCol + 1);
        checkBlackVictory();
        checkerMove = WHITECHECKER;
        return true;
      } else if (row == (selectedRow - 2) && col == (selectedCol - 2) && isTargetCellFree(board,
          row, col) && board[selectedRow - 1][selectedCol - 1] != BLACKCHECKER) {
        Board.killChecker(selectedRow - 1, selectedCol - 1);
        checkBlackVictory();
        checkerMove = WHITECHECKER;
        return true;
      }
    }
    return false;
  }


  private boolean leftBorderLogicForWhite(int[][] board, int row, int col, int selectedRow,
      int selectedCol) {
    if (row == (selectedRow + 2) && col == (selectedCol + 2) && isTargetCellFree(board, row, col)
        && board[selectedRow + 1][selectedCol + 1] != WHITECHECKER) {
      Board.killChecker(selectedRow + 1, selectedCol + 1);
      checkWhiteVictory();
      return true;
    }
    return false;
  }

  private boolean leftBorderLogicForBlack(int[][] board, int row, int col, int selectedRow,
      int selectedCol) {
    if (row == (selectedRow - 2) && col == (selectedCol + 2) && isTargetCellFree(board, row, col)
        && board[selectedRow - 1][selectedCol + 1] != BLACKCHECKER) {
      Board.killChecker(selectedRow - 1, selectedCol + 1);
      checkBlackVictory();
      return true;
    }
    return false;
  }

  private boolean rightBorderLogicForWhite(int[][] board, int row, int col, int selectedRow,
      int selectedCol) {
    if (row == (selectedRow + 2) && col == (selectedCol - 2) && isTargetCellFree(board, row, col)
        && board[selectedRow + 1][selectedCol - 1] != WHITECHECKER) {
      Board.killChecker(selectedRow + 1, selectedCol - 1);
      checkWhiteVictory();
      return true;
    }
    return false;
  }

  private boolean rightBorderLogicForBlack(int[][] board, int row, int col, int selectedRow,
      int selectedCol) {
    if (row == (selectedRow - 2) && col == (selectedCol - 2) && isTargetCellFree(board, row, col)
        && board[selectedRow - 1][selectedCol - 1] != BLACKCHECKER) {
      Board.killChecker(selectedRow - 1, selectedCol - 1);
      checkBlackVictory();
      return true;
    }
    return false;
  }

  private boolean isTargetCellFree(int[][] board, int row, int col) {
    return board[row][col] == 0;
  }

  public int getCheckerMove() {
    return checkerMove;
  }

  private boolean isLeftBorderChecker(int selectedCol) {
    return selectedCol == 0;
  }

  private boolean isRightBorderChecker(int selectedCol) {
    return selectedCol == 7;
  }

  /**
   * Checking that there are no white checkers left on the field
   *
   * @return true if there are no white checkers left on the playing field
   */
  private boolean isWhiteCheckerResetToZero() {
    return countWhiteChecker == 0;
  }

  /**
   * Checking that there are no black checkers left on the field
   *
   * @return true if there are no black checkers left on the playing field
   */
  private boolean isBlackCheckerResetToZero() {
    return countBlackChecker == 0;
  }

  /**
   * Decrement of the number of white checkers
   */
  public void minusOneWhiteChecker() {
    this.countWhiteChecker--;
  }

  /**
   * Decrement of the number of black checkers
   */
  public void minusOneBlackChecker() {
    this.countBlackChecker--;
  }

  /**
   * Checking the victory of white checkers
   */
  public void checkWhiteVictory() {
    minusOneBlackChecker();
    if (isBlackCheckerResetToZero()) {
      gameOverWithWhiteVictory();
    }
  }

  /**
   * Checking the victory of black checkers
   */
  public void checkBlackVictory() {
    minusOneWhiteChecker();
    if (isWhiteCheckerResetToZero()) {
      gameOverWithBlackVictory();
    }
  }

  /**
   * The end of the game with the victory of the white checkers and exit the game
   */
  public void gameOverWithWhiteVictory() {
    // TODO увеличение побед белых и увеличение поражений черных
    System.out.println("Игра завершена! Белые выиграли!");
    System.exit(1);
  }

  /**
   * The end of the game with the victory of the black checkers and exit the game
   */
  public void gameOverWithBlackVictory() {
    // TODO увеличение побед черных и увеличение поражений белых
    System.out.println("Игра завершена! Черные выиграли!");
    System.exit(1);
  }
}
