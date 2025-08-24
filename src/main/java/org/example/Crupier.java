package org.example;

import java.util.ArrayList;
import java.util.List;

public class Crupier extends Jugador {

    public Crupier() {
        super("Crupier");
    }

    public void jugar(Baraja baraja){
        List<Integer> pos = new ArrayList<>();

        setPuntuacion(calcularPuntos());

        while (getPuntuacion() < 17) {
            Carta nueva = baraja.removerCarta(baraja.getBaraja().removeFirst());
            pedirCarta(nueva);

            setPuntuacion(getPuntuacion() + nueva.getPuntos());
            setPuntuacion(getPuntuacion());
            posicionA(getMano());
            modificarAses();





//            pos = posicionA(getMano());
//
//
//
//            if (getPuntuacion() > 21 && pos != null) {
//                int index = 0;
//
//                Carta carta = new Carta();
//
//                for (int i = 0; i < pos.size(); i++) {
//                    mano.get(0).setPuntos(1);
//
//                    mano.set(pos.get(i), mano.get(pos.get(i)));
//                }
//
//            }

        }

        System.out.println("Aces: " + posicionA(getMano()));

        System.out.println(getMano());
        System.out.println("el crupier se planta con: " + getPuntuacion() +" puntos");
    }
}
