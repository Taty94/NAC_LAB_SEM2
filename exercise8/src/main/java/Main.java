import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== GRADO DE EFICIENCIA DE OPERARIOS ===\n");
        System.out.print("Ingrese el numero de operarios (N): ");
        int n = scanner.nextInt();

        int[]    codigos      = Utils.generarCodigos(n);
        double[] horas        = Utils.generarHorasAusencia(n);
        int[]    defectuosos  = Utils.generarDefectuosos(n);
        int[]    producidos   = Utils.generarProducidos(n);
        int[]    grados       = new int[n];

        for (int i = 0; i < n; i++)
            grados[i] = Utils.calcularGrado(horas[i], defectuosos[i], producidos[i]);

        System.out.println("\n--- REPORTE DE OPERARIOS ---");
        Utils.imprimirReporte(codigos, horas, defectuosos, producidos, grados, n);

        System.out.println("\n--- CONDICIONES EVALUADAS ---");
        System.out.println("  C1: Ausencia <= 3 horas");
        System.out.println("  C2: Defectuosos < 300");
        System.out.println("  C3: Producidos > 10000");
        System.out.println("\n--- TABLA DE GRADOS ---");
        System.out.println("  Ninguna        → Grado  5");
        System.out.println("  Solo C1        → Grado  7");
        System.out.println("  Solo C2        → Grado  8");
        System.out.println("  Solo C3        → Grado  9");
        System.out.println("  C1 y C2        → Grado 12");
        System.out.println("  C1 y C3        → Grado 13");
        System.out.println("  C2 y C3        → Grado 15");
        System.out.println("  C1, C2 y C3   → Grado 20");

        scanner.close();
    }
}