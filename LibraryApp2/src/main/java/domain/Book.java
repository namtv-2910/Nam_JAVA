package domain;

public class Book {
    private String bookCode;
    private String bookName;
    private String publisherCode;
    private String publisherName; 

    public Book() {}

    public Book(String bookCode, String bookName, String publisherCode) {
        this.bookCode      = bookCode;
        this.bookName      = bookName;
        this.publisherCode = publisherCode;
    }

    public Book(String bookCode, String bookName,
                String publisherCode, String publisherName) {
        this(bookCode, bookName, publisherCode);
        this.publisherName = publisherName;
    }

    public String getBookCode()           { return bookCode; }
    public void   setBookCode(String v)   { this.bookCode = v; }
    public String getBookName()           { return bookName; }
    public void   setBookName(String v)   { this.bookName = v; }
    public String getPublisherCode()      { return publisherCode; }
    public void   setPublisherCode(String v){ this.publisherCode = v; }
    public String getPublisherName()      { return publisherName; }
    public void   setPublisherName(String v){ this.publisherName = v; }

    @Override
    public String toString() {
        return String.format("[%-12s] %-50s NXB: %s",
                bookCode, bookName, publisherCode);
    }
}