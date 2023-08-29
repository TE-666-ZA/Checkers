package logics;

import com.diogonunes.jcolor.AnsiConsole;

public class MainMenu {


  public class ColoredCenteredTitle {

    public static void main(String[] args) {
      AnsiConsole.systemInstall();
      String title = "Цветной заголовок";
      String coloredTitle = "\u001B[31m" + title + "\u001B[0m"; // 31 - код цвета (красный)

      int terminalWidth = 80; // Ширина вашей консоли
      int padding = (terminalWidth - title.length()) / 2;
      System.out.println(" ".repeat(padding) + coloredTitle);

      AnsiConsole.systemUninstall();
    }
  }


  public void showMainMenu() {
    System.out.println("Checkers created by Natalya Seluynina & Kenan Iusubovi");
  }

}
