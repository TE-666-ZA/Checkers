package logics;

public class Player extends PlayerLogics {

  private String name;
  private int selectedCheckerColor;
  private int amountOfVictories;
  private int amountOfDefeats;


  public Player(String name) {
    this.name = name;
    this.amountOfVictories = 0;
    this.amountOfDefeats = 0;
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

  public int getAmountOfVictories() {
    return amountOfVictories;
  }

  /**
   * Increment of the number of wins
   */
  public void setAmountOfVictories(int amountOfVictories) {
    this.amountOfVictories = amountOfVictories;
  }

  public int getAmountOfDefeats() {
    return amountOfDefeats;
  }

  /**
   * Increment of the number of defeats
   *
   * @param amountOfDefeats number of defeats
   */
  public void setAmountOfDefeats(int amountOfDefeats) {
    this.amountOfDefeats = amountOfDefeats;
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
        ", numberOfVictories=" + amountOfVictories +
        ", numberOfDefeats=" + amountOfDefeats +
        '}';
  }
}
