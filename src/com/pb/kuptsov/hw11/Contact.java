package com.pb.kuptsov.hw11;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;
import com.google.gson.Gson;

public class Contact {
    private final static Logger LOGGER =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private String fio;
    private String date_birthday;
    private List<String> phoneList;
    private String adress;
    private Date editTime;

    public Contact() {
    }

    public Contact(String fio, String date_birthday, List<String> phoneList, String adress, Date editTime) {
        this.fio = fio;
        this.date_birthday = date_birthday;
        this.phoneList = phoneList;
        this.adress = adress;
        this.editTime = editTime;
    }

    public static Logger getLOGGER() {
        return LOGGER;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getDate_birthday() {
        return date_birthday;
    }

    public void setDate_birthday(String date_birthday) {
        this.date_birthday = date_birthday;
    }

    public List<String> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<String> phoneList) {
        this.phoneList = phoneList;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(fio, contact.fio) && Objects.equals(date_birthday, contact.date_birthday) && Objects.equals(phoneList, contact.phoneList) && Objects.equals(adress, contact.adress) && Objects.equals(editTime, contact.editTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio, date_birthday, phoneList, adress, editTime);
    }

    public void addContactAuto(List<Contact> phonelist){

    }

    public String printPhones(List<String> phones){
        int count = 1;
        String str = "";
        for(String phone: phones){
            str += " телефон" + count + ": " + phone;
            count++;
        }
        return str;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String time = df.format(editTime);
        return "Контакт: \n" +
                "фио: " + fio +
                ", дата рождения: " + date_birthday +
                ", номера: (" + printPhones(phoneList) +
                "), адрес: " + adress +
                ", дата и время изменения записи: " + time;
    }

}