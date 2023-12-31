package logics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

  private String ourFile = "src/logics/res/playersStatistics.csv";
  private List<Player> players = new ArrayList<>();
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
        String result = player.getName() + SEPARATOR + player.getAmountOfVictories() + SEPARATOR
            + player.getAmountOfDefeats();
        fileWriter.write(result + "\n");
      }
      fileWriter.close();
    } catch (IOException e) {
      System.err.println("Statistic file could not be find");
    }
  }

  public List<Player> getPlayers() {
    return players;
  }

  public String getOurFile() {
    return ourFile;
  }

  public void setOurFile(String ourFile) {
    this.ourFile = ourFile;
  }

  public void setPlayers(List<Player> players) {
    this.players = players;
  }

  /**
   * Output of a numbered list of players with statistics data
   */
  public void printNumberedListStatistics(String firstPlayerName) {
    int index = 1;
    for (Player player : players) {
      if (!player.getName().equals(firstPlayerName)) {
        System.out.println(
            index + ". " + player.getName() + ": victories: " + player.getAmountOfVictories()
                + ", defeats: " + player.getAmountOfDefeats());
        index++;
      }
    }
  }

  /**
   * Output a numbered list of player names
   */
  public void printNumberedListNamesPlayers() {
    int index = 1;
    for (Player player : players) {
      System.out.println(index + ". " + player);
      index++;
    }
  }
}
