package org.example;

import java.util.ArrayList;
import java.util.List;

public class Crupier extends Jugador {

    public Crupier() {
        super("Crupier");
    }

    public void jugar(Baraja baraja){
        List<Integer> pos = new ArrayList<>();

        calcularPuntos();

        while (getPuntuacion() < 17) {

            Carta nueva = baraja.removerCarta(baraja.getBaraja().removeFirst());
            pedirCarta(nueva);

            calcularPuntos();

        }
        System.out.println("Aces: " + posicionA());
        System.out.println(getMano());
        System.out.println("el crupier se planta con: " + getPuntuacion() + " puntos");
    }
}
