import java.util.Random;

public class Utils {
    static Random rand = new Random();

    public static int[][] generarMatriz(int m, int n) {
        int[][] matriz = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                matriz[i][j] = rand.nextInt(20) + 1;
        return matriz;
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int val : fila)
                System.out.printf("%5d", val);
            System.out.println();
        }
    }

    public static int[][] sumar(int[][] a, int[][] b) {
        int m = a.length, n = a[0].length;
        int[][] resultado = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                resultado[i][j] = a[i][j] + b[i][j];
        return resultado;
    }

    public static int[][] restar(int[][] a, int[][] b) {
        int m = a.length, n = a[0].length;
        int[][] resultado = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                resultado[i][j] = a[i][j] - b[i][j];
        return resultado;
    }

    public static int[][] multiplicar(int[][] a, int[][] b) {
        if (a[0].length != b.length) return null;
        int filas = a.length, cols = b[0].length, comun = b.length;
        int[][] resultado = new int[filas][cols];
        for (int i = 0; i < filas; i++)
            for (int j = 0; j < cols; j++)
                for (int k = 0; k < comun; k++)
                    resultado[i][j] += a[i][k] * b[k][j];
        return resultado;
    }

    public static int[][] trasponer(int[][] a) {
        int m = a.length, n = a[0].length;
        int[][] resultado = new int[n][m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                resultado[j][i] = a[i][j];
        return resultado;
    }
}
