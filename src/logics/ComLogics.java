package logics;

import graphics.code.Board;

public class ComLogics {

  private Player player;
  private int[][] board;

  ComLogics() {
    this.player = new Player("com");
    this.board = Board.getBoard();
  }

  public void comCheckerColor(Player player) {
    if (Player.getSelectedCheckerColor() == 1) {
      this.player.setSelectedCheckerColor(2);
    } else {
      this.player.setSelectedCheckerColor(1);
    }
  }

  public boolean isFirstMoveMakesCom() {
    if (this.player.getSelectedCheckerColor() == 1) {
      return true;
    }
    return false;
  }
}
