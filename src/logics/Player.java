package logics;

public class Player {

  private String name;
  private int selectedCheckerColor;
  private int numberOfVictories;
  private int numberOfDefeats;


  public Player(String name) {
    this.name = name;
    this.numberOfVictories = 0;
    this.numberOfDefeats = 0;
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

  public int getNumberOfVictories() {
    return numberOfVictories;
  }

  public void setNumberOfVictories(int numberOfVictories) {
    this.numberOfVictories++;
  }

  public int getNumberOfDefeats() {
    return numberOfDefeats;
  }

  public void setNumberOfDefeats(int numberOfDefeats) {
    this.numberOfDefeats++;
  }

  public int getSelectedCheckerColor() {
    return selectedCheckerColor;
  }

}
