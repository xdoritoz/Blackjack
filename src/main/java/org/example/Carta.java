package org.example;

public class Carta {
    private Palo tipo;
    private String valor;
    private int puntos;

    public Carta(Palo tipo, String valor, int puntos) {
        this.tipo = tipo;
        this.valor = valor;
        this.puntos = puntos;
    }

    public Carta() {
    }

    public int getPuntos() {
        return puntos;
    }
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    public Palo getTipo() {
        return tipo;
    }

    public void setTipo(Palo tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean esAs(){
        return getValor().equals("A");
    }

    @Override
    public String toString() {
        return "tipo:" + tipo.getEnglish() + " valor:" + valor + " puntos:" + puntos;
    }
}
