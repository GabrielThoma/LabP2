/**
 * Representa um Filme no sistema.
 */
public class Filme {

    private String nome;
    private String ano;
    private String local;

    public Filme(String nome, String ano, String local) {
        this.nome = nome;
        this.ano = ano;
        this.local = local;
    }

    public String getNome() {
        return this.nome;
    }
    public String getAno() {
        return this.ano;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\n" +
                "Ano: " + this.ano + "\n" +
                "Local: " + this.local;
    }
}