import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SISTEMA UNIVERSITARIO ===\n");
        System.out.print("Ingrese el numero de estudiantes (N): ");
        int n = scanner.nextInt();

        int[]    codigos = Utils.generarCodigos(n);
        double[][] notas = Utils.generarCalificaciones(n);

        System.out.println("\n--- TABLA DE CALIFICACIONES ---");
        Utils.imprimirTabla(codigos, notas, n);

        // a. Promedio por estudiante
        double[] promEstudiante = Utils.promedioPorEstudiante(notas, n);
        System.out.println("\na. PROMEDIO POR ESTUDIANTE:");
        for (int i = 0; i < n; i++)
            System.out.printf("   Codigo %d: %.2f%n", codigos[i], promEstudiante[i]);

        // b. Promedio por materia
        double[] promMateria = Utils.promedioPorMateria(notas, n);
        System.out.println("\nb. PROMEDIO POR MATERIA:");
        for (int j = 0; j < Utils.MATERIAS; j++)
            System.out.printf("   Materia %d: %.2f%n", (j + 1), promMateria[j]);

        // c. Estudiante con mayor promedio
        int idx = Utils.indiceMayorPromedio(promEstudiante);
        System.out.printf("%nc. ESTUDIANTE CON MAYOR PROMEDIO:%n");
        System.out.printf("   Codigo: %d | Promedio: %.2f%n", codigos[idx], promEstudiante[idx]);

        // d. Aprobados por materia
        int[] aprobados = Utils.aprobadosPorMateria(notas, n);
        System.out.println("\nd. APROBADOS POR MATERIA (nota >= 7):");
        for (int j = 0; j < Utils.MATERIAS; j++)
            System.out.printf("   Materia %d: %d estudiante(s)%n", (j + 1), aprobados[j]);

        // e. Reprobados por materia
        int[] reprobados = Utils.reprobadosPorMateria(notas, n);
        System.out.println("\ne. REPROBADOS POR MATERIA (nota < 7):");
        for (int j = 0; j < Utils.MATERIAS; j++)
            System.out.printf("   Materia %d: %d estudiante(s)%n", (j + 1), reprobados[j]);

        scanner.close();
    }
}