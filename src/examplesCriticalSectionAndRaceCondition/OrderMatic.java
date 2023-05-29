package examplesCriticalSectionAndRaceCondition;

public class OrderMatic implements Runnable{
    private int orderNo;
    //synchronized parametresi için bir Object sınıfı nesnesi lazım
    private final Object LOCK = new Object();

    public OrderMatic() {
        this.orderNo = 0;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(2000);// 2 saniye beklesin önce
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Kritik durum kısmı
        // burda senkron yaptığımız takdirde çakışmanın önüne geçicez
//        synchronized (LOCK){ // bu şekilde tekrarın önüne geçmiş olduk
//            this.orderNo++;
//            System.out.println(Thread.currentThread().getName() + " - OrderNo : " + this.orderNo);
//        }
        // burda not olarak methodlarda synchronized olabilir örneğin
        increaseOrderNo(); // bu şekilde senkron özelliği verdiğimiz method aynı işlemi yapıcak
    }

    public synchronized void increaseOrderNo(){
        this.orderNo++;
        System.out.println(Thread.currentThread().getName() + " - OrderNo : " + this.orderNo);
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }
}
