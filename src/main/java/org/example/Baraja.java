package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baraja {
    private List<Carta> baraja = new ArrayList<>();

    public Baraja() {
    }

    public List<Carta> llenarBaraja() {
        String[] valor = {"2", "3", "4", "5", "6", "7", "8", "9" , "J", "Q", "K", "A"};

        for (Palo t : Palo.values() ) {
            for(String v: valor){
                int puntos;
                if(v.equals("J") || v.equals("Q") || v.equals("K")){
                    puntos = 10;
                } else if (v.equals("A")){
                    puntos = 11;
                } else{
                    puntos = Integer.parseInt(v);
                }
                baraja.add(new Carta(t, v, puntos));
            }
        }
        barajarCartas(baraja);
        return baraja;
    }


    public void barajarCartas(List<Carta> baraja) {
        Collections.shuffle(baraja);
    }

    public Carta removerCarta(Carta carta) {
        baraja.remove(carta);
        return carta;
    }

    public List<Carta> getBaraja() {
        return baraja;
    }

    public void setBaraja(ArrayList<Carta> baraja) {
        this.baraja = baraja;
    }

    @Override
    public String toString() {
        return "Baraja{" +
                "cartas=" + getBaraja() +
                '}';
    }
}
