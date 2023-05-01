package TrabalhoPart2;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GrafoTarefas {
    @JsonProperty("grafo_tarefas")
    private List<Tarefa> grafoTarefas;

    public List<Tarefa> getGrafoTarefas() {
        return grafoTarefas;
    }

    public void setGrafoTarefas(List<Tarefa> grafoTarefas) {
        this.grafoTarefas = grafoTarefas;
    }
}