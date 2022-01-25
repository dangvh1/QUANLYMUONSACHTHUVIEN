package library;

import model.Book;
import model.Reader;

import java.util.Arrays;

public class BorrowBook {
    private Reader reader;
    private Book[] books;
    private int[] quantity;
    private int totalBook;

    public BorrowBook() {
    }

    public BorrowBook(Reader reader, Book[] books, int[] quantity) {
        this.reader = reader;
        this.books = books;
        this.quantity = quantity;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public int[] getQuantity() {
        return quantity;
    }

    public void setQuantity(int[] quantity) {
        this.quantity = quantity;
    }

    public int getTotalBook() {
        return totalBook;
    }

    public void setTotalBook(int totalBook) {
        this.totalBook = totalBook;
    }

    @Override
    public String toString() {
        return "BorrowBook{" +
                "reader=" + reader +
                ", books=" + Arrays.toString(books) +
                ", quantity=" + Arrays.toString(quantity) +
                '}';
    }
}
