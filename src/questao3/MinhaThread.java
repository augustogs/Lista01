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
            System.out.println("Primeira fase: Thread " + id + " dormiu por " + tempo + " segundos");

            int sNum = (int) (Math.random() * 10);
            Main.sorteados[id] = (sNum);
            System.out.println("Primeira fase: Thread " + id + " sorteou " + sNum);

            Main.mutex.acquire();
            Main.count++;
            if (Main.count == Main.num) {
                Main.catr2.release();
            }
            Main.mutex.release();

            Main.catr2.acquire();
            Main.catr2.release();

            int tempo2;
            if (id == 0) {
                tempo2 = Main.sorteados[Main.sorteados.length - 1];
            } else {
                tempo2 = Main.sorteados[id-1];
            }
            Thread.sleep(tempo2 * 1000);
            System.out.println("Segunda fase: Thread " + id + " dormiu por " + tempo2 + " segundos");

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
