package TrabalhoPart2;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tarefa {
    @JsonProperty("tarefa_origem")
    private String tarefaOrigem;
    @JsonProperty("tarefa_destino")
    private String tarefaDestino;
    @JsonProperty("quantidade_pacotes")
    private int quantidadePacotes;

    public String getTarefaOrigem() {
        return tarefaOrigem;
    }

    public void setTarefaOrigem(String tarefaOrigem) {
        this.tarefaOrigem = tarefaOrigem;
    }

    public String getTarefaDestino() {
        return tarefaDestino;
    }

    public void setTarefaDestino(String tarefaDestino) {
        this.tarefaDestino = tarefaDestino;
    }

    public int getQuantidadePacotes() {
        return quantidadePacotes;
    }

    public void setQuantidadePacotes(int quantidadePacotes) {
        this.quantidadePacotes = quantidadePacotes;
    }
}