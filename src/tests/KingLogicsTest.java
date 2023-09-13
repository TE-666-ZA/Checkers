package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import logics.KingLogics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KingLogicsTest {
  private KingLogics kingLogics;

  @BeforeEach
  public void setUp() {
    this.kingLogics = new KingLogics();
  }

  @Test
  public void differentRowDown() {
    int selectedRow = 3;
    int row = 7;
    int differentRow = kingLogics.differentRow(selectedRow, row);
    assertEquals(4, differentRow);
  }

  @Test
  public void differentRowUp() {
    int selectedRow = 7;
    int row = 3;
    int differentRow = kingLogics.differentRow(selectedRow, row);
    assertEquals(4, differentRow);
  }

  @Test
  public void differentColRight() {
    int selectedCol = 2;
    int col = 5;
    int differentCol = kingLogics.differentCol(selectedCol, col);
    assertEquals(3, differentCol);
  }

  @Test
  public void differentColLeft() {
    int selectedCol = 5;
    int col = 2;
    int differentCol = kingLogics.differentCol(selectedCol, col);
    assertEquals(3, differentCol);
  }
}
