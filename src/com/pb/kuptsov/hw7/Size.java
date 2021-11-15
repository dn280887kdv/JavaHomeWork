package com.pb.kuptsov.hw7;

public enum Size {
    XXS("Детский размер", "32"),
    XS("Взрослый размер", "34"),
    S("Взрослый размер", "36"),
    M("Взрослый размер", "38"),
    L("Взрослый размер", "40");

    String description;
    String euroSize;

    Size(String description, String euroSize) {
        this.description = description;
        this.euroSize = euroSize;
    }

    String getDescription(){
        return description;
    }

    String getEuroSize(){
        return euroSize;
    }
}
