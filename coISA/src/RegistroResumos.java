/**
 * Classe responsavel pelo gerenciamento e armazenamento de resumos de estudos.
 * Permite cadastrar, verificar a existencia e realizar buscas nos temas e conteudos.
 *
 * @author GabrielThoma
 */
public class RegistroResumos {

    /**
     * Quantidade maxima de resumos suportada pelo registro.
     */
    private int numeroDeResumos;

    /**
     * Indice atual para insercao no array (controle de fila circular).
     */
    private int index; //eu usaria um nome que ja deixa claro pra oq essa variavel serve (MUDEI)

    /**
     * Quantidade total de resumos cadastrados no momento.
     */
    private int qtdResumos;

    /**
     * Array contendo os temas dos resumos cadastrados.
     */
    private String[] temas;

    /**
     * Array contendo o texto e conteudo completo dos resumos.
     */
    private String[] resumos;

    /**
     * Construtor que inicializa o registro com uma quantidade limite de resumos.
     *
     * @param numeroDeResumos limite maximo de resumos a serem armazenados
     */
    public RegistroResumos(int numeroDeResumos) {
        this.numeroDeResumos = numeroDeResumos;
        this.temas = new String[numeroDeResumos];
        this.resumos = new String[numeroDeResumos];
        this.index = 0;
        this.qtdResumos = 0;
    }

    /**
     * Adiciona um novo resumo ou atualiza o conteudo caso o tema ja exista.
     * Se o limite for atingido, sobrescreve o mais antigo.
     *
     * @param tema o assunto do resumo
     * @param conteudo o texto explicativo do resumo
     */
    public void adiciona(String tema, String conteudo) {
        String resumo = tema + ": " + conteudo;

        for (int i = 0; i < qtdResumos; i++) {
            if (temas[i].equals(tema)) {
                resumos[i] = resumo;
                return;
            }
        }

        temas[index] = tema;
        resumos[index] = resumo;
        index = (index + 1) % numeroDeResumos;

        if (qtdResumos < numeroDeResumos) {
            qtdResumos++;
        }
    }

    /**
     * Retorna um array contendo todos os resumos cadastrados ate o momento.
     *
     * @return array de String com os resumos
     */
    public String[] pegaResumos() {
        String[] resultado = new String[qtdResumos];
        for (int i = 0; i < qtdResumos; i++) {
            resultado[i] = resumos[i];
        }
        return resultado;
    }

    /**
     * Gera uma representacao em String listando a quantidade de resumos
     * e os temas cadastrados separados por barras.
     *
     * @return String formatada com os resumos
     */
    public String imprimeResumos() {
        String saida = qtdResumos + " resumo(s) cadastrado(s)\n";
        for (int i = 0; i < qtdResumos; i++) {
            saida += temas[i];
            if (i < qtdResumos - 1) {
                saida += " | ";
            }
        }
        return saida;
    }

    /**
     * Retorna a quantidade total de resumos cadastrados no sistema.
     *
     * @return numero inteiro representando a contagem de resumos
     */
    public int conta() {
        return qtdResumos;
    }

    /**
     * Verifica se um determinado tema ja esta registrado.
     *
     * @param tema o tema a ser verificado
     * @return true se o tema ja existir, false caso contrario
     */
    public boolean temResumo(String tema) {
        for (int i = 0; i < qtdResumos; i++) {
            if (temas[i].equals(tema)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Busca resumos cujo conteúdo contenha a chave de busca (ignorando maiúsculas/minúsculas).
     * Retorna um array com os temas dos resumos encontrados em ordem lexicográfica.
     *
     * @param chaveDeBusca termo usado para pesquisar nos resumos
     * @return array de String ordenado com os temas encontrados
     */
    public String[] busca(String chaveDeBusca) {
        if (chaveDeBusca == null || chaveDeBusca.isEmpty()) {
            return new String[0];
        }

        String chaveMinuscula = chaveDeBusca.toLowerCase();

        // 1. Primeira passada: conta quantos temas correspondem à busca
        int contagem = 0;
        for (int i = 0; i < qtdResumos; i++) {
            if (resumos[i].toLowerCase().contains(chaveMinuscula)) {
                contagem++;
            }
        }

        // 2. Cria o array do tamanho exato dos resultados encontrados
        String[] resultados = new String[contagem];
        int pos = 0;
        for (int i = 0; i < qtdResumos; i++) {
            if (resumos[i].toLowerCase().contains(chaveMinuscula)) {
                resultados[pos] = temas[i];
                pos++;
            }
        }

        // 3. Ordena os temas em ordem lexicográfica (alfabética)
        ordenar(resultados);

        return resultados;
    }

    /**
     * Metodo auxiliar de ordenação (Bubble Sort) em ordem alfabética.
     *
     * @param array o array de Strings a ser ordenado
     */
    private void ordenar(String[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}