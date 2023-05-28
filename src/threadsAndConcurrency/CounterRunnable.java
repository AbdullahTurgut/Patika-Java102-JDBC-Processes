package threadsAndConcurrency;

public class CounterRunnable implements Runnable {
    private String name;
    // Thread Bekletmek(sleep)
    private int id;
    // Thread Durdurmak için olan kısım
    private boolean isRun = true;

    public CounterRunnable(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " sayacı başladı");
        // durdurma kısmı
        int i = 0; // durdurma kısmı için for döngüsü engel oluyor kaldıracağız
        while (isRun){
                // her artış kadar Thread i uyutucak(bekletecek)
                try {
                    Thread.sleep(1000L * this.id); // Kod buraya geldiğinde 1'er saniye bekliyor ve devam ediyor
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(this.getName() + " : " + i++);
            }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // kendimiz Stop methodu yazabiliriz Thread için
    public void stop(){
        this.isRun = false;
    }
}
