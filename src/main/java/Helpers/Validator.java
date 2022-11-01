package Helpers;
import javax.swing.JOptionPane;


public abstract class Validator {
    
    
    
    public static int Validate(int aValidar){
    boolean Pasa=false;
       do{
           aValidar=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el valor: "));
           if(aValidar>0){
               Pasa=true;
               
           }
           else{
               JOptionPane.showMessageDialog(null,"Por favor ingrese un valor numérico mayor a 0");
           }
       }while(Pasa!=true);
       
       
       return aValidar;
    }
    
    private static boolean intTryParse(String parseable){
        String value="";
        value=parseable;
        try {
            Integer.parseInt(parseable);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
    public static int ValidateProcessCC(int pValidar,int i){
    boolean Pasa=false;
    do{
       pValidar= Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la cantidad de ciclos","Proceso "+i,2));
       if(pValidar>0){
        Pasa=true;
        }
       else{
           JOptionPane.showMessageDialog(null,"Por favor ingrese un valor numérico mayor a 0");
       }
    
    }while(Pasa!=true);
    
       return pValidar;
    }
    
    public static int ValidateProcessTL(int pValidar,int i){
    boolean Pasa=false;
    do{
       pValidar= Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el Tiempo de Llegada ","Proceso "+i,2));
       if(pValidar>-1){
        Pasa=true;
        }
       else{
           JOptionPane.showMessageDialog(null,"Por favor ingrese un valor numérico mayor a -1");
       }
    
    }while(Pasa!=true);
    
       return pValidar;
    }
       
    public static int ValidateProcessRE(int pValidar,int i){
        boolean Pasa=false;
        
        do{       
        pValidar= Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el valor de la rafaga","Proceso "+i,2));
           if(pValidar>-1){
            Pasa=true;
            }
           else{
               JOptionPane.showMessageDialog(null,"Por favor ingrese un valor numérico mayor a -1");
           }
        
        }while(Pasa!=true);
        
           return pValidar;
        }


    
}