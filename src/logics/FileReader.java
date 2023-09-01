package logics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileReader {

  private String ourFile = "src/graphics/res/playersStatistics.csv";
  private Map<String, Player> players = new HashMap<>();
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
      players.put(name, player);
    }
    scanner.close();
  }

  /**
   * Writing data to a file
   */
  public void writingToFile() throws IOException {
    FileWriter fileWriter = new FileWriter(ourFile);

    for (Map.Entry<String, Player> entry : players.entrySet()) {
      String result =
          entry.getKey() + SEPARATOR + entry.getValue().getNumberOfVictories() + SEPARATOR
              + entry.getValue().getNumberOfDefeats();
      fileWriter.write(result + "\n");
    }
    fileWriter.close();
  }

  public Map<String, Player> getPlayers() {
    return players;
  }

  public String getOurFile() {
    return ourFile;
  }

  /**
   * Output of a numbered list of players with statistics data
   */
  public void printNumberedListStatistics() {
    for (Map.Entry<String, Player> entry : players.entrySet()) {
      int index = 1;
      System.out.println(index + ". " + entry.getKey() + ": кол-во побед - " + entry.getValue()
          .getNumberOfVictories() + ", кол-во поражений - " + entry.getValue()
          .getNumberOfDefeats());
      index++;
    }
  }

  /**
   * Output a numbered list of player names
   */
  public void printNumberedListNamesPlayers() {
    int index = 1;
    for (Map.Entry<String, Player> entry : players.entrySet()) {
      System.out.println(index + ". " + entry.getKey());
      index++;
    }
  }
}
