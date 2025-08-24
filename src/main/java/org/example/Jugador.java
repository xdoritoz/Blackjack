package org.example;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    List<Carta> mano = new ArrayList<>();
    List<Integer> pos = new ArrayList<>();
    List<Integer> vistos = new ArrayList<>();

    private int creditos = 0;
    private String tipo = "";
    private int puntuacion = 0;
    int ases;

    public Jugador (int creditos, String tipo) {
        this.creditos = creditos;
        this.tipo = tipo;
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


    public void pedirCarta(Carta carta) {
        mano.add(carta);
    }

    public List<Carta> getMano() {
        return mano;
    }

    public void setMano(List<Carta> mano) {
        this.mano = mano;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
                ", creditos=" + creditos +
                ", tipo='" + tipo + '\'' +
                ", puntuacion=" + puntuacion +
                '}';
    }
}
