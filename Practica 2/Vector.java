class Vector3D {
    double x;
    double y;
    double z;
    public Vector3D() {
        x = 0;
        y = 0;
        z = 0;
    }
    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Vector3D sumar(Vector3D b) {
        double nuevoX = x + b.x;
        double nuevoY = y + b.y;
        double nuevoZ = z + b.z;

        return new Vector3D(nuevoX, nuevoY, nuevoZ);
    }
    public Vector3D multiplicar(double numero) {
        double nuevoX = numero * x;
        double nuevoY = numero * y;
        double nuevoZ = numero * z;

        return new Vector3D(nuevoX, nuevoY, nuevoZ);
    }
    public double longitud() {
        double resultado = x * x + y * y + z * z;

        return Math.sqrt(resultado);
    }
    public Vector3D normal() {
        double longitudVector = longitud();

        if (longitudVector == 0) {
            System.out.println("No se puede normalizar el vector cero");
            return new Vector3D();
        }

        double nuevoX = x / longitudVector;
        double nuevoY = y / longitudVector;
        double nuevoZ = z / longitudVector;

        return new Vector3D(nuevoX, nuevoY, nuevoZ);
    }
    public double productoEscalar(Vector3D b) {
        double resultado;

        resultado = x * b.x
                  + y * b.y
                  + z * b.z;

        return resultado;
    }
    public Vector3D productoVectorial(Vector3D b) {
        double nuevoX = y * b.z - z * b.y;
        double nuevoY = z * b.x - x * b.z;
        double nuevoZ = x * b.y - y * b.x;

        return new Vector3D(nuevoX, nuevoY, nuevoZ);
    }
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}


public class Vector {

    public static void main(String[] args) {

        Vector3D a = new Vector3D(1, 2, 3);
        Vector3D b = new Vector3D(4, 5, 6);

        System.out.println("Vector a = " + a);
        System.out.println("Vector b = " + b);

        Vector3D suma = a.sumar(b);
        System.out.println("\nSuma de a + b = " + suma);

        Vector3D multiplicacion = a.multiplicar(2);
        System.out.println("Multiplicación de 2 por a = "
                + multiplicacion);

        double longitud = a.longitud();
        System.out.println("Longitud del vector a = "
                + longitud);

        Vector3D normal = a.normal();
        System.out.println("Normal del vector a = "
                + normal);

        double escalar = a.productoEscalar(b);
        System.out.println("Producto escalar a · b = "
                + escalar);

        Vector3D vectorial = a.productoVectorial(b);
        System.out.println("Producto vectorial a x b = "
                + vectorial);
    }
}