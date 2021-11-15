package com.pb.kuptsov.hw7;

public class Tie extends Clothes implements ManClothes{

    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Tie(String prise, String color, Size size, String name) {
        super(prise, color, size);
        this.name = name;
    }

    @Override
    public void dressMan() {
        System.out.println("Одевает мужчина: " + getName() + ", размер: " + getSize().getEuroSize() + "("+
                getSize().getDescription() +"), цена: " + getPrise() + ", цвет: " + getColor());
    }
}
