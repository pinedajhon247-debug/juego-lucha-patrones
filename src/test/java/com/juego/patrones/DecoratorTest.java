package com.juego.patrones;

import com.juego.model.Personaje;
import com.juego.model.PersonajeBase;
import com.juego.patrones.decorator.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DecoratorTest {

    @Mock
    private Personaje mockPersonaje;

    // --- FuerzaDecorator ---
    @Test
    void testFuerzaDecorator_sumaBonusDano() {
        when(mockPersonaje.atacar()).thenReturn(15);
        FuerzaDecorator fuerza = new FuerzaDecorator(mockPersonaje);
        int resultado = fuerza.atacar();
        assertEquals(25, resultado);
        verify(mockPersonaje).atacar();
    }

    @Test
    void testFuerzaDecorator_nombre() {
        when(mockPersonaje.getNombre()).thenReturn("Thor");
        FuerzaDecorator fuerza = new FuerzaDecorator(mockPersonaje);
        assertTrue(fuerza.getNombre().contains("Fuerza"));
    }

    // --- ArmaduraDecorator ---
    @Test
    void testArmaduraDecorator_reduceDano() {
        ArmaduraDecorator armadura = new ArmaduraDecorator(mockPersonaje);
        armadura.recibirDano(10);
        verify(mockPersonaje).recibirDano(5);
    }

    @Test
    void testArmaduraDecorator_danoMenorQueReduccion() {
        ArmaduraDecorator armadura = new ArmaduraDecorator(mockPersonaje);
        armadura.recibirDano(3);
        verify(mockPersonaje).recibirDano(0);
    }

    @Test
    void testArmaduraDecorator_nombre() {
        when(mockPersonaje.getNombre()).thenReturn("Thor");
        ArmaduraDecorator armadura = new ArmaduraDecorator(mockPersonaje);
        assertTrue(armadura.getNombre().contains("Armadura"));
    }

    // --- VenenoDecorator ---
    @Test
    void testVenenoDecorator_nombre() {
        when(mockPersonaje.getNombre()).thenReturn("Loki");
        VenenoDecorator veneno = new VenenoDecorator(mockPersonaje);
        assertTrue(veneno.getNombre().contains("Veneno"));
    }

    @Test
    void testVenenoDecorator_atacar() {
        when(mockPersonaje.atacar()).thenReturn(12);
        VenenoDecorator veneno = new VenenoDecorator(mockPersonaje);
        int resultado = veneno.atacar();
        assertEquals(12, resultado);
    }
}
