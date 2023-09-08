package logics;

import graphics.code.Board;

public class KingLogics {

  private static final int KING_WHITE_CHECKER = 3;
  private static final int KING_BLACK_CHECKER = 4;

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
    int currentRow = selectedRow + rowStep;
    int currentCol = selectedCol + colStep;

    if (differentRow == 1) {
      if (board[currentRow][currentCol] != 0) {
        return false;
      } else {
        return true;
      }
    }

    if (differentRow == 2) {
      if (board[currentRow][currentCol] != 0) {
        return canKill(board, row, col, selectedRow, selectedCol, currentRow, currentCol, rowStep,
            colStep, differentRow);
      }
      return true;
    }

    if (differentRow > 2) {
      boolean choiceMoveOrKill = choiceMoveOrKill(currentRow, currentCol, row, col, rowStep,
          colStep, board, selectedRow, selectedCol, differentRow);
    }
    return false;
  }

  public boolean canKill(int[][] board, int row, int col, int selectedRow, int selectedCol,
      int currentRow, int currentCol, int rowStep, int colStep, int differentRow) {
    if (board[selectedRow][selectedCol] == 3) {
      if (board[currentRow][currentCol] == 1 || board[currentRow][currentCol] == 3) {
        return false;
      } else {
        Board.killChecker(currentRow, currentCol);
        Board.checkWhiteVictory();
        return true;
      }
    } else if (board[selectedRow][selectedCol] == 4) {
      if (board[currentRow][currentCol] == 2 || board[currentRow][currentCol] == 4) {
        return false;
      } else {
        Board.killChecker(currentRow, currentCol);
        Board.checkBlackVictory();
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

  public boolean choiceMoveOrKill(int currentRow, int currentCol, int row, int col, int rowStep,
      int colStep, int[][] board, int selectedRow, int selectedCol, int differentRow) {
    while ((currentRow <= row - rowStep) && (currentCol <= col - colStep)) {
      if (board[currentRow][currentCol] == 0) {
        currentRow++;
        currentCol++;
      }
      if ((currentRow == row - rowStep) && (currentCol == col - colStep)) {
        if (board[currentRow][currentCol] == 0) {
          return true;
        } else {
          return canKill(board, row, col, selectedRow, selectedCol, currentRow, currentCol, rowStep,
              colStep, differentRow);
        }
      }
    }
    return false;
  }
}
