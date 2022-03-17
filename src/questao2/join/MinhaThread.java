package questao2.join;

public class MinhaThread implements Runnable {

    private int id;
    private long tempo;

    public MinhaThread(int id, long tempo){
        this.id = id;
        this.tempo = tempo;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(tempo * 1000);
            System.out.println("Thread " + id + " dormiu por " + tempo + " segundos");
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

}
