import java.util.*;

public class Biblioteca {

    // 1. LinkedList para colecao de livros
    private LinkedList<Livro> colecao;

    // 2. Queue para lista de espera
    private Queue<String> listaEspera;

    // 3. Stack para historico de navegacao
    private Stack<Livro> historico;

    // 4. Grafo para recomendacoes
    private GrafoBiblioteca grafo;

    public Biblioteca() {
        colecao = new LinkedList<>();
        listaEspera = new LinkedList<>();
        historico = new Stack<>();
        grafo = new GrafoBiblioteca();
    }

    // ===================== LINKEDLIST =====================

    public void adicionarLivro(Livro livro) {
        colecao.add(livro);
        grafo.adicionarLivro(livro);
        System.out.println("Livro adicionado: " + livro);
    }

    public void removerLivro(String titulo) {
        colecao.removeIf(l -> l.getTitulo().equalsIgnoreCase(titulo));
        System.out.println("Livro removido: " + titulo);
    }

    public void listarColecao() {
        System.out.println("\n===== COLEÇÃO DA BIBLIOTECA =====");
        if (colecao.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        int i = 1;
        for (Livro livro : colecao) {
            System.out.println(i++ + ". " + livro);
        }
    }

    // ===================== QUEUE =====================

    public void entrarListaEspera(String usuario) {
        listaEspera.offer(usuario);
        System.out.println(usuario + " entrou na lista de espera.");
    }

    public void atenderProximoUsuario() {
        String usuario = listaEspera.poll();
        if (usuario != null) {
            System.out.println("Usuário atendido: " + usuario);
        } else {
            System.out.println("Lista de espera vazia.");
        }
    }

    public void exibirListaEspera() {
        System.out.println("\n===== LISTA DE ESPERA =====");
        if (listaEspera.isEmpty()) {
            System.out.println("Nenhum usuário na fila.");
            return;
        }
        int pos = 1;
        for (String usuario : listaEspera) {
            System.out.println(pos++ + ". " + usuario);
        }
    }

    // ===================== STACK =====================

    public void visualizarLivro(Livro livro) {
        historico.push(livro);
        System.out.println("Visualizando: " + livro);
    }

    public void exibirHistorico() {
        System.out.println("\n===== HISTÓRICO DE NAVEGAÇÃO =====");
        if (historico.isEmpty()) {
            System.out.println("Nenhum livro visualizado ainda.");
            return;
        }
        Stack<Livro> temp = (Stack<Livro>) historico.clone();
        int pos = 1;
        while (!temp.isEmpty()) {
            System.out.println(pos++ + ". " + temp.pop());
        }
    }

    public Livro voltarUltimoLivro() {
        if (!historico.isEmpty()) {
            Livro ultimo = historico.pop();
            System.out.println("Voltando para: " + ultimo);
            return ultimo;
        }
        System.out.println("Histórico vazio.");
        return null;
    }

    // ===================== GRAFO =====================

    public void adicionarRelacao(Livro a, Livro b) {
        grafo.adicionarRelacao(a, b);
    }

    public void exibirGrafo() {
        grafo.exibirGrafo();
    }

    public void sugerirLivros(Livro livro) {
        grafo.sugerirLivros(livro);
    }

    // ===================== MAIN =====================

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        // --- Criando 10 livros ---
        Livro l1  = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954);
        Livro l2  = new Livro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", 1997);
        Livro l3  = new Livro("O Hobbit", "J.R.R. Tolkien", 1937);
        Livro l4  = new Livro("As Crônicas de Nárnia", "C.S. Lewis", 1950);
        Livro l5  = new Livro("Duna", "Frank Herbert", 1965);
        Livro l6  = new Livro("Fundação", "Isaac Asimov", 1951);
        Livro l7  = new Livro("1984", "George Orwell", 1949);
        Livro l8  = new Livro("Admirável Mundo Novo", "Aldous Huxley", 1932);
        Livro l9  = new Livro("O Nome do Vento", "Patrick Rothfuss", 2007);
        Livro l10 = new Livro("A Roda do Tempo", "Robert Jordan", 1990);

        // --- 1. Adicionando à LinkedList ---
        System.out.println("========================================");
        System.out.println("     SISTEMA DE BIBLIOTECA VIRTUAL      ");
        System.out.println("========================================");
        System.out.println("\n--- Adicionando livros à coleção ---");
        biblioteca.adicionarLivro(l1);
        biblioteca.adicionarLivro(l2);
        biblioteca.adicionarLivro(l3);
        biblioteca.adicionarLivro(l4);
        biblioteca.adicionarLivro(l5);
        biblioteca.adicionarLivro(l6);
        biblioteca.adicionarLivro(l7);
        biblioteca.adicionarLivro(l8);
        biblioteca.adicionarLivro(l9);
        biblioteca.adicionarLivro(l10);

        biblioteca.listarColecao();

        // --- 2. Fila de espera ---
        System.out.println("\n--- Gerenciando lista de espera ---");
        biblioteca.entrarListaEspera("Ana Silva");
        biblioteca.entrarListaEspera("Carlos Souza");
        biblioteca.entrarListaEspera("Maria Oliveira");
        biblioteca.exibirListaEspera();
        biblioteca.atenderProximoUsuario();
        biblioteca.exibirListaEspera();

        // --- 3. Pilha de histórico ---
        System.out.println("\n--- Navegando por livros ---");
        biblioteca.visualizarLivro(l1);
        biblioteca.visualizarLivro(l5);
        biblioteca.visualizarLivro(l7);
        biblioteca.exibirHistorico();
        biblioteca.voltarUltimoLivro();
        biblioteca.exibirHistorico();

        // --- 4. Grafo de relações ---
        System.out.println("\n--- Configurando relações entre livros ---");
        // Fantasia
        biblioteca.adicionarRelacao(l1, l3);  // Senhor dos Anéis <-> Hobbit
        biblioteca.adicionarRelacao(l1, l4);  // Senhor dos Anéis <-> Nárnia
        biblioteca.adicionarRelacao(l1, l9);  // Senhor dos Anéis <-> Nome do Vento
        biblioteca.adicionarRelacao(l2, l4);  // Harry Potter <-> Nárnia
        biblioteca.adicionarRelacao(l2, l9);  // Harry Potter <-> Nome do Vento
        biblioteca.adicionarRelacao(l3, l10); // Hobbit <-> Roda do Tempo
        biblioteca.adicionarRelacao(l9, l10); // Nome do Vento <-> Roda do Tempo
        // Ficção Científica / Distopia
        biblioteca.adicionarRelacao(l5, l6);  // Duna <-> Fundação
        biblioteca.adicionarRelacao(l5, l7);  // Duna <-> 1984
        biblioteca.adicionarRelacao(l6, l8);  // Fundação <-> Admirável Mundo Novo
        biblioteca.adicionarRelacao(l7, l8);  // 1984 <-> Admirável Mundo Novo

        biblioteca.exibirGrafo();

        // --- Sistema de recomendação ---
        System.out.println("\n--- Sistema de Recomendação ---");
        biblioteca.sugerirLivros(l1);  // Recomendações para quem leu Senhor dos Anéis
        biblioteca.sugerirLivros(l7);  // Recomendações para quem leu 1984
    }
}
