package logics;

public class Player {

  private String name;
  private int selectedCheckerColor;



  public Player(String name) {
    this.name = name;
  }

  public void selectCheckersColor(int choice) {
    if (choice > 0 && choice < 3) {
      selectedCheckerColor = choice;
    }
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

}
