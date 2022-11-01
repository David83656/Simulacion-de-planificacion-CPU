package Global;

import Models.Politicas;
import Models.Proceso;
import java.util.ArrayList;

public abstract class Colas {
  public static ArrayList<Proceso> total = new ArrayList<Proceso>();
  public static ArrayList<Proceso> nuevo = new ArrayList<Proceso>();
  public static ArrayList<Proceso> listo = new ArrayList<Proceso>();
  public static ArrayList<Proceso> bloqueado = new ArrayList<Proceso>();
  public static ArrayList<Proceso> terminado = new ArrayList<Proceso>();

  public static void reiniciarColas() {
    total = new ArrayList<Proceso>();
    nuevo = new ArrayList<Proceso>();
    listo = new ArrayList<Proceso>();
    bloqueado = new ArrayList<Proceso>();
    terminado = new ArrayList<Proceso>();
  }

  public static void reordenarLista(ArrayList<Proceso> lista, Politicas politica) {
   if(politica == Politicas.JSF || politica == Politicas.JSFD)
    reordenarListaJSF(lista);
   if(politica == Politicas.FIFO)
    reordenarListaFIFO(lista);
    
  }
  public static void reordenarListaJSF(ArrayList<Proceso> lista) {
    Proceso aux;
    for (int i = 0; i < lista.size() - 1; i++) {
      for (int j = 0; j < lista.size() - i - 1; j++) {
        if (
          lista.get(j + 1).getTiempoRequeridoRafaga() <
          lista.get(j).getTiempoRequeridoRafaga()
        ) {
          aux = lista.get(j + 1);
          lista.set(j + 1, lista.get(j));
          lista.set(j, aux);
        }
      }
    }
  }
  public static void reordenarListaFIFO(ArrayList<Proceso> lista) {
    Proceso aux;
    for (int i = 0; i < lista.size() - 1; i++) {
      for (int j = 0; j < lista.size() - i - 1; j++) {
        if (
          lista.get(j + 1).getTiempoDeLlegada() <
          lista.get(j).getTiempoDeLlegada()
        ) {
          aux = lista.get(j + 1);
          lista.set(j + 1, lista.get(j));
          lista.set(j, aux);
        }
      }
    }
  }
}
