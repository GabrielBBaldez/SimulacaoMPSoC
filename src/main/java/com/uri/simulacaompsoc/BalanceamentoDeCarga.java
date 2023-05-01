package com.uri.simulacaompsoc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BalanceamentoDeCarga {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[][] matriz = new int[0][0];
        boolean isMatrizTamanhoValido = false; // Não pode ser maior que 12x12
        boolean isNumeroTaskValido = false; // Não pode ser menor que 0
        boolean continuar = true;
        List<NodoObsoleto> nodoObsoletoList = new ArrayList<>();
        int xMatriz = 0;
        int yMatriz = 0;

        String respostaContinuar;
        int taskPorNodo = 0;
        int posicaoAtual = 0; // Começando em 1

        while (!isMatrizTamanhoValido) {
            System.out.println("Informe o X e Y da matriz (Tamanho máximo de 12x12)");

            xMatriz = scan.nextInt();
            yMatriz = scan.nextInt();

            if (xMatriz <= 12 && yMatriz <= 12) {
                matriz = new int[xMatriz][yMatriz];
                isMatrizTamanhoValido = true;
            } else {
                System.out.println("Tamanho da matriz inválido");
            }
        }

        while (!isNumeroTaskValido) {
            System.out.println("Insira o número de Task(s) por processador");
            taskPorNodo = scan.nextInt();

            if (taskPorNodo <= 0) {
                System.out.println("Número invalido, precisa ser maior que 0");
            } else {
                isNumeroTaskValido = true;
            }
        }

        // Cria Nodos (começando em 1, ignorando 0x0)
        for (int y = 0; y < yMatriz; y++) {
            for (int x = 0; x < xMatriz; x++) {
                NodoObsoleto nodoObsoleto = new NodoObsoleto(x, y, taskPorNodo);
                nodoObsoletoList.add(nodoObsoleto);
            }
        }

        while (continuar) {
            System.out.println("Insira um número: ");
            int novoNumero = scan.nextInt();

            if (novoNumero < 0) {
                continuar = false;
                break;
            }

            for (int i = 0; i < novoNumero; i++) {
                posicaoAtual = (posicaoAtual + 1) % ((xMatriz * yMatriz));
                if(posicaoAtual == 0){
                    posicaoAtual = 1;
                }
                NodoObsoleto nodoObsoleto = nodoObsoletoList.get(posicaoAtual);

                if (nodoObsoleto.getTaksOcupadas() >= taskPorNodo) {
                    System.out.println("Número máximo de tarefas atingido");
                    continuar = false;
                    break;
                }

                nodoObsoleto.setTaksOcupadas(nodoObsoleto.getTaksOcupadas() + 1);
            }
            // Imprime a matriz atualizada
            for (int y = 0; y < yMatriz; y++) {
                for (int x = 0; x < xMatriz; x++) {
                    NodoObsoleto nodoObsoleto = nodoObsoletoList.get(y * xMatriz + x);
                    System.out.print(nodoObsoleto.getTaksOcupadas() + " ");
                }
                System.out.println();
            }
        }
        scan.close();
    }
}
