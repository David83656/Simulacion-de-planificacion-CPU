package Models;

import java.util.ArrayList;

import Global.Parametros;
import javax.swing.JOptionPane;

public class Resultados {
    private String[][] tabla;
    private ArrayList<Proceso> procesos;
    private ArrayList<Proceso> ordenDeFinalizacionDeProcesos = new ArrayList<Proceso>();

    public Resultados(
        String[][] tabla,
        ArrayList<Proceso> procesos,
        int tiempoRequerido
    ){
        this.tabla = tabla;
        this.procesos = procesos;
    }

    public void calcularTiempoDeFinalizacionDeProcesos(){
        for(int i = 0; i < this.tabla[0].length; i++){
            String celda = this.tabla[Parametros.cantidadDeProcesos + 3][i];
            if( celda == null ) continue;
            if(!celda.contains("6P")) continue;
            int idDelProcesoFinalizado = Integer.parseInt(celda.split("P")[1]);
            for(Proceso p : procesos){
                if(p.getId() != idDelProcesoFinalizado) continue;
                ordenDeFinalizacionDeProcesos.add(p.clone());
            }
        }
        for(Proceso p : ordenDeFinalizacionDeProcesos){
            JOptionPane.showMessageDialog(null,p.toBeautyString());
        }
    }
}
