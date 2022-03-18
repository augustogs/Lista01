package questao3;

import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.List;
import java.util.ArrayList;

public class Main {

    static int num = 0;
    static int count = 0;
    static int count2 = 0;
    static Semaphore mutex = new Semaphore(1);
    static Semaphore catr = new Semaphore(0);
    static Semaphore catr2 = new Semaphore(0);
    static int[] sorteados;

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Número de threads que serão criadas: ");
        num = sc.nextInt();

        count2 = num;
        sorteados = new int[num];

        List<Thread> listaThreads = new ArrayList<>();
        for (int i=0; i<num; i++) {
            int rNum = (int) (Math.random() * 5);
            MinhaThread mt = new MinhaThread(i, rNum);
            listaThreads.add(new Thread(mt));
        }

        for (Thread threads: listaThreads) {
            threads.start();
        }
        catr.acquire();

        System.out.println("Thread principal terminou de executar. " + num);
    }

}

