package lamb;

public class Main {
    public static void main(String[] args) {
        // Java8 den sonra Labmda expression kullanabiliyoruz
        // Functional Interface Örneği
//        Runnable r1 = () -> System.out.println("r2 sınıfı");
//        r1.run();
        Matematik toplama = (a, b) -> a + b; // lambda kullanımı (Functional interface için geçerli ama)
        Matematik cikarma = (a, b) -> a - b;
        Matematik bolme = (a, b) -> {
            if (b == 0) {
                b = 1;
            }
            return a / b;
        };
        Matematik carpma = (a, b) -> a * b;

        System.out.println(toplama.transaction(10, 2));
        System.out.println(cikarma.transaction(10,2));
        System.out.println(carpma.transaction(10,2));
        System.out.println(bolme.transaction(10,2));
    }
}
