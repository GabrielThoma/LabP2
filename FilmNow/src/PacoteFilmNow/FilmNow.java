package PacoteFilmNow;

import static PacoteFilmNow.Filme.adicionarPlataforma;

/**
 * Sistema que mantém os seus filmes prediletos. Podem existir 100 filmes.
 *
 * @author eliane
 *
 */
public class FilmNow {

    private static final int TAMANHO = 100;
    private static final int TAMANHO_HOTLIST = 10;

    private static Filme[] filmes;
    private Filme[] filmesHot;

    /**
     * Cria o FilmNow.
     */
    public FilmNow() {
        this.filmes = new Filme[TAMANHO];
        this.filmesHot = new Filme[TAMANHO_HOTLIST];
    }

    /**
     * Acessa a lista de filmes mantida.
     * @return O array com os nomes dos filmes.
     */
    public String[] getFilmes() {
        String[] nomesFilmes = new String[TAMANHO];
        for (int i = 0; i < TAMANHO; i++) {
            if (this.filmes[i] != null) {
                nomesFilmes[i] = this.filmes[i].getNome();
            }
        }
        return nomesFilmes;
    }

    /**
     * Acessa a lista de filmes da HotList.
     * @return O array com os nomes dos filmes da HotList.
     */
    public String[] getFilmesHot() {
        String[] nomesHot = new String[TAMANHO_HOTLIST];
        for (int i = 0; i < TAMANHO_HOTLIST; i++) {
            if (this.filmesHot[i] != null) {
                nomesHot[i] = this.filmesHot[i].getNome();
            }
        }
        return nomesHot;
    }

    /**
     * Acessa os detalhes de um filme específico.
     * @param posicao Posição do filme no sistema (1 a 100).
     * @return Dados formatados do filme. Null se não há filme na posição.
     */
    public String getDetalhesFilme(int posicao) {
        int indice = posicao - 1;
        if (indice >= 0 && indice < TAMANHO && this.filmes[indice] != null) {
            return this.filmes[indice].toString();
        }
        return null;
    }
    public static void adicionaPlataforma(int index, String plataforma, int posicao) {
        filmes[index].adicionarPlataforma(plataforma, posicao);
    }

    public static void removePlataforma(int index, int plataforma) {
        filmes[index].removerPlataforma(plataforma);

    }
    /**
     * Adiciona um filme em uma posição. Se já existir filme na posição, sobrescreve o anterior.
     * @param posicao Posição do filme (1 a 100).
     * @param nome Nome do filme.
     * @param ano Ano de lançamento do filme.
     * @param local Local onde o filme pode ser assistido.
     */
    public void cadastraFilme(int posicao, String nome, String ano, String local) {
        int indice = posicao - 1;
        if (indice >= 0 && indice < TAMANHO) {
            this.filmes[indice] = new Filme(nome, ano, local);
        }
    }

    /**
     * Adiciona um filme previamente cadastrado à HotList.
     * @param posicaoFilme Posição do filme no sistema (1 a 100).
     * @param posicaoHot Posição na HotList (1 a 10).
     */
    public void adicionarHotList(int posicaoFilme, int posicaoHot) {
        int indiceFilme = posicaoFilme - 1;
        int indiceHot = posicaoHot - 1;

        if (indiceFilme >= 0 && indiceFilme < TAMANHO && this.filmes[indiceFilme] != null) {
            if (indiceHot >= 0 && indiceHot < TAMANHO_HOTLIST) {
                this.filmesHot[indiceHot] = this.filmes[indiceFilme];
            }
        }
    }

    /**
     * Remove um filme da HotList.
     * @param posicaoHot Posição na HotList (1 a 10).
     */
    public void removerHotList(int posicaoHot) {
        int indiceHot = posicaoHot - 1;
        if (indiceHot >= 0 && indiceHot < TAMANHO_HOTLIST) {
            this.filmesHot[indiceHot] = null;
        }
    }
}