package logics;

import graphics.code.Board;

public class ComLogics {

  private Player player;
  private int[][] board;

  ComLogics() {
    this.player = new Player("com");
    this.board = Board.getBoard();
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
