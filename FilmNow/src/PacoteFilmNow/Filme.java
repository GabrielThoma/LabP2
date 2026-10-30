package PacoteFilmNow;

/**
 * Representa um Filme no sistema.
 */
public class Filme {

    private String nome;
    private String ano;
    private String[] plataformas = new String[5];

    public Filme(String nome, String ano, String plataforma) {
        if (nome == null) {
            throw new NullPointerException("O nome do filme não pode ser nulo.");
        }
        if (nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do filme não pode ser vazio.");
        }

        this.nome = nome;
        this.ano = ano;
        this.plataformas[0] = plataforma;
    }

    public String getNome() {
        return this.nome;
    }

    public String getAno() {
        return this.ano;
    }

    public String[] getPlataformas() {
        return plataformas;
    }

    /**
     * Adiciona plataformas onde o filme pode ser visto
     * @param plataforma o nome da plataforma
     * @param posicao o índice em que a plataforma será inserida (0 a 4)
     */
    public void adicionarPlataforma(String plataforma, int posicao) {
        if (posicao < 0 || posicao >= plataformas.length) {
            throw new IllegalArgumentException("Posição de plataforma inválida. Deve ser entre 0 e 4.");
        }
        this.plataformas[posicao] = plataforma;
    }

    public void removerPlataforma(int index) {
        if (index < 0 || index >= plataformas.length) {
            throw new IllegalArgumentException("Índice de plataforma inválido.");
        }
        this.plataformas[index] = null;
    }

    @Override
    public String toString() {
        String local = plataformas[0] != null ? plataformas[0] : "Nenhum";
        return "Nome: " + this.nome + "\n" +
                "Ano: " + this.ano + "\n" +
                "Local: " + local;
    }
}