public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;

    public Livro(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnoPublicacao() { return anoPublicacao; }

    @Override
    public String toString() {
        return "\"" + titulo + "\" - " + autor + " (" + anoPublicacao + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Livro)) return false;
        Livro outro = (Livro) obj;
        return titulo.equals(outro.titulo) && autor.equals(outro.autor);
    }

    @Override
    public int hashCode() {
        return titulo.hashCode() * 31 + autor.hashCode();
    }
}
