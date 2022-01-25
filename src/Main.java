import model.Book;
import model.Reader;
import library.BorrowBook;

import java.util.Scanner;

public class Main {
    private static int countReader;
    private static Reader[] readers;
    private static Book[] books;
    private static BorrowBook[] borrowBooks;

    public static void main(String[] args) {
        menu();
    }
    private static int functionChoice(){
        System.out.println("--------Quản lý mượn sách thư viện--------");
        System.out.println("1.Nhập danh sách đầu sách mới");
        System.out.println("2.Nhập danh sách bạn đọc");
        System.out.println("3.Quản lý mượn sách cho từng bạn đọc");
        System.out.println("4.Sắp xếp danh sách quản lý mượn sách");
        System.out.println("5.Tìm kiếm và hiển thị danh sách theo tên bạn đọc");
        System.out.println("6.Thoát");
        int functionChoice;
        do {
            functionChoice = new Scanner(System.in).nextInt();
            if (functionChoice >= 1 && functionChoice <= 6) {
                break;
            }
            System.out.print("Chức năng chọn không hợp lệ, vui lòng chọn lại: ");
        } while (true);
        return functionChoice;
    }

    private static void menu() {
        do {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    createNewBooks();
                    displayBooks();
                    break;
                case 2:
                    createNewReaders();
                    displayReaders();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    sortBorrowList();
                    break;
                case 5:
                    searchAndDisplay();
                    break;
                case 6:
                    System.exit(0);
            }

        } while (true);
    }

    private static void searchAndDisplay() {
        if (borrowBooks == null || borrowBooks.length == 0) {
            System.out.println("Bạn cần nhập danh sách bạn đọc và đầu sách trước khi cho mượn!");
            return;
        }

        System.out.print("Nhập tên bạn đọc muốn tìm kiếm: ");
        String tempName = new Scanner(System.in).nextLine();
        boolean isFound = false;
        for (BorrowBook borrowBook : borrowBooks) {
            if (borrowBook.getReader().getName().equals(tempName)) {
                System.out.println(borrowBook.getReader());
                isFound = true;
            }
        }

        if (!isFound) {
            System.out.println("Không tìm thấy bạn đọc có tên '" + tempName + "' trong danh sách mượn sách");
        }
    }

    private static void sortBorrowList() {
        if (borrowBooks == null || borrowBooks.length == 0) {
            System.out.println("Bạn cần nhập danh sách bạn đọc và đầu sách trước khi cho mượn!");
            return;
        }
        do {
            int sortChoice;
            System.out.println("SẮP XẾP DANH SÁCH MƯỢN SÁCH");
            System.out.println("1. Theo tên bạn đọc.");
            System.out.println("2. Theo số lượng cuốn sách được mượn (giảm dần).");
            System.out.println("3. Thoát chức năng sắp xếp.");
            System.out.print("Xin mời chọn chức năng: ");
            do {
                sortChoice = new Scanner(System.in).nextInt();
                if (sortChoice >= 1 && sortChoice <= 3) {
                    break;
                }
                System.out.print("Chức năng chọn không hợp lệ, vui lòng chọn lại: ");
            } while (true);
            switch (sortChoice) {
                case 1:
                    sortBorrowListByReaderName();
                    break;
                case 2:
                    sortBorrowListByBookAmount();
                    break;
                case 3:
                    return;
            }
        } while (true);
    }

    private static void createNewReaders() {
        System.out.println("Nhập số lượng bạn đọc muốn thêm: ");
        countReader = new Scanner(System.in).nextInt();
        readers = new Reader[countReader];
        for (int i = 0; i < readers.length; i++) {
            Reader reader = new Reader();
            reader.inputReaderInfo();
            readers[i] = reader;
        }
    }

    private static void displayReaders() {
        for (Reader reader : readers) {
            System.out.println(reader);
        }
    }

    private static void createNewBooks() {
        System.out.println("Nhập số lượng sách muốn thêm: ");
        int countBook = new Scanner(System.in).nextInt();
        books = new Book[countBook];
        for (int i = 0; i < books.length; i++) {
            Book book = new Book();
            book.inputBookInfo();
            books[i] = book;
        }
    }

    private static void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private static void sortBorrowListByBookAmount() {
        if (borrowBooks == null || borrowBooks.length == 0) {
            System.out.println("Bạn cần nhập danh sách cho mượn trước khi sắp xếp!");
            return;
        }

        for (BorrowBook borrowBook : borrowBooks) {
            Book[] books = borrowBook.getBooks();
            int[] quantity = borrowBook.getQuantity();
            int tempTotal = 0;
            for (int j = 0; j < books.length; j++) {
                tempTotal += quantity[j];
            }
            borrowBook.setTotalBook(tempTotal);
        }

        for (int i = 0; i < borrowBooks.length; i++) {
            for (int j = i + 1; j < borrowBooks.length; j++) {
                if (borrowBooks[i].getTotalBook() < borrowBooks[j].getTotalBook()) {
                    BorrowBook temp = borrowBooks[i];
                    borrowBooks[i] = borrowBooks[j];
                    borrowBooks[j] = temp;
                }
            }
        }
        for (BorrowBook borrowBook : borrowBooks) {
            System.out.println(borrowBook);
        }
    }

    private static void sortBorrowListByReaderName() {
        if (borrowBooks == null || borrowBooks.length == 0) {
            System.out.println("Bạn cần nhập danh sách cho mượn trước khi sắp xếp!");
            return;
        }
        for (int i = 0; i < borrowBooks.length; i++) {
            for (int j = i+1; j < borrowBooks.length; j++) {
                if (borrowBooks[i].getReader().getName().compareTo(borrowBooks[j].getReader().getName()) > 0) {
                    BorrowBook temp = borrowBooks[i];
                    borrowBooks[i] = borrowBooks[j];
                    borrowBooks[j] = temp;
                }
            }
        }
        for (BorrowBook borrowBook : borrowBooks) {
            System.out.println(borrowBook);
        }
    }

    private static boolean isValidBookAndReader() {
        return books != null && readers != null && books.length > 0 && readers.length > 0;
    }

    private static void borrowBook() {
        if (!isValidBookAndReader()) {
            System.out.println("Bạn cần nhập danh sách bạn đọc và đầu sách trước khi cho mượn!");
            return;
        }
        boolean checked = true;
        borrowBooks = new BorrowBook[countReader];
        for (int i = 0; i < readers.length; i++) {
            System.out.println("Nhập số lượng đầu sách mà bạn " + readers[i].getName() + " muốn mượn: ");
            int k;
            do {
                k = new Scanner(System.in).nextInt();
                if (k < 0 || k > 5 || k > books.length) {
                    System.out.println("nhập lại! số lượng đầu sách lớn hơn 0, nhỏ hơn 5 và tổng sách:  ");
                    checked = false;
                }
            } while (!checked);
            Book[] bookList = new Book[k];
            int[] quantityList = new int[k];
            for (int j = 0; j < k; j++) {
                System.out.println("Nhập id của đầu sách thứ " + (j + 1) + " mà bạn " + readers[i].getName() + " muốn mượn: ");
                int tempId;
                do {
                    tempId = new Scanner(System.in).nextInt();
                    Book book = searchBook(tempId);
                    int m = 0;
                    if (book != null) {
                        System.out.print("Nhập số lượng cuốn bạn muốn mượn của sách " + book.getBookName() + ": ");
                        do {
                            m = new Scanner(System.in).nextInt();
                            if (m > 3 || m <= 0) {
                                System.out.println("Số lượng sách được cho phép mượn của một đầu sách lớn hơn 0, " +
                                        "không vượt quá 3 và không có chữ! nhập lại: ");
                                checked = false;
                            }
                        } while (!checked);
                        bookList[j] = book;
                        quantityList[j] = m;
                        break;
                    }
                    System.out.print("Không có sách nào trong thư viện có ID vừa nhập, vui lòng nhập lại: ");
                } while (true);
            }

            BorrowBook borrowBook = new BorrowBook(readers[i], bookList, quantityList);
            borrowBooks[i] = borrowBook;

        }
        System.out.println("Danh sách bảng mượn sách của các bạn đọc hiện tại là:");
        for (BorrowBook borrowBook : borrowBooks) {
            System.out.println(borrowBook);
        }
    }

    private static Book searchBook(int id) {
        for (Book book : books) {
            if (book.getBookID() == id) {
                return book;
            }
        }
        return null;
    }


}
