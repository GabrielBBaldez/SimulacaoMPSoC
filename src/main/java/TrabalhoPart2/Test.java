package TrabalhoPart2;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Test {
    @JsonProperty("APP")
    private String app;
    @JsonProperty("QTD")
    private int qtd;
    private List<Tarefa> tarefasList;

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public List<Tarefa> getTarefasList() {
        return tarefasList;
    }

    public void setTarefasList(List<Tarefa> tarefasList) {
        this.tarefasList = tarefasList;
    }

    @Override
    public String toString() {
        return "Test{" +
                "app='" + app + '\'' +
                ", qtd=" + qtd +
                '}';
    }
}