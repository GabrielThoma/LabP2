import java.util.Arrays;

public class RegistroTempoOnline {
    private final String[] nomeDisciplina;
    private int tempoEsperado;
    private int tempoCorrido;

    public RegistroTempoOnline(String[] nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }
    public RegistroTempoOnline(String[] nomeDisciplina , int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoEsperado = tempoOnlineEsperado;
    }
    void adicionaTempoOnline(int valor) {
        tempoCorrido += valor;
    }
    boolean atingiuMetaTempoOnline() {
        return tempoCorrido >= tempoEsperado;
    }
    @Override public String toString() {
        return Arrays.toString(nomeDisciplina) + " " +  tempoCorrido + "/" + tempoEsperado;
    }
}

