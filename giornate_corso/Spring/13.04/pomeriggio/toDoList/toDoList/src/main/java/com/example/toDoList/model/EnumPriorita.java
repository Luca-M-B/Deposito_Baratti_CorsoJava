package com.example.toDoList.model;

public enum EnumPriorita {
    ALTA(1),
    MEDIA(2),
    BASSA(3);

    private final int livello;

    EnumPriorita(int livello) {
        this.livello = livello;
    }

    public int getLivello() {
        return livello;
    }
}