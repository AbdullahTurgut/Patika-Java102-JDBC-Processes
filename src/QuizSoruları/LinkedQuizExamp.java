package QuizSoruları;

/*
Çift sayılı indexlerdeki değerleri bulunduğu bağlı listeden kaldıran
ve bu değerleri orjinal sırasında eklenen yeni bir bağlı listeyi döndüren, ciftleriSil adlı bir method yazın.
Örneğin, [8,13,17,4,9,12,98,41,7,23,0,92] değerlerini saklayan list1 bağlı listesini ele alalım
ve aşağıdaki kod satırı çalıştığında :
LinkedList list2 = list1.ciftleriSil();
Silme işleminden sonra list1[13,4,12,41,23,92] ve list2[8,17,9,98,7,0] değerlerini içermelidir.
Not: Bu problemi çözmek için sınıfın yapıcı dışında herhangi bir yöntemini çağıramazsınız.
Bu sorunu çözmek için yeni düğümler oluşturamaz veya veri alanlarında saklanan değerleri değiştiremezsiniz.
Listenin bağlantılarını yeniden düzenleyerek çözmelisiniz.

*/
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        next = null;
    }
}
class LinkedList {
    Node head;
    LinkedList() {
        head = null;
    }
    void ekle(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    void yazdir() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    LinkedList ciftleriSil() {
        LinkedList newList = new LinkedList();

        if (head == null) {
            return newList;
        }
        Node current = head;
        Node prev = null;
        int count = 0;
        while (current != null) {
            if (count % 2 == 0) {
                newList.ekle(current.data);

                if (prev != null) {
                    prev.next = current.next;
                } else {
                    head = current.next;
                }
            }
            prev = current;
            current = current.next;
            count++;
        }

        return newList;
    }
}
public class LinkedQuizExamp {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.ekle(8);
        list1.ekle(13);
        list1.ekle(17);
        list1.ekle(4);
        list1.ekle(9);
        list1.ekle(12);
        list1.ekle(98);
        list1.ekle(41);
        list1.ekle(7);
        list1.ekle(23);
        list1.ekle(0);
        list1.ekle(92);

        LinkedList list2 = list1.ciftleriSil();

        System.out.print("List1: ");
        list1.yazdir();

        System.out.print("List2: ");
        list2.yazdir();
    }
}


