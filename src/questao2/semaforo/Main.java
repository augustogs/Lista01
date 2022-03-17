package questao2.semaforo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {

    static int count = 0;
    static int num = 0;
    static Semaphore catr = new Semaphore(0);
    static Semaphore mutex = new Semaphore(1);

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Número de threads que serão criadas: ");
        num = sc.nextInt();

        List<Thread> listaThreads = new ArrayList<>();
        for (int i=0; i<num; i++) {
            MinhaThread mt = new MinhaThread(i, (int) (Math.random() * 5));
            listaThreads.add(new Thread(mt));
        }

        for (Thread thread: listaThreads) {
            thread.start();
        }

        catr.acquire();

        System.out.println("Thread principal terminou de executar. " + num);
    }

}
