package com.juego.patrones.decorator;
import com.juego.model.Personaje;

public class FuerzaDecorator extends PersonajeDecorator {

    private static final int BONUS_DANO = 10;

    public FuerzaDecorator(Personaje personaje) {
        super(personaje);
    }

    @Override
    public int atacar() {
        int danioBase  = personaje.atacar();
        int danioTotal = danioBase + BONUS_DANO;
        System.out.println("  [Fuerza] +" + BONUS_DANO + " de bonus → daño total: " + danioTotal);
        return danioTotal;
    }

    @Override
    public String getNombre() {
        return personaje.getNombre() + " [Fuerza]";
    }
}