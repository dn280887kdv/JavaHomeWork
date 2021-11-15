package com.pb.kuptsov.hw7;

public class Atelier {
    public static void main(String[] args) {

        Clothes cloth1 = new Pants( "34 USD", "красные", Size.M, "штаны общие");
        Clothes cloth2 = new Skirt("20 USD", "белая", Size.XS, "юбка");
        Clothes cloth3 = new Tie("10 USD", "черный", Size.M, "галстук");
        Clothes cloth4 = new Tshirt("5 USD", "разноцветная", Size.XXS, "футболка общая");

        Clothes[] clothes = {cloth1, cloth2, cloth3, cloth4};

        dressMan(clothes);
        dressWomen(clothes);

    }

    public static void dressMan(Clothes[] clothes){
        for(Clothes c: clothes){
            if(c instanceof ManClothes){
                ((ManClothes) c).dressMan();
            }
        }

    }

    public static void dressWomen(Clothes[] clothes){
        for(Clothes c: clothes) {
            if (c instanceof WomenClothes) {
                ((WomenClothes) c).dressWomen();
            }
        }
    }
}
