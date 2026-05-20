package com.juego.patrones.factory;

import com.juego.model.Personaje;
import com.juego.model.PersonajeBase;
import com.juego.patrones.decorator.ArmaduraDecorator;
import com.juego.patrones.decorator.FuerzaDecorator;

public class GuerreroFactory implements PersonajeFactory {
    @Override
    public Personaje crearPersonaje(String nombre) {
        return new FuerzaDecorator(
                   new ArmaduraDecorator(
                       new PersonajeBase(nombre, 100, 15)));
    }
}
