public class Disciplina {
    public String disciplina;
    public int horas = 0;
    public double nota;
    public boolean aprovado;
    public double[] ListaNotas =  new double[4];
    public double somaNotas = 0;
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
            aprovado = true;
            return true;
        } else {
            aprovado = false;
            return false;
        }
        }
     for (int g = 0; g >= 4; g++) {
        listaString = listaString + ListaNotas[g];
    }

   @Override String toString() {
            return disciplina + " " + horas + " " + media + " " + listaString;
        }
        }
    }

