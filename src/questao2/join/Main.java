package questao2.join;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Scanner in = new Scanner(System.in);
        System.out.println("Número de threads que serão criadas: ");
        int num = in.nextInt();

        List<Thread> listaThreads = new ArrayList<>();
        for (int i=0; i<num; i++) {
            MinhaThread mt = new MinhaThread(i, (int) (Math.random() * 5));
            listaThreads.add(new Thread(mt));
        }

        for (Thread thread : listaThreads) {
            thread.start();
        }

        for (Thread thread : listaThreads) {
            thread.join();
        }
        System.out.println("Thread principal terminou de executar. " + num);
    }
}
