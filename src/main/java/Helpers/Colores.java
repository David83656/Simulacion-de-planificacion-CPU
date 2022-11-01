package Helpers;

import Global.Parametros;

public abstract class Colores {
    private static final String reset = "\u001B[0m";
    public static String toColor(String text, Color color){
        while(text.length() < Parametros.cantidadDeProcesos) text += " ";
        return color.hashCode + text + reset;    
    }
    public static final Color red = new Color("\u001B[31m");
}

class Color{
    final String hashCode;
    Color(String hashCode){
        this.hashCode = hashCode;
    }
}



