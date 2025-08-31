package org.example;

import org.example.exception.InsufficientBalanceException;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    List<Carta> mano = new ArrayList<>();
    List<Integer> pos = new ArrayList<>();
    List<Integer> vistos = new ArrayList<>();

    private String nombre;
    private int credito = 0;
    private String tipo = "";
    private int puntuacion = 0;
    private Boolean turno = false;

    public Jugador (String nombre, int credito, String tipo) {
        this.nombre = nombre;
        this.credito = credito;
        this.tipo = tipo;
    }

    public Jugador() {
    }

    public Jugador(String tipo) {
        this.tipo = tipo;
    }

    public int calcularPuntos() {
        puntuacion = 0;

        for(Carta c : mano){
            puntuacion += c.getPuntos();
        }
        modificarAses();

        return puntuacion;
    }

    public void modificarAses() {
        pos = posicionA();

        if (pos != null) {
            for (int num : pos) {
                if (getPuntuacion() > 21 && pos.get(num) != null && mano.get(pos.get(num)).getPuntos() == 11) {
                    mano.get(pos.get(num)).setPuntos(1);
                    puntuacion -= 10;
                }
            }
        }
    }

    public List<Integer> posicionA() {
        List<Integer> pos = new ArrayList<>();
        int count = 0;

        for (Carta c : mano) {
            count++;
            if (c.getValor().equals("A")){
                pos.add(count-1);
            }
        }
        return pos;
    }

    public void colocarApuesta(int creditoApostado) {
        creditos -= creditoApostado;
    }

    public void pedirCarta(Carta carta) {
        mano.add(carta);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Carta> getMano() {
        return mano;
    }

    public void setMano(List<Carta> mano) {
        this.mano = mano;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public int getApuesta() {
        return apuesta;
    }

    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean getTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "mano=" + mano +
                ", nombre='" + nombre + '\'' +
                ", credito=" + credito +
                ", tipo='" + tipo + '\'' +
                ", puntuacion=" + puntuacion +
                ", turno=" + turno +
                ", apuesta=" + apuesta +
                '}';
    }
}
