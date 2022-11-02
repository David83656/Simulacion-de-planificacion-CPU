package Helpers;

import javax.swing.JOptionPane;

import Global.ProccessColecction;
import Global.ScannerController;
import Global.Tabla;
import Models.Politicas;
import Models.Resultados;

public abstract class comparador {
    private static int[] results = new int[4];

    public static void fillResults(){

        PrintHelper.cls();
        ProccessColecction.submit();
        RSO.run(Politicas.JSF);
        results[0] = RSO.i - 1;
        System.out.println("Politica: JSF" );
        Resultados jsf = new Resultados(Tabla.tabla, ProccessColecction.getProcesos(), RSO.i - 1);
        jsf.calcularTiempoDeFinalizacionDeProcesos();
        RSO.resetRSO();
        //System.out.println("Pulse una tecla para ver el siguiente resultado");
        //ScannerController.pause();
        
        PrintHelper.cls();
        ProccessColecction.submit();
        RSO.run(Politicas.JSFD);
        results[1] = RSO.i - 1;
        System.out.println("Politica: JSFD" );
        Resultados jsfd = new Resultados(Tabla.tabla, ProccessColecction.getProcesos(), RSO.i - 1);
        jsfd.calcularTiempoDeFinalizacionDeProcesos();
        RSO.resetRSO();
        // System.out.println("Pulse una tecla para ver el siguiente resultado");
        //  ScannerController.pause();

        PrintHelper.cls();
        ProccessColecction.submit();
        RSO.run(Politicas.FIFO);
        results[2] = RSO.i - 1;
        System.out.println("Politica: FIFO" );
        Resultados fifo = new Resultados(Tabla.tabla, ProccessColecction.getProcesos(), RSO.i - 1);
        fifo.calcularTiempoDeFinalizacionDeProcesos();
        RSO.resetRSO();
        // System.out.println("Pulse una tecla para ver el siguiente resultado");
        // ScannerController.pause();

        PrintHelper.cls();
        ProccessColecction.submit();
        RSO.run(Politicas.RR);
        results[3] = RSO.i - 1;
        System.out.println("Politica: Round Robin" );
        Resultados rr = new Resultados(Tabla.tabla, ProccessColecction.getProcesos(), RSO.i - 1);
        rr.calcularTiempoDeFinalizacionDeProcesos();
        RSO.resetRSO();
        //System.out.println("Pulse una tecla para continuar");
        //ScannerController.pause();
    }
    public static void showResults(){

            //PrintHelper.cls();
            JOptionPane.showMessageDialog(null, (" JSF: "+results[0]+"\n"+" JSFD: "+results[1]+"\n"+" FIFO: "+results[2]+"\n"+" RR: "+results[3]+"\n"), "Resultados", 1);
            //System.out.println(" --- Comparativa entre politicas --- ");
            //System.out.println("Tiempo empleado por: ");
            //System.out.println("JSF: " + results[0]);
            //System.out.println("JSFD: " + results[1]);
            //System.out.println("FIFO: " + results[2]);
            //System.out.println("RR: " + results[3]);
           // ScannerController.pause();
    }
}
