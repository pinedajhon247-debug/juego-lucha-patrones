package com.juego.patrones.decorator;
import com.juego.model.Personaje;

public abstract class PersonajeDecorator implements Personaje {

    protected final Personaje personaje;

    public PersonajeDecorator(Personaje personaje) {
        this.personaje = personaje;
    }

    @Override
    public int atacar() { return personaje.atacar(); }

    @Override
    public void recibirDano(int dano) { personaje.recibirDano(dano); }

    @Override
    public boolean estaVivo() { return personaje.estaVivo(); }

    @Override
    public String getNombre() { return personaje.getNombre(); }
}