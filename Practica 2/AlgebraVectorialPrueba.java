class AlgebraVectorial {

    double x;
    double y;
    double z;
    public AlgebraVectorial() {
        x = 0;
        y = 0;
        z = 0;
    }

    public AlgebraVectorial(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public AlgebraVectorial sumar(AlgebraVectorial b) {
        return new AlgebraVectorial(
            x + b.x,
            y + b.y,
            z + b.z
        );
    }


    public AlgebraVectorial restar(AlgebraVectorial b) {
        return new AlgebraVectorial(
            x - b.x,
            y - b.y,
            z - b.z
        );
    }

    public AlgebraVectorial multiplicar(double numero) {
        return new AlgebraVectorial(
            x * numero,
            y * numero,
            z * numero
        );
    }

    public double modulo() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double productoEscalar(AlgebraVectorial b) {
        return x * b.x + y * b.y + z * b.z;
    }

    public AlgebraVectorial productoVectorial(AlgebraVectorial b) {
        double nuevoX = y * b.z - z * b.y;
        double nuevoY = z * b.x - x * b.z;
        double nuevoZ = x * b.y - y * b.x;

        return new AlgebraVectorial(nuevoX, nuevoY, nuevoZ);
    }

    public boolean perpendicular(AlgebraVectorial b) {
        double resultado = productoEscalar(b);

        return Math.abs(resultado) < 0.0001;
    }

    public boolean perpendicular(AlgebraVectorial b, int opcion) {

        if (opcion == 1) {
            double resultado1 = sumar(b).modulo();
            double resultado2 = restar(b).modulo();

            return Math.abs(resultado1 - resultado2) < 0.0001;

        } else if (opcion == 2) {
            double resultado1 = restar(b).modulo();
            double resultado2 = b.restar(this).modulo();

            return Math.abs(resultado1 - resultado2) < 0.0001;

        } else if (opcion == 3) {
            return perpendicular(b);

        } else if (opcion == 4) {
            double lado1 = Math.pow(sumar(b).modulo(), 2);

            double lado2 = Math.pow(modulo(), 2)
                         + Math.pow(b.modulo(), 2);

            return Math.abs(lado1 - lado2) < 0.0001;
        }

        return false;
    }
    public boolean paralela(AlgebraVectorial b) {
        AlgebraVectorial resultado = productoVectorial(b);

        return resultado.modulo() < 0.0001;
    }

    public boolean paralela(AlgebraVectorial b, double r) {
        AlgebraVectorial resultado = b.multiplicar(r);

        return Math.abs(x - resultado.x) < 0.0001
            && Math.abs(y - resultado.y) < 0.0001
            && Math.abs(z - resultado.z) < 0.0001;
    }
    public AlgebraVectorial proyeccion(AlgebraVectorial b) {
        double producto = productoEscalar(b);
        double moduloB = Math.pow(b.modulo(), 2);
        double numero = producto / moduloB;

        return b.multiplicar(numero);
    }
    public double componente(AlgebraVectorial b) {
        return productoEscalar(b) / b.modulo();
    }

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}


public class AlgebraVectorialPrueba {

    public static void main(String[] args) {

        AlgebraVectorial a = new AlgebraVectorial(1, 0, 0);
        AlgebraVectorial b = new AlgebraVectorial(0, 1, 0);

        System.out.println("Vector a = " + a);
        System.out.println("Vector b = " + b);

        System.out.println("\n¿Son perpendiculares?");

        System.out.println("Método 1: "
                + a.perpendicular(b, 1));

        System.out.println("Método 2: "
                + a.perpendicular(b, 2));

        System.out.println("Método 3: "
                + a.perpendicular(b, 3));

        System.out.println("Método 4: "
                + a.perpendicular(b, 4));


        AlgebraVectorial c = new AlgebraVectorial(2, 4, 6);
        AlgebraVectorial d = new AlgebraVectorial(1, 2, 3);

        System.out.println("\nVector c = " + c);
        System.out.println("Vector d = " + d);

        System.out.println("¿Son paralelos por c = 2d? "
                + c.paralela(d, 2));

        System.out.println("¿Son paralelos por producto vectorial? "
                + c.paralela(d));


        AlgebraVectorial e = new AlgebraVectorial(3, 4, 0);
        AlgebraVectorial f = new AlgebraVectorial(1, 0, 0);

        System.out.println("\nProyección de e sobre f: "
                + e.proyeccion(f));

        System.out.println("Componente de e en f: "
                + e.componente(f));
    }
}