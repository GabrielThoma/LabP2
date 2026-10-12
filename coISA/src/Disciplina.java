import java.util.Arrays;

/**
 * Representa uma disciplina cursada pelo estudante, guardando informaoes
 * de horas estudadas e as notas obtidas no semestre.
 *
 * @author GabrielThoma
 */
public class Disciplina {

    /**
     * Nome da disciplina.
     */
    private String nomeDisciplina;

    /**
     * Total de horas de estudo dedicadas a materia.
     */
    private int horasEstudo;

    /**
     * Array que armazena as notas atingidas
     */
    private double[] notas;

    /**
     * Array com os pesos para calculo de media ponderada (pode ser nulo).
     */
    private int[] pesos;

    /**
     * Construtor padrao que inicializa a disciplina com 4 notas por padrao.
     *
     * @param nomeDisciplina o nome da materia
     */
    public Disciplina(String nomeDisciplina) {
        this(nomeDisciplina, 4);
    }

    /**
     * Construtor que permite definir uma quantidade personalizada de notas .
     *
     * @param nomeDisciplina o nome da disciplina
     * @param numNotas quantidade total de notas
     */
    public Disciplina(String nomeDisciplina, int numNotas) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[numNotas];
        this.pesos = null; // Indica média aritmética
    }

    /**
     * Construtor completo que recebe o numero de notas e os pesos de cada uma.
     *
     * @param nomeDisciplina o nome da materia
     * @param numNotas quantidade de avaliacoes
     * @param pesos array contendo os pesos para o calculo da media
     */
    public Disciplina(String nomeDisciplina, int numNotas, int[] pesos) {
        this.nomeDisciplina = nomeDisciplina;
        this.horasEstudo = 0;
        this.notas = new double[numNotas];
        this.pesos = Arrays.copyOf(pesos, pesos.length);
    }

    /**
     * Registra e acumula horas de estudo dedicadas a disciplina.
     *
     * @param horas quantidade de horas a serem adicionadas
     */
    public void cadastraHoras(int horas) {
        this.horasEstudo += horas;
    }

    /**
     * Cadastra uma nota em uma posicao especifica (de 1 ate o limite de notas).
     *
     * @param nota o indice de 1 base referente a nota
     * @param valorNota o valor da nota obtida
     */
    public void cadastraNota(int nota, double valorNota) {
        if (nota < 1 || nota > this.notas.length) {
            return;
        }
        this.notas[nota - 1] = valorNota;
    }

    /**
     * Calcula a media das notas. Caso existam pesos configurados realiza o
     * calculo de media ponderada, se nao faz media aritmetica simples.
     *
     * @return a media calculada
     */
    private double calculaMedia() {
        if (this.notas.length == 0) {
            return 0.0;
        }

        // Caso com média ponderada (pesos informados)
        if (this.pesos != null) {
            double somaPonderada = 0;
            int somaPesos = 0;
            for (int i = 0; i < this.notas.length; i++) {
                somaPonderada += this.notas[i] * this.pesos[i];
                somaPesos += this.pesos[i];
            }
            return somaPesos == 0 ? 0.0 : somaPonderada / somaPesos;
        }

        // Caso padrão: média aritmética simples
        double soma = 0;
        for (double n : this.notas) {
            soma += n;
        }
        return soma / this.notas.length;
    }

    /**
     * Infroma se o estudante foi aprovado com base na media obtida.
     *
     * @return true se a media for maior ou igual a 7.0, false caso contrario
     */
    public boolean aprovado() {
        return calculaMedia() >= 7.0;
    }

    /**
     * Retorna a representacao em String da disciplina, contendo nome, horas
     * de estudo, media calculada e as notas cadastradas.
     *
     * @return representacao textual da disciplina
     */
    @Override
    public String toString() {
        return this.nomeDisciplina + " " + this.horasEstudo + " "
                + calculaMedia() + " " + Arrays.toString(this.notas);
    }
}