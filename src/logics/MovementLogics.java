package logics;

import graphics.code.Board;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class MovementLogics extends JPanel {

  int[][] board = Board.getBoard();
  private static int selectedRow;
  private static int selectedCol;

  public MovementLogics() {
    selectedRow = -1;
    selectedCol = -1;
    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int row = e.getY() / Board.CELL_SIZE;
        int col = e.getX() / Board.CELL_SIZE;

        if (selectedRow == -1) {
          if (board[row][col] != 0) {
            selectedRow = row;
            selectedCol = col;
          }

        } else {
          if (isMoveValid(row, col)) {
            // Здесь реализуйте логику перемещения шашек
            board[row][col] = board[selectedRow][selectedCol];
            board[selectedRow][selectedCol] = 0;
            selectedRow = -1;
            selectedCol = -1;
          }
        }

        repaint();
      }
    });
  }

  public boolean isMoveValid(int row, int col) {
    int choice = choiceToMove();
    int choicePosition = choicePositionSelectedWhiteChecker();

    if (choice == 1) {

      if (choicePosition == 1) {
        if (board[row][col] == board[selectedRow + 1][selectedCol - 1]) {
          if (board[row][col] == 1) {
            return false;
          }
          if (board[row][col] == 0) {
            return true;
          }
          if (board[row][col] == 2) {
            if ((board[row + 1][col - 1]) != 0) {
              return false;
            } else {
              return true;
            }
          }
        }
      }

      if (choicePosition == 2) {
        if (board[row][col] == board[selectedRow + 1][selectedCol - 1]) {
          if (board[row][col] != 0) {
            return false;
          } else {
            return true;
          }
        }
        if (board[row][col] == board[selectedRow + 1][selectedCol + 1]) {
          if (board[row][col] == 1) {
            return false;
          }
          if (board[row][col] == 0) {
            return true;
          }
          if (board[row][col] == 2) {
            if ((board[row + 1][col + 1]) != 0) {
              return false;
            } else {
              return true;
            }
          }
        }
      }

      if (choicePosition == 3) {
        if (board[row][col] == board[selectedRow + 1][selectedCol + 1]) {
          if (board[row][col] != 0) {
            return false;
          } else {
            return true;
          }
        }
        if (board[row][col] == board[selectedRow + 1][selectedCol - 1]) {
          if (board[row][col] == 1) {
            return false;
          }
          if (board[row][col] == 0) {
            return true;
          }
          if (board[row][col] == 2) {
            if ((board[row + 1][col - 1]) != 0) {
              return false;
            } else {
              return true;
            }
          }
        }
      }

      if (choicePosition == 4) {
        if (board[row][col] == board[selectedRow + 1][selectedCol + 1]) {
          if (board[row][col] == 1) {
            return false;
          }
          if (board[row][col] == 0) {
            return true;
          }
          if (board[row][col] == 2) {
            if ((board[row + 1][col + 1]) != 0) {
              return false;
            } else {
              return true;
            }
          }
        }
      }

      if (choicePosition == 5) {
        if (board[row][col] == board[selectedRow + 1][selectedCol - 1]) {
          if (board[row][col] != 0) {
            return false;
          } else {
            return true;
          }
        }
      }

      if (choicePosition == 6) {
        if ((board[row][col] == board[selectedRow + 1][selectedCol + 1]) || (board[row][col]
            == board[selectedRow + 1][selectedCol - 1])) {
          if (board[row][col] != 0) {
            return false;
          } else {
            return true;
          }
        }
      }

      if (choicePosition == 7) {
        if ((board[row][col] == board[selectedRow + 1][selectedCol + 1]) || (board[row][col]
            == board[selectedRow + 1][selectedCol - 1])) {
          if (board[row][col] == 1) {
            return false;
          }
          if (board[row][col] == 0) {
            return true;
          }
          if (board[row][col] == 2) {
            if ((board[row + 1][col + 1] != 0) || (board[row + 1][col - 1] != 0)) {
              return false;
            } else {
              return true;
            }
          }
        }
      }
    }

      if (choice == 2) {
        if ((row != selectedRow - 1) && ((col != selectedCol + 1) || (col != selectedCol - 1))) {
          return false;
        }
        if (board[row][col] == 0) {
          return true;
        } else if (board[row][col] == choice) {
          return false;
        }

        if (col == selectedCol + 1) {
          if (board[row - 1][col + 1] == 0) {
            return true;
          }
        }
        if (col == selectedCol - 1) {
          if (board[row - 1][col - 1] == 0) {
            return true;
          }
        }
      }
      return false;
    }

    public int choiceToMove () {
      if (Player.getSelectedCheckerColor() == 1) {
        return 1;
      }
      return 2;
    }

    public int choicePositionSelectedWhiteChecker () {
      int choicePosition = board[selectedRow][selectedCol];
      if ((choicePosition == board[0][7]) || (choicePosition == board[2][7]) || (choicePosition
          == board[4][7])) {
        return 1;
      } else if ((choicePosition == board[0][1] || (choicePosition == board[2][1])
          || choicePosition == board[4][1])) {
        return 2;
      } else if ((choicePosition == board[1][6]) || (choicePosition == board[3][6]) || (
          choicePosition
              == board[5][6])) {
        return 3;
      } else if ((choicePosition == board[1][0]) || (choicePosition == board[3][0]) || (
          choicePosition
              == board[5][0])) {
        return 4;
      } else if ((choicePosition == board[6][7])) {
        return 5;
      } else if ((choicePosition == board[6][5]) || (choicePosition == board[6][3]) || (
          choicePosition
              == board[6][1])) {
        return 6;
      } else {
        return 7;
      }
    }

    public static int getSelectedRow () {
      return selectedRow;
    }

    public static int getSelectedCol () {
      return selectedCol;
  }
}
