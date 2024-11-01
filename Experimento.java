
package com.mycompany.hashing;

import java.util.Random;

public class Experimento {
    public static void executarInsercao(Registro[] registros, TabelaHash tabela, int metodoHash) {
        long totalColisoes = 0;

        long inicio = System.currentTimeMillis();
        for (Registro registro : registros) {
            totalColisoes += tabela.inserir(registro, metodoHash);
        }
        long tempoInsercao = System.currentTimeMillis() - inicio;

        System.out.println("Metodo Hash: " + metodoHash);
        System.out.println("Tamanho da Tabela: " + tabela.getTamanhoTabela());
        System.out.println("Tempo de Insercao: " + tempoInsercao + " ms");
        System.out.println("Total de Colisoes: " + totalColisoes);
    }

    public static void executarBusca(Registro[] registros, TabelaHash tabela, int metodoHash) {
        Random random = new Random();
        long tempoTotalBusca = 0;
        int comparacoesTotais = 0;

        for (int i = 0; i < 5; i++) {
            int indice = random.nextInt(registros.length);
            Registro registroBusca = registros[indice]; 

            long inicio = System.currentTimeMillis();
            comparacoesTotais += tabela.buscar(registroBusca, metodoHash);
            tempoTotalBusca += System.currentTimeMillis() - inicio;
        }

        System.out.println("Metodo Hash: " + metodoHash);
        System.out.println("Tempo Total de Busca: " + tempoTotalBusca + " ms");
        System.out.println("Comparacoes Totais: " + comparacoesTotais);
    }
}
