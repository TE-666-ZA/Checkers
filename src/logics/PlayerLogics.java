package logics;

import graphics.code.Board;
import javax.swing.JPanel;

public class PlayerLogics extends JPanel implements MovementLogics {

  private int checkerMove;
  public static final int WHITE_CHECKER = 1;
  public static final int BLACK_CHECKER = 2;
 
  int lastRowPosition;
  int lastColPosition;
  boolean canDoNextMove;
  KingLogics kingLogics;

  public PlayerLogics() {
    checkerMove = WHITE_CHECKER;
    kingLogics = new KingLogics();
    canDoNextMove = false;
    lastColPosition = -1;
    lastRowPosition = -1;

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

  public boolean isMoveValid(int[][] board, int row, int col, int selectedRow, int selectedCol) {
    if (board[row][col] == KingLogics.getKING_BLACK_CHECKER()
        || board[row][col] == KingLogics.getKING_WHITE_CHECKER()) {
      return kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    }
    if (canDoNextMove) {
      return isCanDoValid(board, row, col, selectedRow, selectedCol);
    } else {
      if (checkerMove == WHITE_CHECKER) {
        if (col == (selectedCol + 1) | col == (selectedCol - 1) && row == (selectedRow + 1)
            && isTargetCellFree(board[row][col])) {
          isKing(row, col);
          return true;
        } else {

          return canDoNextMove = canKill(board, row, col, selectedRow, selectedCol);
        }
      }

      if (checkerMove == BLACK_CHECKER) {
        if (col == (selectedCol + 1) | col == (selectedCol - 1) && row == (selectedRow - 1)
            && isTargetCellFree(board[row][col])) {
          return true;
        } else {

          return canDoNextMove = canKill(board, row, col, selectedRow, selectedCol);
        }
      }
    }
    return false;
  }

  /**
   * The opportunity to eat the opponent's checker
   *
   * @param board       playing field
   * @param row         the position of the row of the field cell where we will get to if we can eat
   *                    the opponent's checker
   * @param col         the position of the column of the cell of the field where we will get if we
   *                    can eat the opponent's checker
   * @param selectedRow the position of the row of the cell of the field where the checker with
   *                    which we want to eat the opponent's checker is located
   * @param selectedCol the position of the column of the cell of the field where the checker with
   *                    which we want to eat the opponent's checker is located
   * @return true if the white checker can eat the opponent's black checker, and false if it can't
   */
  public boolean canKill(int[][] board, int row, int col, int selectedRow, int selectedCol) {
    if (checkerMove == WHITE_CHECKER) {

      if (isLeftBorderChecker(selectedCol)) {

        return leftBorderLogicForWhite(board, row, col, selectedRow, selectedCol);
      } else if (isRightBorderChecker(selectedCol)) {

        return rightBorderLogicForWhite(board, row, col, selectedRow, selectedCol);
      } else if (row == (selectedRow + 2) && col == (selectedCol + 2) && isTargetCellFree(
          board[row][col]) && board[selectedRow + 1][selectedCol + 1] == BLACK_CHECKER) {
        Board.killChecker(selectedRow + 1, selectedCol + 1);
        Board.checkWhiteVictory();
        isKing(row, col);
        lastRowPosition = row;
        lastColPosition = col;

        return true;

      } else if (row == (selectedRow + 2) && col == (selectedCol - 2) && isTargetCellFree(
          board[row][col]) && board[selectedRow + 1][selectedCol - 1] == BLACK_CHECKER) {
        Board.killChecker(selectedRow + 1, selectedCol - 1);
        Board.checkWhiteVictory();
        isKing(row, col);
        lastRowPosition = row;
        lastColPosition = col;

        return true;
      }

    } else if (checkerMove == BLACK_CHECKER) {
      if (isLeftBorderChecker(selectedCol)) {

        return leftBorderLogicForBlack(board, row, col, selectedRow, selectedCol);
      } else if (isRightBorderChecker(selectedCol)) {

        return rightBorderLogicForBlack(board, row, col, selectedRow, selectedCol);
      } else if (row == (selectedRow - 2) && col == (selectedCol + 2) && isTargetCellFree(
          board[row][col]) && board[selectedRow - 1][selectedCol + 1] == WHITE_CHECKER) {
        Board.killChecker(selectedRow - 1, selectedCol + 1);
        Board.checkBlackVictory();
        lastRowPosition = row;
        lastColPosition = col;

        return true;
      } else if (row == (selectedRow - 2) && col == (selectedCol - 2) && isTargetCellFree(
          board[row][col]) && board[selectedRow - 1][selectedCol - 1] == WHITE_CHECKER) {
        Board.killChecker(selectedRow - 1, selectedCol - 1);
        Board.checkBlackVictory();
        lastRowPosition = row;
        lastColPosition = col;

        return true;
      }
    }
    return false;
  }

  /**
   * Checks the possibility of eating the opponent's black checkers with a white checker located in
   * the left most column
   *
   * @param board       playing field
   * @param row         the position of the row of the cell of the playing field, where the white
   *                    checker will fall if it eats the opponent's checker
   * @param col         the position of the column of the cell of the playing field, where the white
   *                    checker will fall if it eats the opponent's checker
   * @param selectedRow the position of the cell row of the white checker field, which is located in
   *                    the left most column and which plans to eat the opponent's black checker
   * @param selectedCol the position of the left most column where the white checker is located,
   *                    which plans to eat the opponent's black checker
   * @return true if the white checker can eat the opponent's black checker, and false if it can't
   */
  public boolean leftBorderLogicForWhite(int[][] board, int row, int col, int selectedRow,
      int selectedCol) {
    if (row == (selectedRow + 2) && col == (selectedCol + 2) && isTargetCellFree(board[row][col])
        && board[selectedRow + 1][selectedCol + 1] == BLACK_CHECKER) {
      Board.killChecker(selectedRow + 1, selectedCol + 1);
      Board.checkWhiteVictory();
      isKing(row, col);
      lastRowPosition = row;
      lastColPosition = col;

      return true;
    }
    return false;
  }

  /**
   * Checks the possibility of eating the opponent's white checkers with a black checker located in
   * the left most column
   *
   * @param board       playing field
   * @param row         the position of the row of the cell of the playing field, where the black
   *                    checker will fall if it eats the opponent's white checker
   * @param col         the position of the column of the cell of the playing field, where the black
   *                    checker will fall if it eats the opponent's white checker
   * @param selectedRow the position of the cell row of the black checker field, which is located in
   *                    the left most column and which plans to eat the opponent's white checker
   * @param selectedCol the position of the left most column where the black checker is located
   *                    which plans to eat the opponent's white checker
   * @return true if the black checker can eat the opponent's white checker, and false if it can't
   */
  public boolean leftBorderLogicForBlack(int[][] board, int row, int col, int selectedRow,
      int selectedCol) {
    if (row == (selectedRow - 2) && col == (selectedCol + 2) && isTargetCellFree(board[row][col])
        && board[selectedRow - 1][selectedCol + 1] == WHITE_CHECKER) {
      Board.killChecker(selectedRow - 1, selectedCol + 1);
      Board.checkBlackVictory();
      lastRowPosition = row;
      lastColPosition = col;

      return true;
    }
    return false;
  }

  public boolean rightBorderLogicForWhite(int[][] board, int row, int col, int selectedRow,
      int selectedCol) {
    if (row == (selectedRow + 2) && col == (selectedCol - 2) && isTargetCellFree(board[row][col])
        && board[selectedRow + 1][selectedCol - 1] == BLACK_CHECKER) {
      Board.killChecker(selectedRow + 1, selectedCol - 1);
      Board.checkWhiteVictory();
      isKing(row, col);
      lastRowPosition = row;
      lastColPosition = col;

      return true;
    }
    return false;
  }

  public boolean rightBorderLogicForBlack(int[][] board, int row, int col, int selectedRow,
      int selectedCol) {
    if (row == (selectedRow - 2) && col == (selectedCol - 2) && isTargetCellFree(board[row][col])
        && board[selectedRow - 1][selectedCol - 1] == WHITE_CHECKER) {
      Board.killChecker(selectedRow - 1, selectedCol - 1);
      Board.checkBlackVictory();
      lastRowPosition = row;
      lastColPosition = col;

      return true;
    }
    return false;
  }

  /**
   * Checks that the cell of the playing field is free
   *

   * @return true if the cell of the playing field is free, and false if there is another checker on
   * the cell
   */
  public boolean isTargetCellFree(int target) {
    return target == 0;
  }

  public int getCheckerMove() {
    return checkerMove;
  }

  /**
   * Checks that the checker we want to go to is in the left most column
   *
   * @param selectedCol the position of the column of the cell of the playing field, where the
   *                    checker is located, which we want to make a move
   * @return true if the checker is in the left most table of the playing field, and false if the
   * checker is in any other table
   */
  public boolean isLeftBorderChecker(int selectedCol) {
    return selectedCol == 0;
  }

  /**
   * Checks that the checker we want to go to is in the right most column
   *
   * @param selectedCol the position of the column of the cell of the playing field, where the
   *                    checker is located, which we want to make a move
   * @return true if the checker is in the right most table of the playing field, and false if the
   * checker is in any other table
   */
  public boolean isRightBorderChecker(int selectedCol) {
    return selectedCol == 7;
  }


  public boolean isCanDoNextMove() {
    return canDoNextMove;
  }

  public void changeMoveColor() {
    if (checkerMove == WHITE_CHECKER) {
      checkerMove = BLACK_CHECKER;
    } else if (checkerMove == BLACK_CHECKER) {
      checkerMove = WHITE_CHECKER;
    }
  }

  public int getLastRowPosition() {
    return lastRowPosition;
  }

  public int getLastColPosition() {
    return lastColPosition;
  }

  public boolean isCanDoValid(int[][] board, int row, int col, int selectedRow, int selectedCol) {
    if (selectedRow < 6 && selectedRow > 1 && selectedCol < 6 && selectedCol > 1) {
      if (checkerMove == WHITE_CHECKER) {
        if (board[lastRowPosition + 2][lastColPosition + 2] == 0
            || board[lastRowPosition + 2][lastColPosition - 2] == 0) {
          return canKill(board, row, col, selectedRow, selectedCol);

        }
      }
      if (checkerMove == BLACK_CHECKER) {
        if (board[lastRowPosition - 2][lastColPosition + 2] == 0
            || board[lastRowPosition - 2][lastColPosition - 2] == 0) {
          return canKill(board, row, col, selectedRow, selectedCol);
        }
      }
    }
    changeMoveColor();
    return canDoNextMove = false;
  }

  public void isKing(int row, int col) {
    if (checkerMove == WHITE_CHECKER && row == 7) {
      Board.setKing(row, col);
    } else if (checkerMove == BLACK_CHECKER && row == 0) {
      Board.setKing(row, col);
    }
  }

  public static int getWhitechecker() {
    return WHITE_CHECKER;
  }

  public static int getBlackchecker() {
    return BLACK_CHECKER;
  }

}
