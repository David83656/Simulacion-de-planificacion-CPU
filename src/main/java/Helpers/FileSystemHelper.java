package Helpers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public abstract class FileSystemHelper {

public static boolean shouldSaveTxt() {
    Scanner sc = new Scanner(System.in);
    System.out.println("¿Desea guardar la tabla en un archivo de texto?");
    ArrayList<String> validAnswers = new ArrayList<String>(
      Arrays.asList("si", "s", "true", "y", "yes")
    );
    String response = sc.nextLine();
    response = response.toLowerCase().trim();
    return validAnswers.contains(response);
  }

  public static void saveTxt(String data, String path, String fileName) {
    try {
      FileWriter fw = new FileWriter(path + "\\" + fileName); 

      fw.write(data);
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    
    
  }

  
}
