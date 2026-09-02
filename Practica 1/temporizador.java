class Cronometro {
    private long inicia;
    private long finaliza;
    public Cronometro() {
        inicia = System.currentTimeMillis();
    }
    public long getInicia() {
        return inicia;
    }
    public long getFinaliza() {
        return finaliza;
    }
    public void inicia() {
        inicia = System.currentTimeMillis();
    }
    public void detener() {
        finaliza = System.currentTimeMillis();
    }
    public long lapsoDeTiempo() {
        return finaliza - inicia;
    }
}

public class temporizador {

    public static void main(String[] args) {

        int[] numeros = new int[100000];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int)(Math.random() * 100000);
        }
        Cronometro cronometro = new Cronometro();

        for (int i = 0; i < numeros.length - 1; i++) {

            int indiceMinimo = i;

            for (int j = i + 1; j < numeros.length; j++) {

                if (numeros[j] < numeros[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }

            int temporal = numeros[i];
            numeros[i] = numeros[indiceMinimo];
            numeros[indiceMinimo] = temporal;
        }
        cronometro.detener();
        System.out.println(
            "El tiempo de ejecución es " + cronometro.lapsoDeTiempo()+ " milisegundos"
        );
    }
}