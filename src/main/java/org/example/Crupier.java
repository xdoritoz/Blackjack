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

            //modificarAses();

            pos = posicionA(getMano());

            if (getPuntuacion() > 21 && pos != null) {
                for (int i = 0; i < pos.size(); i++) {
                    if (getPuntuacion() > 21) {
                        mano.get(pos.get(i)).setPuntos(1);
                        setPuntuacion(getPuntuacion() - 10);
                    }
                }
            }

        }
        System.out.println("Aces: " + posicionA(getMano()));
        System.out.println(getMano());
        System.out.println("el crupier se planta con: " + getPuntuacion() + " puntos");
    }
}
