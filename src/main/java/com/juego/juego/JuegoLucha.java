package com.juego.juego;
import com.juego.model.*;
import com.juego.patrones.decorator.*;

public class JuegoLucha {

    public static void main(String[] args) {

        Personaje jugador1 = new FuerzaDecorator(
                                new ArmaduraDecorator(
                                    new PersonajeBase("Guerrero", 100, 15)));

        VenenoDecorator jugador2 = new VenenoDecorator(
                                       new PersonajeBase("Asesino", 80, 12));

        System.out.println("==============================================");
        System.out.println("         JUEGO DE LUCHA");
        System.out.println("==============================================");
        System.out.println("Jugador 1: " + jugador1.getNombre());
        System.out.println("Jugador 2: " + jugador2.getNombre());
        System.out.println("----------------------------------------------\n");

        int turno = 1;

        while (jugador1.estaVivo() && jugador2.estaVivo()) {

            System.out.println("== Turno " + turno + " ==");

            System.out.println("▶ " + jugador1.getNombre() + " ataca:");
            int dano1 = jugador1.atacar();
            jugador2.recibirDano(dano1);

            if (!jugador2.estaVivo()) break;

            System.out.println("\n▶ " + jugador2.getNombre() + " ataca:");
            jugador2.atacarCon(jugador1);

            System.out.println();
            turno++;

            if (turno > 10) {
                System.out.println("Demo terminada tras 10 turnos.");
                break;
            }
        }

        System.out.println("==============================================");
        if (!jugador1.estaVivo()) {
            System.out.println("Ganador: " + jugador2.getNombre());
        } else if (!jugador2.estaVivo()) {
            System.out.println("Ganador: " + jugador1.getNombre());
        } else {
            System.out.println("Empate (fin de demo)");
        }
        System.out.println("==============================================");
    }
}