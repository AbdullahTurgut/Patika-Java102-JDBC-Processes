package typeCasting;

public class Main {
    public static void main(String[] args) {
        int a = 10;
        double b = a; // int a yı double b ye atadık
//        System.out.println(b); // 10.0

        // Manuel Casting (Narrowing)
        double pi = 3.1435;
        int c = (int) pi; // c output -> 3

        byte capitalP = 80;
        char pCapital = (char) capitalP; // -> P

        int value = 20;
        String str = String.valueOf(value); // value artık String -> "20"

        int parseValue = Integer.parseInt(str); // 20 tekrar Integer -> 20 oldu

    }
}
