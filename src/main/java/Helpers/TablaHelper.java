package Helpers;

import java.util.ArrayList;

import Global.Colas;
import Global.Parametros;
import Global.Tabla;
import Global.Tiempo;
import Models.Proceso;

public abstract class TablaHelper {

  public static String tableToString(String[][] tabla, int tiempoRequerido){
    String tablaString = "";



    String celda;
    int minLenght = Parametros.cantidadDeProcesos;
    if(minLenght < 3) minLenght = 3;
    for (int y = 0; y < tabla.length; y++) {
      for (int x = 0; x < tiempoRequerido; x++) {

        
        celda = tabla[y][x] == null ? "   " : tabla[y][x];
        

        if(y == tabla.length - 1 && x == tiempoRequerido - 1) {
          tablaString += "|\n";
          break;
        };
        
        //Grabar Tiempo
        if(y == tabla.length - 1) celda = x + "";
        while(celda.length() < minLenght)
          celda += " ";
        if (y == 0 && x == 0) tablaString += ("Nuevo ");
        if (y == 1 && x == 0) tablaString += ("Listo ");
        if (y == 2 && x == 0) tablaString += ("Bloq  ");

        for(int i = 0; i < Parametros.cantidadDeProcesos; i++)
          if(y == i + 3 && x == 0)
          tablaString +=("P" + (i + 1)+ "    ");

        if (y == Parametros.cantidadDeProcesos + 3 && x == 0) tablaString +=("RSO   ");
        if (y == Parametros.cantidadDeProcesos + 4 && x == 0) tablaString +=("Tiempo");
        if (x == tabla[0].length - 1) {
          tablaString +=("|" + celda + "|");
          continue;
        }
        tablaString +=("|" + celda);
      }
      tablaString += "\n";
    }





    return tablaString;
  }


    public static void grabarEnTabla(){
        grabarCola(Colas.nuevo, 0);
        grabarCola(Colas.listo, 1);
        grabarCola(Colas.bloqueado, 2);
    }


    private static void grabarCola(ArrayList<Proceso> cola, int nf){
      int minLenght = Parametros.cantidadDeProcesos;
      if(minLenght < 3) minLenght = 3;
        if(!cola.isEmpty()){
            String n = "";
            for(Proceso p : cola) n += p.getId();
            while(n.length() < minLenght)
              n += " ";
            Tabla.tabla[nf][Tiempo.getTiempoActual()] = n;
          }
    }

    
}
