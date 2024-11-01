package com.mycompany.hashing;

public class TabelaHash {
    private Registro[][] tabela;
    private int[] ocupacao;
    private Funcoes funcoes;
    private int capacidadeColisoes;
    private int tamanhoTabela;
    private int colisoes;

    public TabelaHash(int tamanho, int capacidadeColisoes) {
        this.tamanhoTabela = tamanho;
        this.tabela = new Registro[tamanhoTabela][capacidadeColisoes];
        this.ocupacao = new int[tamanhoTabela];
        this.capacidadeColisoes = capacidadeColisoes;
        this.funcoes = new Funcoes();
        System.out.println("Tabela Hash criada com tamanho " + tamanho + 
                         " e capacidade de " + capacidadeColisoes + " colisoes por posiçao");
    }

    public int inserir(Registro registro, int metodoHash) {
    int chave = registro.getCodigo();
    int indice = 0;

    // Seleciona o método de hashing
    if (metodoHash == 1) {
        indice = funcoes.restoDivisao(chave, tamanhoTabela);
    } else if (metodoHash == 2) {
        indice = funcoes.multiplicacao(chave, tamanhoTabela);
    } else if (metodoHash == 3) {
        indice = funcoes.dobramento(chave, tamanhoTabela);
    }

    // Verifica se o índice está dentro do intervalo
    if (indice < 0 || indice >= tamanhoTabela) {
        return -1;
    }

    // Verifica se o registro já existe no índice para evitar duplicatas
    for (int i = 0; i < ocupacao[indice]; i++) {
        if (tabela[indice][i] != null && tabela[indice][i].getCodigo() == chave) {
            return ocupacao[indice];
        }
    }

    // Insere o registro caso ainda haja espaço no índice
    if (ocupacao[indice] < capacidadeColisoes) {
        tabela[indice][ocupacao[indice]] = registro;
        ocupacao[indice]++;
        return ocupacao[indice]; // Retorna a ocupação atual após inserção
    } else {
        System.out.println("Capacidade de colisões excedida no índice: " + indice);
        return -1;
    }
}

    public int buscar(Registro registro, int metodoHash) {
    int chave = registro.getCodigo();
    int indice = 0;

    // Seleciona o método de hashing
    if (metodoHash == 1) {
        indice = funcoes.restoDivisao(chave, tamanhoTabela);
    } else if (metodoHash == 2) {
        indice = funcoes.multiplicacao(chave, tamanhoTabela);
    } else if (metodoHash == 3) {
        indice = funcoes.dobramento(chave, tamanhoTabela);
    }

    // Verifica se o índice está dentro do intervalo
    if (indice < 0 || indice >= tamanhoTabela) {
        return -1;
    }

    // Percorre os registros no índice para localizar o registro desejado
    for (int i = 0; i < ocupacao[indice]; i++) {
        if (tabela[indice][i] != null && tabela[indice][i].getCodigo() == chave) {
            System.out.println("Registro encontrado no índice: " + indice);
            return i + 1; 
        }
    }

    return -1;
}


    public Registro[][] getTabela() {
        return tabela;
    }

    public void setTabela(Registro[][] tabela) {
        this.tabela = tabela;
    }

    public int[] getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(int[] ocupacao) {
        this.ocupacao = ocupacao;
    }

    public Funcoes getFuncoes() {
        return funcoes;
    }

    public void setFuncoes(Funcoes funcoes) {
        this.funcoes = funcoes;
    }

    public int getCapacidadeColisoes() {
        return capacidadeColisoes;
    }

    public void setCapacidadeColisoes(int capacidadeColisoes) {
        this.capacidadeColisoes = capacidadeColisoes;
    }

    public int getColisoes() {
        return colisoes;
    }

    public void setColisoes(int colisoes) {
        this.colisoes = colisoes;
    }

    public int getTamanhoTabela() {
        return tamanhoTabela;
    }

    public void setTamanhoTabela(int tamanhoTabela) {
        this.tamanhoTabela = tamanhoTabela;
    }
    
    
    
    
}