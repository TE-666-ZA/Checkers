package tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import logics.PlayerLogics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerLogicsTest {

  private PlayerLogics playerLogics;


  @BeforeEach
  public void setUp() {
    this.playerLogics = new PlayerLogics();
  }

  @Test
  public void isMoveValidToFreeCellWhiteChecker() {
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {0, 0, 0, 0, 2, 0, 1, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    int targetRow = 3;
    int targetCol = 2;
    int selectedRow = 2;
    int selectedCol = 1;

    boolean result = playerLogics.isMoveValid(board, targetRow, targetCol, selectedRow,
        selectedCol);
    assertTrue(result);

    targetCol = 0;

    result = playerLogics.isMoveValid(board, targetRow, targetCol, selectedRow, selectedCol);
    assertTrue(result);

  }

  @Test
  public void isMoveValidToFreeCellBlackChecker() {
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {0, 0, 0, 0, 2, 0, 1, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    playerLogics.changeMoveColor();

    int targetRow = 4;
    int targetCol = 1;
    int selectedRow = 5;
    int selectedCol = 2;

    boolean result = playerLogics.isMoveValid(board, targetRow, targetCol, selectedRow,
        selectedCol);
    assertTrue(result);

    targetCol = 3;

    result = playerLogics.isMoveValid(board, targetRow, targetCol, selectedRow,
        selectedCol);
    assertTrue(result);

  }

  @Test
  public void isMoveValidToOccupiedCellWhiteChecker() {
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 2, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };
    int targetRow = 3;
    int targetCol = 2;
    int selectedRow = 2;
    int selectedCol = 1;

    boolean result = playerLogics.isMoveValid(board, targetRow, targetCol, selectedRow,
        selectedCol);
    assertFalse(result);

    targetCol = 0;

    result = playerLogics.isMoveValid(board, targetRow, targetCol, selectedRow, selectedCol);
    assertFalse(result);
  }


  @Test
  public void isMoveValidToOccupiedCellBlackChecker() {
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 2, 0, 0, 0, 0, 0},
        {0, 1, 0, 2, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    int targetRow = 4;
    int targetCol = 1;
    int selectedRow = 5;
    int selectedCol = 2;

    boolean result = playerLogics.isMoveValid(board, targetRow, targetCol, selectedRow,
        selectedCol);
    assertFalse(result);

    targetCol = 3;

    result = playerLogics.isMoveValid(board, targetRow, targetCol, selectedRow, selectedCol);
    assertFalse(result);
  }

  @Test
  public void isMoveValidFromEmptyCell() {
    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 2, 0, 0, 0, 0, 0},
        {0, 1, 0, 2, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    int targetRow = 4;
    int targetCol = 0;
    int selectedRow = 5;
    int selectedCol = 1;

    boolean result = playerLogics.isMoveValid(board, targetRow, targetCol, selectedRow,
        selectedCol);
    assertFalse(result);

    targetCol = 2;

    result = playerLogics.isMoveValid(board, targetRow, targetCol, selectedRow, selectedCol);
    assertFalse(result);
  }


  @Test
  public void WhiteCanKillBlackIfTargetCellFree() {

    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 2, 0, 1, 0, 1, 0, 1},
        {1, 0, 0, 0, 2, 0, 2, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    int targetRow = 4;
    int targetCol = 5;
    int selectedRow = 2;
    int selectedCol = 3;

    boolean result = playerLogics.isMoveValid(board, targetRow, targetCol, selectedRow,
        selectedCol);
    assertTrue(result);

    selectedCol = 5;
    targetCol = 3;

    result = playerLogics.isMoveValid(board, targetRow, targetCol, selectedRow, selectedCol);
    assertTrue(result);

  }

  @Test
  public void WhiteCanKillBlackIfTargetCellOccupied() {

    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 2, 0, 1, 0, 1, 0, 1},
        {1, 0, 0, 0, 2, 0, 2, 0},
        {0, 0, 0, 1, 0, 2, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    int targetRow = 4;
    int targetCol = 5;
    int selectedRow = 2;
    int selectedCol = 3;

    boolean result = playerLogics.isMoveValid(board, targetRow, targetCol, selectedRow,
        selectedCol);
    assertFalse(result);

    selectedCol = 5;
    targetCol = 3;

    result = playerLogics.isMoveValid(board, targetRow, targetCol, selectedRow, selectedCol);
    assertFalse(result);

  }

  @Test
  public void WhiteCanKillBlackIfTargetCellFreeFromBorder() {

    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 2, 0, 1, 0, 1, 0, 1},
        {1, 0, 0, 0, 2, 0, 2, 0},
        {0, 0, 0, 2, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    int targetRow = 3;
    int targetCol = 2;
    int selectedRow = 1;
    int selectedCol = 0;

    boolean result = playerLogics.isMoveValid(board, targetRow, targetCol, selectedRow,
        selectedCol);
    assertTrue(result);

    targetRow = 4;
    selectedRow = 2;
    selectedCol = 7;
    targetCol = 5;

    result = playerLogics.isMoveValid(board, targetRow, targetCol, selectedRow, selectedCol);
    assertTrue(result);

  }

  @Test
  public void WhiteCanKillWhiteIfTargetCellFree() {

    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 0, 0},
        {0, 0, 0, 2, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    int targetRow = 4;
    int targetCol = 1;
    int selectedRow = 2;
    int selectedCol = 3;

    boolean result = playerLogics.isMoveValid(board, targetRow, targetCol, selectedRow,
        selectedCol);
    assertFalse(result);

    targetCol = 5;

    result = playerLogics.isMoveValid(board, targetRow, targetCol, selectedRow, selectedCol);
    assertFalse(result);

  }

  @Test
  public void BlackCanKillWhiteIfTargetCellFreeFromBorder() {

    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 1, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 1, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    playerLogics.changeMoveColor();

    int targetRow = 3;
    int targetCol = 2;
    int selectedRow = 5;
    int selectedCol = 0;

    boolean result = playerLogics.isMoveValid(board, targetRow, targetCol, selectedRow,
        selectedCol);
    assertTrue(result);

    targetRow = 4;
    targetCol = 5;
    selectedRow = 6;
    selectedCol = 7;

    result = playerLogics.isMoveValid(board, targetRow, targetCol, selectedRow, selectedCol);
    assertTrue(result);

  }

  @Test
  public void BlackCanKillWhiteIfTargetCellFree() {

    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 1, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 1, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    playerLogics.changeMoveColor();

    int targetRow = 3;
    int targetCol = 4;
    int selectedRow = 5;
    int selectedCol = 2;

    boolean result = playerLogics.isMoveValid(board, targetRow, targetCol, selectedRow,
        selectedCol);
    assertTrue(result);

   selectedCol = 4;
   targetCol = 2;

    result = playerLogics.isMoveValid(board, targetRow, targetCol, selectedRow, selectedCol);
    assertTrue(result);

  }

  @Test
  public void BlackCanKillBlackIfTargetCellFree() {

    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 2, 0, 2, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 1, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    playerLogics.changeMoveColor();

    int targetRow = 3;
    int targetCol = 4;
    int selectedRow = 5;
    int selectedCol = 2;

    boolean result = playerLogics.isMoveValid(board, targetRow, targetCol, selectedRow,
        selectedCol);
    assertFalse(result);

    selectedCol = 4;
    targetCol = 2;

    result = playerLogics.isMoveValid(board, targetRow, targetCol, selectedRow, selectedCol);
    assertFalse(result);

  }

  @Test
  public void BlackCanKillWhiteIfTargetCellOccupied() {

    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {2, 0, 1, 0, 2, 0, 0, 0},
        {0, 1, 0, 1, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 1, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    playerLogics.changeMoveColor();

    int targetRow = 3;
    int targetCol = 4;
    int selectedRow = 5;
    int selectedCol = 2;

    boolean result = playerLogics.isMoveValid(board, targetRow, targetCol, selectedRow,
        selectedCol);
    assertFalse(result);

    selectedCol = 4;
    targetCol = 2;

    result = playerLogics.isMoveValid(board, targetRow, targetCol, selectedRow, selectedCol);
    assertFalse(result);

  }

  @Test
  public void WhiteCanDoNextMove() {

    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 2, 0, 1, 0, 1, 0, 1},
        {1, 0, 0, 0, 2, 0, 2, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 2, 0},
        {0, 2, 0, 0, 0, 0, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    int targetRow = 4;
    int targetCol = 5;

    boolean result = playerLogics.isCanDoNextMoveValid(board,targetRow,targetCol);
    assertTrue(result);

  }


  @Test
  public void BlackCanDoNextMove() {

    int[][] board = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 0, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 1, 0, 0, 0, 0},
        {2, 0, 2, 0, 2, 0, 1, 0},
        {0, 2, 0, 2, 0, 2, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0}
    };

    playerLogics.changeMoveColor();

    int targetRow = 3;
    int targetCol = 4;


    boolean result = playerLogics.isCanDoNextMoveValid(board, targetRow, targetCol);
    assertTrue(result);

  }

}
