package TrabalhoPart2;

import java.util.ArrayList;
import java.util.List;

public class Nodo {

    int x;
    int y;
    int numeroTask;
    int taksOcupadas;
    int pacotes;
    String nome;
    List<String> appList = new ArrayList<>();

    public Nodo(int x, int y, int numeroTask, String nome) {
        this.x = x;
        this.y = y;
        this.numeroTask = numeroTask;
        this.taksOcupadas = 0;
        this.pacotes = 0;
        this.nome = nome;
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

    public int getPacotes() {
        return pacotes;
    }
    public void setPacotes(int pacotes) {
        this.pacotes = pacotes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getAppList() {
        return appList;
    }

    public void setAppList(List<String> appList) {
        this.appList = appList;
    }
}
