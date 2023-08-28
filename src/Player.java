public class Player {

  private static String name;
  String selectedCheckerColor;


  public Player(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSelectedCheckerColor() {
    return selectedCheckerColor;
  }

  public void setSelectedCheckerColor(String selectedCheckerColor) {
    this.selectedCheckerColor = selectedCheckerColor;
  }
}
