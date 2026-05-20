package com.juego.model;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
class PersonajeTest {
    private PersonajeBase guerrero;
    private PersonajeBase oponente;
    @BeforeEach
    void setUp() {
        guerrero = new PersonajeBase("Thor", 100, 15);
        oponente = new PersonajeBase("Loki", 100, 15);
    }
    @Test
    void testCreacion() {
        assertEquals("Thor", guerrero.getNombre());
        assertEquals(100, guerrero.getPuntosDeVida());
        assertTrue(guerrero.estaVivo());
    }
    @Test
    void testRecibirDano() {
        guerrero.recibirDano(30);
        assertEquals(70, guerrero.getPuntosDeVida());
    }
    @Test
    void testHpNoNegativo() {
        guerrero.recibirDano(150);
        assertEquals(0, guerrero.getPuntosDeVida());
        assertFalse(guerrero.estaVivo());
    }
    @Test
    void testDanoNegativo() {
        guerrero.recibirDano(-10);
        assertEquals(100, guerrero.getPuntosDeVida());
    }
}
