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
      checkerMove = BLACKCHECKER;
      if (isLeftBorderChecker(selectedCol) && canKillBlackRight(board, row, col, selectedRow,
          selectedCol)) {
        return leftBorderLogic(board, row, col, selectedRow, selectedCol);
      }

      if (isRightBorderChecker(selectedCol) && canKillBlackLeft(board, row, col, selectedRow,
          selectedCol)) {
        return rightBorderLogic(board, row, col, selectedRow, selectedCol);
      }

      if (canKillBlackLeft(board, row, col, selectedRow, selectedCol)
          | canKillBlackRight(board, row, col, selectedRow, selectedCol)) {

        if (row == (selectedRow + 2) && col == (selectedCol + 2)
            && isTargetCellFree(board, row, col)) {
          killChecker(selectedRow + 2, selectedCol + 2);
          return true;

        } else if (row == (selectedRow + 2) && col == (selectedCol - 2) && isTargetCellFree(board,
            row, col)) {
          killChecker(selectedRow + 2, selectedCol - 2);
          return true;
        }
      }
    }
    checkerMove = WHITECHECKER;
    if (isLeftBorderChecker(selectedCol) && canKillWhiteRight(board, row, col, selectedRow,
        selectedCol)) {
      return leftBorderLogic(board, row, col, selectedRow, selectedCol);
    }
    if (isRightBorderChecker(selectedCol) && canKillWhiteLeft(board, row, col, selectedRow,
        selectedCol)) {
      return rightBorderLogic(board, row, col, selectedRow, selectedCol);
    }
    if (canKillWhiteRight(board, row, col, selectedRow, selectedCol)
        | canKillWhiteLeft(board, row, col, selectedRow, selectedCol)) {

      if (row == (selectedRow - 2) && col == (selectedCol + 2)
          && isTargetCellFree(board, row, col)) {
        killChecker(selectedRow - 2, selectedCol + 2);
        return true;
      } else if (row == (selectedRow - 2) && col == (selectedCol - 2) && isTargetCellFree(board,
          row, col)) {
        killChecker(selectedRow - 2, selectedCol - 2);
        return true;
      }
    }

    return false;
  }


  private boolean leftBorderLogic(int[][] board, int row, int col, int selectedRow,
      int selectedCol) {
    if (col == (selectedCol + 2) && row == (selectedRow + 2) && isTargetCellFree(board, row, col)) {
      killChecker(selectedRow + 2, selectedCol + 2);
      return true;
    }
    return false;
  }

  private boolean rightBorderLogic(int[][] board, int row, int col, int selectedRow,
      int selectedCol) {
    if (col == (selectedCol - 2) && row == (selectedRow + 2) && isTargetCellFree(board, row, col)) {
      killChecker(selectedRow + 2, selectedCol + 2);
      return true;
    }
    return false;
  }

  private boolean canKillBlackRight(int[][] board, int row, int col, int selectedRow,
      int selectedCol) {
    return board[selectedRow + 1][selectedCol + 1] == BLACKCHECKER && isTargetCellFree(board, row,
        col);
  }

  private boolean canKillBlackLeft(int[][] board, int row, int col, int selectedRow,
      int selectedCol) {
    return board[selectedRow + 1][selectedCol - 1] == BLACKCHECKER && isTargetCellFree(board, row,
        col);
  }

  private boolean canKillWhiteRight(int[][] board, int row, int col, int selectedRow,
      int selectedCol) {
    return board[selectedRow + 1][selectedCol + 1] == WHITECHECKER && isTargetCellFree(board, row,
        col);
  }

  private boolean canKillWhiteLeft(int[][] board, int row, int col, int selectedRow,
      int selectedCol) {
    return board[selectedRow + 1][selectedCol - 1] == WHITECHECKER && isTargetCellFree(board, row,
        col);
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

  private void killChecker(int selectedRow, int selectedCol) {
    Board.setBoard(selectedRow, selectedCol);
  }
}
