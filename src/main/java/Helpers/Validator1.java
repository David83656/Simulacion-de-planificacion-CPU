/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;


import java.util.Scanner;

public abstract class Validator1 {

    public static int validate(int minValue, String msg){
        System.out.println(msg);
        String value = "NULL";
        boolean isValidValue = false;
        while(!isValidValue){
            value = new Scanner(System.in).nextLine();
            isValidValue = intTryParse(value);
            if(!intTryParse(value)) {
                System.out.println("Ingrese un numero valido");
                continue;
            }
            isValidValue = isValidValue && Integer.parseInt(value) >= minValue;
            if(Integer.parseInt(value) < minValue) System.out.println("El numero no debe ser menor a " + minValue);
        }
        return Integer.parseInt(value);
    }
    private static boolean intTryParse(String parseable){
        try {
            Integer.parseInt(parseable);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
