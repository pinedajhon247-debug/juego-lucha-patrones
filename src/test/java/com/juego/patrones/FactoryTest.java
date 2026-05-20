package com.juego.patrones;

import com.juego.model.Personaje;
import com.juego.patrones.factory.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class FactoryTest {

    @Test
    void testGuerreroFactory_creaPersonaje() {
        PersonajeFactory factory = new GuerreroFactory();
        Personaje p = factory.crearPersonaje("Guerrero1");
        assertNotNull(p);
        assertTrue(p.getNombre().contains("Guerrero1"));
        assertTrue(p.estaVivo());
    }

    @Test
    void testAsesinFactory_creaPersonaje() {
        PersonajeFactory factory = new AsesinFactory();
        Personaje p = factory.crearPersonaje("Asesino1");
        assertNotNull(p);
        assertTrue(p.estaVivo());
    }

    @Test
    void testMagoFactory_creaPersonaje() {
        PersonajeFactory factory = new MagoFactory();
        Personaje p = factory.crearPersonaje("Mago1");
        assertNotNull(p);
        assertTrue(p.estaVivo());
    }
}
