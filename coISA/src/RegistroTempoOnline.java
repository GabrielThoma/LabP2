public class RegistroTempoOnline {
    private String nomeDisciplina;
    private final int tempoEsperado;
    private int tempoCorrido;

    public RegistroTempoOnline(String nomeDisciplina) {
        this(nomeDisciplina,120);
    }
    public RegistroTempoOnline(String nomeDisciplina , int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoEsperado = tempoOnlineEsperado;
        this.tempoCorrido = 0;
    }

    public void adicionaTempoOnline(int valor) {
        this.tempoCorrido += valor;
    }

    public boolean atingiuMetaTempoOnline() {
        return this.tempoCorrido >= this.tempoEsperado;
    }
    @Override
    public String toString() {
        return this.nomeDisciplina + " " + this.tempoCorrido + "/" + this.tempoEsperado;
    }
}

