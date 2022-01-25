package model;

import java.util.Scanner;

public class Reader extends Person {
    private int id;
    private String ReaderType;

    private static final String STUDENT = "Sinh viên";
    private static final String GRADUATE_STUDENT = "Học viên cao học";
    private static final String TEACHER = "Giáo viên";

    private static int AUTO_ID = 10000;

    public Reader() {
    }

    public Reader(int id, String name, String address, String phone, String readerType) {
        super(name, address, phone);
        this.id = id;
        this.ReaderType = readerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public static String getSTUDENT() {
        return STUDENT;
    }

    public static String getGraduateStudent() {
        return GRADUATE_STUDENT;
    }

    public static String getTEACHER() {
        return TEACHER;
    }




    public String getReaderType() {
        return ReaderType;
    }

    public void setReaderType(String readerType) {
        ReaderType = readerType;
    }





    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    public void inputReaderInfo() {
        this.setId(Reader.AUTO_ID);
        super.inputperson();
        System.out.println("Nhập loại bạn đọc:");
        System.out.println("1.Sinh viên");
        System.out.println("2.Học viên cao học");
        System.out.println("3.Giảng viên");
        System.out.println("Nhập sự lựa chọn: ");
        boolean check = true;
        do {
            int choice = new Scanner(System.in).nextInt();
            if (choice <= 0 || choice > 3) {
                System.out.print("Nhập số trong khoảng từ 1 đến 3! Nhập lại: ");
                check = false;
                continue;
            }

            switch (choice) {
                case 1:
                    this.setReaderType(Reader.getSTUDENT());
                    System.out.println("Sinh viên");
                    check = true;
                    break;
                case 2:
                    this.setReaderType(Reader.getGraduateStudent());
                    System.out.println("Học viên cao học");
                    check = true;
                    break;
                case 3:
                    this.setReaderType(Reader.getTEACHER());
                    System.out.println("Giáo viên");
                    check = true;
                    break;
                default:
                    System.out.println("Nhập sai! Hãy nhập từ 1 đến 3!");
                    check = false;
                    break;
            }
        } while (!check);
        Reader.AUTO_ID++;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", name='" + getName() + '\'' +
                ", address='" + getaddress() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", ReaderType='" + ReaderType + '\'' +
                '}';
    }
}
