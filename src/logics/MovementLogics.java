package logics;

import graphics.code.Board;
import javax.swing.JPanel;

public class MovementLogics extends JPanel {

  private int checkerMove;
  private final int WHITECHECKER = 1;
  private final int BLACKCHECKER = 2;

  public MovementLogics() {
    checkerMove = WHITECHECKER;
  }

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

  private boolean canKill(int[][] board, int row, int col, int selectedRow, int selectedCol) {
    if (checkerMove == WHITECHECKER) {

      if (isLeftBorderChecker(selectedCol)) {
        checkerMove = BLACKCHECKER;
        return leftBorderLogicForWhite(board, row, col, selectedRow, selectedCol);
      } else if (isRightBorderChecker(selectedCol)) {
        checkerMove = BLACKCHECKER;
        return rightBorderLogicForWhite(board, row, col, selectedRow, selectedCol);
      } else if (row == (selectedRow + 2) && col == (selectedCol + 2) && isTargetCellFree(board,
          row,
            col)) {
          Board.killChecker(selectedRow + 1, selectedCol + 1);
        checkerMove = BLACKCHECKER;
          return true;

        } else if (row == (selectedRow + 2) && col == (selectedCol - 2) && isTargetCellFree(board,
            row, col)) {
          Board.killChecker(selectedRow + 1, selectedCol - 1);
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
          row,
            col)) {
          Board.killChecker(selectedRow - 1, selectedCol + 1);
        checkerMove = WHITECHECKER;
          return true;
      } else if (row == (selectedRow - 2) && col == (selectedCol - 2) && isTargetCellFree(board,
            row, col)) {
          Board.killChecker(selectedRow - 1, selectedCol - 1);
        checkerMove = WHITECHECKER;
          return true;
        }
      }
    return false;
  }


  private boolean leftBorderLogicForWhite(int[][] board, int row, int col, int selectedRow,
      int selectedCol) {
    if (row == (selectedRow + 2) && col == (selectedCol + 2) && isTargetCellFree(board, row, col)) {
      Board.killChecker(selectedRow + 1, selectedCol + 1);
      return true;
    }
    return false;
  }

  private boolean leftBorderLogicForBlack(int[][] board, int row, int col, int selectedRow,
      int selectedCol) {
    if (row == (selectedRow - 2) && col == (selectedCol + 2) && isTargetCellFree(board, row, col)) {
      Board.killChecker(selectedRow - 1, selectedCol + 1);
      return true;
    }
    return false;
  }

  private boolean rightBorderLogicForWhite(int[][] board, int row, int col, int selectedRow,
      int selectedCol) {
    if (row == (selectedRow + 2) && col == (selectedCol - 2) && isTargetCellFree(board, row, col)) {
      Board.killChecker(selectedRow + 1, selectedCol - 1);
      return true;
    }
    return false;
  }

  private boolean rightBorderLogicForBlack(int[][] board, int row, int col, int selectedRow,
      int selectedCol) {
    if (row == (selectedRow - 2) && col == (selectedCol - 2) && isTargetCellFree(board, row, col)) {
      Board.killChecker(selectedRow - 1, selectedCol - 1);
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
}
