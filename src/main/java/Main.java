
import Frames.DataFrame;
import Global.ScannerController;
import Helpers.OptionSelecctedHelper;
import Helpers.PrintHelper;

public class Main {

  public static void main(String[] args) {
    int opt = 0;
    
    DataFrame D1=new DataFrame();
    D1.setVisible(true);
    
    
    PrintHelper.welcomeMessage();
    do {
      PrintHelper.showMenu();
      opt = ScannerController.getScanner().nextInt();
      OptionSelecctedHelper.optionSelectedController(opt);
      PrintHelper.cls();
    } while (opt != 7);

    ScannerController.dispose();
  }
}
