package com.juego.model;

public interface Personaje {
    int atacar();
    void recibirDano(int dano);
    boolean estaVivo();
    String getNombre();
}