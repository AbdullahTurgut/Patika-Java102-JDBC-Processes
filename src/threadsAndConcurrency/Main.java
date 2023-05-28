package threadsAndConcurrency;

public class Main {
    public static void main(String[] args) {
        CounterRunnable c1 = new CounterRunnable("c1");
        CounterRunnable c2 = new CounterRunnable("c2");
        CounterRunnable c3 = new CounterRunnable("c3");

        // Thread sınıfı açıp Runnable ataması yapabiliyoruz
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);

        t1.start();
        t2.start();
        t3.start();
//        Counter c1 = new Counter();
//
//        Counter c2 = new Counter();
//
//        c1.start();
//
//        c2.start();
    }
}
