package model;

import java.util.Scanner;

public class Book {
    private int bookID;
    private String bookName;
    private String tacGia;
    private String chuyenNganh;
    private String namXuatBan;
    private String quantitty;

    public Book() {
    }

    public Book(int bookID, String bookName, String tacGia, String chuyenNganh, String namXuatBan, String quantitty) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.tacGia = tacGia;
        this.chuyenNganh = chuyenNganh;
        this.namXuatBan = namXuatBan;
        this.quantitty = quantitty;
    }


    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public String getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(String namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public String getQuantitty() {
        return quantitty;
    }

    public void setQuantitty(String quantitty) {
        this.quantitty = quantitty;
    }
}
