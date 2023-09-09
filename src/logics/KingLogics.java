package logics;

import graphics.code.Board;

public class KingLogics {

  private static final int KING_WHITE_CHECKER = 3;
  private static final int KING_BLACK_CHECKER = 4;
  public static boolean canDoNextMove = false;

  public boolean isMoveValid(int[][] board, int row, int col, int selectedRow, int selectedCol) {
    int differentRow = differentRow(selectedRow, selectedCol, row, col);
    int differentCol = differentCol(selectedRow, selectedCol, row, col);

    if (!isDifferentRowAndCol(differentRow, differentCol)) {
      return false;
    }

    if (board[row][col] != 0) {
      return false;
    }

    int rowStep = rowStep(selectedRow, row);
    int colStep = colStep(selectedCol, col);

    if (canDoNextMove) {
      return canKill(board, row, col, selectedRow, selectedCol, rowStep, colStep);
    }

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

    return false;
  }

  public boolean canKill(int[][] board, int row, int col, int selectedRow, int selectedCol,
      int rowStep, int colStep) {
    if (board[selectedRow][selectedCol] == 3) {
      if (board[row - rowStep][col - colStep] == 1 || board[row - rowStep][col - colStep] == 3) {
        return false;
      } else {
        Board.killChecker(row - rowStep, col - colStep);
        Board.checkWhiteVictory();
        canDoNextMove = isCanDoNextMoveValid(board, row, col);
        return true;
      }
    } else if (board[selectedRow][selectedCol] == 4) {
      if (board[row - rowStep][col - colStep] == 2 || board[row - rowStep][col - colStep] == 4) {
        return false;
      } else {
        Board.killChecker(row - rowStep, col - colStep);
        Board.checkBlackVictory();
        canDoNextMove = isCanDoNextMoveValid(board, row, col);
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

  public int differentRow(int selectedRow, int selectedCol, int row, int col) {
    int differentRow = Math.abs(row - selectedRow);
    return differentRow;
  }

  public int differentCol(int selectedRow, int selectedCol, int row, int col) {
    int differentCol = Math.abs(col - selectedCol);
    return differentCol;
  }

  public boolean isDifferentRowAndCol(int differentRow, int differentCol) {
    return differentRow == differentCol;
  }

  public int rowStep(int selectedRow, int row) {
    int rowStep = (row - selectedRow) > 0 ? 1 : -1;
    return rowStep;
  }

  public int colStep(int selectedCol, int col) {
    int colStep = (col - selectedCol) > 0 ? 1 : -1;
    return colStep;
  }

  public boolean choiceMoveOrKill(int row, int col, int rowStep, int colStep, int[][] board,
      int selectedRow, int selectedCol, int differentRow) {
    int current = 1;
    while (current < differentRow - 1) {
      if (board[selectedRow + rowStep][selectedCol + colStep] != 0) {
        return false;
      } else {
        rowStep++;
        colStep++;
        current++;
      }
    }
    rowStep = rowStep(selectedRow, row);
    colStep = colStep(selectedCol, col);
    if (board[row - rowStep][col - colStep] == 0) {
      return true;
    } else {
      return canKill(board, row, col, selectedRow, selectedCol, rowStep, colStep);
    }
  }

  public boolean isCanDoNextMoveValid(int[][] board, int row, int col) {
//    if (board[row + 2][col + 2] != 0 || board[row + 2][col - 2] != 0
//        || board[row - 2][col + 2] != 0 || board[row - 2][col - 2] != 0) {
//      return false;
//    }

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

