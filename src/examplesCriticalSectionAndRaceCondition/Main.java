package examplesCriticalSectionAndRaceCondition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        OrderMatic orderMatic = new OrderMatic();
//        Thread t1 = new Thread(orderMatic);
//        t1.start();
//        t1.join(); // join ile bunların birbirinden bağımsız halde çalışabiliyor
//        Thread t2 = new Thread(orderMatic);
//        t2.start(); // burda orderNo çıktıları ikisindede 1 olarak kaldı.Bir nesne üzerinden 2 Thread oluşturamadık
//        t2.join(); // join ile bunların birbirinden bağımsız halde çalışabiliyor

        OrderMatic oMatic = new OrderMatic();
//        List<Thread> islemler = new ArrayList<>();

        // Thread sınıfı ile oluşturduğumuz listemize birden çok thread atama yapabiliceğiz
        // ** Burda 100 tane Thread oluşturmak hiç mantıklı değil bu yüzden thread pooling kullanmalıyız
        // THREAD POOLING
        ExecutorService pool = Executors.newFixedThreadPool(10);// 10 tanelik thread havuzu oluştu


        for (int i = 0; i < 100; i++) {
            pool.execute(oMatic); // bu şekilde runnable sınıfımız ile thread oluşturabiliyoruz
//            Thread t = new Thread(oMatic);
//            islemler.add(t);
//            t.start();
        }

//        for(Thread t : islemler){
//            t.join(); // bu şekilde çakışma minimuma indirgendi
//        }

        System.out.println(oMatic.getOrderNo()); // burdaki değeri 100 den çıkarınca çakışan threadlerin sayısı elde edilir

        // burda çakışma önlenmesi için senkron oluşturmak lazım OrderMatic sınıfı içerisinde

    }
}
