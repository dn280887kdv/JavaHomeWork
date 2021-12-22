package com.pb.kuptsov.hw12;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        List<String> phones1 = new ArrayList<>();
        phones1.add("+334343");
        phones1.add("+1231223");

        List<String> phones2 = new ArrayList<>();
        phones2.add("+5644");
        phones2.add("+77787");

        List<String> phones3 = new ArrayList<>();
        phones3.add("+334122343");
        phones3.add("+1231444223");

        Contact contact1 = new Contact(IntStream.range(0, 5).sum(),"asdasd","11/22/33", phones1, "sadsasad", new Date());
        Thread.sleep(2000);
        Contact contact2 = new Contact(IntStream.range(0, 10).sum(), "zcxzxc","11/22/33", phones2, "asdasdasd", new Date());
        Thread.sleep(2000);
        Contact contact3 = new Contact(IntStream.range(0, 3).sum(), "qweqwe","11/22/33", phones3, "sadasddsa", new Date());

        List<Contact> contacts = new ArrayList<>();
        contacts.add(contact3);
        contacts.add(contact2);
        contacts.add(contact1);

        ContactBook book = new ContactBook();
//        book.printContacts(contacts, "fio");


        book.recordToFile(contacts);

        book.getContactsFromFile();
//        System.out.println(book.getContactByFio(contacts, "asdasd"));
//        System.out.println(book.getContactByPhone(contacts, "+1231444223"));

//        book.addContact(contacts);

        book.printContacts(contacts, "");



    }
}
