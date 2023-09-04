package logics;

import graphics.code.Board;

public class KingLogics implements MovementLogics {

  private static final int KING_WHITE_CHECKER = 3;
  private static final int KING_BLACK_CHECKER = 4;
  private int current = 1;

  @Override
  public boolean isMoveValid(int[][] board, int row, int col, int selectedRow, int selectedCol) {
    int differentRow = differentRow(selectedRow, selectedCol, row, col);
    int differentCol = differentCol(selectedRow, selectedCol, row, col);

    if (!isDifferentRowAndCol(differentRow, differentCol)) {
      return false;
    }

    int rowStep = rowStep(selectedRow, row);
    int colStep = colStep(selectedCol, col);
    int currentRow = selectedRow + rowStep;
    int currentCol = selectedCol + colStep;

//    int ourChecker = board[selectedRow][selectedCol];

    if (differentRow == 1) {
      if (board[currentRow][currentCol] != 0) {
        return false;
      } else {
        return true;
      }
    }
    if (differentRow == 2) {
      if (board[currentRow + rowStep][currentCol + colStep] != 0) {
        return false;
      }
      if ((board[selectedRow][selectedCol] == 3)) {
        if ((board[currentRow][currentCol] == 2) || (board[currentRow][currentCol] == 4)) {
          return canKill(board, row, col, selectedRow, selectedCol);
        }
        if ((board[currentRow][currentCol] == 1) || (board[currentRow][currentCol] == 3)) {
          return false;
        }
      } else if ((board[selectedRow][selectedCol] == 4)) {
        if ((board[currentRow][currentCol] == 1) || (board[currentRow][currentCol] == 3)) {
          return canKill(board, row, col, selectedRow, selectedCol);
        }
        if ((board[currentRow][currentCol] == 2) || (board[currentRow][currentCol] == 4)) {
          return false;
        }
      }
      return true;
    }

    if (differentRow > 2) {
      if (moveDownAndRight(selectedRow, selectedCol, row, col)) {
        while (current <= differentRow) {
          if (board[selectedRow + current][selectedCol + current] == 0) {
            current++;
            return true;
          } else {
            return canKill(board, row, col, selectedRow, selectedCol);
          }
        }
        current = 1;
      }
      if (moveDownAndLeft(selectedRow, selectedCol, row, col)) {
        while (current <= differentRow) {
          if (board[selectedRow + current][selectedCol - current] == 0) {
            current++;
            return true;
          } else {
            return canKill(board, row, col, selectedRow, selectedCol);
          }
        }
        current = 1;
      }
      if (moveUpAndRight(selectedRow, selectedCol, row, col)) {
        while (current <= differentRow) {
          if (board[selectedRow - current][selectedCol + current] == 0) {
            current++;
            return true;
          } else {
            return canKill(board, row, col, selectedRow, selectedCol);
          }
        }
        current = 1;
      }
      if (moveUpAndLeft(selectedRow, selectedCol, row, col)) {
        while (current <= differentRow) {
          if (board[selectedRow - current][selectedCol - current] == 0) {
            current++;
            return true;
          } else {
            return canKill(board, row, col, selectedRow, selectedCol);
          }
        }
        current = 1;
      }
    }
    return canKill(board, row, col, selectedRow, selectedCol);
  }

  public boolean canKill(int[][] board, int row, int col, int selectedRow, int selectedCol) {
    if ((board[selectedRow][selectedCol] == 3) && (moveDownAndRight(selectedRow, selectedCol, row,
        col))) {
      int different = row - selectedRow;
      if (different > 2) {
        while (current < different - 1) {
          if (board[selectedRow + current][selectedCol + current] == 0) {
            current++;
          } else {
            return false;
          }
        }
        current = 1;
        if (board[selectedRow + different][selectedCol + different] != 0) {
          return false;
        }
        if (board[selectedRow + (different - 1)][selectedCol + (different - 1)] == 2
            || board[selectedRow + (different - 1)][selectedCol + (different - 1)] == 4) {
          Board.killChecker(
              selectedRow + (different - 1), selectedCol + (different - 1));
          Board.checkWhiteVictory();
          return true;
        }
        if (board[selectedRow + (different - 1)][selectedCol + (different - 1)] == 1
            || board[selectedRow + (different - 1)][selectedCol + (different - 1)] == 3) {
          return false;
        }
      } else {
        if (board[selectedRow + 2][selectedCol + 2] != 0) {
          return false;
        } else {
          if (board[selectedRow + 1][selectedCol + 1] == 2
              || board[selectedRow + 1][selectedCol + 1] == 4) {
            Board.killChecker(selectedRow + 1, selectedCol + 1);
            Board.checkWhiteVictory();
            return true;
          } else if (board[selectedRow + 1][selectedCol + 1] == 1
              || board[selectedRow + 1][selectedCol + 1] == 3) {
            return false;
          }
        }
      }

    } else if ((board[selectedRow][selectedCol] == 4) && (moveDownAndRight(selectedRow, selectedCol,
        row, col))) {
      int different = row - selectedRow;
      if (different > 2) {
        while (current < different - 1) {
          if (board[selectedRow + current][selectedCol + current] == 0) {
            current++;
          } else {
            return false;
          }
        }
        current = 1;
        if (board[selectedRow + different][selectedCol + different] != 0) {
          return false;
        }
        if (board[selectedRow + (different - 1)][selectedCol + (different - 1)] == 1
            || board[selectedRow + (different - 1)][selectedCol + (different - 1)]
            == 3) {
          Board.killChecker(
              selectedRow + (different - 1), selectedCol + (different - 1));
          Board.checkBlackVictory();
          return true;
        }
        if (board[selectedRow + (different - 1)][selectedCol + (different - 1)] == 2
            || board[selectedRow + (different - 1)][selectedCol + (different - 1)]
            == 4) {
          return false;
        }
      } else {
        if (board[selectedRow + 2][selectedCol + 2] != 0) {
          return false;
        } else {
          if (board[selectedRow + 1][selectedCol + 1] == 1
              || board[selectedRow + 1][selectedCol + 1] == 3) {
            Board.killChecker(selectedRow + 1, selectedCol + 1);
            Board.checkBlackVictory();
            return true;
          } else if (board[selectedRow + 1][selectedCol + 1] == 2
              || board[selectedRow + 1][selectedCol + 1] == 4) {
            return false;
          }
        }
      }

    } else if ((board[selectedRow][selectedCol] == 3) && (moveDownAndLeft(selectedRow, selectedCol,
        row, col))) {
      int different = row - selectedRow;
      if (different > 2) {
        while (current < different - 1) {
          if (board[selectedRow + current][selectedCol - current] == 0) {
            current++;
          } else {
            return false;
          }
        }
        current = 1;
        if (board[selectedRow + different][selectedCol - different] != 0) {
          return false;
        }
        if ((board[selectedRow + (different - 1)][selectedCol - (different - 1)] == 2
            || board[selectedRow + (different - 1)][selectedCol - (different - 1)] == 4)) {
          Board.killChecker(
              selectedRow + (different - 1), selectedCol - (different - 1));
          Board.checkWhiteVictory();
          return true;
        }
        if ((board[selectedRow + (different - 1)][selectedCol - (different - 1)] == 1
            || board[selectedRow + (different - 1)][selectedCol - (different - 1)] == 3)) {
          return false;
        }
      } else {
        if (board[selectedRow + 2][selectedCol - 2] != 0) {
          return false;
        } else {
          if ((board[selectedRow + 1][selectedCol - 1] == 2
              || board[selectedRow + 1][selectedCol - 1] == 4)) {
            Board.killChecker(selectedRow + 1, selectedCol - 1);
            Board.checkWhiteVictory();
            return true;
          } else if (board[selectedRow + 1][selectedCol - 1] == 1
              || board[selectedRow + 1][selectedCol - 1] == 3) {
            return false;
          }
        }
      }

    } else if (((board[selectedRow][selectedCol] == 4) && (moveDownAndLeft(selectedRow, selectedCol,
        row, col)))) {
      int different = row - selectedRow;
      if (different > 2) {
        while (current < different - 1) {
          if (board[selectedRow + current][selectedCol - current] == 0) {
            current++;
          } else {
            return false;
          }
        }
        current = 1;
        if (board[selectedRow + different][selectedCol - different] != 0) {
          return false;
        }
        if ((board[selectedRow + (different - 1)][selectedCol - (different - 1)] == 1) || (
            board[selectedRow + (different - 1)][selectedCol - (different - 1)] == 3)) {
          Board.killChecker(selectedRow + (different - 1), selectedCol - (different - 1));
          Board.checkBlackVictory();
          return true;
        }
        if ((board[selectedRow + (different - 1)][selectedCol - (different - 1)] == 2) || (
            board[selectedRow + (different - 1)][selectedCol - (different - 1)] == 4)) {
          return false;
        }
      } else {
          if (board[selectedRow + 2][selectedCol - 2] != 0) {
            return false;
          } else {
            if ((board[selectedRow + 1][selectedCol - 1] == 1
                || board[selectedRow + 1][selectedCol - 1] == 3)) {
              Board.killChecker(
                  selectedRow + 1, selectedCol - 1);
              Board.checkBlackVictory();
              return true;
            } else if (board[selectedRow + 1][selectedCol - 1] == 2
                || board[selectedRow + 1][selectedCol - 1] == 4) {
              return false;
            }
          }
        }

    } else if (((board[selectedRow][selectedCol] == 3) && (moveUpAndRight(selectedRow, selectedCol,
        row, col)))) {
      int different = col - selectedCol;
      if (different > 2) {
        while (current < different - 1) {
          if (board[selectedRow - current][selectedCol + current] == 0) {
            current++;
          } else {
            return false;
          }
        }
        current = 1;
        if (board[selectedRow - different][selectedCol + different] != 0) {
          return false;
        }
        if ((board[selectedRow - (different - 1)][selectedCol + (different - 1)]
            == 2 || board[selectedRow - (different - 1)][selectedCol + (different - 1)] == 4)) {
          Board.killChecker(
              selectedRow - (different - 1), selectedCol + (different - 1));
          Board.checkWhiteVictory();
          return true;
        }
        if (board[selectedRow - (different - 1)][selectedCol + (different - 1)]
            == 1 || board[selectedRow - (different - 1)][selectedCol + (different - 1)] == 3) {
          return false;
        }
      } else {
        if (board[selectedRow - 2][selectedCol + 2] != 0) {
          return false;
        } else {
          if (board[selectedRow - 1][selectedCol + 1] == 2
              || board[selectedRow - 1][selectedCol + 1] == 4) {
            Board.killChecker(
                selectedRow - 1, selectedCol + 1);
            Board.checkWhiteVictory();
            return true;
          } else if (board[selectedRow - 1][selectedCol + 1] == 1
              || board[selectedRow - 1][selectedCol + 1] == 3) {
            return false;
          }
        }
      }

    } else if (((board[selectedRow][selectedCol] == 4) && (moveUpAndRight(selectedRow, selectedCol,
        row, col)))) {
      int different = col - selectedCol;
      if (different > 2) {
        while (current < different - 1) {
          if (board[selectedRow - current][selectedCol + current] == 0) {
            current++;
          } else {
            return false;
          }
        }
        current = 1;
        if (board[selectedRow - different][selectedCol + different] != 0) {
          return false;
        }
        if ((board[selectedRow - (different - 1)][selectedCol + (different - 1)] == 1
            || board[selectedRow - (different - 1)][selectedCol + (different - 1)] == 3)) {
          Board.killChecker(
              selectedRow - (different - 1), selectedCol + (different - 1));
          Board.checkBlackVictory();
          return true;
        }
        if ((board[selectedRow - (different - 1)][selectedCol + (different - 1)] == 2
            || board[selectedRow - (different - 1)][selectedCol + (different - 1)] == 4)) {
          return false;
        }
      } else {
        if (board[selectedRow - 2][selectedCol + 2] != 0) {
          return false;
        } else {
          if ((board[selectedRow - 1][selectedCol + 1] == 1
              || board[selectedRow - 1][selectedCol + 1] == 3)) {
            Board.killChecker(
                selectedRow - 1, selectedCol + 1);
            Board.checkBlackVictory();
            return true;
          } else if ((board[selectedRow - 1][selectedCol + 1] == 2
              || board[selectedRow - 1][selectedCol + 1] == 4)) {
            return false;
          }
        }
      }

    } else if ((((board[selectedRow][selectedCol] == 3) && (moveUpAndLeft(selectedRow, selectedCol,
        row, col))))) {
      int different = Math.abs(row - selectedRow);
      if (different > 2) {
        while (current < different - 1) {
          if (board[selectedRow - current][selectedCol - current] == 0) {
            current++;
          } else {
            return false;
          }
        }
        current = 1;
        if (board[selectedRow - different][selectedCol - different] != 0) {
          return false;
        }
        if ((board[selectedRow - (different - 1)][selectedCol - (different - 1)] == 2
            || board[selectedRow - (different - 1)][selectedCol - (different - 1)] == 4)) {
          Board.killChecker(
              selectedRow - (different - 1), selectedCol - (different - 1));
          Board.checkWhiteVictory();
          return true;
        }
        if ((board[selectedRow - (different - 1)][selectedCol - (different - 1)] == 1
            || board[selectedRow - (different - 1)][selectedCol - (different - 1)] == 3)) {
          return false;
        }
      } else {
        if (board[selectedRow - 2][selectedCol - 2] != 0) {
          return false;
        } else {
          if (board[selectedRow - 1][selectedCol - 1] == 2
              || board[selectedRow - 1][selectedCol - 1] == 4)  {
              Board.killChecker(
                  selectedRow - 1, selectedCol - 1);
          Board.checkWhiteVictory();
          return true;
        } else if (board[selectedRow - 1][selectedCol - 1] == 1
              || board[selectedRow - 1][selectedCol - 1] == 3) {
            return false;
          }
        }
      }

    } else if ((((board[selectedRow][selectedCol] == 4) && (moveUpAndLeft(selectedRow, selectedCol,
        row, col))))) {
      int different = Math.abs(row - selectedRow);
      if (different > 2) {
        while (current < different - 1) {
          if (board[selectedRow - current][selectedCol - current] == 0) {
            current++;
          } else {
            return false;
          }
        }
        current = 1;
        if (board[selectedRow - different][selectedCol - different] != 0) {
          return false;
        }
        if ((board[selectedRow - (different - 1)][selectedCol - (different - 1)] == 1
            || board[selectedRow - (different - 1)][selectedCol - (different - 1)] == 3)) {
          Board.killChecker(
              selectedRow - (different - 1), selectedCol - (different - 1));
          Board.checkBlackVictory();
          return true;
        }
        if (board[selectedRow - (different - 1)][selectedCol - (different - 1)] == 2
            || board[selectedRow - (different - 1)][selectedCol - (different - 1)] == 4) {
          return false;
        }
      } else {
        if (board[selectedRow - 2][selectedCol - 2] != 0) {
          return false;
        } else {
          if ((board[selectedRow - 1][selectedCol - 1] == 1
              || board[selectedRow - 1][selectedCol - 1] == 3)) {
            Board.killChecker(
                selectedRow - 1, selectedCol - 1);
            Board.checkBlackVictory();
            return true;
          } else if ((board[selectedRow - 1][selectedCol - 1] == 2
              || board[selectedRow - 1][selectedCol - 1] == 4)) {
            return false;
          }
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

  public boolean isInequalitySelectedRowAndRowSelectedColAndCol(int selectedRow, int selectedCol,
      int row, int col) {
    return selectedRow == row && selectedCol == col;
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
}
