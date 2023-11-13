package logics;

import graphics.code.Board;
import javax.swing.JFrame;

public class Main {
  public static void main(String[] args)  {
    PlayerLogics movementLogics = new PlayerLogics();
    MainMenu menu = new MainMenu();

    menu.showMainMenu();
  }

  /**
   * Creates and displays a graphical window for playing checkers
   *
   */
  public static void play() {
    JFrame frame = new JFrame("Checkers Board");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(816, 900);
    frame.setResizable(false);
    frame.add(new Board());
    frame.setVisible(true);
  }
}
