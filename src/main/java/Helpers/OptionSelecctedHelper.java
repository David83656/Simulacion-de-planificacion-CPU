package Helpers;

import Global.Tabla;
import Models.Politicas;

public abstract class OptionSelecctedHelper {

  public static void optionSelectedController(int opt) {
    PrintHelper.cls();
    switch (opt) {
      case 1:
        OptionHelper.firstCase();
        break;
      case 2:
        OptionHelper.secondCase();
        break;
      case 3:
        if (!OptionHelper.validateNotEmptyProcess()) break;
        OptionHelper.runTableWith(Politicas.JSF);
        if (FileSystemHelper.shouldSaveTxt()) FileSystemHelper.saveTxt(
          TablaHelper.tableToString(Tabla.tabla, RSO.i + 1),
          System.getProperty("user.home") + "/desktop",
          "JSF.txt"
        );
        break;
      case 4:
        if (!OptionHelper.validateNotEmptyProcess()) break;
        OptionHelper.runTableWith(Politicas.JSFD);
        if (FileSystemHelper.shouldSaveTxt()) FileSystemHelper.saveTxt(
          TablaHelper.tableToString(Tabla.tabla, RSO.i + 1),
          System.getProperty("user.home") + "/desktop",
          "JSFD.txt"
        );
        break;
      case 5:
        if (!OptionHelper.validateNotEmptyProcess()) break;
        OptionHelper.runTableWith(Politicas.FIFO);
        if (FileSystemHelper.shouldSaveTxt()) FileSystemHelper.saveTxt(
          TablaHelper.tableToString(Tabla.tabla, RSO.i + 1),
          System.getProperty("user.home") + "/desktop",
          "FIFO.txt"
        );
        break;
      case 6:
        if (!OptionHelper.validateNotEmptyProcess()) break;
        OptionHelper.runTableWith(Politicas.RR);
        if (FileSystemHelper.shouldSaveTxt()) FileSystemHelper.saveTxt(
          TablaHelper.tableToString(Tabla.tabla, RSO.i + 1),
          System.getProperty("user.home") + "/desktop",
          "Round Robin.txt"
        );
        break;
    }
  }
}
