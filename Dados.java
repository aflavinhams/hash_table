package com.mycompany.hashing;

import java.util.Random;

public class Dados {
    
    //gera uma lista de registros aleatório com 9 digitos
    public static Registro[] gerarConjunto(int quantidade) {
        Registro[] registros = new Registro[quantidade];
        Random random = new Random();

        for (int i = 0; i < quantidade; i++) {
            int codigo = 100000000 + random.nextInt(900000000);
            registros[i] = new Registro(codigo);
        }

        return registros;
    }
}
