package PacoteFilmNow;

/**
 * Sistema que mantém os seus filmes prediletos. Podem existir 100 filmes.
 *
 * @author eliane
 */
public class FilmNow {

    private static final int TAMANHO = 100;
    private static final int TAMANHO_HOTLIST = 10;

    private Filme[] filmes;
    private Filme[] filmesHot;

    /**
     * Cria o FilmNow.
     */
    public FilmNow() {
        this.filmes = new Filme[TAMANHO];
        this.filmesHot = new Filme[TAMANHO_HOTLIST];
    }

    public String[] getFilmes() {
        String[] nomesFilmes = new String[TAMANHO];
        for (int i = 0; i < TAMANHO; i++) {
            if (this.filmes[i] != null) {
                nomesFilmes[i] = this.filmes[i].getNome();
            }
        }
        return nomesFilmes;
    }

    public String[] getFilmesHot() {
        String[] nomesHot = new String[TAMANHO_HOTLIST];
        for (int i = 0; i < TAMANHO_HOTLIST; i++) {
            if (this.filmesHot[i] != null) {
                nomesHot[i] = this.filmesHot[i].getNome();
            }
        }
        return nomesHot;
    }

    public String getDetalhesFilme(int posicao) {
        int indice = posicao - 1;
        if (indice < 0 || indice >= TAMANHO) {
            throw new IndexOutOfBoundsException("Posição inválida. Escolha entre 1 e " + TAMANHO);
        }
        if (this.filmes[indice] != null) {
            return this.filmes[indice].toString();
        }
        return null;
    }

    public void adicionaPlataforma(int posicaoFilme, String plataforma, int posicaoPlataforma) {
        int indice = posicaoFilme - 1;
        if (indice < 0 || indice >= TAMANHO || this.filmes[indice] == null) {
            throw new IllegalArgumentException("Filme não encontrado na posição informada.");
        }
        this.filmes[indice].adicionarPlataforma(plataforma, posicaoPlataforma);
    }

    public void removePlataforma(int posicaoFilme, int posicaoPlataforma) {
        int indice = posicaoFilme - 1;
        if (indice < 0 || indice >= TAMANHO || this.filmes[indice] == null) {
            throw new IllegalArgumentException("Filme não encontrado na posição informada.");
        }
        this.filmes[indice].removerPlataforma(posicaoPlataforma);
    }

    public String cadastraFilme(int posicao, String nome, String ano, String local) {
        int indice = posicao - 1;
        if (indice < 0 || indice >= TAMANHO) {
            throw new IndexOutOfBoundsException("Posição inválida para cadastrar filme. Deve ser entre 1 e " + TAMANHO);
        }
        this.filmes[indice] = new Filme(nome, ano, local);
        return nome;
    }

    public void adicionarHotList(int posicaoFilme, int posicaoHot) {
        int indiceFilme = posicaoFilme - 1;
        int indiceHot = posicaoHot - 1;

        if (indiceFilme < 0 || indiceFilme >= TAMANHO || this.filmes[indiceFilme] == null) {
            throw new IllegalArgumentException("Posição do filme base é inválida ou não há filme cadastrado nela.");
        }
        if (indiceHot < 0 || indiceHot >= TAMANHO_HOTLIST) {
            throw new IndexOutOfBoundsException("Posição na HotList é inválida. Deve ser entre 1 e " + TAMANHO_HOTLIST);
        }

        this.filmesHot[indiceHot] = this.filmes[indiceFilme];
    }

    public void removerHotList(int posicaoHot) {
        int indiceHot = posicaoHot - 1;
        if (indiceHot < 0 || indiceHot >= TAMANHO_HOTLIST) {
            throw new IndexOutOfBoundsException("Posição na HotList inválida.");
        }
        this.filmesHot[indiceHot] = null;
    }
}