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


    static Scanner serp = new Scanner(System.in);

    public static void main(String[] args) {
        
        //creamos un string
        String salida = "";
        do {
            //creamos las variables y los valores 
            int n = nmediciones();
            int k = umb();
            //con la variable n creamos el array lecturas
            int[] lecturas = new int[n];
            //bucle for para leer datos
            for (int i = 0; i < n; i++) {
                lecturas[i] = lecturaDato();
            }
            //la funcion procesamiento hace todo el trabajo del programa
            procesamiento(lecturas, k);
            do {
                //condicion de repeticion del programa
                System.out.println("¿Desea realizar otra medición? (Sí/No");
                salida = serp.nextLine();
            } while (salida.compareToIgnoreCase("Sí") != 0 && salida.compareToIgnoreCase("No") != 0);

        } while (salida.compareToIgnoreCase("Sí") == 0);

    }

    public static int nmediciones() {

        //creamos una variable n
        int n = 0;
        System.out.println("Introduzca el número de mediciones: ");
        //se repite hasta que no se metan los datos correctamente
        
        do {
            //captura de la excepcion NumberFormatException
            try {
                n = serp.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("Error en la introducción de datos, inténtelo de nuevo. ");
            }
            if (n < 1 || n > 100) {
                System.out.println("Dato fuera de rango, introduzca un número entero entre 1 y 100. ");
            }
        } while (n < 1 || n > 100);
        return n;
    }

    public static int umb() {

        //Control del do while
        int k = 0;
        System.out.println("Introduzca el número de mediciones consecutivas por debajo del umbral (k): ");
        //Inserccion del array
        do {
            //captura de la excepcion NumberFormatException
            try {
                k = serp.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("Error , inténtelo de nuevo. ");
            }
            if (k < 0) {
                System.out.println("Dato fuera de rango, intentelo de nuevo");
            }
        } while (k < 0);
        return k;
    }

    public static int lecturaDato() {

        
        int numero = 0;
        do {
            //pedimos numeros
            System.out.println("Introduzca un 0 o un 1: ");
            //capturamos de la excepcion NumberFormatException
            
            try {
                numero = serp.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("Error, inténtelo de nuevo. ");
            }
            if (numero != 0 && numero != 1) {
                System.out.println("Debe introducir un uno o un cero, inténtelo de nuevo");
            }
        } while (numero != 0 && numero != 1);
        //Limpiamos el \n
        serp.nextLine();
        return numero;
    }

    public static void procesamiento(int[] lecturas, int k) {
        //creamos las variables 
        int contador = 0;
        int contFinal = 0;
        int contCero = 0;
        int contUno = 0;
        int contUnoFinal = 0;
        int comienzo = -1;
        int comienzoFinal = 0;

        for (int j = 0; j < lecturas.length; j++) {
            //si no tenemos una posición de inicio, buscamos el primer uno
            if (lecturas[j] == 1 && comienzo == -1) {
            //cuando lo tenemos, guardamos la posición y aumentamos los contadores de unos y de tamaño del segmento
                comienzo = j;
                contUno++;
                contador++;
            //en caso de encontrar otro uno, comprobamos si estamos en la última posición del array
            } else if (lecturas[j] == 1 && comienzo != -1) {
                //si lo está, aumentamos en contador y comparamos el segmento actual con el segmento anterior, si lo hay
                if (j == lecturas.length - 1) {
                    contador++;
                    //si el segmento anterior recorre más posiciones , se guardan las del nuevo como las que se presentarán por pantalla
                    if (contFinal < contador) {
                        contFinal = contador;
                        comienzoFinal = comienzo;
                        contUnoFinal = contUno;
                        //reseteamos a los valores a los iniciales
                        contador = 0;
                        comienzo = -1;
                        contCero = 0;
                        contUno = 0;
                    //si tienen el mismo tamaño, comparamos el número de unos y sobreescribimos datos
                    } else if (contFinal == contador && contUno > contUnoFinal) {
                        contFinal = contador;
                        comienzoFinal = comienzo;
                        contUnoFinal = contUno;
                        //reseteamos a los valores a los iniciales
                        contador = 0;
                        comienzo = -1;
                        contCero = 0;
                        contUno = 0;
                    } else {
                        //si no se dan los casos anteriores, reseteamos a los valores iniciales
                        contador = 0;
                        comienzo = -1;
                        contCero = 0;
                        contUno = 0;
                    }
                } else {
                    contador++;
                    contCero = 0;
                    contUno++;
                }
            } else if (lecturas[j] == 0 && comienzo != -1) {
                contCero++;
                if (j != lecturas.length-1) {
                    if (contCero <= k && lecturas[j + 1] == 1) {
                        contador += contCero;
                    }
                }

                if (contCero > k) {
                    //si se supera el umbral k entonces se resetea el array final
                    if (contFinal < contador) {
                        contFinal = contador;
                        comienzoFinal = comienzo;
                        contUnoFinal = contUno;
                        //reseteamos a los valores iniciales
                        contador = 0;
                        comienzo = -1;
                        contCero = 0;
                        contUno = 0;
                    //si se da el caso de que tienen el mismo tamaño, comparamos el número de unoss
                    } else if (contFinal == contador && contUno > contUnoFinal) {
                        contFinal = contador;
                        comienzoFinal = comienzo;
                        contUnoFinal = contUno;
                        //reseteamos a los valores iniciales
                        contador = 0;
                        comienzo = -1;
                        contCero = 0;
                        contUno = 0;
                    } else {
                        //si no se dan los casos anteriores, reseteamos a los valores iniciales
                        contador = 0;
                        comienzo = -1;
                        contCero = 0;
                        contUno = 0;
                    }

                }
            }
        }
        //imprimimos por pantalla
        System.out.println("Resultado: El periodo óptimo tiene longitud " + contFinal + " comienza en la medición " + (comienzoFinal + 1));

    }
}
