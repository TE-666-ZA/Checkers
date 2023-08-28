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
      public void mouseClicked (MouseEvent e){
        int row = e.getY() / Board.CELL_SIZE;
        int col = e.getX() / Board.CELL_SIZE;

        if (selectedRow == -1) {
          if (board[row][col] != 0) {
            selectedRow = row;
            selectedCol = col;
          }

        } else {
          // Здесь реализуйте логику перемещения шашек
          board[row][col] = board[selectedRow][selectedCol];
          board[selectedRow][selectedCol] = 0;
          selectedRow = -1;
          selectedCol = -1;
        }

        repaint();
      }
    });
  }

  public boolean isMoveValid(int row, int col) {
    int choice = choiceToMove();

    if (choice == 1) {
      while (row != selectedRow + 1) {
        System.out.println("Некорректый выбор позиции");
      }
      if (board[row][col] == 0) {
        return true;
      } else if (board[row][col] == choice) {
        return false;
      }

      if ()
    }

    if (choice == 2) {
      if (board[row][col] == 0) {
        return true;
      } else if (board[row][col] == choice) {
        return false;
      }
      return false;
    }
  }

  public int choiceToMove() {
    if (Player.getSelectedCheckerColor() == 1) {
      return 1;
    }
      return 2;
  }

  public boolean placeToMove() {

  }

  public static int getSelectedRow() {
    return selectedRow;
  }

  public static int getSelectedCol() {
    return selectedCol;
  }
}
