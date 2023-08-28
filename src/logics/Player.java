package logics;

import java.util.Scanner;

public class Player {

  private String name;
  private static int selectedCheckerColor;


  public Player(String name) {
    this.name = name;
  }

  public void selectColor(Scanner scanner) {
    if (scanner.nextInt() > 0 && scanner.nextInt() < 3) {
      selectedCheckerColor = scanner.nextInt();
    }
  }
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static int getSelectedCheckerColor() {
    return selectedCheckerColor;
  }

  public void setSelectedCheckerColor(int selectedCheckerColor) {
    this.selectedCheckerColor = selectedCheckerColor;
  }
}
