
package model;

import java.io.Serializable;

public class Book implements Serializable{
    private static int ID = 9999;
    private int id;
    private String bookname;
    private String bookAuthor;
    private String bookMajor;
    private String bookYear;
    private int bookMount;
    
    public Book()
    {}

    public Book(int id, String bookname, String bookAuthor, String bookMajor, String bookYear, int bookMount) {
        this.id = ID ++;
        this.bookname = bookname;
        this.bookAuthor = bookAuthor;
        this.bookMajor = bookMajor;
        this.bookYear = bookYear;
        this.bookMount = bookMount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookMajor() {
        return bookMajor;
    }

    public void setBookMajor(String bookMajor) {
        this.bookMajor = bookMajor;
    }

    public String getBookYear() {
        return bookYear;
    }

    public void setBookYear(String bookYear) {
        this.bookYear = bookYear;
    }

    public int getBookMount() {
        return bookMount;
    }

    public void setBookMount(int bookMount) {
        this.bookMount = bookMount;
    }
    public Object[] toObject(){
        return new Object[]{id,bookname,bookAuthor,bookMajor,bookMount};
    }
}
