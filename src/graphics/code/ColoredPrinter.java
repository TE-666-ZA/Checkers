package graphics.code;

public class ColoredPrinter {

  private String redColor;
  private String greenColor;
  private String resetColor;
  private String yellowColor;
  private String blueColor;
  private String purpleColor;
  private String whiteColor;


  public ColoredPrinter() {
    this.redColor = "\u001B[31m";
    this.greenColor = "\u001B[32m";
    this.resetColor = "\u001B[0m";
    this.yellowColor = "\u001B[33m";
    this.blueColor = "\u001B[34m";
    this.purpleColor = "\u001B[35m";
    this.whiteColor = "\u001B[37m";
  }

  /**
   * Returns the width of the console
   *
   * @return console width
   */
  public static int getConsoleWidth() {
    return Math.max(80, Math.min(100, 60));
  }

  /**
   * Displays text in red in the center of the console
   *
   * @param text line of text
   */
  public void printInMiddleRed(String text) {
    int consoleWidth = getConsoleWidth();
    int padding = (consoleWidth - text.length()) / 2;
    String coloredText = redColor + " ".repeat(padding) + text + " ".repeat(padding) + resetColor;

    System.out.println(coloredText);
  }

  /**
   * Displays text in green in the center of the console
   *
   * @param text line of text
   */
  public void printInMiddleGreen(String text) {
    int consoleWidth = getConsoleWidth();
    int padding = (consoleWidth - text.length()) / 2;
    String coloredText = greenColor + " ".repeat(padding) + text + " ".repeat(padding) + resetColor;

    System.out.println(coloredText);
  }

  /**
   * Displays text in yellow in the center of the console
   *
   * @param text line of text
   */
  public void printInMiddleYellow(String text) {
    int consoleWidth = getConsoleWidth();
    int padding = (consoleWidth - text.length()) / 2;
    String coloredText =
        yellowColor + " ".repeat(padding) + text + " ".repeat(padding) + resetColor;

    System.out.println(coloredText);
  }

  /**
   * Displays text in blue in the center of the console
   *
   * @param text line of text
   */
  public void printInMiddleBlue(String text) {
    int consoleWidth = getConsoleWidth();
    int padding = (consoleWidth - text.length()) / 2;
    String coloredText = blueColor + " ".repeat(padding) + text + " ".repeat(padding) + resetColor;

    System.out.println(coloredText);
  }

  /**
   * Displays text in purple in the center of the console
   *
   * @param text line of text
   */
  public void printInMiddlePurple(String text) {
    int consoleWidth = getConsoleWidth();
    int padding = (consoleWidth - text.length()) / 2;
    String coloredText =
        purpleColor + " ".repeat(padding) + text + " ".repeat(padding) + resetColor;

    System.out.println(coloredText);
  }

  /**
   * Displays text in white in the center of the console
   *
   * @param text line of text
   */
  public void printInMiddleWhite(String text) {
    int consoleWidth = getConsoleWidth();
    int padding = (consoleWidth - text.length()) / 2;
    String coloredText = whiteColor + " ".repeat(padding) + text + " ".repeat(padding) + resetColor;

    System.out.println(coloredText);
  }

  /**
   * Displays the text in red
   *
   * @param text line of text
   */
  public void printRed(String text) {
    String coloredText = redColor + text + resetColor;
    System.out.println(coloredText);
  }

  /**
   * Displays the text in green
   *
   * @param text line of text
   */
  public void printGreen(String text) {
    String coloredText = greenColor + text + resetColor;
    System.out.println(coloredText);
  }

  /**
   * Displays the text in yellow
   *
   * @param text line of text
   */
  public void printYellow(String text) {
    String coloredText = yellowColor + text + resetColor;
    System.out.println(coloredText);
  }

  /**
   * Displays the text in blue
   *
   * @param text line of text
   */
  public void printBlue(String text) {
    String coloredText = blueColor + text + resetColor;
    System.out.println(coloredText);
  }

  /**
   * Displays the text in purple
   *
   * @param text line of text
   */
  public void printPurple(String text) {
    String coloredText = purpleColor + text + resetColor;
    System.out.println(coloredText);
  }

  /**
   * Displays the text in white
   *
   * @param text line of text
   */
  public void printWhite(String text) {
    String coloredText = whiteColor + text + resetColor;
    System.out.println(coloredText);
  }

  /**
   * Outputs text in standard color
   *
   * @param text line of text
   */
  public void print(String text) {
    System.out.println(text);
  }
}
