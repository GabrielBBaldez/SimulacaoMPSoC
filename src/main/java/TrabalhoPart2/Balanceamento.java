package TrabalhoPart2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uri.simulacaompsoc.NodoObsoleto;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Balanceamento {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String inputTest = null;
        List<Nodo> nodoList = new ArrayList<>();
        int novoNumero;
        int posicaoAtual = 0;
        int contadorY = 0;

        //Escolhe qual Json vai ser usado
        while (true) {
            System.out.println("Escolha o teste que deseja fazer. (Test1, Test2, Test3 ou Test4)");
            inputTest = scan.next();
            if (inputTest.equals("Test1") || inputTest.equals("Test2") || inputTest.equals("Test3") || inputTest.equals("Test4")) {
                break;
            }
        }

        // Faz a leitura do Json para transformar no objeto de configuração
        String contentConfiguracao = new String(Files.readAllBytes(Paths.get(getEnderecoJsonTest(inputTest))), StandardCharsets.UTF_8);
        ObjectMapper objectMapperConfiguracao = new ObjectMapper();
        Configuracao configuracao = objectMapperConfiguracao.readValue(contentConfiguracao, Configuracao.class);

        //Cria a matriz com base nas informações do Json e quantidade de task por nodo
        int[][] matriz = new int[configuracao.getMpSoCSizeX()][configuracao.getMpSoCSizeY()];
        int task_processador = configuracao.getTasksPerProcessor();

        // Cria Nodos (começando em 1, ignorando 0x0)
        for (int y = 0; y < configuracao.getMpSoCSizeY(); y++) {
            for (int x = 0; x < configuracao.getMpSoCSizeX(); x++) {
                Nodo nodo = new Nodo(x, y, configuracao.getTasksPerProcessor(), null);
                nodoList.add(nodo);
            }
        }

        //Cria o objeto de GrafoTarefas para cada Test
        for (Test tests : configuracao.getTest()) {
            String contentApp = new String(Files.readAllBytes(Paths.get(getEnderecoJsonAplicacao(tests.getApp()))), StandardCharsets.UTF_8);
            ObjectMapper objectMapperAplicacao = new ObjectMapper();
            GrafoTarefas grafoTarefas = objectMapperConfiguracao.readValue(contentApp, GrafoTarefas.class);
            tests.setTarefasList(grafoTarefas.getGrafoTarefas());

            //Quantidade de vezes que o app vai ser repetido
            loopQuantidadeDeTest:
            for (int i = 0; i < tests.getQtd(); i++) {

                    for (Tarefa tarefas : tests.getTarefasList()) {
                        posicaoAtual = (posicaoAtual + 1) % ((configuracao.getMpSoCSizeX() * configuracao.getMpSoCSizeY()));
                        if (posicaoAtual == 0) {
                            posicaoAtual = 1;
                        }


                        Nodo nodo = nodoList.get(posicaoAtual);

                        if (nodo.getTaksOcupadas() >= configuracao.getTasksPerProcessor()) {
                            System.out.println("Número máximo de tarefas atingido");
                            break loopQuantidadeDeTest;
                        }

                        nodo.setTaksOcupadas(nodo.taksOcupadas + 1);
                        nodo.setNome(tests.getApp());
                        nodo.setPacotes(nodo.getPacotes() + tarefas.getQuantidadePacotes());

                    }

            }
        }

        // Imprime a matriz atualizada
        for (int y = 0; y < configuracao.getMpSoCSizeY(); y++) {
            for (int x = 0; x < configuracao.getMpSoCSizeX(); x++) {
                Nodo nodo = nodoList.get(y * configuracao.getMpSoCSizeX() + x);
                System.out.print(nodo.getNome() + "/" + nodo.getPacotes() + "/" + nodo.getTaksOcupadas() + " ");
            }
            System.out.println();
        }
    }

    public static String getEnderecoJsonTest(String test) {
        if (test.equals("Test1")) {
            return "C:/Users/Gabriel/Desktop/Testes/Test1.json";
        }
        if (test.equals("Test2")) {
            return "C:/Users/Gabriel/Desktop/Testes/Test2.json";
        }
        if (test.equals("Test3")) {
            return "C:/Users/Gabriel/Desktop/Testes/Test3.json";
        }
        if (test.equals("Test4")) {
            return "C:/Users/Gabriel/Desktop/Testes/Test4.json";
        }
        return null;
    }

    public static String getEnderecoJsonAplicacao(String app){
        if(app.equals("appA")){
            return "C:/Users/Gabriel/Desktop/Testes/Applications/appA.json";
        }
        if(app.equals("appB")){
            return "C:/Users/Gabriel/Desktop/Testes/Applications/appB.json";
        }
        if(app.equals("appC")){
            return "C:/Users/Gabriel/Desktop/Testes/Applications/appC.json";
        }
        if(app.equals("appD")){
            return "C:/Users/Gabriel/Desktop/Testes/Applications/appD.json";
        }
            return null;
    }
}

