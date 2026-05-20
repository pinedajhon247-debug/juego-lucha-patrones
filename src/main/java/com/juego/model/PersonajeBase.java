package com.juego.model;

public class PersonajeBase implements Personaje {
    private final String nombre;
    private int vida;
    private final int danioBase;

    public PersonajeBase(String nombre, int vida, int danioBase) {
        this.nombre = nombre;
        this.vida = vida;
        this.danioBase = danioBase;
    }

    @Override
    public int atacar() {
        System.out.println(nombre + " ataca con " + danioBase + " de danio base.");
        return danioBase;
    }

    @Override
    public void recibirDano(int dano) {
        if (dano < 0) return;
        vida -= dano;
        if (vida < 0) vida = 0;
        System.out.println(nombre + " recibe " + dano + " de danio. Vida restante: " + vida);
    }

    @Override
    public boolean estaVivo() {
        return vida > 0;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    public int getPuntosDeVida() {
        return vida;
    }
}
