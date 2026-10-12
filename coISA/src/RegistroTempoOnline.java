/**
 * Classe responsavel por registrar e acompanhar o tempo dedicado a estudos online
 * de uma determinada disciplina, verificando se a meta foi atingida.
 *
 * @author GabrielThoma
 */
public class RegistroTempoOnline {

    /**
     * Nome da  disciplina monitorada.
     */
    private String nomeDisciplina;

    /**
     * Tempo de estudo online esperado em minutos para cumprir a meta.
     */
    private final int tempoEsperado;

    /**
     * Quantidade total de minutos ja estudados ate o momento.
     */
    private int tempoCorrido;

    /**
     * Construtor padrao que define a meta de tempo em  120 minutos por padrao.
     *
     * @param nomeDisciplina o nome da materia
     */
    public RegistroTempoOnline(String nomeDisciplina) {
        this(nomeDisciplina, 120);
    }

    /**
     * Construtor que permite definir o nome da disciplina e a meta customizada de tempo.
     *
     * @param nomeDisciplina o nome da materia
     * @param tempoOnlineEsperado meta de tempo online em minutos.
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoEsperado = tempoOnlineEsperado;
        this.tempoCorrido = 0;
    }

    /**
     * Adiciona e acumula tempo online estudado na disciplina.
     *
     * @param valor quantidade de minutos a serem somados
     */
    public void adicionaTempoOnline(int valor) {
        this.tempoCorrido += valor;
    }

    /**
     * Verifica se a quantidade acumulada de tempo atinge ou supera a meta estipulada.
     *
     * @return true se o tempo dedicado for maior ou igual a meta, false caso contrario
     */
    public boolean atingiuMetaTempoOnline() {
        return this.tempoCorrido >= this.tempoEsperado;
    }

    /**
     * Retorna a representacao textual do registro no formato "Disciplina tempoCorrido/tempoEsperado".
     *
     * @return String formatada contendo o progresso das horas
     */
    @Override
    public String toString() {
        return this.nomeDisciplina + " " + this.tempoCorrido + "/" + this.tempoEsperado;
    }
}