package com.juego.patrones.factory;

import com.juego.model.Personaje;
import com.juego.model.PersonajeBase;
import com.juego.patrones.decorator.VenenoDecorator;

public class AsesinFactory implements PersonajeFactory {
    @Override
    public Personaje crearPersonaje(String nombre) {
        return new VenenoDecorator(
                   new PersonajeBase(nombre, 80, 12));
    }
}
