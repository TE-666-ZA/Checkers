import java.util.Scanner;

public class Player {

  private static String name;
  private static int selectedCheckerColor;


  public Player(String name) {
    this.name = name;
  }

  public void selectColor(Scanner scanner) {

  }
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getSelectedCheckerColor() {
    return selectedCheckerColor;
  }

  public void setSelectedCheckerColor(int selectedCheckerColor) {
    this.selectedCheckerColor = selectedCheckerColor;
  }
}
