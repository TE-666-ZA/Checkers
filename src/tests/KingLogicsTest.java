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
}
