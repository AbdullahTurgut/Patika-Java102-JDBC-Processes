package streamApi;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Java 8 le beraber gelen bir özellik daha
        // Collection sınıfları üzerinde lambda ifadeler kullanarak işlem yapma olanağı sağlıyor
        ArrayList<Integer> list = new ArrayList<>();
        list.add(25);
        list.add(25);
        list.add(25);
        list.add(12);
        list.add(3);
        list.add(89);
        list.add(25);
        list.add(44);
        list.add(100);
        list.add(7);
        list.add(63);

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        for (Integer i : list) {
//            System.out.println(i);
//        }
//        list.forEach(i -> System.out.println(i)); // tek satırda foreach yapabiliyoruz
//        list.forEach(System.out::println); // alternatifi
        // filter() ile kullanımı
//        list.stream().filter(num -> num > 60).forEach(System.out::println); // 60dan büyük olanları listeledi
        // distinc() ile kullanımı (duplicate önlemek için)
//        list.stream().distinct().forEach(System.out::println);
        // sort yapıp da gösterebiliriz ()
//        list.stream().sorted().forEach(System.out::println); // sıralama yapar
//        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println); // tersten sıralar
//        list.stream().limit(5L).forEach(System.out::println); // limit ile 5 elemanı bastırabiliriz
//        list.stream().skip(3).limit(5).forEach(System.out::println); // 3 eleman atla ve 5 eleman bastır
            long c = list.stream().filter(num -> num < 40).distinct().count(); // 40 dan küçük 4 eleman var

        boolean control = list.stream().anyMatch(i -> i == 25); // eşleşen var mı -> true döner

        boolean control2 = list.stream().allMatch(i -> i > 20); // bütün elemanlar 20 den büyük değil -> false

        boolean control3 = list.stream().noneMatch(i -> i < 0); // hiç eşlesen yok bu yüzden -> true

        list.stream().map(i -> i * 2).forEach(System.out::println); // bütün elamanları 2 ile çarpıp bastırır

    }
}
