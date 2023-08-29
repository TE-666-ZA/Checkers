package logics;

import graphics.code.Board;
import javax.swing.JFrame;

public class Main {

  public static void main(String[] args) {
    MainMenu menu = new MainMenu();

    menu.showMainMenu();

    boolean play = false;
    if (play) {
      JFrame frame = new JFrame("Checkers Board");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(Board.BOARD_SIZE * Board.CELL_SIZE, Board.BOARD_SIZE * Board.CELL_SIZE);
      frame.add(new Board());
      frame.setVisible(true);
    }
  }
}