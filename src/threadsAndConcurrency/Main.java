package threadsAndConcurrency;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // ##### Thread Durdurmak ve Bekletmek #####

        // Thread durdurmak için burda CounterRunnable için bi obje oluşturmak gerekece
        CounterRunnable c1 = new CounterRunnable("c1",1);
        Thread t1 = new Thread(c1);
        t1.start();
        Thread.sleep(3000);// burda aslında 3 saniye sonra c1 objesinin Thread(iş parçacığını) durdumayı hedefledik
        c1.stop(); // bu şekilde manual olarak 3 saniye sonra durdurmuş olduk Thread'i

//        CounterRunnable c2 = new CounterRunnable("c2",2);
//        Thread t2 = new Thread(c2);
//        t2.start();
//        Thread t2 = new Thread(new CounterRunnable("c2",2));
//        t2.start();

//        CounterRunnable c1 = new CounterRunnable("c1", id);
//        CounterRunnable c2 = new CounterRunnable("c2", id);
//        CounterRunnable c3 = new CounterRunnable("c3", id);
//
//        // Thread sınıfı açıp Runnable ataması yapabiliyoruz
//        Thread t1 = new Thread(c1);
//        Thread t2 = new Thread(c2);
//        Thread t3 = new Thread(c3);
//
//        t1.start();
//        t2.start();
//        t3.start();
//        Counter c1 = new Counter();
//
//        Counter c2 = new Counter();
//
//        c1.start();
//
//        c2.start();
    }
}
