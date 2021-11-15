package com.pb.kuptsov.hw7;

public abstract class Clothes {
    private String prise;
    private String color;
    private Size size;

    public Clothes(String prise, String color, Size size) {
        this.prise = prise;
        this.color = color;
        this.size = size;
    }

    public String getPrise() {
        return prise;
    }

    public void setPrise(String prise) {
        this.prise = prise;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
