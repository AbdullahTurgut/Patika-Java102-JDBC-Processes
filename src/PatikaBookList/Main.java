package PatikaBookList;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ArrayList<Book> bookList = new ArrayList();

        bookList.add(new Book("ÇALI KUŞU","H.EDİP ADIVAR",406,2005));
        bookList.add(new Book("GENİŞZAMANLAR","AYŞE KULİN",114,2003));
        bookList.add(new Book("YAPRAK DÖKÜMÜ","R.NURİ GÜNTEKİN",134,2012));
        bookList.add(new Book("İNTİBAH","NAMIK KEMAL",176,1985));
        bookList.add(new Book("SİMYACI","PAULO COELHO",166,1965));
        bookList.add(new Book("DON KİŞOT","CERVANTES",320,2008));
        bookList.add(new Book("VADİDEKİZAMBAK","BALZAK",366,1995));
        bookList.add(new Book("SEMERKANT","AMİN MAALOUF",318,1972));
        bookList.add(new Book("İKİ ŞEHRİN HİKAYESİ","CHARLES DİCKENS",399,1986));
        bookList.add(new Book("KUMARBAZ","DOSTOYEVSKİ",160,1899));

        Map<String, String> bookMap = new HashMap<>();
        bookList.forEach(book -> bookMap.put(book.getName(),book.getAuthor()));
        bookMap.forEach((name,author) -> System.out.println("Kitap adı : " + name + " ---- Yazarı : " + author));

        List<Book> bookListAbove100PageNumber = bookList.stream().filter(book -> book.getPageNumber() > 100).toList();
        bookListAbove100PageNumber
                .forEach(book -> System.out.println("Kitap adı : " + book.getName()));
    }
}
