package com.juego.juego;

import com.juego.model.Personaje;
import com.juego.model.PersonajeBase;
import com.juego.patrones.decorator.*;
import com.juego.patrones.factory.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class JuegoLuchaTest {

    @Test
    void testBatallaCompleta_guerreroVsAsesino() {
        PersonajeFactory guerreroFactory = new GuerreroFactory();
        PersonajeFactory asesinFactory = new AsesinFactory();

        Personaje jugador1 = guerreroFactory.crearPersonaje("Guerrero");
        Personaje jugador2 = asesinFactory.crearPersonaje("Asesino");

        assertTrue(jugador1.estaVivo());
        assertTrue(jugador2.estaVivo());

        int turno = 1;
        while (jugador1.estaVivo() && jugador2.estaVivo() && turno <= 20) {
            int dano1 = jugador1.atacar();
            jugador2.recibirDano(dano1);
            if (!jugador2.estaVivo()) break;

            if (jugador2 instanceof VenenoDecorator) {
                ((VenenoDecorator) jugador2).atacarCon(jugador1);
            } else {
                int dano2 = jugador2.atacar();
                jugador1.recibirDano(dano2);
            }
            turno++;
        }

        assertFalse(jugador1.estaVivo() && jugador2.estaVivo());
    }

    @Test
    void testMainMethod_noLanzaExcepcion() {
        assertDoesNotThrow(() -> JuegoLucha.main(new String[]{}));
    }
}
