import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de estudiantes: ");
        int numero = sc.nextInt();

        int[] matematica = new int[numero];
        int[] ingles = new int[numero];
        int[] ambos = new int[numero];
        int contadorAmbos = 0;

        System.out.println("\nIngrese las cédulas de los estudiantes que reprobaron MATEMATICA:");
        Utils.llenarArreglo(matematica,numero,sc);

        System.out.println("\nIngrese las cédulas de los estudiantes que reprobaron INGLES:");
        Utils.llenarArreglo(ingles,numero,sc);

        for (int i = 0; i < numero; i++) {
            for (int j = 0; j < numero; j++) {
                if (matematica[i] == ingles[j]) {
                    ambos[contadorAmbos] = matematica[i];
                    contadorAmbos++;
                    break;
                }
            }
        }

        System.out.println("\n--- ESTUDIANTES QUE REPROBARON MATEMATICA ---");
        Utils.imprimirArreglo(matematica);

        System.out.println("\n--- ESTUDIANTES QUE REPROBARON INGLES ---");
        Utils.imprimirArreglo(ingles);

        System.out.println("\n--- ESTUDIANTES QUE REPROBARON AMBAS MATERIAS ---");
        Utils.validarEstudiantesReprobados(contadorAmbos,ambos);

        sc.close();
    }

}