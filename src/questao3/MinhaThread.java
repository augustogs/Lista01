package questao3;

public class MinhaThread implements Runnable {

    private int id;
    private long tempo;

    public MinhaThread(int id, int tempo) {
        this.id = id;
        this.tempo = tempo;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(tempo * 1000);
            System.out.println("Thread " + id + " dormiu por " + tempo + " segundos");

            int numSorteado = (int) (Math.random() * 10);
            Main.sorteados[id] = (numSorteado);
            System.out.println("Thread " + id + " sorteou " + numSorteado);

            Main.mutex.acquire();
            Main.count++;
            if (Main.count == Main.num) {
                Main.catr1.release();
            }
            Main.mutex.release();

            Main.catr1.acquire();
            Main.catr1.release();

            int tempo2;
            if (id == 0) {
                tempo2 = Main.sorteados[Main.sorteados.length - 1];
            } else {
                tempo2 = Main.sorteados[id-1];
            }
            System.out.println("Thread " + id + " está dormindo por " + tempo2 + " segundos");

            Thread.sleep(tempo2 * 1000);

            //Identifica que todas as threads já terminaram a execução.
            System.out.println("Thread " + id + " terminou de executar");
            Main.mutex.acquire();
            Main.count2--;
            if (Main.count2 == 0) {
                Main.catr.release();
            }
            Main.mutex.release();

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
