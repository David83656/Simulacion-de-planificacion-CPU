package Global;

public abstract class Tabla {
  public static String[][] tabla = new String[Parametros.cantidadDeProcesos + 5][1024];
  public static void reiniciarTabla(){
    tabla = new String[Parametros.cantidadDeProcesos + 5][1024];
  }
  /*
     0 - Nuevo
     1 - Listo
     2 - Bloqueado
     3 - p1
     4 - p2
     5 - p3
     6 - RSO
     7 - UT
    */


}
