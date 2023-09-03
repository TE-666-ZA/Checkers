package logics;

import graphics.code.Board;

public class KingLogics implements MovementLogics {

  private static final int KING_WHITE_CHECKER = 3;
  private static final int KING_BLACK_CHECKER = 4;
  
  @Override
  public boolean isMoveValid(int[][] board, int row, int col, int selectedRow, int selectedCol) {
    int differentRow = Math.abs(row - selectedRow);
    int differentCol = Math.abs(col - selectedCol);
    if (differentCol != differentRow) {
      return false;

    } else {
      int rowStep = (row - selectedRow) > 0 ? 1 : -1;
      int colStep = (col - selectedCol) > 0 ? 1 : -1;
      int currentRow = selectedRow + rowStep;
      int currentCol = selectedCol + colStep;

      while (currentRow != row && currentCol != col) {
        if (board[currentRow][currentCol] != 0) {
          return false;
        }
        if (rowStep > 0) {
          currentRow++;
        } else {
          currentRow--;
        }
        if (colStep > 0) {
          currentCol++;
        } else {
          currentCol++;
        }
      }
      return true;
    }
  }

  @Override
  public boolean canKill(int[][] board, int row, int col, int selectedRow, int selectedCol) {
    if ((board[selectedRow][selectedCol] == 3) && (moveDownAndRight(selectedRow, selectedCol, row,
        col))) {
      int different = row - selectedRow;
      if (different > 2) {
        int current = 1;
        while (current < different - 1) {
          if (board[selectedRow + current][selectedCol + current] == 0) {
            current++;
          } else {
            return false;
          }
        }
        if ((board[selectedRow + (different - 1)][selectedCol + (different - 1)]
            == PlayerLogics.getBlackchecker()
            || board[selectedRow + (different - 1)][selectedCol + (different - 1)]
            == KING_BLACK_CHECKER) && (board[row][col] == 0)) {
          Board.killChecker(
              selectedRow + (different - 1), selectedCol + (different - 1));
          Board.checkWhiteVictory();
          return true;
        }
      } else {
        if ((board[selectedRow + 1][selectedCol + 1] == PlayerLogics.getBlackchecker()
            || board[selectedRow + 1][selectedCol + 1] == KING_BLACK_CHECKER) && (board[row][col]
            == 0)) {
          Board.killChecker(selectedRow + 1, selectedCol + 1);
          Board.checkWhiteVictory();
          return true;
        }
      }

    } else if ((board[selectedRow][selectedCol] == 4) && (moveDownAndRight(selectedRow, selectedCol,
        row, col))) {
      int different = row - selectedRow;
      if (different > 2) {
        int current = 1;
        while (current < different - 1) {
          if (board[selectedRow + current][selectedCol + current] == 0) {
            current++;
          } else {
            return false;
          }
        }
        if ((board[selectedRow + (different - 1)][selectedCol + (different - 1)]
            == PlayerLogics.getWhitechecker()
            || board[selectedRow + (different - 1)][selectedCol + (different - 1)]
            == KING_WHITE_CHECKER) && (board[row][col] == 0)) {
          Board.killChecker(
              selectedRow + (different - 1), selectedCol + (different - 1));
          Board.checkBlackVictory();
          return true;
        }
      } else {
        if ((board[selectedRow + 1][selectedCol + 1] == PlayerLogics.getWhitechecker()
            || board[selectedRow + 1][selectedCol + 1] == KING_WHITE_CHECKER) && (board[row][col]
            == 0)) {
          Board.killChecker(selectedRow + 1, selectedCol + 1);
          Board.checkBlackVictory();
          return true;
        }
      }

    } else if ((board[selectedRow][selectedCol] == 3) && (moveDownAndLeft(selectedRow, selectedCol,
        row, col))) {
      int different = row - selectedRow;
      if (different > 2) {
        int current = 1;
        while (current < different - 1) {
          if (board[selectedRow + current][selectedCol - current] == 0) {
            current++;
          } else {
            return false;
          }
        }
        if ((board[selectedRow + (different - 1)][selectedCol - (different - 1)]
            == PlayerLogics.getBlackchecker()
            || board[selectedRow + (different - 1)][selectedCol - (different - 1)]
            == KING_BLACK_CHECKER) && (board[row][col] == 0)) {
          Board.killChecker(
              selectedRow + (different - 1), selectedCol - (different - 1));
          Board.checkWhiteVictory();
          return true;
        }
      } else {
        if ((board[selectedRow + 1][selectedCol - 1] == PlayerLogics.getBlackchecker()
            || board[selectedRow + 1][selectedCol - 1] == KING_BLACK_CHECKER) && (board[row][col]
            == 0)) {
          Board.killChecker(selectedRow + 1, selectedCol - 1);
          Board.checkWhiteVictory();
          return true;
        }
      }

    } else if (((board[selectedRow][selectedCol] == 4) && (moveDownAndLeft(selectedRow, selectedCol,
        row, col)))) {
      int different = row - selectedRow;
      if (different > 2) {
        int current = 1;
        while (current < different - 1) {
          if (board[selectedRow + current][selectedCol - current] == 0) {
            current++;
          } else {
            return false;
          }
        }
        if ((board[selectedRow + 1][selectedCol - 1] == PlayerLogics.getWhitechecker()
            || board[selectedRow + 1][selectedCol - 1] == KING_WHITE_CHECKER) && (board[row][col]
            == 0)) {
          Board.killChecker(
              selectedRow + 1, selectedCol - 1);
          Board.checkBlackVictory();
          return true;
        }
      }

    } else if (((board[selectedRow][selectedCol] == 3) && (moveUpAndRight(selectedRow, selectedCol,
        row, col)))) {
      int different = col - selectedCol;
      if (different > 2) {
        int current = 1;
        while (current < different - 1) {
          if (board[selectedRow - current][selectedCol + current] == 0) {
            current++;
          } else {
            return false;
          }
        }
        if ((board[selectedRow - (different - 1)][selectedCol + (different - 1)]
            == PlayerLogics.getBlackchecker()
            || board[selectedRow - (different - 1)][selectedCol + (different - 1)]
            == KING_BLACK_CHECKER) && (board[row][col] == 0)) {
          Board.killChecker(
              selectedRow - (different - 1), selectedCol + (different - 1));
          Board.checkWhiteVictory();
          return true;
        }
      } else {
        if ((board[selectedRow - 1][selectedCol + 1] == PlayerLogics.getBlackchecker()
            || board[selectedRow - 1][selectedCol + 1] == KING_BLACK_CHECKER) && (board[row][col]
            == 0)) {
          Board.killChecker(
              selectedRow - 1, selectedCol + 1);
          Board.checkWhiteVictory();
          return true;
        }
      }

    } else if (((board[selectedRow][selectedCol] == 4) && (moveUpAndRight(selectedRow, selectedCol,
        row, col)))) {
      int different = col - selectedCol;
      if (different > 2) {
        int current = 1;
        while (current < different - 1) {
          if (board[selectedRow - current][selectedCol + current] == 0) {
            current++;
          } else {
            return false;
          }
        }
        if ((board[selectedRow - (different - 1)][selectedCol + (different - 1)]
            == PlayerLogics.getWhitechecker()
            || board[selectedRow - (different - 1)][selectedCol + (different - 1)]
            == KING_WHITE_CHECKER) && (board[row][col] == 0)) {
          Board.killChecker(
              selectedRow - (different - 1), selectedCol + (different - 1));
          Board.checkBlackVictory();
          return true;
        }
      } else {
        if ((board[selectedRow - 1][selectedCol + 1] == PlayerLogics.getWhitechecker()
            || board[selectedRow - 1][selectedCol + 1] == KING_WHITE_CHECKER) && (board[row][col]
            == 0)) {
          Board.killChecker(
              selectedRow - 1, selectedCol + 1);
          Board.checkBlackVictory();
          return true;
        }
      }

    } else if ((((board[selectedRow][selectedCol] == 3) && (moveUpAndLeft(selectedRow, selectedCol,
        row, col))))) {
      int different = Math.abs(row - selectedRow);
      if (different > 2) {
        int current = 1;
        while (current < different - 1) {
          if (board[selectedRow - current][selectedCol - current] == 0) {
            current++;
          } else {
            return false;
          }
        }
        if ((board[selectedRow - (different - 1)][selectedCol - (different - 1)]
            == PlayerLogics.getBlackchecker()
            || board[selectedRow - (different - 1)][selectedCol - (different - 1)]
            == KING_BLACK_CHECKER) && (board[row][col] == 0)) {
          Board.killChecker(
              selectedRow - (different - 1), selectedCol - (different - 1));
          Board.checkWhiteVictory();
          return true;
        }
      } else {
        if ((board[selectedRow - 1][selectedCol - 1] == PlayerLogics.getBlackchecker()
            || board[selectedRow - 1][selectedCol - 1] == KING_BLACK_CHECKER) && (board[row][col]
            == 0)) {
          Board.killChecker(
              selectedRow - 1, selectedCol - 1);
          Board.checkWhiteVictory();
          return true;
        }
      }

    } else if ((((board[selectedRow][selectedCol] == 4) && (moveUpAndLeft(selectedRow, selectedCol,
        row, col))))) {
      int different = Math.abs(row - selectedRow);
      if (different > 2) {
        int current = 1;
        while (current < different - 1) {
          if (board[selectedRow - current][selectedCol - current] == 0) {
            current++;
          } else {
            return false;
          }
        }
        if ((board[selectedRow - (different - 1)][selectedCol - (different - 1)]
            == PlayerLogics.getWhitechecker()
            || board[selectedRow - (different - 1)][selectedCol - (different - 1)]
            == KING_WHITE_CHECKER) && (board[row][col] == 0)) {
          Board.killChecker(
              selectedRow - (different - 1), selectedCol - (different - 1));
          Board.checkWhiteVictory();
          return true;
        }
      } else {
        if ((board[selectedRow - 1][selectedCol - 1] == PlayerLogics.getWhitechecker()
            || board[selectedRow - 1][selectedCol - 1] == KING_WHITE_CHECKER) && (board[row][col]
            == 0)) {
          Board.killChecker(
              selectedRow - 1, selectedCol - 1);
          Board.checkWhiteVictory();
          return true;
        }
      }
    }
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
  public boolean isTargetCellFree(int targetCell) {
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

  public static int getKING_WHITE_CHECKER() {
    return KING_WHITE_CHECKER;
  }

  public static int getKING_BLACK_CHECKER() {
    return KING_BLACK_CHECKER;
  }

  public boolean moveDownAndRight(int selectedRow, int selectedCol, int row, int col) {
    return (row > selectedRow && col > selectedCol);
  }

  public boolean moveDownAndLeft(int selectedRow, int selectedCol, int row, int col) {
    return (row > selectedRow && col < selectedCol);
  }

  public boolean moveUpAndRight(int selectedRow, int selectedCol, int row, int col) {
    return (row < selectedRow && col > selectedCol);
  }

  public boolean moveUpAndLeft(int selectedRow, int selectedCol, int row, int col) {
    return (row < selectedRow && col < selectedCol);
  }
}
