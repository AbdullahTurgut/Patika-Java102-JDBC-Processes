package PatikaBookList;

public class Book {

    private String name;
    private String author;
    private int pageNumber;
    private int publishedYear;

    public Book(String name, String author, int pageNumber, int publishedYear) {
        this.name = name;
        this.author = author;
        this.pageNumber = pageNumber;
        this.publishedYear = publishedYear;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }
}
