
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class ArquivoTextoLeitura {

    private BufferedReader entrada;

    ArquivoTextoLeitura(String nomeArquivo) {
        try {
            entrada = new BufferedReader(new FileReader(nomeArquivo));
        } catch (FileNotFoundException excecao) {
            System.out.println("Arquivo não encontrado: " + nomeArquivo);
        }
    }

    public void fecharArquivo() {
        if (entrada != null) {
            try {
                entrada.close();
            } catch (IOException excecao) {
                System.out.println("Erro no fechamento do arquivo de leitura: " + excecao);
            }
        }
    }

    public String ler() {
        String textoEntrada = null;
        if (entrada != null) {
            try {
                textoEntrada = entrada.readLine();
            } catch (IOException excecao) {
                System.out.println("Erro de leitura: " + excecao);
            }
        }
        return textoEntrada;
    }
}

class Livro {

    private long ISBN;
    private String titulo;
    private String autor_principal;
    private String segundo_autor;
    private String categoria;
    private String descricao;
    private int ano_publicacao;
    private int quantidade_paginas;
    private float nota_avaliacao;
    private int quantidade_avaliacoes;

    void setISBN(long x) {
        this.ISBN = x;
    }

    void setTitulo(String x) {
        this.titulo = x;
    }

    void setAutor_principal(String x) {
        this.autor_principal = x;
    }

    void setSegundo_autor(String x) {
        this.segundo_autor = x;
    }

    void setCategoria(String x) {
        this.categoria = x;
    }

    void setDescricao(String x) {
        this.descricao = x;
    }

    void setAno_publicacao(int x) {
        this.ano_publicacao = x;
    }

    void setQuantidade_paginas(int x) {
        this.quantidade_paginas = x;
    }

    void setNota_avaliacao(float x) {
        this.nota_avaliacao = x;
    }

    void setQuantidade_avaliacoes(int x) {
        this.quantidade_avaliacoes = x;
    }

    long getISBN() {
        return this.ISBN;
    }

    String getTitulo() {
        return this.titulo;
    }

    String getAutor_principal() {
        return this.autor_principal;
    }

    String getSegundo_autor() {
        return this.segundo_autor;
    }

    String getCategoria() {
        return this.categoria;
    }

    String getDescricao() {
        return this.descricao;
    }

    int getAno_publicacao() {
        return this.ano_publicacao;
    }

    int getQuantidade_paginas() {
        return this.quantidade_paginas;
    }

    float getNota_avaliacao() {
        return this.nota_avaliacao;
    }

    int getQuantidade_avaliacoes() {
        return this.quantidade_avaliacoes;
    }

    @Override
    public String toString() {
        if (this.getSegundo_autor().equals("")) {
            return "[" + this.categoria + this.quantidade_avaliacoes + "] "
                    + this.autor_principal + ". " + this.titulo + ". " + this.ano_publicacao + ". ISBN: " + this.ISBN + ".";
        } else {
            return "[" + this.categoria + "] [" + "] [" + this.quantidade_avaliacoes + "] "
                    + this.autor_principal + ". " + this.titulo + ". " + this.ano_publicacao + ". ISBN: " + this.ISBN + ".";
        }
    }

    public void imprimir() {
        MyIO.println(toString());
    }

    public Livro clone() {
        return new Livro(this.ISBN, this.titulo, this.autor_principal, this.segundo_autor, this.categoria,
                this.descricao, this.ano_publicacao,
                this.quantidade_paginas, this.nota_avaliacao, this.quantidade_avaliacoes);
    }

    Livro() {
    }

    Livro(long isbn, String titulo, String autor_principal, String segundo_autor, String categoria,
            String descricao, int ano_publicacao, int quantidade_paginas, float nota_avaliacao,
            int quantidade_avaliacoes) {
        this.ISBN = isbn;
        this.titulo = titulo;
        this.autor_principal = autor_principal;
        this.segundo_autor = segundo_autor;
        this.categoria = categoria;
        this.descricao = descricao;
        this.ano_publicacao = ano_publicacao;
        this.quantidade_paginas = quantidade_paginas;
        this.nota_avaliacao = nota_avaliacao;
        this.quantidade_avaliacoes = quantidade_avaliacoes;
    }

    void ler(String linha) {
        String[] info = linha.split("\\|");
        this.setISBN(Long.parseLong(info[0]));
        this.setTitulo(info[1]);
        this.setAutor_principal(info[2]);
        this.setSegundo_autor(info[3]);
        this.setCategoria(info[4]);
        this.setDescricao(info[5]);
        this.setAno_publicacao(Integer.parseInt(info[6]));
        this.setQuantidade_paginas(Integer.parseInt(info[7]));
        this.setNota_avaliacao(Float.parseFloat(info[8]));
        this.setQuantidade_avaliacoes(Integer.parseInt(info[9]));
    }

    void ler2(String linha) {
        String[] info = linha.split(";");
        this.setTitulo(info[0]);
        this.setAno_publicacao(Integer.parseInt(info[1]));
        this.setAutor_principal(info[2]);
    }

}

class Fila {

    private Livro[] fila;
    int inicio;
    int fim;
    private int totalElementos;
    private double somaNota;

    public Fila(int capacidade) {
        fila = new Livro[capacidade + 1];
        inicio = 0;
        fim = 0;
        totalElementos = 0;
        somaNota = 0.0;
    }

    public void enfileirar(Livro livro) {
        if ((fim + 1) % fila.length == inicio) {
            throw new RuntimeException("Fila cheia");
        }
        fila[fim] = livro;
        fim = (fim + 1) % fila.length;
        totalElementos++;
        somaNota += livro.getNota_avaliacao();

        MyIO.println((int) Math.round(somaNota));
    }

    public Livro desenfileirar() {
        if (inicio == fim) {
            throw new RuntimeException("Fila vazia");
        }
        Livro livro = fila[inicio];
        inicio = (inicio + 1) % fila.length;
        totalElementos--;
        somaNota -= livro.getNota_avaliacao();
        return livro;
    }

    public void mostrar() {
        if (inicio == fim) {
            MyIO.println("Fila vazia");
            return;
        }
        for (int tmp = inicio, i = 0; tmp != fim; tmp = (tmp + 1) % fila.length, i++) {
            MyIO.print("[" + i + "] [" + fila[tmp].getCategoria() + "] [" + fila[tmp].getNota_avaliacao() + "] ["
                    + fila[tmp].getQuantidade_avaliacoes() + "] [" + fila[tmp].getAutor_principal() + "], ["
                    + fila[tmp].getSegundo_autor() + "]. [" + fila[tmp].getTitulo() + " [" + fila[tmp].getAno_publicacao()
                    + "]. ISBN:[" + fila[tmp].getISBN() + "]");
        }
    }

    public int getSomaMedia() {
        return (int) Math.round(somaNota);
    }

    public int getQtdElementos() {
        return totalElementos;
    }

    double obterSomaDaNotaMedia() {
        return totalElementos > 0 ? somaNota / totalElementos : 0.0;
    }
}

class lista8 {

    static void acharLivro(Livro livro, Livro[] livros, Fila fila) {
        for (int i = 0; i < livros.length; i++) {
            if (livros[i].getTitulo().equals(livro.getTitulo())
                    && livros[i].getAno_publicacao() == livro.getAno_publicacao()
                    && livros[i].getAutor_principal().equals(livro.getAutor_principal())) {
                fila.enfileirar(livros[i]);
            }
        }
    }

    public static void main(String[] args) {
        String linha;

        // contar
        ArquivoTextoLeitura txt_1 = new ArquivoTextoLeitura("livros.txt");
        int qtdLivro = 0;
        do {
            linha = txt_1.ler();
            if (linha != null) {
                qtdLivro++;
            }
        } while (linha != null);
        txt_1.fecharArquivo(); // Fechar após contar

        ArquivoTextoLeitura txt_2 = new ArquivoTextoLeitura("livros.txt");

        // preencher
        Livro livrosTxt[] = new Livro[qtdLivro];
        int i = 0;

        linha = txt_2.ler();
        while (linha != null && !linha.equals("FIM")) {
            Livro livro = new Livro();
            livro.ler(linha);
            livrosTxt[i++] = livro;
            linha = txt_2.ler();
        }

        // fila
        Fila fila = new Fila(100);
        // prencher pubin
        linha = MyIO.readLine();

        while (!linha.equals("FIM")) {
            Livro livro = new Livro();
            livro.ler2(linha);
            acharLivro(livro, livrosTxt, fila);
            linha = MyIO.readLine();
        }

        int operacoes = MyIO.readInt();

for (int j = 0; j < operacoes; j++) {
    linha = MyIO.readLine();

    String[] dados = linha.split(" ", 2);

   
    if (dados[0].equals("D")) { 
        if (fila.inicio == fila.fim) {
            MyIO.println("Fila vazia");
        } else {
            Livro livro = fila.desenfileirar();
            MyIO.println("(D) [" + livro.getCategoria() + "] [" + livro.getNota_avaliacao() + "] ["
                    + livro.getQuantidade_avaliacoes() + "] [" + livro.getAutor_principal() + "], ["
                    + livro.getSegundo_autor() + "]. [" + livro.getTitulo() + "]. [" + livro.getAno_publicacao()
                    + "]. ISBN:[" + livro.getISBN() + "].");
        }
    }

    
    if (dados[0].equals("E")) {
        Livro livro = new Livro();
        livro.ler2(dados[1]);
        acharLivro(livro, livrosTxt, fila);
    }
}

    fila.mostrar();

    }
}
