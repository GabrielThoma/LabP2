package filmnow;

public class Filme {
    private String nome;
    private int anoDeLancamento;
    private final String localOndeAssistir;
    private final boolean hot;

    public Filme(String nome, int ano, String plataforma) {
        this.nome = nome;
        this.anoDeLancamento = ano;
        this.localOndeAssistir = plataforma;
        hot = false;
    }
    public void setHot() {
        this.hot = true;
    }

    @Override
    public String toString() {
        return nome;
    }
}
