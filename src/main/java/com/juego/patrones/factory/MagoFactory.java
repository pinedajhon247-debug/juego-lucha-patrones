package com.juego.patrones.factory;

import com.juego.model.Personaje;
import com.juego.model.PersonajeBase;
import com.juego.patrones.decorator.FuerzaDecorator;
import com.juego.patrones.decorator.VenenoDecorator;

public class MagoFactory implements PersonajeFactory {
    @Override
    public Personaje crearPersonaje(String nombre) {
        return new FuerzaDecorator(
                   new VenenoDecorator(
                       new PersonajeBase(nombre, 70, 18)));
    }
}
