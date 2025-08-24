package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!🍀💖");


        Jugador jugador = new Jugador(10000, "jugador");
        Jugador jugador2 = new Jugador(10000, "jugador");

        Crupier crupier = new Crupier();

        Baraja baraja = new Baraja();
        baraja.llenarBaraja();
        System.out.println(baraja);

        jugador.pedirCarta(baraja.removerCarta(baraja.getBaraja().getFirst()));
        jugador.pedirCarta(baraja.removerCarta(baraja.getBaraja().getFirst()));


//        System.out.println(jugador.getMano());
//        System.out.println(jugador.calcularPuntos());


        crupier.pedirCarta(new Carta(Palo.Trebol, "A", 11));
        crupier.pedirCarta(new Carta(Palo.Trebol, "A", 11));





        //crupier.setPuntuacion(crupier.mano.get(0).getPuntos() + crupier.mano.get(1).getPuntos());
        crupier.jugar(baraja);
        //System.out.println(crupier.getMano());
        System.out.println(crupier.getPuntuacion());

    }


}



