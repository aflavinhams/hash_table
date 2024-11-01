package com.mycompany.hashing;

public class Hashing {

    public static void main(String[] args) {
        int[] tamanhosTabela = {10, 100, 1000, 10000, 100000}; //tamanhos de tabelas
        int capacidadeColisoes = 5; // Limite de colisões por índice

        // inicializando os registros com dados 
        Registro[] dados1M = Dados.gerarConjunto(1000000);
        Registro[] dados5M = Dados.gerarConjunto(5000000);
        Registro[] dados20M = Dados.gerarConjunto(20000000);

        for (int tamanhoTabela : tamanhosTabela) {
            for (int metodoHash : new int[]{1, 2, 3}) {
                
                TabelaHash tabela = new TabelaHash(tamanhoTabela, capacidadeColisoes);
                
                System.out.println("Insercao para " + metodoHash + " com tabela de tamanho " + tamanhoTabela);
                Experimento.executarInsercao(dados1M, tabela, metodoHash);
                Experimento.executarInsercao(dados5M, tabela, metodoHash);
                Experimento.executarInsercao(dados20M, tabela, metodoHash);
                System.out.println();

                System.out.println("Busca para " + metodoHash + " com tabela de tamanho " + tamanhoTabela);
                Experimento.executarBusca(dados1M, tabela, metodoHash);
                Experimento.executarBusca(dados5M, tabela, metodoHash);
                Experimento.executarBusca(dados20M, tabela, metodoHash);
                System.out.println();
            }
        }
    }
}
