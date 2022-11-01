package Helpers;

import Global.Parametros;

public abstract class PrintHelper {

  public static void showMenu() {
    System.out.println("1/Establecer Parametros");
    System.out.println("2/Cargar Procesos");
    System.out.println("3/Mostrar grafica de la primer politica JSF");
    System.out.println("4/Mostrar grafica de la segunda politica JSF/D");
    System.out.println("5/Mostrar grafica de la tercer politica FIFO");
    System.out.println("6/Mostrar grafica de la cuarta politica ROUND ROBIN");
    System.out.println("Pulse otra tecla para salir");
  }

  public static void welcomeMessage() {
    System.out.println("Bienvenido al menu del proyecto.");
    System.out.println(
      "A continuacion digite un numero para seleccionar una opcion: "
    );
  }

  public static void cls() {
    System.out.print("\033[H\033[2J");
  }

  public static void showTable(String[][] tabla, int tiempoRequerido) {
    String celda;
    int minLenght = Parametros.cantidadDeProcesos;
    if(minLenght < 3) minLenght = 3;
    for (int y = 0; y < tabla.length; y++) {
      for (int x = 0; x < tiempoRequerido; x++) {
        celda = tabla[y][x] == null ? "   " : tabla[y][x];

        if(celda.contains("6P")){
          celda = Colores.toColor(celda ,Colores.red);
        }

        if(y == tabla.length - 1 && x == tiempoRequerido - 1) {
          System.out.println("|");
          break;
        };
        
        //Grabar Tiempo
        if(y == tabla.length - 1) celda = x + "";
        while(celda.length() < minLenght)
          celda += " ";
        if (y == 0 && x == 0) System.out.print("Nuevo ");
        if (y == 1 && x == 0) System.out.print("Listo ");
        if (y == 2 && x == 0) System.out.print("Bloq  ");

        for(int i = 0; i < Parametros.cantidadDeProcesos; i++)
          if(y == i + 3 && x == 0)
            System.out.print("P" + (i + 1)+ "    ");

        if (y == Parametros.cantidadDeProcesos + 3 && x == 0) System.out.print("RSO   ");
        if (y == Parametros.cantidadDeProcesos + 4 && x == 0) System.out.print("Tiempo");
        if (x == tabla[0].length - 1) {
          System.out.print("|" + celda + "|");
          continue;
        }
        System.out.print("|" + celda);
      }
      System.out.println();
    }
  }
}
