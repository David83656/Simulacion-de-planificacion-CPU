package Global;

import java.util.Scanner;

public abstract class ScannerController {
  private static Scanner sc = new Scanner(System.in);

  public static Scanner getScanner() {
    return sc;
  }

  public static void dispose() {
    sc.close();
  }

  public static void pause() {
    new Scanner(System.in).nextLine();
}
}
