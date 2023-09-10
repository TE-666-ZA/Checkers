package logics;

import graphics.code.Board;

public class KingLogics {

  private static final int KING_WHITE_CHECKER = 3;
  private static final int KING_BLACK_CHECKER = 4;

  /**
   * Checking the possibility of movement of the king's checkers
   *
   * @param board       playing field
   * @param row         the position of the row of the cell of the field where we want to move the
   *                    king's checker
   * @param col         the position of the column of the cell of the field where we want to move
   *                    the king's checker
   * @param selectedRow the position of the row of the cell of the field from where we want to move
   *                    the king's checker
   * @param selectedCol the position of the column of the cell of the field from where we want to
   *                    move the king's checker
   * @return true if the king's checker can be moved, and false if the king's checker cannot be
   * moved
   */
  public boolean isMoveValid(int[][] board, int row, int col, int selectedRow, int selectedCol) {
    int differentRow = differentRow(selectedRow, row);
    int differentCol = differentCol(selectedCol, col);

    if (!isDifferentRowAndCol(differentRow, differentCol)) {
      return false;
    }

    if (board[row][col] != 0) {
      return false;
    }

    int rowStep = rowStep(selectedRow, row);
    int colStep = colStep(selectedCol, col);

    if (differentRow == 1) {
      if (board[row][col] != 0) {
        return false;
      } else {
        return true;
      }
    }

    if (differentRow == 2) {
      if (board[selectedRow + rowStep][selectedCol + colStep] != 0) {
        return canKill(board, row, col, selectedRow, selectedCol, rowStep, colStep);
      }
      return true;
    }

    if (differentRow > 2) {
      return choiceMoveOrKill(row, col, rowStep, colStep, board, selectedRow, selectedCol,
          differentRow);
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
   * @param selectedRow the position of the row of the cell of the field where the king's checker
   *                    with which we want to eat the opponent's checker is located
   * @param selectedCol the position of the column of the cell of the field where the king's checker
   *                    with which we want to eat the opponent's checker is located
   * @param rowStep     step to change the string
   * @param colStep     step to change the column
   * @return true if the king's checker can eat the opponent's checker, and false if it can't
   */
  public boolean canKill(int[][] board, int row, int col, int selectedRow, int selectedCol,
      int rowStep, int colStep) {
    if (board[selectedRow][selectedCol] == 3) {
      if (board[row - rowStep][col - colStep] == 1 || board[row - rowStep][col - colStep] == 3) {
        return false;
      } else {
        Board.killChecker(row - rowStep, col - colStep);
        Board.checkWhiteVictory();
        PlayerLogics.canDoNextMove = isCanDoNextMoveValid(board, row, col);
        return true;
      }
    } else if (board[selectedRow][selectedCol] == 4) {
      if (board[row - rowStep][col - colStep] == 2 || board[row - rowStep][col - colStep] == 4) {
        return false;
      } else {
        Board.killChecker(row - rowStep, col - colStep);
        Board.checkBlackVictory();
        PlayerLogics.canDoNextMove = isCanDoNextMoveValid(board, row, col);
        return true;
      }
    }
    return false;
  }

  public static int getKING_WHITE_CHECKER() {
    return KING_WHITE_CHECKER;
  }

  public static int getKING_BLACK_CHECKER() {
    return KING_BLACK_CHECKER;
  }

  /**
   * Calculates and returns the absolute difference between the values of the initial value of the
   * string and the final value
   *
   * @param selectedRow the starting position of the row of the field cell where the king's checker
   *                    is located
   * @param row         the final position of the row of the field cell where the king's checker
   *                    plans to be
   * @return the absolute difference between the initial value of the cell row of the field and the
   * final value
   */
  public int differentRow(int selectedRow, int row) {
    int differentRow = Math.abs(row - selectedRow);
    return differentRow;
  }

  /**
   * Calculates and returns the absolute difference between the values of the initial value of the
   * string and the final value
   *
   * @param selectedCol the starting position of the column of the field cell where the king's
   *                    checker is located
   * @param col         the final position of the column of the field cell where the king's checker
   *                    plans to be
   * @return the absolute difference between the initial value of the cell column of the field and
   * the final value
   */
  public int differentCol(int selectedCol, int col) {
    int differentCol = Math.abs(col - selectedCol);
    return differentCol;
  }

  /**
   * Checks whether the values of the difference between rows and the difference between columns are
   * equal
   *
   * @param differentRow the difference between the initial value of the row and the final one
   * @param differentCol the difference between the initial value of the column and the final one
   * @return true if the values are equal, and false if they differ
   */
  public boolean isDifferentRowAndCol(int differentRow, int differentCol) {
    return differentRow == differentCol;
  }

  /**
   * Calculates and returns a "step" (1 or -1), which indicates the direction of the king checker's
   * movement
   *
   * @param selectedRow the starting position of the row of the field cell where the king's checker
   *                    is located
   * @param row         the final position of the row of the field cell where the king's checker
   *                    plans to be
   * @return returns step 1 if the movement is in the positive direction and step -1 if in the
   * negative
   */
  public int rowStep(int selectedRow, int row) {
    int rowStep = (row - selectedRow) > 0 ? 1 : -1;
    return rowStep;
  }

  /**
   * Calculates and returns a "step" (1 or -1), which indicates the direction of the king checker's
   * movement
   *
   * @param selectedCol the starting position of the column of the field cell where the king's
   *                    checker is located
   * @param col         the final position of the column of the field cell where the king's checker
   *                    plans to be
   * @return returns step 1 if the movement is in the positive direction and step -1 if in the
   * negative
   */
  public int colStep(int selectedCol, int col) {
    int colStep = (col - selectedCol) > 0 ? 1 : -1;
    return colStep;
  }

  /**
   * Сhecks whether the player can make a move or a hit in the game
   *
   * @param row          the position of the row of the field cell where we want to move the king's
   *                     checker or where the king's checker will come after eating the opponent's
   *                     checkers
   * @param col          the position of the column of the field cell where we want to move the
   *                     king's checker or where the king's checker will come after eating the
   *                     opponent's checkers
   * @param rowStep      the king checker's move down or up the line by one position
   * @param colStep      the king checker's move along the column to the left or right by one
   *                     position
   * @param board        playing field
   * @param selectedRow  the position of the row of the field cell from where we want to move the
   *                     king's checker or from where the king's checker can eat the opponent's
   *                     checker
   * @param selectedCol  the position of the column of the field cell from where we want to move the
   *                     king's checker or from where the king's checker can eat the opponent's
   *                     checker
   * @param differentRow the absolute difference between the initial value of the cell row of the
   *                     field and the final value
   * @return true if it can move or eat the opponent and false if it can't
   */
  public boolean choiceMoveOrKill(int row, int col, int rowStep, int colStep, int[][] board,
      int selectedRow, int selectedCol, int differentRow) {
    int current = 1;
    if (rowStep == 1 && colStep == 1) {
      while (current < differentRow - 1) {
        if (board[selectedRow + current][selectedCol + current] != 0) {
          return false;
        } else {
          current++;
        }
      }
    }

    if (rowStep == 1 && colStep == -1) {
      while (current < differentRow - 1) {
        if (board[selectedRow + current][selectedCol - current] != 0) {
          return false;
        } else {
          current++;
        }
      }
    }

    if (rowStep == -1 && colStep == 1) {
      while (current < differentRow - 1) {
        if (board[selectedRow - current][selectedCol + current] != 0) {
          return false;
        } else {
          current++;
        }
      }
    }

    if (rowStep == -1 && colStep == -1) {
      while (current < differentRow - 1) {
        if (board[selectedRow - current][selectedCol - current] != 0) {
          return false;
        } else {
          current++;
        }
      }
    }

    if (board[row - rowStep][col - colStep] == 0) {
      return true;
    } else {
      return canKill(board, row, col, selectedRow, selectedCol, rowStep, colStep);
    }
  }

  /**
   * Checks whether it is permissible to make the next move for the king's checker in this position
   *
   * @param board playing field
   * @param row   the position of the cell row of the field where the king's checker has moved the
   *              checker and from where he plans to eat another opponent's checker
   * @param col   the position of the column of the field cell where the king's checker has moved
   *              the checker and from where he plans to eat another opponent's checker
   * @return true if the king's checker can make another move and eat the opponent's checker and
   * false if she can't
   */
  public boolean isCanDoNextMoveValid(int[][] board, int row, int col) {
    if (board[row][col] == 3) {
      if ((row + 2) <= 7 && (col + 2) <= 7 && board[row + 2][col + 2] == 0 && (
          board[row + 1][col + 1] == 2 || board[row + 1][col + 1] == 4)) {
        return true;
      } else if ((row + 2) <= 7 && (col - 2) >= 0 && board[row + 2][col - 2] == 0 && (
          board[row + 1][col - 1] == 2 || board[row + 1][col - 1] == 4)) {
        return true;
      } else if ((row - 2) >= 0 && (col + 2) <= 7 && board[row - 2][col + 2] == 0 && (
          board[row - 1][col + 1] == 2 || board[row - 1][col + 1] == 4)) {
        return true;
      } else if ((row - 2) >= 0 && (col - 2) >= 0 && board[row - 2][col - 2] == 0 && (
          board[row - 1][col - 1] == 2 || board[row - 1][col - 1] == 4)) {
        return true;
      }
    }
    if (board[row][col] == 4) {
      if ((row + 2) <= 7 && (col + 2) <= 7 && board[row + 2][col + 2] == 0 && (
          board[row + 1][col + 1] == 1 || board[row + 1][col + 1] == 3)) {
        return true;
      } else if ((row + 2) <= 7 && (col - 2) >= 0 && board[row + 2][col - 2] == 0 && (
          board[row + 1][col - 1] == 1 || board[row + 1][col - 1] == 3)) {
        return true;
      } else if ((row - 2) >= 0 && (col + 2) <= 7 && board[row - 2][col + 2] == 0 && (
          board[row - 1][col + 1] == 1 || board[row - 1][col + 1] == 3)) {
        return true;
      } else if ((row - 2) >= 0 && (col - 2) >= 0 && board[row - 2][col - 2] == 0 && (
          board[row - 1][col - 1] == 1 || board[row - 1][col - 1] == 3)) {
        return true;
      }
    }
    return false;
  }
}
