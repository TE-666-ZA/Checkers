package logics;

import graphics.code.Board;
import graphics.code.ColoredPrinter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {

  ColoredPrinter printer;
  Scanner scanner;
  private boolean isStatisticIsOn;
  private boolean isCheckersColorSelected;
  private int saveSelectedColor;
  FileReader fileReader;
  private String saveFirstPlayerName;

  MainMenu() {
    this.printer = new ColoredPrinter();
    this.scanner = new Scanner(System.in);
    this.isCheckersColorSelected = false;
    this.fileReader = new FileReader();
    this.saveFirstPlayerName = null;
  }

  /**
   * It is the main menu of the game of checkers and provides a choice of different game modes
   *
   */
  public void showMainMenu()  {
    fileReader.readingFromFile();
    while (true) {
      printer.printInMiddlePurple("Checkers created by Natalya Seluynina & Kenan Iusubovi");
      printer.printInMiddleBlue("Checkers");
      printer.printBlue("1. Player 1 vs Player 1" + "\n"
          +"2. Player 1 vs Player 2" + "\n"
          + "3. Player 1 vs Com --COMING WITH NEXT UPDATE !--" + "\n"
          + "4. Com vs Com --COMING WITH NEXT UPDATE !--" + "\n"
          + "5. Show Statistics");
      printer.printRed("0. Exit");

      int command = scanner.nextInt();
      scanner.nextLine();
      switch (command) {
        case 1:
          player1VsPlayer1();
          break;
        case 2:
          player1VsPlayer2();
          break;
        case 3:
          player1VsCom();
          break;
        case 4:
          comVsCom();
          break;
        case 5:
          showStatistics();
          break;
        case 0:
          System.out.println("Goodbye");
          System.exit(0);
          break;
        default:
          System.out.println("Enter a number from 0 to 5");
          break;
      }
    }
  }

  /**
   * Creates a game in which one player will play for two
   *
   */
  public void player1VsPlayer1() {
    isStatisticIsOn = false;
    Player player = new Player("DefaultName");
    Board.setPlayer1(player);
    Board.setPlayer2(player);
    Main.play();
  }

  /**
   * Creates a game between two players
   *
   */
  public void player1VsPlayer2() {
    Board.setPlayALone(false);
    isStatisticIsOn = true;
    String name1Player;
    String name2Player;
    Player player1;
    Player player2;

    printer.printYellow("Player №1 have you played before: ");
    int choice = choiceNewOrExistingPlayer();

    if (choice == 1) {
      printer.printYellow("Please input 1st player name ");
      name1Player = addNameNewPlayer();
      player1 = addNewPlayer(name1Player);
    } else {
      printer.printYellow("Choose the number of your name in the game:");
      fileReader.printNumberedListStatistics(saveFirstPlayerName);
      name1Player = choiceNameExistingPlayer();
      player1 = selectingExistingPlayer(name1Player);
    }

    player1.setName(name1Player);
    choseCheckersColor(player1);
    Board.setPlayer1(player1);


    printer.printGreen("Player №2 have you played before: ");
    choice = choiceNewOrExistingPlayer();
    if (choice == 1) {
      printer.printGreen("Please input 2nd player name ");
      name2Player = addNameNewPlayer();
      player2 = addNewPlayer(name2Player);
    } else {
      printer.printGreen("Choose the number of your name in the game:");
      fileReader.printNumberedListStatistics(saveFirstPlayerName);
      name2Player = choiceNameExistingPlayer();
      player2 = selectingExistingPlayer(name2Player);
    }

    player2.setName(name2Player);
    choseCheckersColor(player2);
    Board.setPlayer2(player2);


    Main.play();
    fileReader.writingToFile();
  }

  /**
   * Creates a game between the player and the computer
   *
   */
  public void player1VsCom()  {
    isStatisticIsOn = true;

    String input = scanner.nextLine();
    Player player = new Player(input);
    ComLogics com = new ComLogics();
    Board.setPlayer1(player);
//    Board.setPlayer2(com);
    choseCheckersColor(player);

    choseCheckersColor(com.getPlayer());

    Main.play();
    fileReader.writingToFile();
  }

  /**
   * Creates a game where a computer will play for both players
   *
   */
  public void comVsCom()  {
    isStatisticIsOn = false;
    ComLogics com1 = new ComLogics("com1");
    com1.getPlayer().selectCheckersColor(1);
    ComLogics com2 = new ComLogics("com2");
    com2.getPlayer().selectCheckersColor(2);
    Main.play();
  }

  public void choseCheckersColor(Player player) {
    if (!isCheckersColorSelected) {
      printer.printInMiddleBlue(
          "Please select color" + "\n" + " Remember the white checkers go first!");
      printer.printYellow("1. i want to play with WHITE color");
      printer.printYellow("2. i want to play with BLACK color");
      int command = 0;
      while (!isCheckersColorSelected) {
        try {
          command = scanner.nextInt();
          if (command >= 1 && command <= 2) {
            isCheckersColorSelected = true;
            player.selectCheckersColor(command);
            saveSelectedColor = command;
          } else {
            printer.printRed("You can choose only between 1 or 2. Please try again!");
            printer.printYellow("1. I want to play with WHITE color");
            printer.printYellow("2. I want to play with BLACK color");
          }
        } catch (InputMismatchException e) {
          printer.printRed("Invalid input. Please enter a number.");
          printer.printYellow("1. I want to play with WHITE color");
          printer.printYellow("2. I want to play with BLACK color");
          scanner.next();
        }
      }

      if (command == 1) {
        printer.printYellow("Player --" + player.getName() + "-- playing with White color");
      } else {
        printer.printYellow("Player --" + player.getName() + "-- playing with BLACK color");
      }
    } else if (saveSelectedColor == 1) {
      player.selectCheckersColor(2);
      printer.printGreen("Player --" + player.getName() + "-- playing with BLACK color");
    } else if (saveSelectedColor == 2) {
      player.selectCheckersColor(1);
      printer.printGreen("Player --" + player.getName() + "-- playing with WHITE color");
    }
  }

  public int choiceNewOrExistingPlayer() {
    System.out.println("1. No");
    System.out.println("2. Yes");
    int choice = scanner.nextInt();
    scanner.nextLine();
    return choice;
  }

  public String addNameNewPlayer() {
    String name;
    do {
      name = scanner.nextLine();
      boolean nameExist = false;
      for (Player player : fileReader.getPlayers()) {
        if (player.getName().equals(name)) {
          nameExist = true;
          break;
        }
      }
      if (nameExist) {
        System.out.println("This name is already in the list, enter another one:");
      } else {
        break;
      }
    } while (true);

    return name;
  }

  public Player addNewPlayer(String namePlayer) {
    Player player = new Player(namePlayer);
    fileReader.getPlayers().add(player);
    return player;
  }

  public String choiceNameExistingPlayer() {
    String playerName = null;
    int numberName = scanner.nextInt();
    scanner.nextLine();
    int index = 0;
    for (Player player : fileReader.getPlayers()) {
      if(!player.getName().equals(saveFirstPlayerName)){
      index++;
      if (index == numberName) {
        playerName = player.getName();
      }
      }
    }
    saveFirstPlayerName = playerName;
    return playerName;
  }

  public Player selectingExistingPlayer(String namePlayer) {
    Player player = new Player(namePlayer);
    return player;
  }

  public boolean isSamePlayer(String name1, String name2) {
    if (name1.equals(name2)) {
      return true;
    }
    return false;
  }

  public boolean isSameNamePlayer(String name) {
    if (!fileReader.getPlayers().contains(name)) {
      return true;
    }
    return false;
  }

  /**
   * Displays player statistics
   *
   */
  public void showStatistics() {
        fileReader.getPlayers().sort((player1, player2) -> {
          if (player2.getAmountOfVictories() - player1.getAmountOfVictories() != 0) {
            return player2.getAmountOfVictories() - player1.getAmountOfVictories();
          }
          return player2.getAmountOfDefeats() - player1.getAmountOfDefeats();
        });
        fileReader.getPlayers().forEach(System.out::println);
  }
}
