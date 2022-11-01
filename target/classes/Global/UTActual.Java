abstract class UTActual{
    private static int tiempoActual = 0;
    public int getTiempoActual(){
        return tiempoActual;
    }
    public void incrementTiempoActual(){
        tiempoActual += 10;
    }
}