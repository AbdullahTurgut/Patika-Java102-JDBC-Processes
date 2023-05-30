package PatikaThreadExercise;

import java.util.ArrayList;

public class ThreadRace implements Runnable {
    private int firstNumber = 1;

    private final Object LOCK = new Object(); // synchronized için boş nesne
    private ArrayList<Integer> first = new ArrayList<>();
    private ArrayList<Integer> second = new ArrayList<>();
    private ArrayList<Integer> third = new ArrayList<>();
    private ArrayList<Integer> fourth = new ArrayList<>();
    private ArrayList<Integer> oddNumbers = new ArrayList<>();
    private ArrayList<Integer> evenNumber = new ArrayList<>();



    @Override
    public void run() {
        synchronized (LOCK) {

            if (this.firstNumber <= 2500) { // 2500 e kadar 1.liste
                this.first.add(this.firstNumber);
                System.out.println(this.firstNumber + " birinci listeye eklendi ! ");
            } else if (this.firstNumber <= 5000) { // 2500-5000 arası 2.liste
                this.second.add(this.firstNumber);
                System.out.println(this.firstNumber + " ikinci listeye eklendi !");
            } else if (this.firstNumber <= 7500) { // 5000 - 7500 arası 3.liste
                this.third.add(this.firstNumber);
                System.out.println(this.firstNumber + " üçüncü listeye eklendi !");
            } else { // 7500 - 10_000 arası 4.liste
                this.fourth.add(this.firstNumber);
                System.out.println(this.firstNumber + " dördüncü listeye eklendi !");
            }

            if (this.firstNumber % 2 == 0) { // sayı çift iste
                this.evenNumber.add(this.firstNumber);
                System.out.println(this.firstNumber + " genel çift listeye eklendi !");
            } else {                        // sayı tek ise
                this.oddNumbers.add(this.firstNumber);
                System.out.println(this.firstNumber + " genel tek listeye eklendi !");
            }
            this.firstNumber++; //
        }

    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public ArrayList<Integer> getFirst() {
        return first;
    }

    public ArrayList<Integer> getSecond() {
        return second;
    }

    public synchronized ArrayList<Integer> getThird() {
        return third;
    }

    public synchronized ArrayList<Integer> getFourth() {
        return fourth;
    }

    public synchronized ArrayList<Integer> getOddNumbers() {
        return oddNumbers;
    }

    public synchronized ArrayList<Integer> getEvenNumber() {
        return evenNumber;
    }
}
