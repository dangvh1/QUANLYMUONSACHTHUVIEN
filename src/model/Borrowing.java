package model;

import model.Book;
import model.Reader;

public class Borrowing {
    private Book[] books;
    private Reader reader;
    private int[] quantity;
    public static int sodausach;

    public Borrowing() {
    }

    public Borrowing(Book[] books, Reader reader, int[] quantity) {
        this.books = books;
        this.reader = reader;
        this.quantity = quantity;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public int[] getQuantity() {
        return quantity;
    }

    public void setQuantity(int[] quantity) {
        this.quantity = quantity;
    }

    public int soSachMuon(){
        int sum = 0;
        for (int i = 0; i < quantity.length; i++) {
            sum = sum + quantity[i];
        }
        return sum;
    }
    public void MuonSach() {
        System.out.println(" ");
        for (int i = 0; i < sodausach; i++) {
            System.out.println(reader.getreaderID() + " | " + books[i].getBookName() + " | " + quantity[i]);
        }
    }

}
