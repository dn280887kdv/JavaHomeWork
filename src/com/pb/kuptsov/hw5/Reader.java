package com.pb.kuptsov.hw5;

import java.sql.Array;

public class Reader {
    private String fio;
    private int ticketNumber;
    private String faculty;
    private String birthday;
    private String phone;

    public Reader() {
    }

    public Reader(String fio, int ticketNumber, String faculty, String birthday, String phone) {
        this.fio = fio;
        this.ticketNumber = ticketNumber;
        this.faculty = faculty;
        this.birthday = birthday;
        this.phone = phone;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return  "ФИО: '" + fio + '\'' +
                ", Номер читательского: " + ticketNumber +
                ", Факультет: '" + faculty + '\'' +
                ", ДР: '" + birthday + '\'' +
                ", Телефон: '" + phone + '\'';
    }


    public void takeBook(int length) {
        System.out.println(fio + " взял " + length + " книги!");
    }

    public void takeBook(Book[] mass) {
        String message = fio + " взял книги: ";

        for(int i = 0; i < mass.length-1; i++){
            message += mass[i].getNameBook() + " (" + mass[i].getAuthorBook() + " " + mass[i].getYearBook() + "г.), ";
        }

        System.out.println(message + mass[mass.length-1].getNameBook() +" (" + mass[mass.length-1].getAuthorBook() + " " + mass[mass.length-1].getYearBook() + "г.)");
    }

    public void takeBook(String[] booksNames) {
        String message = fio + " взял книги: ";

        for(int i = 0; i < booksNames.length-1; i++){
            message += booksNames[i] + ", ";
        }

        System.out.println(message + booksNames[booksNames.length-1]);
    }

    public void returnBook(int length) {
        System.out.println(fio + " вернул " + length + " книги!");
    }

    public void returnBook(Book[] mass) {
        String message = fio + " вернул книги: ";

        for(int i = 0; i < mass.length-1; i++){
            message += mass[i].getNameBook() + " (" + mass[i].getAuthorBook() + " " + mass[i].getYearBook() + "г.), ";
        }

        System.out.println(message + mass[mass.length-1].getNameBook() +" (" + mass[mass.length-1].getAuthorBook() + " " + mass[mass.length-1].getYearBook() + "г.)");
    }

    public void returnBook(String[] booksNames) {
        String message = fio + " вернул книги: ";

        for(int i = 0; i < booksNames.length-1; i++){
            message += booksNames[i] + ", ";
        }

        System.out.println(message + booksNames[booksNames.length-1]);
    }
}
