import java.util.Scanner;

public class Utils {
    public static void imprimirArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(arreglo[i]);
        }
    }

    public static int[] llenarArreglo(int[] arreglo, int numero, Scanner sc){
        for (int i = 0; i < numero; i++) {
            System.out.print("Cédula " + (i + 1) + ": ");
            arreglo[i] = sc.nextInt();
        }
        return arreglo;
    }

    public static void validarEstudiantesReprobados(int contadorAmbos, int[] ambos){
        if (contadorAmbos == 0) {
            System.out.println("Ningún estudiante reprobó ambas materias.");
        } else {
            for (int i = 0; i < contadorAmbos; i++) {
                System.out.println(ambos[i]);
            }
        }
    }
}
