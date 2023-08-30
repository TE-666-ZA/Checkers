package logics;

import graphics.code.Board;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.print.DocFlavor.READER;
import javax.swing.JPanel;

public class MovementLogics extends JPanel {

  private boolean isWhitesTurn = true;
  private final int WHITECHECKER = 1;
  private final int BLACKCHECKER = 2;

  public boolean checkMovement(int[][] board, int row, int col, int selectedRow, int selectedCol) {
    if (isWhitesTurn) {
      if (col == (selectedCol + 1) | col == (selectedCol - 1) && row == (selectedRow + 1)
          && board[row][col] == 0) {
        if (board[row][col] == 0) {
          isWhitesTurn = false;
          return true;
        }
      } else if (col == (selectedCol + 2) | col == (selectedCol - 2) && row == (selectedRow + 2)
          && board[row][col] == BLACKCHECKER) {
        isWhitesTurn = false;
        return true;
      }
    }

    if (!isWhitesTurn) {
      if (col == (selectedCol + 1) | col == (selectedCol - 1) && row == (selectedRow - 1)
          && board[row][col] == 0) {
        isWhitesTurn = true;
        return true;
      }
    } else if (col == (selectedCol + 2) | col == (selectedCol - 2) && row == (selectedRow - 2)
        && board[row][col] == WHITECHECKER) {
      isWhitesTurn = true;
      return true;
    }

    return false;
  }

  public void setWhitesTurn(boolean whitesTurn) {
    isWhitesTurn = whitesTurn;
  }
}
