package Models;

import Global.Ejecucion;
import Global.Parametros;
//PLANTILLA PARA CLASE PROCESO
import Helpers.PrintHelper;
import Helpers.Validator;

import java.util.ArrayList;
import java.util.Scanner;

public class Proceso {
  //FUNCION SCANEO
  static Scanner sc = new Scanner(System.in);
  public static int tiempoES = 3;

  //CARACTERÍSTICAS
  private static int cantidadDeProcesos = 0;
  private int  dato;
  private int CantidadCiclos;
  private int tiempoDeLlegada;
  private int id;
  private int tiempoRequerido = 0;
  private int tiempoEmpleado = 0;
  private ArrayList<Integer> rafagasDeEjecucion;
  private int tiempoBloqueado = 0;

  public int getId() {
    return id;
  }

  //METODOS

  public Proceso() {
    PrintHelper.cls();
    if (cantidadDeProcesos == Parametros.cantidadDeProcesos) cantidadDeProcesos = 0;
    cantidadDeProcesos++;
    System.out.println("Proceso: " + cantidadDeProcesos);
    this.id = cantidadDeProcesos;
    this.CantidadCiclos=Validator.ValidateProcessCC(CantidadCiclos, cantidadDeProcesos);
    this.tiempoDeLlegada=Validator.ValidateProcessTL(tiempoDeLlegada, cantidadDeProcesos);    
    this.rafagasDeEjecucion = new ArrayList<Integer>();
    for (int i = 0; i < CantidadCiclos; i++) {
        dato = Validator.ValidateProcessRE(dato, cantidadDeProcesos);
        this.tiempoRequerido += dato;
        this.rafagasDeEjecucion.add(dato);
    }
  }

  public Proceso(
    int id,
    int tiempoDeLlegada,
    ArrayList<Integer> rafagasDeEjecucion
  ) {
    this.id = id;
    this.tiempoDeLlegada = tiempoDeLlegada;
    this.rafagasDeEjecucion = new ArrayList<Integer>(rafagasDeEjecucion);
    for(Integer i : this.rafagasDeEjecucion)
      this.tiempoRequerido += i;
  }

  public Integer getTiempoRequeridoRafaga(){
    return this.rafagasDeEjecucion.get(0);
  }

  public Proceso clone() {
    return new Proceso(this.id, this.tiempoDeLlegada, this.rafagasDeEjecucion);
  }

  public static void reiniciarIdDeProcesos(){
    cantidadDeProcesos = 0;
}

  public void reducirLongitudDeRafaga() {
    this.rafagasDeEjecucion.remove(0);
  }

  public void incrementarTiempoBloqueado() {
    this.tiempoBloqueado++;
  }

  public ArrayList<Integer> getRafagasDeEjecucion() {
    return this.rafagasDeEjecucion;
  }

  public void setTiempoBloqueado(int i) {
    this.tiempoBloqueado = i;
  }

  public void setTiempoEmpleado(int i) {
    this.tiempoEmpleado = i;
  }

  public int getTiempoBloqueado() {
    return this.tiempoBloqueado;
  }

  public void ejecutarProceso() {
    if (this.deboBloquear()) {
      Ejecucion.bloquearProceso(this);
      if (this.rafagasDeEjecucion.size() == 0) return;
      this.rafagasDeEjecucion.remove(0);
    } else this.tiempoEmpleado++;
  }

  public boolean deboBloquear() {
    return this.tiempoEmpleado >= this.rafagasDeEjecucion.get(0);
  }

  public boolean deboDesbloquear() {
    return this.tiempoBloqueado >= tiempoES;
  }

  public int getTiempoDeLlegada() {
    return tiempoDeLlegada;
  }

  public int getTiempoRequerido() {
    return this.tiempoRequerido;
  }

  public void setTiempoDeLlegada(int tiempoDeLlegada) {
    this.tiempoDeLlegada = tiempoDeLlegada;
  }

  @Override
  public String toString() {
    return (
      "{\n  id: " +
      this.id +
      "\n  tiempoRequerido: " +
      this.tiempoRequerido +
      "\n  tiempoEmpleado: " +
      this.tiempoEmpleado +
      "\n  rafagas: " +
      this.rafagasDeEjecucion +
      "\n}"
    );
  }
}
