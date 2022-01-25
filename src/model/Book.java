package model;

import java.util.Scanner;

public class Book {
    private static int AUTO_ID = 10000;
    private int bookID;
    private String bookName;
    private String tacGia;
    private String chuyenNganh;
    private int namXuatBan;
    private String quantitty;

    private final static String NATURAL_SCIENCE = "Khoa học tự nhiên";
    private final static String LITERATURE_ART = "Văn học nghệ thuật";
    private final static String ELECTRONIC_TELECOMMUNICATION = "Điện tử viễn thông";
    private final static String INFORMATION_TECHNOLOGY = "Công nghệ thông tin";

    public Book() {
    }

    public Book(int bookID, String bookName, String tacGia, String chuyenNganh, int namXuatBan, String quantitty) {
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

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public String getQuantitty() {
        return quantitty;
    }

    public void setQuantitty(String quantitty) {
        this.quantitty = quantitty;
    }
    public void inputBookInfo() {
        this.setBookID(Book.AUTO_ID);
        System.out.println("Nhập tên sách: ");
        this.bookName = new Scanner(System.in).nextLine();
        System.out.println("Nhập tên tác giả: ");
        this.tacGia = new Scanner(System.in).nextLine();
        System.out.println("Nhập năm xuất bản: ");
        this.namXuatBan = new Scanner(System.in).nextInt();
        System.out.println("Nhập loại sách:");
        System.out.println("1.Khoa học tự nhiên");
        System.out.println("2.Văn học - nghệ thuật");
        System.out.println("3.Điện tử viễn thông");
        System.out.println("4.Công nghệ thông tin");
        System.out.println("Nhập sự lựa chọn: ");
        boolean check = true;
        do {
            int choice = new Scanner(System.in).nextInt();
            if (choice <= 0 || choice > 4) {
                System.out.print("Nhập số trong khoảng từ 1 đến 4! Nhập lại: ");
                check = false;
                continue;
            }

            switch (choice) {
                case 1:
                    this.setChuyenNganh(Book.NATURAL_SCIENCE);
                    System.out.println("Khoa học tự nhiên");
                    check = true;
                    break;
                case 2:
                    this.setChuyenNganh(Book.LITERATURE_ART);
                    System.out.println("Văn học - nghệ thuật");
                    check = true;
                    break;
                case 3:
                    this.setChuyenNganh(Book.ELECTRONIC_TELECOMMUNICATION);
                    System.out.println("Điện tử viễn thông");
                    check = true;
                    break;
                case 4:
                    this.setChuyenNganh(Book.INFORMATION_TECHNOLOGY);
                    System.out.println("Công nghệ thông tin");
                    check = true;
                    break;
                default:
                    System.out.println("Nhập sai! Hãy nhập từ 1 đến 4!");
                    check = false;
                    break;
            }
        } while (!check);
        Book.AUTO_ID++;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", tacGia='" + tacGia + '\'' +
                ", chuyenNganh='" + chuyenNganh + '\'' +
                ", namXuatBan=" + namXuatBan +
                '}';
    }
}
