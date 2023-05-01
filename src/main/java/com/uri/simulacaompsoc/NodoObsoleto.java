package com.uri.simulacaompsoc;

public class NodoObsoleto {

    int x;
    int y;
    int numeroTask;
    int taksOcupadas;

    public NodoObsoleto(int x, int y, int numeroTask) {
        this.x = x;
        this.y = y;
        this.numeroTask = numeroTask;
        this.taksOcupadas = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getNumeroTask() {
        return numeroTask;
    }

    public void setNumeroTask(int numeroTask) {
        this.numeroTask = numeroTask;
    }

    public int getTaksOcupadas() {
        return taksOcupadas;
    }

    public void setTaksOcupadas(int taksOcupadas) {
        this.taksOcupadas = taksOcupadas;
    }
}
