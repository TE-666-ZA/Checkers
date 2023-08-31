package logics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

  private String ourFile = "src/graphics/res/playersStatistics.csv";
  private List<Player> players = new ArrayList<>();
  private static final String SEPARATOR = ";";

  /**
   * Reading data from a file
   */
  public void readingFromFile() throws IOException {
    File file = new File(ourFile);
    if (!file.exists() || file.length() == 0) {
      return;
    }

    Scanner scanner = new Scanner(file);
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String[] cells = line.split(SEPARATOR);
      String name = cells[0];
      int numberOfVictories = Integer.parseInt(cells[1]);
      int numberOfDefeats = Integer.parseInt(cells[2]);
      Player player = new Player(name);
      players.add(player);
    }
    scanner.close();
  }

  /**
   * Writing data to a file
   */
  public void writingToFile() throws IOException {
    FileWriter fileWriter = new FileWriter(ourFile);

    for (Player player : players) {
      String result = player.getName() + SEPARATOR + player.getNumberOfVictories() + SEPARATOR
          + player.getNumberOfDefeats();
      fileWriter.write(result + "\n");
    }
    fileWriter.close();
  }

  public List<Player> getPlayers() {
    return players;
  }

  public String getOurFile() {
    return ourFile;
  }

  /**
   * Output of a numbered list of players with statistics data
   */
  public void printNumberedListStatistics() {
    for (int i = 0; i < players.size(); i++) {
      System.out.println(i + 1 + ". " + players.get(i).getName() + " - побед:" + players.get(i)
          .getNumberOfVictories() + " поражений:" + players.get(i).getNumberOfDefeats());
    }
  }

  /**
   * Output a numbered list of player names
   */
  public void printNumberedListNamesPlayers() {
    for (int i = 0; i < players.size(); i++) {
      System.out.println(i + 1 + ". " + players.get(i).getName());
    }
  }
}
