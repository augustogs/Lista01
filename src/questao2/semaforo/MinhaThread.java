package questao2.semaforo;

public class MinhaThread implements Runnable {
    private int id;
    private long tempo;

    public MinhaThread(int id, long tempo) {
        this.id = id;
        this.tempo = tempo;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(tempo * 1000);
            System.out.println("Thread " + id + " dormiu por " + tempo + " segundos");

            Main.mutex.acquire();
            Main.count++;
            Main.mutex.release();

            if (Main.count == Main.num) {
                Main.catr.release();
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

    }
}
