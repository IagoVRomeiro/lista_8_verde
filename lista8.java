import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class ArquivoTextoLeitura {

   private BufferedReader entrada;

   ArquivoTextoLeitura(String nomeArquivo) {

      try {
         entrada = new BufferedReader(new FileReader(nomeArquivo));
      } catch (FileNotFoundException excecao) {
         System.out.println("Arquivo nao encontrado");
      }
   }

   public void fecharArquivo() {

      try {
         entrada.close();
      } catch (IOException excecao) {
         System.out.println("Erro no fechamento do arquivo de leitura: " + excecao);
      }
   }

   @SuppressWarnings("finally")
   public String ler() {

      String textoEntrada = null;

      try {
         textoEntrada = entrada.readLine();
      } catch (EOFException excecao) { // Excecao de final de arquivo.
         textoEntrada = null;
      } catch (IOException excecao) {
         System.out.println("Erro de leitura: " + excecao);
         textoEntrada = null;
      } finally {
         return textoEntrada;
      }
   }
}

class MyIO {

   private static BufferedReader in = new BufferedReader(
         new InputStreamReader(System.in, Charset.forName("ISO-8859-1")));
   private static String charset = "UTF-8";

   public static void setCharset(String charset_) {
      charset = charset_;
      in = new BufferedReader(new InputStreamReader(System.in, Charset.forName(charset)));
   }

   public static void print() {
   }

   public static void print(int x) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      } catch (UnsupportedEncodingException e) {
         System.out.println("Erro: charset invalido");
      }
   }

   public static void print(double x) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      } catch (UnsupportedEncodingException e) {
         System.out.println("Erro: charset invalido");
      }
   }

   public static void print(String x) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      } catch (UnsupportedEncodingException e) {
         System.out.println("Erro: charset invalido");
      }
   }

   public static void print(boolean x) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      } catch (UnsupportedEncodingException e) {
         System.out.println("Erro: charset invalido");
      }
   }

   public static void print(char x) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      } catch (UnsupportedEncodingException e) {
         System.out.println("Erro: charset invalido");
      }
   }

   public static void println() {
   }

   public static void println(int x) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      } catch (UnsupportedEncodingException e) {
         System.out.println("Erro: charset invalido");
      }
   }

   public static void println(double x) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      } catch (UnsupportedEncodingException e) {
         System.out.println("Erro: charset invalido");
      }
   }

   public static void println(String x) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      } catch (UnsupportedEncodingException e) {
         System.out.println("Erro: charset invalido");
      }
   }

   public static void println(boolean x) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      } catch (UnsupportedEncodingException e) {
         System.out.println("Erro: charset invalido");
      }
   }

   public static void println(char x) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      } catch (UnsupportedEncodingException e) {
         System.out.println("Erro: charset invalido");
      }
   }

   public static void printf(String formato, double x) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.printf(formato, x);// "%.2f"
      } catch (UnsupportedEncodingException e) {
         System.out.println("Erro: charset invalido");
      }
   }

   public static double readDouble() {
      double d = -1;
      try {
         d = Double.parseDouble(readString().trim().replace(",", "."));
      } catch (Exception e) {
      }
      return d;
   }

   public static double readDouble(String str) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      } catch (UnsupportedEncodingException e) {
         System.out.println("Erro: charset invalido");
      }
      return readDouble();
   }

   public static float readFloat() {
      return (float) readDouble();
   }

   public static float readFloat(String str) {
      return (float) readDouble(str);
   }

   public static int readInt() {
      int i = -1;
      try {
         i = Integer.parseInt(readString().trim());
      } catch (Exception e) {
      }
      return i;
   }

   public static int readInt(String str) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      } catch (UnsupportedEncodingException e) {
         System.out.println("Erro: charset invalido");
      }
      return readInt();
   }

   public static String readString() {
      String s = "";
      char tmp;
      try {
         do {
            tmp = (char) in.read();
            if (tmp != '\n' && tmp != ' ' && tmp != 13) {
               s += tmp;
            }
         } while (tmp != '\n' && tmp != ' ');
      } catch (IOException ioe) {
         System.out.println("lerPalavra: " + ioe.getMessage());
      }
      return s;
   }

   public static String readString(String str) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      } catch (UnsupportedEncodingException e) {
         System.out.println("Erro: charset invalido");
      }
      return readString();
   }

   public static String readLine() {
      String s = "";
      char tmp;
      try {
         do {
            tmp = (char) in.read();
            if (tmp != '\n' && tmp != 13) {
               s += tmp;
            }
         } while (tmp != '\n');
      } catch (IOException ioe) {
         System.out.println("lerPalavra: " + ioe.getMessage());
      }
      return s;
   }

   public static String readLine(String str) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      } catch (UnsupportedEncodingException e) {
         System.out.println("Erro: charset invalido");
      }
      return readLine();
   }

   public static char readChar() {
      char resp = ' ';
      try {
         resp = (char) in.read();
      } catch (Exception e) {
      }
      return resp;
   }

   public static char readChar(String str) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      } catch (UnsupportedEncodingException e) {
         System.out.println("Erro: charset invalido");
      }
      return readChar();
   }

   public static boolean readBoolean() {
      boolean resp = false;
      String str = "";

      try {
         str = readString();
      } catch (Exception e) {
      }

      if (str.equals("true") || str.equals("TRUE") || str.equals("t") || str.equals("1") ||
            str.equals("verdadeiro") || str.equals("VERDADEIRO") || str.equals("V")) {
         resp = true;
      }

      return resp;
   }

   public static boolean readBoolean(String str) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      } catch (UnsupportedEncodingException e) {
         System.out.println("Erro: charset invalido");
      }
      return readBoolean();
   }

   public static void pause() {
      try {
         in.read();
      } catch (Exception e) {
      }
   }

   public static void pause(String str) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      } catch (UnsupportedEncodingException e) {
         System.out.println("Erro: charset invalido");
      }
      pause();
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
      this.setNota_avaliacao(Float.parseFloat(info[2]));
   }

}

class Fila {
   private Livro[] fila;
   private int inicio;
   private int fim;
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
         desenfileirar();
      }
      fila[fim] = livro;
      fim = (fim + 1) % fila.length;

      totalElementos++;
      somaNota += livro.getNota_avaliacao();
      MyIO.println(somaNota / totalElementos);

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
         System.out.println("Fila vazia");
         return;
      }

      int i = 0;
      for (int tmp = inicio; tmp < totalElementos; tmp++) {

         MyIO.print("[" + i + "] [" + fila[tmp].getCategoria() + "] [" + fila[tmp].getNota_avaliacao() + "] [" +
               fila[tmp].getQuantidade_avaliacoes() + "] [" + fila[tmp].getAutor_principal() + "], ["
               + fila[tmp].getSegundo_autor() + "]. [" + fila[tmp].getTitulo() + "[" + fila[tmp].getAno_publicacao() +
               "]. ISBN:[" + fila[tmp].getISBN() + "]");
         i++;

      }
   }

   public int getSomaMedia() {
      return (int) Math.round(somaNota);
   }

   public int getQtdElementos() {
      return totalElementos;
   }

}

class lista8 {

   static void acharLivro(Livro livro, Livro[] livros, Fila fila) {
      for (int i = 0; i < livros.length; i++) {
         if (livros[i].getTitulo().equals(livro.getTitulo()) &&
               livros[i].getAno_publicacao() == livro.getAno_publicacao() &&
               livros[i].getAutor_principal().equals(livro.getAutor_principal())) {

            fila.enfileirar(livros[i]);
         }
      }

   }

   public static void main(String[] args) {
      String linha;

      // contar
      ArquivoTextoLeitura txt_1 = new ArquivoTextoLeitura("/tmp/jogos.txt");
      int qtdLivro = 0;
      do {
         linha = txt_1.ler();
         qtdLivro++;
      } while (linha != null);

      txt_1.fecharArquivo();
      ArquivoTextoLeitura txt_2 = new ArquivoTextoLeitura("/tmp/jogos.txt");

      // preencher
      Livro livrosTxt[] = new Livro[qtdLivro];

      for (int i = 0; i < qtdLivro; i++) {
         linha = txt_2.ler();
         Livro livro = new Livro();
         livro.ler(linha);
         livrosTxt[i] = livro;
      }

      txt_2.fecharArquivo();

      // fila
      Fila fila = new Fila(100);

      // prencher pubin
      linha = MyIO.readLine();

      while (linha != "FIM") {

         Livro livro = new Livro();
         livro.ler2(linha);

         acharLivro(livro, livrosTxt, fila);

         linha = MyIO.readLine();
      }

      int operacoes = MyIO.readInt();

      for (int i = 0; i < operacoes; i++) {
         linha = MyIO.readLine();

         String[] dados = linha.split(" ");

         // desenfileirar
         if (dados[0].equals("D")) {
            Livro livro = fila.desenfileirar();

            MyIO.println("(D) [" + livro.getCategoria() + "] [" + livro.getNota_avaliacao() + "] [" +
                  livro.getQuantidade_avaliacoes() + "] [" + livro.getAutor_principal() + "], ["
                  + livro.getSegundo_autor() + "]. ["
                  + livro.getTitulo() + "]. [" + livro.getAno_publicacao() + " ]. ISBN:[" + livro.getISBN() + "].");

         }

         // enfileirar
         else if (dados[0].equals("E")) {

            Livro livro = new Livro();
            livro.ler2(dados[1]);

            acharLivro(livro, livrosTxt, fila);

         }
      }

   }

}
