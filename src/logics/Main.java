package logics;

import graphics.code.Board;
import java.io.IOException;
import java.util.List;
import javax.swing.JFrame;

public class Main {
  public static void main(String[] args) throws IOException {
    FileReader fileReader = new FileReader();
    List<Player> players = fileReader.getPlayers();
    Player player = new Player("Витек");
    Player player1 = new Player("Саша");
    player.setNumberOfVictories(player.getNumberOfVictories());
    players.add(player);
    players.add(player1);
    fileReader.readingFromFile();
    fileReader.writingToFile();


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