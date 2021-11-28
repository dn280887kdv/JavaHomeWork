package com.pb.kuptsov.hw10;

public class NumBox <T extends Number>{
    private T mas[];
    private int length = 0;


    public T[] getMas() {
        return mas;
    }

    public void setMas(int index, T t) {
        this.mas[index] = t;
    }

    public NumBox(int i) {
        mas = (T[]) new Number[i];
    }

    public void add(T num){
        if(length < mas.length){
            mas[length] = num;
            length++;
        } else throw new IndexOutOfBoundsException("Массив заполнен, выберите другой");
    }

    public T get(int index){
        return mas[index];
    }

    public int length(){
        return mas.length;
    }

    public double average(){
        double sum = 0.0;
        for (int i = 0; i < mas.length; i++) {
            sum += mas[i].doubleValue();
        }
        return sum/mas.length;
    }

    public double sum(){
        double sum = 0.0;
        for (int i = 0; i < mas.length; i++) {
            sum += mas[i].doubleValue();
        }
        return sum;
    }

    public T max(){
        double max = 0.0;
        int count = 0;
        for(int i = 0; i < mas.length; i++){
            if(mas[i].doubleValue() > max){
                max = mas[i].doubleValue();
                count = i;
            }
        }
        return mas[count];
    }
}
