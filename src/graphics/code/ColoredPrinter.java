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

  public static int getConsoleWidth() {
    return Math.max(40, Math.min(120, 80));
  }

  public void printInMiddleRed(String text) {
    int consoleWidth = getConsoleWidth();
    int padding = (consoleWidth - text.length()) / 2;
    String coloredText = redColor + " ".repeat(padding) + text + " ".repeat(padding) + resetColor;

    System.out.println(coloredText);
  }

  public void printInMiddleGreen(String text) {
    int consoleWidth = getConsoleWidth();
    int padding = (consoleWidth - text.length()) / 2;
    String coloredText = greenColor + " ".repeat(padding) + text + " ".repeat(padding) + resetColor;

    System.out.println(coloredText);
  }

  public void printInMiddleYellow(String text) {
    int consoleWidth = getConsoleWidth();
    int padding = (consoleWidth - text.length()) / 2;
    String coloredText =
        yellowColor + " ".repeat(padding) + text + " ".repeat(padding) + resetColor;

    System.out.println(coloredText);
  }

  public void printInMiddleBlue(String text) {
    int consoleWidth = getConsoleWidth();
    int padding = (consoleWidth - text.length()) / 2;
    String coloredText = blueColor + " ".repeat(padding) + text + " ".repeat(padding) + resetColor;

    System.out.println(coloredText);
  }

  public void printInMiddlePurple(String text) {
    int consoleWidth = getConsoleWidth();
    int padding = (consoleWidth - text.length()) / 2;
    String coloredText =
        purpleColor + " ".repeat(padding) + text + " ".repeat(padding) + resetColor;

    System.out.println(coloredText);
  }

  public void printInMiddleWhite(String text) {
    int consoleWidth = getConsoleWidth();
    int padding = (consoleWidth - text.length()) / 2;
    String coloredText = whiteColor + " ".repeat(padding) + text + " ".repeat(padding) + resetColor;

    System.out.println(coloredText);
  }

  public void printRed(String text) {
    String coloredText = redColor + text + resetColor;
  }

  public void printGreen(String text) {
    String coloredText = greenColor + text + resetColor;
  }

  public void printYellow(String text) {
    String coloredText = yellowColor + text + resetColor;
  }

  public void printBlue(String text) {
    String coloredText = blueColor + text + resetColor;
  }

  public void printPurple(String text) {
    String coloredText = purpleColor + text + resetColor;
  }

  public void printWhite(String text) {
    String coloredText = whiteColor + text + resetColor;
  }

  public void print(String text) {
    System.out.println(text);
  }
}

