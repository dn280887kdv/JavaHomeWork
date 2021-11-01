package com.pb.kuptsov.hw5;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Book1", "Author1", 1997);
        Book book2 = new Book("Book2", "Author2", 1998);
        Book book3 = new Book("Book3", "Author3", 1999);

        Reader reader1 = new Reader("FIO1", 1, "COMP1", "Birthday1", "+380631111111");
        Reader reader2 = new Reader("FIO2", 2, "COMP2", "Birthday2", "+380631111112");
        Reader reader3 = new Reader("FIO3", 3, "COMP3", "Birthday3", "+380631111113");

        Reader[] readers = {reader1, reader2, reader3};
        Book[] mass = {book1, book2, book3};
        String[] booksNames = {book1.getNameBook(), book2.getNameBook(), book3.getNameBook()};

        for(Reader reader: readers){
            System.out.println("Читатель: " + reader.toString());
        }

        for(Book book: mass){
            System.out.println("Книга: " + book.toString());
        }

        reader1.takeBook(mass.length);
        reader1.takeBook(booksNames);
        reader1.takeBook(mass);

        reader1.returnBook(mass.length);
        reader1.returnBook(booksNames);
        reader1.returnBook(mass);

    }
}
