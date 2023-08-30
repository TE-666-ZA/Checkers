package logics;

public class ComLogics {

  private Player player;

  ComLogics() {
    this.player = new Player("com");
  }

  ComLogics(String name) {
    this.player = new Player(name);
  }



  public boolean isFirstMoveMakesCom() {
    if (this.player.getSelectedCheckerColor() == 1) {
      return true;
    }
    return false;
  }

  public Player getPlayer() {
    return player;
  }
}
