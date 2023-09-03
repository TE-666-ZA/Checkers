package logics;

public class ComLogics extends PlayerLogics implements MovementLogics {

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

  @Override
  public boolean isMoveValid(int[][] board, int row, int col, int selectedRow, int selectedCol) {
    return false;
  }

  @Override
  public boolean canKill(int[][] board, int row, int col, int selectedRow, int selectedCol) {
    return false;
  }

  @Override
  public boolean leftBorderLogicForWhite(int[][] board, int row, int col, int selectedRow,
      int selectedCol) {
    return false;
  }

  @Override
  public boolean leftBorderLogicForBlack(int[][] board, int row, int col, int selectedRow,
      int selectedCol) {
    return false;
  }

  @Override
  public boolean rightBorderLogicForWhite(int[][] board, int row, int col, int selectedRow,
      int selectedCol) {
    return false;
  }

  @Override
  public boolean rightBorderLogicForBlack(int[][] board, int row, int col, int selectedRow,
      int selectedCol) {
    return false;
  }

  @Override
  public boolean isTargetCellFree(int targetCell) {
    return false;
  }

  @Override
  public int getCheckerMove() {
    return 0;
  }

  @Override
  public boolean isLeftBorderChecker(int selectedCol) {
    return false;
  }

  @Override
  public boolean isRightBorderChecker(int selectedCol) {
    return false;
  }

}
