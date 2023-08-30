package logics;

import graphics.code.Board;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class MovementLogics extends JPanel {

  private boolean isWhitesTurn = true;

  public boolean checkMovement(int[][] board, int row, int col, int selectedRow, int selectedCol) {
    if(isWhitesTurn) {
      if (col == (selectedCol + 1) | col == (selectedCol - 1) && row == (selectedRow + 1)) {
        isWhitesTurn = false;
        return true;
      }
    }

    if (!isWhitesTurn) {
      if (col == (selectedCol + 1) | col == (selectedCol - 1) && row == (selectedRow - 1)) {
        isWhitesTurn = true;
        return true;
      }
    }

    return false;
  }

  public void setWhitesTurn(boolean whitesTurn) {
    isWhitesTurn = whitesTurn;
  }
}
