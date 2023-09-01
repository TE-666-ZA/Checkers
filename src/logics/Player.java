package logics;

public class Player {

  private String name;
  private int selectedCheckerColor;
  private int numberOfVictories;
  private int numberOfDefeats;


  public Player(String name) {
    this.name = name;
  }

  public Player() {
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

  /**
   * Increment of the number of wins
   *
   * @param numberOfVictories number of wins
   */
  public void setNumberOfVictories(int numberOfVictories) {
    this.numberOfVictories++;
  }

  public int getNumberOfDefeats() {
    return numberOfDefeats;
  }

  /**
   * Increment of the number of defeats
   *
   * @param numberOfDefeats number of defeats
   */
  public void setNumberOfDefeats(int numberOfDefeats) {
    this.numberOfDefeats++;
  }

  public int getSelectedCheckerColor() {
    return selectedCheckerColor;
  }
}
