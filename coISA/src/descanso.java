/**
 * Classe que controla e calcula a situacao de descanso de um aluno
 * baseando-se nas horas descansadas e no numero de semanas
 *
 * @author GabrielThoma
 */
public class descanso {

    /**
     * Quantidade total de horas de descando acumuladas.
     */
    private int HorasDescanso;

    /**
     * Quantidade de semanas analizadas para o calculoo
     */
    private int NumeroSemanas;

    /**
     * Define o total de horas descansadas pelo usuario
     *
     * @param valor valor inteiro representando as horas
     */
    public void defineHorasDescanso(int valor) {
        this.HorasDescanso = valor;
    }

    /**
     * Define a quantidade de semanas consideradas no periodo.
     *
     * @param valor quantidade de semanas
     */
    public void defineNumeroSemanas(int valor) {
        this.NumeroSemanas = valor;
    }

    /**
     * Retorna o status geral de descanso do aluno.
     * Se o numero de semanas for menor ou igual a zero ou se a media
     * de horas por semana for inferior a 26, retorna que esta cansado.
     * Caso contrario, retorna que esta decansado
     *
     * @return String contendo "cansado" ou "descansado"
     */
    public String getStatusGeral() {
        if (this.NumeroSemanas <= 0) {
            return "cansado";
        }

        if ( this.HorasDescanso / this.NumeroSemanas >= 26) {
            return "descansado";
        } else {
            return "cansado"; //não seria melhor deixa "cansado" tbm pra ficar igual o outro (MUDEI)
        }
    }
}