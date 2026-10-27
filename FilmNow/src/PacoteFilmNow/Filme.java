package PacoteFilmNow;
/**
 * Representa um Filme no sistema.
 */
public class Filme {

    private String nome;
    private String ano;
    private String[] plataformas = new String[5];

    public Filme(String nome, String ano, String plataformas) {

        if (nome == null) {
            throw new NullPointerException("Nome Invalido");
            }else if (nome.isBlank()) {
            throw new IllegalAccessException();
        }else if (nome == "") {
            throw new IllegalArgumentException();
        }else{

            this.nome = nome;
            this.ano = ano;
            this.plataformas[0] = plataformas;
        }
    }
    public String getNome() {
        return this.nome;
    }
    public String getAno() {
        return this.ano;
    }

    /**
     * Sdiciona plataformas onde o filme pode ser visto
     * @param posicao o índice em que a plataforma será inserida
     * @param plataforma o nome da plataforma
     * @return void
     * @author Gabriel
     */
    public static void adicionarPlataforma(String plataforma, int posicao) {
        plataformas[posicao] = plataforma;
    }
    public void removerPlataforma(int index) {
        plataformas[index] = null;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\n" +
                "Ano: " + this.ano + "\n" +
                "Local: " + this.plataformas;
    }
}