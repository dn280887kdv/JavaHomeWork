package com.pb.kuptsov.hw12;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ContactBook {

    public ContactBook() {
    }

    public void printContacts(List<Contact> contacts, String sort){
        if(sort.equals("editTime")){
            Comparator<Contact> comparator = Comparator.comparing(obj -> obj.getEditTime());
            Collections.sort(contacts, comparator);
        } else if(sort.equals("id")){
            Comparator<Contact> comparator = Comparator.comparing(obj -> obj.getId());
            Collections.sort(contacts, comparator);
        }

        System.out.println("Список всех контактов телефонной книги: ");
        for(Contact contact: contacts){
            System.out.println(contact.toString());
        }
    }

    public boolean delContact(List<Contact> contacts, Contact contact){
        boolean del = false;
        for (Contact cont: contacts){
            if(cont.equals(contact)){
                contacts.remove(contact);
                del = true;
            }
        }
        return del;
    }

    public Contact getContactByPhone(List<Contact> contacts, String phone){
        Contact cont = null;
        for(Contact contact: contacts){
            for (String tel: contact.getPhoneList()){
//                System.out.println(tel);
                if (tel == phone){
                    cont = contact;
                }
            }
        }
        return cont;
    }

    public Contact getContactByFio(List<Contact> contacts, String fio){
        Contact cont = null;
        for(Contact contact: contacts){
            System.out.println(contact.getFio());
            if (contact.getFio() == fio){
                cont = contact;
            }
        }
        return cont;
    }

    public void recordToFile(List<Contact> contacts) throws IOException {
        String str = "";
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter("C:\\test.json")) {
            gson.toJson(contacts, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Object> getContactsFromFile(){
        List<Object> list = new ArrayList<>();
        Gson gson = new Gson();

        try (FileReader reader = new FileReader("C:\\test.json")) {
            list = gson.fromJson(reader, ArrayList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Object contact: list){
            System.out.println(contact);
        }

        return list;
    }

    public void addContact(List<Contact> contacts){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добавление контакта в телефонную книгу. Заполните следующие поля:");
        System.out.print("Фио: ");
        String fio = scanner.next();
        System.out.print("Дата рождения: ");
        String date_birthday = scanner.next();
        System.out.print("Телефон: ");
        List<String> phonelist = new ArrayList<String>();
        String phone = scanner.next();
        phonelist.add(phone);
        int count = 1;
        while (true){
            System.out.println("еще добавить телефон? 1 - да, 2 - нет");
            if(scanner.nextInt() == 1){
                ++count;
                System.out.print("Телефон "+ count + ": ");
                phonelist.add(new String(scanner.next()));
            } else break;
        }
        System.out.print("Адресс: ");
        String adress = scanner.next();
        Date editDate = new Date();
        Contact contact = new Contact(new Random().nextInt(101), fio, date_birthday, phonelist, adress, editDate);
        contacts.add(contact);
        System.out.println("Контакт " + contact.getFio() + " успешно сохранен");
    }


}
