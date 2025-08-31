package org.example;

import org.example.exception.InsufficientBalanceException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Juego {

    List<Jugador> jugadores = new ArrayList<Jugador>();
    int apuesta = 0;

    public void iniciarJuego() {
        Crupier crupier = new Crupier();
        Baraja baraja = new Baraja();

        baraja.llenarBaraja();

        //repartirMano(jugador, crupier);

        int opcion = 0, opcion2;
        boolean salir = false;

        Scanner sc = new Scanner(System.in);
        boolean errorOcurrido;

        do {
            errorOcurrido = false;

            try {
                System.out.println("Escribe 1 si quieres iniciar el juego, 0 si quieres salir : \n");
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
            sc.nextLine();

            int cantJugadores = 0;
            String nombre = "";

            do {
                System.out.println("## EL JUEGO A COMENZADO ##");

                System.out.print("Ingrese la cantidad de jugadores: ");
                cantJugadores = Integer.parseInt(sc.nextLine());

                //Creacion de jugadores
                for (int i = 0; i < cantJugadores; i++) {
                    System.out.print("\nDigite el nombre del jugador " + "[" + i + "]: ");
                    nombre = sc.nextLine();


                    Jugador jugador = new Jugador(nombre, 10000, "jugador");
                    jugadores.add(jugador);

                    //Apuestas de los jugadores
                    pedirAPuesta(jugadores.get(i));

                }

                System.out.println(jugadores.toString());

                System.out.println("¿Quieres Continuar con el juego? 1 para SI 0 para NO:");
                opcion2 = sc.nextInt();
                salir = (opcion2 == 0);

            } while (!salir);
        }

    }

    public void repartirMano (Jugador jugador, Crupier crupier){

    }

    public void pedirAPuesta (Jugador jugador) {
        boolean apuestaValida = false;
        Scanner sc = new Scanner(System.in);

        while (!apuestaValida) {
            try {
                System.out.print("COLOCA TU APUESTA💵💵💵💵: ");
                apuesta = sc.nextInt();
                sc.nextLine();

                jugador.colocarApuesta(apuesta);
                apuestaValida = true;

            } catch (InsufficientBalanceException e) {
                System.out.println("\n" + e.getMessage());

            } catch (InputMismatchException e) {
                System.out.println("\n" + jugador.getNombre() + " TIENE QUE SER NUMERO ESTUPIDOOOOOOOOOOOO");
                sc.nextLine();
            }

        }

    }

}



