package Global;

public abstract class Tiempo {
    private static int tiempoActual = 0;

    public static int getTiempoActual() {
        return tiempoActual;
    }

    public static void incrementar() {
        tiempoActual ++; 
    }

    public static void reiniciar(){
        tiempoActual = 0;
    }

}
