package logics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class FileReader {

  private String ourFile = "src/logics/res/playersStatistics.csv";
  private HashSet<Player> players = new HashSet<>();
  private static final String SEPARATOR = ";";

  /**
   * Reading data from a file
   */
  public void readingFromFile() {
    try {
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
    } catch (IOException e) {
      System.err.println("Statistic file could not be find");
    }
  }

  /**
   * Writing data to a file
   */
  public void writingToFile() {
    try {
      FileWriter fileWriter = new FileWriter(ourFile);

      for (Player player : players) {
        String result = player.getName() + SEPARATOR + player.getNumberOfVictories() + SEPARATOR
            + player.getNumberOfDefeats();
        fileWriter.write(result + "\n");
      }
      fileWriter.close();
    } catch (IOException e) {
      System.err.println("Statistic file could not be find");
    }
  }

  public HashSet<Player> getPlayers() {
    return players;
  }

  public String getOurFile() {
    return ourFile;
  }

  /**
   * Output of a numbered list of players with statistics data
   */
  public void printNumberedListStatistics() {
    int index = 1;
    for (Player player : players) {
      System.out.println(
          index + ". " + player.getName() + ": кол-во побед - " + player.getNumberOfVictories()
              + ", кол-во поражений - " + player.getNumberOfDefeats());
      index++;
    }
  }

  /**
   * Output a numbered list of player names
   */
  public void printNumberedListNamesPlayers() {
    int index = 1;
    for (Player player : players) {
      System.out.println(index + ". " + player.getName());
      index++;
    }
  }
}
