public class RegistroTempoOnline {
    private String[] nomeDisciplina;
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
        if (tempoCorrido >= tempoEsperado) {
            return true;
        } else {
            return false;
        }
    }
    @Override public String toString() {
        return nomeDisciplina + " " +  tempoCorrido + " " + tempoEsperado;
    }
}

