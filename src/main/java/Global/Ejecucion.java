package Global;

import java.util.ArrayList;

import Models.Proceso;

public abstract class Ejecucion {
    private static Proceso enEjecucion;
    private static int tiempoEjecutando = 0;
    private static ArrayList<Integer> historialDeEjecucion = new ArrayList<Integer>();

    public static int getTiempoEjecutando(){
      return tiempoEjecutando;
    }

    public static void incrementarTiempoEjecutando(){
      tiempoEjecutando++;
    }

    public static void reiniciarTiempoEnEjecucion(){
      tiempoEjecutando = 0;
    } 

    public static Proceso getProcesoEnEjecucion(){
        return enEjecucion;
    }
    public static boolean hayProcesoEnEjecucion(){
        return enEjecucion != null;
    }
    public static void ejecutar(Proceso proceso){
      historialDeEjecucion.add(proceso.getId());
        enEjecucion = proceso;
    }
    public static void bloquearProceso(Proceso proceso){
      enEjecucion = null;
      proceso.reducirLongitudDeRafaga();
      proceso.setTiempoBloqueado(0);
      proceso.setTiempoEmpleado(0);
      Colas.bloqueado.add(proceso);
    }
    public static void desalojar(){
      enEjecucion = null;
    }

}
