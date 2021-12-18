package com.pb.kuptsov.hw11;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> phones1 = new ArrayList<>();
        phones1.add("+334343");
        phones1.add("+1231223");

        List<String> phones2 = new ArrayList<>();
        phones2.add("+5644");
        phones2.add("+77787");

        List<String> phones3 = new ArrayList<>();
        phones3.add("+334122343");
        phones3.add("+1231444223");

        Contact contact1 = new Contact("asdasd","11/22/33", phones1, "sadsasad", new Date());
        Contact contact2 = new Contact("zcxzxc","11/22/33", phones2, "asdasdasd", new Date());
        Contact contact3 = new Contact("qweqwe","11/22/33", phones3, "sadasddsa", new Date());

        List<Contact> contacts = new ArrayList<>();
        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);

        ContactBook book = new ContactBook();
//        book.printContacts(contacts, "fio");


        book.recordToFile(contacts);

        book.getContactsFromFile();
        System.out.println(book.getContactByFio(contacts, "asdasd"));
        System.out.println(book.getContactByPhone(contacts, "+1231444223"));

        book.addContact(contacts);



    }
}
