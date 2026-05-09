import java.util.Random;

public class Utils {
    static final int MATERIAS = 8;
    static Random rand = new Random();

    public static int[] generarCodigos(int n) {
        int[] codigos = new int[n];
        for (int i = 0; i < n; i++)
            codigos[i] = 1000 + (i + 1);
        return codigos;
    }

    public static double[][] generarCalificaciones(int n) {
        double[][] notas = new double[n][MATERIAS];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < MATERIAS; j++)
                notas[i][j] = Math.round((rand.nextDouble() * 6 + 4) * 10.0) / 10.0;
        return notas;
    }

    public static void imprimirTabla(int[] codigos, double[][] notas, int n) {
        System.out.printf("%-12s", "Codigo");
        for (int j = 0; j < MATERIAS; j++)
            System.out.printf("%-10s", "Mat." + (j + 1));
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.printf("%-12d", codigos[i]);
            for (int j = 0; j < MATERIAS; j++)
                System.out.printf("%-10.1f", notas[i][j]);
            System.out.println();
        }
    }

    // a. Promedio por estudiante
    public static double[] promedioPorEstudiante(double[][] notas, int n) {
        double[] promedios = new double[n];
        for (int i = 0; i < n; i++) {
            double suma = 0;
            for (int j = 0; j < MATERIAS; j++)
                suma += notas[i][j];
            promedios[i] = Math.round((suma / MATERIAS) * 100.0) / 100.0;
        }
        return promedios;
    }

    // b. Promedio por materia
    public static double[] promedioPorMateria(double[][] notas, int n) {
        double[] promedios = new double[MATERIAS];
        for (int j = 0; j < MATERIAS; j++) {
            double suma = 0;
            for (int i = 0; i < n; i++)
                suma += notas[i][j];
            promedios[j] = Math.round((suma / n) * 100.0) / 100.0;
        }
        return promedios;
    }

    // c. Estudiante con mayor promedio
    public static int indiceMayorPromedio(double[] promedios) {
        int idx = 0;
        for (int i = 1; i < promedios.length; i++)
            if (promedios[i] > promedios[idx])
                idx = i;
        return idx;
    }

    // d. Aprobados por materia (nota >= 7 y <= 10)
    public static int[] aprobadosPorMateria(double[][] notas, int n) {
        int[] aprobados = new int[MATERIAS];
        for (int j = 0; j < MATERIAS; j++)
            for (int i = 0; i < n; i++)
                if (notas[i][j] >= 7 && notas[i][j] <= 10)
                    aprobados[j]++;
        return aprobados;
    }

    // e. Reprobados por materia (nota < 7)
    public static int[] reprobadosPorMateria(double[][] notas, int n) {
        int[] reprobados = new int[MATERIAS];
        for (int j = 0; j < MATERIAS; j++)
            for (int i = 0; i < n; i++)
                if (notas[i][j] < 7)
                    reprobados[j]++;
        return reprobados;
    }
}
