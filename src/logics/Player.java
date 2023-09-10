package logics;

public class Player extends PlayerLogics {

  private String name;
  private int selectedCheckerColor;
  private int numberOfVictories;
  private int numberOfDefeats;


  public Player(String name) {
    this.name = name;
    this.numberOfVictories = 0;
    this.numberOfDefeats = 0;
  }

  /**
   * Choose the color of the checkers for the player to start the game
   *
   * @param choice the number of the checkers color that the player has chosen
   */
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
   */
  public void setNumberOfVictories() {
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

  /**
   * Provides color change of selected checkers
   *
   */
  public void changeColor() {
    if (selectedCheckerColor == PlayerLogics.WHITE_CHECKER) {
      selectedCheckerColor = PlayerLogics.BLACK_CHECKER;
    } else {
      selectedCheckerColor = PlayerLogics.WHITE_CHECKER;
    }
  }

  @Override
  public String toString() {
    return "Player{" +
        "name='" + name + '\'' +
        ", numberOfVictories=" + numberOfVictories +
        ", numberOfDefeats=" + numberOfDefeats +
        '}';
  }
}
