package com.juego.patrones.decorator;
import com.juego.model.Personaje;

public class VenenoDecorator extends PersonajeDecorator {

    private static final int DANO_VENENO = 5;

    public VenenoDecorator(Personaje personaje) {
        super(personaje);
    }

    @Override
    public int atacar() {
        return personaje.atacar();
    }

    public int atacarCon(Personaje objetivo) {
        int danioBase = personaje.atacar();
        objetivo.recibirDano(danioBase);
        System.out.println("  [Veneno] aplica " + DANO_VENENO + " puntos extra de veneno.");
        objetivo.recibirDano(DANO_VENENO);
        return danioBase + DANO_VENENO;
    }

    @Override
    public String getNombre() {
        return personaje.getNombre() + " [Veneno]";
    }
}