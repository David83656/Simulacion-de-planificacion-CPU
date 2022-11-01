package Helpers;

import Global.Parametros;
import Global.ProccessColecction;
import Global.ScannerController;
import Global.Tabla;
import Models.Politicas;
import Models.Proceso;

public abstract class OptionHelper {
    public static void firstCase(){
        int cantidadDeProcesosOriginales = Parametros.cantidadDeProcesos;
        Proceso.tiempoES = Validator1.validate(1, "Ingrese el tiempo de entrada-salida, actual: " + Proceso.tiempoES);
        Parametros.quantum = Validator1.validate(1, "Ingrese el Quantum, actual: " + Parametros.quantum);
        Parametros.cantidadDeProcesos = Validator1.validate(1, "Ingrese la cantidad de procesos, actual: " + Parametros.cantidadDeProcesos);
        if(cantidadDeProcesosOriginales != Parametros.cantidadDeProcesos) {
          ProccessColecction.reiniciarProcesos();
          Proceso.reiniciarIdDeProcesos();
        }
    }
    public static void secondCase(){
        System.out.println("Usted eligió la opción ESTABLECER PARAMETROS.");
        ProccessColecction.reiniciarProcesos();
        ProccessColecction.setData();
        ProccessColecction.imprimirProcesos();
    }
    public static void runTableWith(Politicas politica){
        ProccessColecction.submit();
        RSO.run(politica);
        PrintHelper.showTable(Tabla.tabla, RSO.i + 1);
        ScannerController.pause();
    }
   
    public static boolean validateNotEmptyProcess(){
        if (ProccessColecction.isEmpty()) {
            System.out.println("Debe cargar procesos antes de ejecutar");
            ScannerController.pause();
            return false;
          }
          return true;
    }
}
