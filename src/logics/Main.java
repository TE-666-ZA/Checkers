package logics;

import graphics.code.Board;
import java.io.IOException;
import javax.swing.JFrame;

public class Main {
  public static void main(String[] args) throws IOException {
//    FileReader fileReader = new FileReader();
//    fileReader.readingFromFile();
//    fileReader.printNumberedListStatistics();
//    fileReader.writingToFile();


    MovementLogics movementLogics = new MovementLogics();
    MainMenu menu = new MainMenu();

    menu.showMainMenu();


  }

  public static void play(Player player1, Player player2, boolean statisticIsOn) {

    JFrame frame = new JFrame("Checkers Board");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(Board.BOARD_SIZE * Board.CELL_SIZE, Board.BOARD_SIZE * Board.CELL_SIZE);
    frame.add(new Board());
    frame.setVisible(true);
  }
}