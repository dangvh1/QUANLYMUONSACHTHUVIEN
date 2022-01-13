package library;

import model.Book;
import model.Borrowing;
import model.Reader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Management run = new Management();
        Book[] books = new Book[100];
        Reader[] readers = new Reader[100];
        Borrowing[] borrowings = new Borrowing[100];
        for (int i = 0; i < books.length; i++) {
            books[i] = new Book(0, "", "", "", "", "");
        }

        for (int i = 0; i < readers.length; i++) {
            readers[i] = new Reader(0, "", "", "", "",0);
        }

        do {
            System.out.println("***********MENU***********");
            System.out.println("1. Nhập danh sách đầu sách ");
            System.out.println("2. Nhập danh sách bạn đọc mới ");
            System.out.println("3. Hiển thị danh muc sach ");
            System.out.println("4. Hiển thị danh mục bạn đọc ");
            System.out.println("5. Lập bảng QL mượn sách");
            System.out.println("6. Sắp xếp danh sách Quản lý mượn sách");
            System.out.println("7. Tìm kiếm và hiển thị danh sách mượn sách theo tên bạn đọc");
            System.out.println("Su lua chon cua ban: ");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        for (int i = 0; i < books.length; i++) {
                            if (i == 0) {
                                if (books[i].getBookID() == 0) {
                                    books[0] = run.inputBooks(10000);
                                    System.out.println("Đã nhập thông tin sách\n");
                                    break;
                                }
                            } else {
                                if (books[i].getBookID() == 0) {
                                    books[i] = run.inputBooks(books[i - 1].getBookID());
                                    System.out.println("Đã nhập thông tin sách\n");
                                    break;
                                }
                            }
                        }
                        break;
                    case 2:
                        for (int i = 0; i < readers.length; i++) {
                            if (i == 0) {
                                if (readers[i].getreaderID() == 0) {
                                    readers[0] = run.inputReader(10000);
                                    System.out.println("Đã nhập thông tin bạn đọc\n");
                                    break;
                                }
                            } else {
                                if (readers[i].getreaderID() == 0) {
                                    readers[i] = run.inputReader(readers[i - 1].getreaderID());
                                    System.out.println("Đã nhập thông tin bạn đọc\n");
                                    break;
                                }
                            }

                        }
                        System.out.printf("%-5s| %-20s| %-10s| %-15s| %-10s|\n", "ID", "Reader Name", "Address", "Phone", "Job");
                        for (int i = 0; i < readers.length; i++) {
                            if (readers[i].getreaderID() != 0) {
                                System.out.println("");
                            }
                        }

                        break;
                    case 3:
                        run.thucHienMuonSach();
                        run.hienthibook(books);

                        break;
                    case 4:
                        run.hienthireader(readers);

                        break;
                    case 5:
                        run.hienthitabQL(readers,books);

                        break;
                    case 6:
                        do {
                            System.out.println("1. Theo tên bạn đọc");
                            System.out.println("2. Theo Số lượng cuốn sách được mượn (giảm dần)");
                            int choose = Integer.parseInt(sc.nextLine());
                            switch (choose) {
                                case 1:
                                    Reader reader = new Reader();
                                    for (int i = 0; i < readers.length ; i++) {
                                        for (int j = i+1; j < readers.length; j++) {
                                            if (readers[i].getName().compareTo(readers[j].getName())>0){
                                                reader = readers[i];
                                                readers[i]=readers[j];
                                                readers[j] = reader;
                                            }
                                        }
                                    }

                                    break;
                                case 2:

                                    break;
                                default:
                                    System.out.println("Chon menu tu 1 or 2, vui long chon lai: ");
                                    break;
                            }
                        }while (true);
                    case 7:
                        run.searchName(readers);

                        break;
                    default:
                        System.out.println("Chon menu tu 1-3, vui long chon lai: ");
                        break;
                }
        } while (true);

    }


}

