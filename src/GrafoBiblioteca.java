import java.util.*;

public class GrafoBiblioteca {
    private HashMap<Livro, Set<Livro>> grafo;

    public GrafoBiblioteca() {
        this.grafo = new HashMap<>();
    }

    public void adicionarLivro(Livro livro) {
        grafo.putIfAbsent(livro, new HashSet<>());
    }

    public void adicionarRelacao(Livro origem, Livro destino) {
        grafo.putIfAbsent(origem, new HashSet<>());
        grafo.putIfAbsent(destino, new HashSet<>());
        grafo.get(origem).add(destino);
        grafo.get(destino).add(origem); // relação bidirecional
    }

    public Set<Livro> obterRecomendacoes(Livro livro) {
        return grafo.getOrDefault(livro, new HashSet<>());
    }

    public void exibirGrafo() {
        System.out.println("\n===== GRAFO DE RELAÇÕES =====");
        for (Map.Entry<Livro, Set<Livro>> entry : grafo.entrySet()) {
            System.out.println("\n" + entry.getKey().getTitulo() + " se relaciona com:");
            for (Livro relacionado : entry.getValue()) {
                System.out.println("   -> " + relacionado.getTitulo());
            }
        }
    }

    public void sugerirLivros(Livro livroLido) {
        System.out.println("\n===== RECOMENDAÇÕES BASEADAS EM: " + livroLido.getTitulo() + " =====");
        Set<Livro> recomendacoes = obterRecomendacoes(livroLido);
        if (recomendacoes.isEmpty()) {
            System.out.println("Nenhuma recomendação disponível.");
        } else {
            int i = 1;
            for (Livro rec : recomendacoes) {
                System.out.println(i++ + ". " + rec);
            }
        }
    }
}
