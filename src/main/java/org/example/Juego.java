package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Juego {
    public void iniciarJuego() {

        List<Jugador> jugadores = new ArrayList<Jugador>();

        Jugador jugador = new Jugador("fede", 10000, "jugador");
        Crupier crupier = new Crupier();
        Baraja baraja = new Baraja();

        baraja.llenarBaraja();

        repartirMano(jugador, crupier);

        int opcion = 0, opcion2;
        boolean salir = false;

        Scanner sc = new Scanner(System.in);
        boolean errorOcurrido;

        do {
            errorOcurrido = false;

            try {
                System.out.println("Escribe 1 si quieres iniciar el juego, 0 si quieres salir. \n");
                opcion = sc.nextInt();

                if (opcion != 0 && opcion != 1) {
                    throw new IllegalArgumentException("El numero tiene que ser 1 o 0.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Tiene que ser un numero entero.");
                errorOcurrido = true;
                sc.nextLine();

            } catch (IllegalArgumentException e) {
                System.out.println("☢️" + e.getMessage());
                errorOcurrido = true;
                sc.nextLine();
            }
        } while (errorOcurrido);

            if (opcion == 1) {
                do {
                    System.out.println("## EL JUEGO A COMENZADO ##");
                    System.out.println("Tu numero de creditos es: " + jugador.getCreditos());





                    System.out.println("¿quieres Continuar con el juego? 1 para SI 0 para NO");
                    opcion2 = sc.nextInt();
                    salir = (opcion2 == 0);

                } while (!salir);
            }

    }

    public void repartirMano(Jugador jugador, Crupier crupier) {

    }
}
