package com.pb.kuptsov.hw5;

public class Book {
    private String nameBook;
    private String authorBook;
    private int yearBook;

    public Book(){
    }

    public Book(String nameBook, String authorBook, int yearBook) {
        this.nameBook = nameBook;
        this.authorBook = authorBook;
        this.yearBook = yearBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(String authorBook) {
        this.authorBook = authorBook;
    }

    public int getYearBook() {
        return yearBook;
    }

    public void setYearBook(int yearBook) {
        this.yearBook = yearBook;
    }

    @Override
    public String toString() {
        return  "Название книги: '" + nameBook + '\'' +
                ", Автор книги: '" + authorBook + '\'' +
                ", Год выпуска: " + yearBook;
    }
}
