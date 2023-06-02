package QuizSoruları;

import java.util.LinkedList;

public class LinkedQuizExampMyWay {
    public static void main(String[] args) {
        java.util.LinkedList<Integer> list1 = new java.util.LinkedList<>();
        list1.add(8);
        list1.add(13);
        list1.add(17);
        list1.add(4);
        list1.add(9);
        list1.add(12);
        list1.add(98);
        list1.add(41);
        list1.add(7);
        list1.add(23);
        list1.add(0);
        list1.add(92);
        java.util.LinkedList<Integer> list2 = new LinkedList<>();
        int count = 0;

        for (Integer i : list1) {
            if (count % 2 == 0) {
                list2.add(i);
            }
            count++;
        }

        for (int i = 0; i < list1.size(); i += 2) {
            list1.remove(i);
        }

        System.out.println("List1");

        for (Integer i : list1) {
            System.out.print(i + " ");
        }

        System.out.println();

        System.out.println("List2");
        for (Integer i : list2) {
            System.out.print(i + " ");
        }

    }
}
