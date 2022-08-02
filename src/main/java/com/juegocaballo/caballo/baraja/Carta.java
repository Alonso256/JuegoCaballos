package com.juegocaballo.caballo.baraja;

public class Carta {
    int id;
    int numero;
    String palo;

    public Carta(int id, int numero, String palo) {
        this.id = id;
        this.numero = numero;
        this.palo = palo;
    }

    public Carta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
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
