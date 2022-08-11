package com.juegocaballo.caballo.baraja;

public class Carta {
    int id;
    int numero;
    String palo;

    int x;
    int y;

    public Carta(int id, int numero, String palo) {
        this.id = id;
        this.numero = numero;
        this.palo = palo;
    }


    public int getId() {
        return id;
    }


    public String getPalo() {
        return palo;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "id=" + id +
                ", numero=" + numero +
                ", palo='" + palo + '\'' +
                '}';
    }
}
