package Global;

import Models.*;
import java.util.ArrayList;

public abstract class ProccessColecction {
  private static ArrayList<Proceso> procesos = new ArrayList<Proceso>();
  
  public static ArrayList<Proceso> getProcesos(){
    return procesos;
  }
  public static Proceso getProceso(int n) {
    return procesos.get(n);
  }

  public static boolean isEmpty(){
    return procesos.isEmpty();
  }

  public static void setData(){
    for(int i = 0; i < Parametros.cantidadDeProcesos; i++)
      addProceso(new Proceso());
  }

  public static void imprimirProcesos(){
     for(Proceso p : procesos)
      System.out.println(p);
  }

  public static void reiniciarProcesos(){
    procesos = new ArrayList<Proceso>();
  }

  public static void addProceso(Proceso proceso) {
    procesos.add(proceso);
  }

  public static void submit() {
    for (Proceso proceso : procesos){
      proceso.setTiempoEmpleado(0);
      Colas.total.add(proceso.clone());
    } 
  }
}
