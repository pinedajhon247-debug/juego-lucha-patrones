package com.juego.patrones;

import com.juego.model.PersonajeBase;
import com.juego.patrones.decorator.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class DecoratorCoberturaTest {

    @Test
    void testFuerzaDecorator_atacaConBonus() {
        PersonajeBase base = new PersonajeBase("Thor", 100, 15);
        FuerzaDecorator fuerza = new FuerzaDecorator(base);
        int dano = fuerza.atacar();
        assertEquals(25, dano);
    }

    @Test
    void testArmaduraDecorator_reduceDano() {
        PersonajeBase base = new PersonajeBase("Thor", 100, 15);
        ArmaduraDecorator armadura = new ArmaduraDecorator(base);
        armadura.recibirDano(10);
        assertEquals(95, base.getPuntosDeVida());
    }

    @Test
    void testArmaduraDecorator_danoMenorQueReduccion() {
        PersonajeBase base = new PersonajeBase("Thor", 100, 15);
        ArmaduraDecorator armadura = new ArmaduraDecorator(base);
        armadura.recibirDano(3);
        assertEquals(100, base.getPuntosDeVida());
    }

    @Test
    void testVenenoDecorator_atacarCon() {
        PersonajeBase atacante = new PersonajeBase("Loki", 80, 12);
        VenenoDecorator veneno = new VenenoDecorator(atacante);
        PersonajeBase objetivo = new PersonajeBase("Thor", 100, 15);
        veneno.atacarCon(objetivo);
        assertTrue(objetivo.getPuntosDeVida() < 100);
    }

    @Test
    void testVenenoDecorator_estaVivo() {
        PersonajeBase base = new PersonajeBase("Loki", 80, 12);
        VenenoDecorator veneno = new VenenoDecorator(base);
        assertTrue(veneno.estaVivo());
        veneno.recibirDano(200);
        assertFalse(veneno.estaVivo());
    }

    @Test
    void testCombinacionDecorators() {
        PersonajeBase base = new PersonajeBase("Guerrero", 100, 15);
        ArmaduraDecorator armadura = new ArmaduraDecorator(base);
        FuerzaDecorator fuerza = new FuerzaDecorator(armadura);
        int dano = fuerza.atacar();
        assertEquals(25, dano);
        fuerza.recibirDano(10);
        assertEquals(95, base.getPuntosDeVida());
    }
}
