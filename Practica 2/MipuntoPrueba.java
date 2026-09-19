class MiPunto {
    private double x;
    private double y;
    public MiPunto() {
        x = 0;
        y = 0;
    }
    public MiPunto(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public double distancia(MiPunto otroPunto) {
        double diferenciaX = otroPunto.getX() - x;
        double diferenciaY = otroPunto.getY() - y;

        return Math.sqrt(
            diferenciaX * diferenciaX +
            diferenciaY * diferenciaY
        );
    }
    public double distancia(double otroX, double otroY) {
        double diferenciaX = otroX - x;
        double diferenciaY = otroY - y;

        return Math.sqrt(
            diferenciaX * diferenciaX +
            diferenciaY * diferenciaY
        );
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class MipuntoPrueba {

    public static void main(String[] args) {

        MiPunto punto1 = new MiPunto();
        MiPunto punto2 = new MiPunto(10, 30.5);

        System.out.println("Punto 1: " + punto1);
        System.out.println("Punto 2: " + punto2);

        double distancia1 = punto1.distancia(punto2);
        double distancia2 = punto1.distancia(10, 30.5);

        System.out.println("Distancia utilizando un objeto MiPunto: "
                + distancia1);

        System.out.println("Distancia utilizando las coordenadas: "
                + distancia2);
    }
}