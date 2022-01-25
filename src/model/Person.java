package model;

import java.util.Scanner;

public class Person {
    private String name;
    private String address;
    private String phone;

    public Person() {
    }

    public Person(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    public void inputperson(){
        System.out.println("Nhập tên bạn đọc: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Nhập địa chỉ bạn đọc: ");
        this.address = new Scanner(System.in).nextLine();
        System.out.println("Nhập số điện thoại bạn đọc");
        this.phone = new Scanner(System.in).nextLine();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
