package library;

import java.util.Scanner;
import model.Book;
import model.Borrowing;
import model.Reader;

public class Management {
    public static int soluongreader;
    private Borrowing[] ds;
    private Borrowing borrowing;
    private Reader[] dsreader;
    private Book[] dsbook;



    Reader inputReader(int readerID){
        Scanner sc = new Scanner(System.in);
        int id = readerID + 1;
        System.out.println("nhap ten nguoi muon sach : ");
        String name = sc.nextLine();
        System.out.println("nhap dia chi nguoi muon : ");
        String address = sc.nextLine();
        System.out.println("nhap so dien thoai nguoi muon : ");
        String phone = sc.nextLine();
        System.out.println("số lượng sách muốn mượn");
        int number = sc.nextInt();
        System.out.print("phan loai nguoi muon : ");
        System.out.println("nguoi muon phai la 'sinh vien' or 'hoc vien cao hoc' or 'giao vien'");
        String readertype;
        do {
            readertype = sc.nextLine();
            boolean check = false;
            if (readertype.equals("sinh vien") || readertype.equals("hoc vien cao hoc" ) || readertype.equals("giao vien")){
                check = true;
                break;
            }else {
                System.out.println("nhap lai loai nguoi muon");
            }
        }while (true);

        Reader r = new Reader(readerID, name, address, phone, readertype, number);
        return r;
    }
    Book inputBooks(int bookID){
        Scanner sc = new Scanner(System.in);
        int id = bookID + 1;
        System.out.print("nhap ten sach : ");
        String bookName =sc.nextLine();
        System.out.print("nhap ten tac gia : ");
        String tacGia = sc.nextLine();
        System.out.print("nhap nam xuat ban : ");
        String namXuatBan =sc.nextLine();
        System.out.print("nhap so luong sach : ");
        String quantitty =sc.nextLine();
        System.out.print("sach thuoc chuyen nganh : ");
        String chuyenNganh;
        do {
            chuyenNganh =sc.nextLine();
            boolean check = false;
            if (chuyenNganh.equals("khoa hoc tu nhien") || chuyenNganh.equals("van hoc nghe thuat" ) || chuyenNganh.equals("dien tu vien thong") || chuyenNganh.equals("cong nghe thong tin")){
                check = true;
                break;
            }else {
                System.out.println("nhap lai sach chuyen nganh");
            }
        }while (true);
        Book b = new Book(bookID, bookName, tacGia, chuyenNganh, namXuatBan, quantitty);
        return b;

    }

    public void hienthibook(Book[] books){
        System.out.printf("%-10s| %-30s| %-15s| %-40s| %-20s| %-10s |\n", "Mã sách", "Tên sách", "Tác giả", "loại sách", "Năm sản xuất", "Số lượng cuốn");
        for (int i = 0; i < books.length; i++) {
            if (books[i].getBookID() != 0) {
                printbook(books[i]);
                System.out.println("");

            }
        }
    }
    public void printbook(Book book){
        System.out.printf(" %-10s| %-30s| %-15s| %-40s| %-20s| %-15s |", book.getBookID(), book.getBookName(), book.getTacGia(),
                book.getChuyenNganh(), book.getNamXuatBan(), book.getQuantitty());
    }

    public void hienthireader(Reader[] readers){
        System.out.printf("%-10s| %-20s| %-25s| %-20s| %-12s| %-10s|\n", "Mã bạn đọc", "Tên bạn đọc", "Địa chỉ bạn đọc", "Số điện thoai ", "Kiểu người đọc", "Số lượng sách mượn");
        for (int i = 0; i < readers.length; i++) {
            if (readers[i].getreaderID() != 0) {
                printreader(readers[i]);
                System.out.println("");

            }
        }
    }

    public void printreader(Reader reader) {
        System.out.printf("%-10s| %-20s| %-25s| %-20s| %-15s| %-10s|", reader.getreaderID(),reader.getName() , reader.getaddress(), reader.getPhone(), reader.getreadertype(),reader.getNumber());
    }

    public void tabqlMuonSach(Reader reader, Book book){
        System.out.printf(" %-10s| %-30s| %-15s|", book.getBookID(), reader.getNumber(), reader.getreaderID() );
    }
    public void hienthitabQL(Reader[] readers, Book[] books){
        System.out.printf("%-20s| %-30s| %-15s|\n", "Mã bạn đọc", "Số lượng sách mượn", "Mã sách");
        for (int i = 0; i < readers.length; i++) {
            if (readers[i].getNumber() != 0){
                tabqlMuonSach(readers[i],books[i]);
                System.out.println("");
            }
        }
    }
    public void searchName(Reader[] readers){
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        System.out.println("nhập tên bạn đọc cần tìm kiếm");
        String s = sc.nextLine();
        for (int i = 0; i < readers.length ; i++) {
            if (readers[i].getName() == s){
                System.out.println("thông tin bạn đọc cần tìm :");
                cnt++;
                printreader(readers[i]);
                System.out.println("");
            }
            if (cnt == 0) {
                System.out.println("không có tên bạn đọc cần tìm");
            }
        }
    }

    public void thucHienMuonSach() {
        Scanner sc = new Scanner(System.in);
        ds = new Borrowing[soluongreader];

        for (int j = 0; j < ds.length; j++) {

            System.out.println("Thực hiện mượn cho bạn đọc: " + dsreader[j].getName());
            System.out.println("Nhập số lượng đầu sách cần mượn:  ");
            System.out.println(" Bạn chỉ được mượn tối đa 5 đầu sách và ít hơn số sách trong danh sách");
            int sosachmuon = sc.nextInt();

            while (sosachmuon < 1 || sosachmuon > 5 || sosachmuon > dsbook.length) {
                System.out.println("Nhập số lượng đầu sách cần mượn:  ");
                System.out.println(" Bạn chỉ được mượn tối đa 5 đầu sách và ít hơn số sách trong danh sách");
                sosachmuon = sc.nextInt();
            }
            Borrowing.sodausach = sosachmuon;
            Book[] dsSachMuon = new Book[Borrowing.sodausach];
            int[] danhSachSL = new int[Borrowing.sodausach];
            borrowing = new Borrowing(dsSachMuon, dsreader[j], danhSachSL);
            ds [j] = borrowing;

        }
    }
}
