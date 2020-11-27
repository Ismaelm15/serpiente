/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ismael.serpiente;

import java.util.Scanner;

/**
 *
 * @author ismael
 */
public class serpiente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner ser = new Scanner(System.in);
        int k = 0, mediciones,comienzo=0,duracion=0,duracionmax=0;

        int nmediciones[] = null;
        System.out.println("Introduzca el numero de mediciones");
        mediciones = ser.nextInt();
        System.out.println("Introduce número de mediciones consecutivas por debajo del umbral(k)");
        k = ser.nextInt();
        nmediciones = new int[mediciones];
        System.out.println("Introduzca las " + mediciones + " mediciones");
        for (int i = 0; i < nmediciones.length; i++) {
            nmediciones[i] = ser.nextInt();
            if (nmediciones[i] != 1 && nmediciones[i] != 0) {
                i--;
                System.out.println("Ha introducido un numero erroneo intentelo de nuevo");
            }
        }
        for (int j=0;j<nmediciones.length;j++){
        if (nmediciones[j]==1){ 
            duracion++;
        }else{duracion=0;}
        
        if (duracionmax<duracion){
            comienzo=duracion-j;
        duracionmax=duracion;
        }
        
        
        
        }
        
    }

}
