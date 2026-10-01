public class RegistroResumos {
    public int numeroDeResumos;
    public int n;
    public int qtdResumos;

    RegistroResumos(int numeroDeResumos) {
        this.numeroDeResumos = numeroDeResumos;
    }
    public String[] temas = new String[numeroDeResumos];

    public String[] resumos = new String[numeroDeResumos] ;

    public void adiciona(String tema, String Conteudo) {
        String resumo = tema + ":" + Conteudo;
        resumos[n] = resumo;
        temas[n] = tema;
        qtdResumos ++;
        if (n>= numeroDeResumos) {
            n = 0;
        }else {
            n++;
        }
    }
    public int conta() {
        return qtdResumos;
    }
    public String [] pegaResumos() {
    }
    public String[] imprimeResumos() {
        return System.out.println(qtdResumos + "resumo(s) cadastrado(s)");
        for (int i ; i >= qtdResumos ; i ++) {
            System.out.println(temas[i] + " | ");
        }
        }
    }


