package model;

public class Reader extends Person {
    private int readerID;
    private String readertype;
    private int number;


    public Reader() {
    }

    public Reader(int readerID, String name, String adress, String phone, String readertype, int number) {
        super(name, adress, phone);
        this.readerID = readerID;
        this.readertype = readertype;
        this.number = number;
    }

    public int getreaderID() {
        return readerID;
    }

    public void setreaderID(int readerID) {
        this.readerID = readerID;
    }

    public String getreadertype() {
        return readertype;
    }

    public void setreadertype(String readertype) {
        this.readertype = readertype;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
