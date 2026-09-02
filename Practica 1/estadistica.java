import java.util.Scanner;

public class estadistica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] numeros = new double[10];
        System.out.println("Ingrese 10 números:");
        for (int i = 0; i < 10; i++) {
            numeros[i] = sc.nextDouble();
        }
        Estadistica e = new Estadistica(numeros);
        System.out.printf("El promedio es %.2f%n", e.promedio());
        System.out.printf("La desviación estándar es %.5f%n", e.desviacion());

        sc.close();
    }
}
class Estadistica {
    private double[] numeros;
    public Estadistica(double[] numeros) {
        this.numeros = numeros;
    }
    public double promedio() {
        double suma = 0;
        for (double numero : numeros) {
            suma += numero;
        }
        return suma / numeros.length;
    }
    public double desviacion() {
        double prom = promedio();
        double suma = 0;
        for (double numero : numeros) {
            suma += Math.pow(numero - prom, 2);
        }
        return Math.sqrt(suma / (numeros.length - 1));
    }
}