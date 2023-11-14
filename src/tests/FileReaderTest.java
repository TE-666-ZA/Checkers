package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import logics.FileReader;
import logics.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileReaderTest {

  private String file = "testFile.txt";
  private List<Player> testPlayers;
  private String SEP = ";";
  private FileReader fileReader;

  @BeforeEach
  public void setUp() {
    testPlayers = new ArrayList<>();
    this.fileReader = new FileReader();
  }

  @AfterEach
  public void close() {
    new File(file).delete();
  }

  @Test
  public void readingFromEmptyFile() {
    String input = "";
    fileReader.setOurFile(input);
    fileReader.readingFromFile();
    assertTrue(testPlayers.isEmpty());
  }

  @Test
  public void readingPlayersFromNonexistentFile() {
    assertThrows(IOException.class, () -> {
      File file2 = new File(file);
      if (!file2.exists()) {
        throw new IOException(file2.getPath());
      }
    });
  }

  @Test
  public void readingFromCorrectingFile() throws IOException {
    File testFile = new File(file);
    FileWriter writer = new FileWriter(testFile);
    String name1 = "Name1";
    String name2 = "Name2";
    Player player1 = new Player(name1);
    Player player2 = new Player(name2);
    testPlayers.add(player1);
    testPlayers.add(player2);

    for (Player player : testPlayers) {
      String result = player.getName() + SEP + player.getAmountOfVictories() + SEP
          + player.getAmountOfDefeats();
      writer.write(result + "\n");
    }
    writer.flush();
    writer.close();

    fileReader.setOurFile(file);
    fileReader.readingFromFile();

    assertFalse(testPlayers.isEmpty());
    assertEquals("Name1", testPlayers.get(0).getName());
    assertEquals("Name2", testPlayers.get(1).getName());
    assertEquals(0, testPlayers.get(0).getAmountOfVictories());
    assertEquals(0, testPlayers.get(1).getAmountOfDefeats());
  }

  @Test
  public void correctWritingToFile() throws IOException {
    File testFile = new File(file);
    FileWriter writer = new FileWriter(testFile);
    String name1 = "Name1";
    String name2 = "Name2";
    Player player1 = new Player(name1);
    Player player2 = new Player(name2);
    testPlayers.add(player1);
    testPlayers.add(player2);

    for (Player player : testPlayers) {
      String result = player.getName() + SEP + player.getAmountOfVictories() + SEP
          + player.getAmountOfDefeats();
      writer.write(result + "\n");
    }
    writer.flush();
    writer.close();

    fileReader.setOurFile(file);
    fileReader.writingToFile();

    assertEquals("Name1", testPlayers.get(0).getName());
    assertEquals("Name2", testPlayers.get(1).getName());
    assertEquals(0, testPlayers.get(0).getAmountOfVictories());
    assertEquals(0, testPlayers.get(1).getAmountOfDefeats());
  }
}
