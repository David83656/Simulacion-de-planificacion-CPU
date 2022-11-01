package Helpers;

import java.util.ArrayList;
import java.util.List;


public abstract class CargarDatos {
    public static List<Integer> cargarHemiciclos(int longitud){
        List<Integer> lista = new ArrayList<Integer>();
        for (int i = 0; i < longitud; i++) {
            System.out.println("Cuanto se demorará el hemiciclo de procesamiento N" + (i + 1) + "?");
            lista.add(5);
        }

        return lista;
    } 
}
