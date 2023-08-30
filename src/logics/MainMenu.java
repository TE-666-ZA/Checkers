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

  MainMenu() {
    this.printer = new ColoredPrinter();
    this.scanner = new Scanner(System.in);
    this.isCheckersColorSelected = false;
  }

  public void showMainMenu() {
    printer.printInMiddlePurple("Checkers created by Natalya Seluynina & Kenan Iusubovi");
    printer.printInMiddleBlue("Checkers");
    printer.printBlue("1. Player 1 vs Player 1");
    printer.printBlue("2. Player 1 vs Player 2");
    printer.printBlue("3. Player 1 vs Com");
    printer.printBlue("4. Com vs Com");
    printer.printBlue("5. Show Statistics");
    printer.printRed("0. Exit");

    int command = scanner.nextInt();
    scanner.nextLine();
    switch (command) {
      case 1:
        player1VsPlaer1();
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
        break;
      case 0:
        break;
    }
  }

  public void player1VsPlaer1() {
    isStatisticIsOn = false;
    Player player = new Player("DefaultName");
    Board.setPlayer1Name(player.getName());
    Board.setPlayer2Name(player.getName());
    Main.play(player, player, isStatisticIsOn);
  }

  public void player1VsPlayer2() {
    isStatisticIsOn = true;
    printer.printYellow("Please input 1st player name ");
    String input = scanner.nextLine();
    Player player1 = new Player(input);
    Board.setPlayer1Name(player1.getName());
    choseCheckersColor(player1);

    printer.printGreen("Please input 2nd player name ");
    scanner.next();
    input = scanner.nextLine();
    Player player2 = new Player(input);
    // Board.setPlayer2Name(player2.getName());
    choseCheckersColor(player2);
    Main.play(player1, player2, isStatisticIsOn);
  }

  public void player1VsCom() {
    isStatisticIsOn = true;
    String input = scanner.nextLine();
    Player player = new Player(input);
    ComLogics com = new ComLogics();
    Board.setPlayer1Name(player.getName());
    Board.setPlayer2Name(com.getPlayer().getName());
    choseCheckersColor(player);

    choseCheckersColor(com.getPlayer());

    Main.play(player, com.getPlayer(), isStatisticIsOn);
  }

  public void comVsCom() {
    isStatisticIsOn = false;
    ComLogics com1 = new ComLogics("com1");
    com1.getPlayer().selectCheckersColor(1);
    ComLogics com2 = new ComLogics("com2");
    com2.getPlayer().selectCheckersColor(2);
    Main.play(com1.getPlayer(), com2.getPlayer(), isStatisticIsOn);
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

}