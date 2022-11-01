package Helpers;

import Global.Colas;
import Global.Ejecucion;
import Global.Parametros;
import Global.Tabla;
import Global.Tiempo;
import Models.Politicas;
import Models.Proceso;

public abstract class RSO {
  public static int i;

  public static void run(Politicas politica) {
    i = 0;

    Tabla.reiniciarTabla();
    for (
      Tiempo.getTiempoActual();
      Colas.terminado.size() < Parametros.cantidadDeProcesos;
      Tiempo.incrementar()
    ) {
      //Para evitar desbordamientos
      if (Tiempo.getTiempoActual() == Tabla.tabla[0].length) break;

      //Cargamos procesos a nuevo
      if (!Colas.total.isEmpty()) {
        for (Proceso p : Colas.total) {
          if (
            p.getTiempoDeLlegada() != Tiempo.getTiempoActual()
          ) continue; else Colas.nuevo.add(p);
        }
      }

      //Grabar datos previos en la tabla
      TablaHelper.grabarEnTabla();

      //Incrementar tiempo en bloqueo
      for (Proceso p : Colas.bloqueado) {
        //if(p.getTiempoBloqueado() >= 0 Envviroment.tiempoES )
        p.incrementarTiempoBloqueado();
      }
      i++;

      if (
        politica == Politicas.JSFD &&
        !Colas.nuevo.isEmpty() &&
        Ejecucion.hayProcesoEnEjecucion() &&
        Colas.nuevo.get(0).getTiempoRequerido() <
        Ejecucion.getProcesoEnEjecucion().getTiempoRequerido()
      ) {
        Tabla.tabla[Parametros.cantidadDeProcesos +
          3][Tiempo.getTiempoActual()] =
          "5P" + Ejecucion.getProcesoEnEjecucion().getId();
        Colas.listo.add(Ejecucion.getProcesoEnEjecucion());
        Colas.reordenarLista(Colas.listo, politica);
        Ejecucion.desalojar();
        continue;
      }
      //Preguntamos si debemos bloquear el proceso en ejecucion

      if (
        Ejecucion.hayProcesoEnEjecucion() &&
        Ejecucion.getProcesoEnEjecucion().deboBloquear()
      ) {
        Ejecucion.reiniciarTiempoEnEjecucion();

        //Terminamos el proceso
        if (
          Ejecucion.getProcesoEnEjecucion().getRafagasDeEjecucion().size() == 1
        ) {
          Tabla.tabla[Parametros.cantidadDeProcesos +
            3][Tiempo.getTiempoActual()] =
            "6P" + Ejecucion.getProcesoEnEjecucion().getId();
          Colas.terminado.add(Ejecucion.getProcesoEnEjecucion());
          Ejecucion.desalojar();
          continue;
        }
        Tabla.tabla[Parametros.cantidadDeProcesos +
          3][Tiempo.getTiempoActual()] =
          "3P" + Ejecucion.getProcesoEnEjecucion().getId();
        Ejecucion.bloquearProceso(Ejecucion.getProcesoEnEjecucion());
        continue;
      }

      if (
        politica == Politicas.RR &&
        Ejecucion.hayProcesoEnEjecucion() &&
        Ejecucion.getTiempoEjecutando() >= Parametros.quantum
      ) {
        Ejecucion.reiniciarTiempoEnEjecucion();
        Tabla.tabla[Parametros.cantidadDeProcesos +
          3][Tiempo.getTiempoActual()] =
          "5P" + Ejecucion.getProcesoEnEjecucion().getId();
        Colas.listo.add(Ejecucion.getProcesoEnEjecucion());
        Ejecucion.desalojar();
        continue;
      }

      //Ejecutar mi proceso si no require ser bloqueado
      if (Ejecucion.hayProcesoEnEjecucion()) {
        Tabla.tabla[Ejecucion.getProcesoEnEjecucion().getId() +
          2][Tiempo.getTiempoActual()] =
          " X ";
        Ejecucion.getProcesoEnEjecucion().ejecutarProceso();
        Ejecucion.incrementarTiempoEjecutando();
        continue;
      }

      //Cargar procesos
      if (!Colas.nuevo.isEmpty()) {
        Tabla.tabla[Parametros.cantidadDeProcesos +
          3][Tiempo.getTiempoActual()] =
          "1P" + Colas.nuevo.get(0).getId();
        NuevoListo(Colas.nuevo.get(0), politica);
        continue;
      }

      if (!Colas.bloqueado.isEmpty()) {
        boolean deboContinuar = false;
        for (Proceso p : Colas.bloqueado) {
          if (p.deboDesbloquear()) {
            Colas.listo.add(p);
            Colas.reordenarLista(Colas.listo, politica);
            Colas.bloqueado.remove(p);
            Tabla.tabla[Parametros.cantidadDeProcesos +
              3][Tiempo.getTiempoActual()] =
              "4P" + p.getId();
            deboContinuar = true;
            break;
          }
        }
        if (deboContinuar) continue;
      }

      //Mandar procesos de listo a ejecucion
      if (!Colas.listo.isEmpty()) {
        Colas.reordenarLista(Colas.listo, politica);
        ListoEjecucion(Colas.listo.get(0));
        continue;
      }
    }
    Tiempo.reiniciar();
    Colas.reiniciarColas();
  }

  public static void NuevoListo(Proceso proceso, Politicas politica) {
    //Cambio de colas
    int i = Colas.nuevo.indexOf(proceso);
    Colas.nuevo.remove(i);
    Colas.listo.add(proceso);
    Colas.reordenarLista(Colas.listo, politica);

    //Gravo en la tabla
    Tabla.tabla[1][Tiempo.getTiempoActual() + 1] = "P" + proceso.getId() + " ";
  }

  public static void ListoEjecucion(Proceso proceso) {
    int i = Colas.listo.indexOf(proceso);
    Colas.listo.remove(i);
    Ejecucion.ejecutar(proceso);
    Tabla.tabla[Parametros.cantidadDeProcesos + 3][Tiempo.getTiempoActual()] =
      "2P" + proceso.getId();
  }
}
