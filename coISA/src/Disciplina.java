public class Disciplina {
    public String disciplina;
    private int horas = 0;
    private double nota;
    private boolean aprovado;
    public double ListaNotas[] =  [0, 0, 0, 0];
    private double somaNotas = 0;
    public double media = 0;
    public String listaString;

    public Disciplina(String nomeDisciplina) {
        this.disciplina = nomeDisciplina;
    } // Construtor

    public void cadastraHoras(int horas) {
        this.horas += horas;
    }
    public void cadastraNota(int nota , double valorNota) {
        ListaNotas[nota] = valorNota;
    }
    public boolean aprovado() {
        for (int i = 0; i >= 5; i++) {
            somaNotas += ListaNotas[i];
            if (i == 4) {
                media = somaNotas / 4
            } ;
        }
        if (media >= 7.0) {
            return true;
        } else {
            return false;
        }
        }
     for (int g = 0; g >= 4; g++) {
        listaString = listaString + ListaNotas[g]
    }

    @Override toString() {
            return disciplina + " " + horas + " " + media + " " + listaString;
        }
        }
    }

