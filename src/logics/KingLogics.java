package logics;

import graphics.code.Board;

public class KingLogics implements MovementLogics {

  private final int KING_WHITE_CHECKER = 3;
  private final int KING_BLACK_CHECKER = 4;

  PlayerLogics playerLogics = new PlayerLogics();

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
            == playerLogics.getBLACKCHECKER()
            || board[selectedRow + (different - 1)][selectedCol + (different - 1)]
            == KING_BLACK_CHECKER) && (board[row][col] == 0)) {
          Board.killChecker(
              selectedRow + (different - 1), selectedCol + (different - 1));
          playerLogics.checkWhiteVictory();
          return true;
        }
      } else {
        if ((board[selectedRow + 1][selectedCol + 1] == playerLogics.getBLACKCHECKER()
            || board[selectedRow + 1][selectedCol + 1] == KING_BLACK_CHECKER) && (board[row][col]
            == 0)) {
          Board.killChecker(selectedRow + 1, selectedCol + 1);
          playerLogics.checkWhiteVictory();
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
            == playerLogics.getWHITECHECKER()
            || board[selectedRow + (different - 1)][selectedCol + (different - 1)]
            == KING_WHITE_CHECKER) && (board[row][col] == 0)) {
          Board.killChecker(
              selectedRow + (different - 1), selectedCol + (different - 1));
          playerLogics.checkBlackVictory();
          return true;
        }
      } else {
        if ((board[selectedRow + 1][selectedCol + 1] == playerLogics.getWHITECHECKER()
            || board[selectedRow + 1][selectedCol + 1] == KING_WHITE_CHECKER) && (board[row][col]
            == 0)) {
          Board.killChecker(selectedRow + 1, selectedCol + 1);
          playerLogics.checkBlackVictory();
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
            == playerLogics.getBLACKCHECKER()
            || board[selectedRow + (different - 1)][selectedCol - (different - 1)]
            == KING_BLACK_CHECKER) && (board[row][col] == 0)) {
          Board.killChecker(
              selectedRow + (different - 1), selectedCol - (different - 1));
          playerLogics.checkWhiteVictory();
          return true;
        }
      } else {
        if ((board[selectedRow + 1][selectedCol - 1] == playerLogics.getBLACKCHECKER()
            || board[selectedRow + 1][selectedCol - 1] == KING_BLACK_CHECKER) && (board[row][col]
            == 0)) {
          Board.killChecker(selectedRow + 1, selectedCol - 1);
          playerLogics.checkWhiteVictory();
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
        if ((board[selectedRow + 1][selectedCol - 1] == playerLogics.getWHITECHECKER()
            || board[selectedRow + 1][selectedCol - 1] == KING_WHITE_CHECKER) && (board[row][col]
            == 0)) {
          Board.killChecker(
              selectedRow + 1, selectedCol - 1);
          playerLogics.checkBlackVictory();
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
            == playerLogics.getBLACKCHECKER()
            || board[selectedRow - (different - 1)][selectedCol + (different - 1)]
            == KING_BLACK_CHECKER) && (board[row][col] == 0)) {
          Board.killChecker(
              selectedRow - (different - 1), selectedCol + (different - 1));
          playerLogics.checkWhiteVictory();
          return true;
        }
      } else {
        if ((board[selectedRow - 1][selectedCol + 1] == playerLogics.getBLACKCHECKER()
            || board[selectedRow - 1][selectedCol + 1] == KING_BLACK_CHECKER) && (board[row][col]
            == 0)) {
          Board.killChecker(
              selectedRow - 1, selectedCol + 1);
          playerLogics.checkWhiteVictory();
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
            == playerLogics.getWHITECHECKER()
            || board[selectedRow - (different - 1)][selectedCol + (different - 1)]
            == KING_WHITE_CHECKER) && (board[row][col] == 0)) {
          Board.killChecker(
              selectedRow - (different - 1), selectedCol + (different - 1));
          playerLogics.checkBlackVictory();
          return true;
        }
      } else {
        if ((board[selectedRow - 1][selectedCol + 1] == playerLogics.getWHITECHECKER()
            || board[selectedRow - 1][selectedCol + 1] == KING_WHITE_CHECKER) && (board[row][col]
            == 0)) {
          Board.killChecker(
              selectedRow - 1, selectedCol + 1);
          playerLogics.checkBlackVictory();
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
            == playerLogics.getBLACKCHECKER()
            || board[selectedRow - (different - 1)][selectedCol - (different - 1)]
            == KING_BLACK_CHECKER) && (board[row][col] == 0)) {
          Board.killChecker(
              selectedRow - (different - 1), selectedCol - (different - 1));
          playerLogics.checkWhiteVictory();
          return true;
        }
      } else {
        if ((board[selectedRow - 1][selectedCol - 1] == playerLogics.getBLACKCHECKER()
            || board[selectedRow - 1][selectedCol - 1] == KING_BLACK_CHECKER) && (board[row][col]
            == 0)) {
          Board.killChecker(
              selectedRow - 1, selectedCol - 1);
          playerLogics.checkWhiteVictory();
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
            == playerLogics.getWHITECHECKER()
            || board[selectedRow - (different - 1)][selectedCol - (different - 1)]
            == KING_WHITE_CHECKER) && (board[row][col] == 0)) {
          Board.killChecker(
              selectedRow - (different - 1), selectedCol - (different - 1));
          playerLogics.checkWhiteVictory();
          return true;
        }
      } else {
        if ((board[selectedRow - 1][selectedCol - 1] == playerLogics.getWHITECHECKER()
            || board[selectedRow - 1][selectedCol - 1] == KING_WHITE_CHECKER) && (board[row][col]
            == 0)) {
          Board.killChecker(
              selectedRow - 1, selectedCol - 1);
          playerLogics.checkWhiteVictory();
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

  public int getKING_WHITE_CHECKER() {
    return KING_WHITE_CHECKER;
  }

  public int getKING_BLACK_CHECKER() {
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
