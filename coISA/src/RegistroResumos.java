public class RegistroResumos {
    private int numeroDeResumos;
    private int index; //eu usaria um nome que ja deixa claro pra oq essa variavel serve (MUDEI)
    private int qtdResumos;
    private String[] temas;
    private String[] resumos;

    public RegistroResumos(int numeroDeResumos) {
        this.numeroDeResumos = numeroDeResumos;
        this.temas = new String[numeroDeResumos];
        this.resumos = new String[numeroDeResumos];
        this.index = 0;
        this.qtdResumos = 0;
    }

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

    public String[] pegaResumos() {
        String[] resultado = new String[qtdResumos];
        for (int i = 0; i < qtdResumos; i++) {
            resultado[i] = resumos[i];
        }
        return resultado;
    }

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

    public int conta() {
        return qtdResumos;
    }

    public boolean temResumo(String tema) {
        for (int i = 0; i < qtdResumos; i++) {
            if (temas[i].equals(tema)) {
                return true;
            }
        }
        return false;
    }
}