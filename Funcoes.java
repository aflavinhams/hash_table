package com.mycompany.hashing;

public class Funcoes {
    
    // metodo hash de resto da divisao
    public int restoDivisao(int chave, int tamanho){
        return chave % tamanho;
    }
    
    // metodo hash de multiplicacao
    public int multiplicacao(int chave, int tamanho){
        int constante = 4;
        float pedaco = (chave * constante) % 1;
        return (int)(tamanho * pedaco);
    }
    
    // metodo hash de dobramento
    public int dobramento(int chave, int tamanho){
        int t_parte = 3;
        int divisor = 1;
        int hash = 0;

        for (int i = 0; i < t_parte; i++) {
            divisor *= 10;
        }

        while (chave > 0) {
            int parte = chave % divisor;
            hash += parte; 
            chave /= divisor; 
        }

        return hash % tamanho;
    }
}
