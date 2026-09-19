import java.util.Scanner;

class EcuacionCuadratica {
    private double a;
    private double b;
    private double c;
    public EcuacionCuadratica(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getDiscriminante() {
        return b * b - 4 * a * c;
    }
    public double getRaiz1() {

        double discriminante = getDiscriminante();

        if (discriminante >= 0) {
            return (-b + Math.sqrt(discriminante))
                    / (2 * a);
        }

        return 0;
    }
    public double getRaiz2() {

        double discriminante = getDiscriminante();

        if (discriminante >= 0) {
            return (-b - Math.sqrt(discriminante))
                    / (2 * a);
        }
        return 0;
    }
}

public class cuadratica {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese a, b, c: ");
        double a = entrada.nextDouble();
        double b = entrada.nextDouble();
        double c = entrada.nextDouble();
        EcuacionCuadratica ecuacion =
                new EcuacionCuadratica(a, b, c);

        double discriminante =
                ecuacion.getDiscriminante();

        if (discriminante > 0) {

            System.out.printf(
                "La ecuación tiene dos raíces %.6f y %.6f%n",
                ecuacion.getRaiz1(),
                ecuacion.getRaiz2()
            );
        } else if (discriminante == 0) {
            System.out.printf(
                "La ecuación tiene una raíz %.6f%n",
                ecuacion.getRaiz1()
            );

        } else {
            System.out.println(
                "La ecuación no tiene raíces reales"
            );
        }
        entrada.close();
    }
}