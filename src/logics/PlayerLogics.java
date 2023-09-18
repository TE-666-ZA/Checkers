package logics;

import graphics.code.Board;
import javax.swing.JPanel;

public class PlayerLogics extends JPanel implements MovementLogics {

  private int checkerMove;
  public static final int WHITE_CHECKER = 1;
  public static final int BLACK_CHECKER = 2;
  private int lastRowPosition;
  private int lastColPosition;

  KingLogics kingLogics;

  public PlayerLogics() {
    checkerMove = WHITE_CHECKER;
    kingLogics = new KingLogics();
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
    if (board[selectedRow][selectedCol] == KingLogics.getKING_BLACK_CHECKER()
        || board[selectedRow][selectedCol] == KingLogics.getKING_WHITE_CHECKER()) {
      return kingLogics.isMoveValid(board, row, col, selectedRow, selectedCol);
    }
    if (Board.isCanDoNextMove()) {
      return canKill(board, row, col, selectedRow, selectedCol);
    } else
    if (checkerMove == WHITE_CHECKER) {
      if (col == (selectedCol + 1) | col == (selectedCol - 1) && row == (selectedRow + 1)
          && isTargetCellFree(board[row][col])) {
        isKing(row, col);
        return true;
      } else {

        return canKill(board, row, col, selectedRow, selectedCol);
      }
    }

    if (checkerMove == BLACK_CHECKER) {
      if (col == (selectedCol + 1) | col == (selectedCol - 1) && row == (selectedRow - 1)
          && isTargetCellFree(board[row][col])) {
        return true;
      } else {

        return canKill(board, row, col, selectedRow, selectedCol);
      }
    }
    return true;
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
   * @return true if the checker can eat the opponent's checker, and false if it can't
   */
  public boolean canKill(int[][] board, int row, int col, int selectedRow, int selectedCol) {
    if (checkerMove == WHITE_CHECKER) {

      if (isLeftBorderChecker(selectedCol)) {

        return leftBorderLogicForWhite(board, row, col, selectedRow, selectedCol);
      } else if (isRightBorderChecker(selectedCol)) {

        return rightBorderLogicForWhite(board, row, col, selectedRow, selectedCol);
      } else if (row == (selectedRow + 2) && col == (selectedCol + 2) && isTargetCellFree(
          board[row][col]) && isNextCellBlackChecker(board[selectedRow + 1][selectedCol + 1])) {
        Board.killChecker(selectedRow + 1, selectedCol + 1);
        Board.checkWhiteVictory();
        isKing(row, col);
        lastRowPosition = row;
        lastColPosition = col;
        Board.setCanDoNextMove(isCanDoNextMoveValid(board, row, col));

        return true;

      } else if (row == (selectedRow + 2) && col == (selectedCol - 2) && isTargetCellFree(
          board[row][col]) && isNextCellBlackChecker(board[selectedRow + 1][selectedCol - 1])) {
        Board.killChecker(selectedRow + 1, selectedCol - 1);
        Board.checkWhiteVictory();
        isKing(row, col);
        lastRowPosition = row;
        lastColPosition = col;
        Board.setCanDoNextMove(isCanDoNextMoveValid(board, row, col));

        return true;
      }

    } else if (checkerMove == BLACK_CHECKER) {
      if (isLeftBorderChecker(selectedCol)) {

        return leftBorderLogicForBlack(board, row, col, selectedRow, selectedCol);
      } else if (isRightBorderChecker(selectedCol)) {

        return rightBorderLogicForBlack(board, row, col, selectedRow, selectedCol);
      } else if (row == (selectedRow - 2) && col == (selectedCol + 2) && isTargetCellFree(
          board[row][col]) && isNextCellWhiteChecker(board[selectedRow - 1][selectedCol + 1])) {
        Board.killChecker(selectedRow - 1, selectedCol + 1);
        Board.checkBlackVictory();
        lastRowPosition = row;
        lastColPosition = col;
        Board.setCanDoNextMove(isCanDoNextMoveValid(board, row, col));

        return true;
      } else if (row == (selectedRow - 2) && col == (selectedCol - 2) && isTargetCellFree(
          board[row][col]) && isNextCellWhiteChecker(board[selectedRow - 1][selectedCol - 1])) {
        Board.killChecker(selectedRow - 1, selectedCol - 1);
        Board.checkBlackVictory();
        lastRowPosition = row;
        lastColPosition = col;
        Board.setCanDoNextMove(isCanDoNextMoveValid(board, row, col));

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
        && isNextCellBlackChecker(board[selectedRow + 1][selectedCol + 1])) {
      Board.killChecker(selectedRow + 1, selectedCol + 1);
      Board.checkWhiteVictory();
      isKing(row, col);
      lastRowPosition = row;
      lastColPosition = col;
      Board.setCanDoNextMove(isCanDoNextMoveValid(board, row, col));

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
        && isNextCellWhiteChecker(board[selectedRow - 1][selectedCol + 1])) {
      Board.killChecker(selectedRow - 1, selectedCol + 1);
      Board.checkBlackVictory();
      lastRowPosition = row;
      lastColPosition = col;
      Board.setCanDoNextMove(isCanDoNextMoveValid(board, row, col));

      return true;
    }
    return false;
  }

  /**
   * Checks the possibility of eating the opponent's black checkers with a white checker located in
   * the right most column
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
  public boolean rightBorderLogicForWhite(int[][] board, int row, int col, int selectedRow,
      int selectedCol) {
    if (row == (selectedRow + 2) && col == (selectedCol - 2) && isTargetCellFree(board[row][col])
        && isNextCellBlackChecker(board[selectedRow + 1][selectedCol - 1])) {
      Board.killChecker(selectedRow + 1, selectedCol - 1);
      Board.checkWhiteVictory();
      isKing(row, col);
      lastRowPosition = row;
      lastColPosition = col;
      Board.setCanDoNextMove(isCanDoNextMoveValid(board, row, col));

      return true;
    }
    return false;
  }

  /**
   * Checks the possibility of eating the opponent's white checkers with a black checker located in
   * the right most column
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
  public boolean rightBorderLogicForBlack(int[][] board, int row, int col, int selectedRow,
      int selectedCol) {
    if (row == (selectedRow - 2) && col == (selectedCol - 2) && isTargetCellFree(board[row][col])
        && isNextCellWhiteChecker(board[selectedRow - 1][selectedCol - 1] )) {
      Board.killChecker(selectedRow - 1, selectedCol - 1);
      Board.checkBlackVictory();
      lastRowPosition = row;
      lastColPosition = col;
      Board.setCanDoNextMove(isCanDoNextMoveValid(board, row, col));

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

  /**
   * Changes the order of the player's turn
   */
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

  /**
   * Checks whether it is permissible to make the next move for the checker in this position
   *
   * @param board       playing field
   * @param row         the position of the cell row of the field where the checker has moved the
   *                    checker and from where he plans to eat another opponent's checker
   * @param col         the position of the column of the field cell where the checker has moved the
   *                    checker and from where he plans to eat another opponent's checker
   * @return true if the checker can make another move and eat the opponent's checker and false if
   * she can't
   */
  public boolean isCanDoNextMoveValid(int[][] board, int row, int col) {

    if (col <= 1 && row > 1 || col >= 6 && row < 6) {

      if (checkerMove == WHITE_CHECKER) {
        if (col < 1 && isTargetCellFree(board[row+2][col+2])&& isNextCellBlackChecker(board[row + 1][col + 1])) {
          return true;
        } else if (col > 6 && isTargetCellFree(board[row+2][col-2])
            && isNextCellBlackChecker(board[row + 1][col - 1])) {
          return true;
        }
      }
      if (checkerMove == BLACK_CHECKER) {
        if (col < 1 && isTargetCellFree(board[row -2][col+2])  && isNextCellWhiteChecker(board[row - 1][col + 1])) {
          return true;
        } else if (col > 6 && isTargetCellFree(board[row-2][col-2])
            && isNextCellWhiteChecker(board[row - 1][col - 1])) {
          return true;
        }
      }
    }
    if (row < 6 && row > 1 && col < 6 && col > 1) {

      if (checkerMove == WHITE_CHECKER) {
        if (isTargetCellFree(board[row+2][col+2]) && isNextCellBlackChecker(board[row + 1][col + 1])
            || isTargetCellFree(board[row+2][col-2]) && isNextCellBlackChecker(board[row + 1][col - 1])) {
          return true;

        }
      }
      if (checkerMove == BLACK_CHECKER) {
        if (isTargetCellFree(board[row - 2][col+2]) && isNextCellWhiteChecker(board[row - 1][col + 1])
            || isTargetCellFree(board[row-2][col-2]) && isNextCellWhiteChecker(board[row - 1][col - 1])) {
          return true;
        }
      }
    }

    return false;
  }

  private boolean isNextCellWhiteChecker(int nextCell){
    return nextCell == WHITE_CHECKER || nextCell == KingLogics.getKING_WHITE_CHECKER();
  }

  private boolean isNextCellBlackChecker(int nextCell){
    return nextCell == BLACK_CHECKER || nextCell == KingLogics.getKING_BLACK_CHECKER();
  }


  /**
   * Performs the check and transformation of an ordinary checker into a king's checker, provided
   * that it is in a certain position
   *
   * @param row the position of the row of the cell of the field where the king's checker turned out
   *            to be after moving or eating the opponent's checkers
   * @param col the position of the column of the cell of the field where the king's checker turned
   *            out to be after moving or eating the opponent's checkers
   */
  public void isKing(int row, int col) {
    if (checkerMove == WHITE_CHECKER && row == 7) {
      Board.setKing(row, col);
    } else if (row == 0) {
      Board.setKing(row, col);
    }
  }

  public static int getWhiteChecker() {
    return WHITE_CHECKER;
  }

  public static int getBlackChecker() {
    return BLACK_CHECKER;
  }

}
