public class Disciplina {
    public String disciplina;
    public int horas = 0;
    public double nota;
    public boolean aprovado;
    public double[] ListaNotas =  new double[4];
    public double somaNotas = 0;
    public double media = 0;
    public String listaString = "";

    public Disciplina(String nomeDisciplina) {
        this.disciplina = nomeDisciplina;
    } // Construtor

    public void cadastraHoras(int horas) {
        this.horas += horas;
    }

    public void cadastraNota(int index, double valorNota) {
        ListaNotas[index] = valorNota;
    }

    public boolean aprovado() {
        somaNotas = 0;

        for (int i = 0; i < 4; i++) {
            somaNotas += ListaNotas[i];
        }
        media = somaNotas / 4;

        listaString = "";
        for (double notax : ListaNotas) {
            listaString += notax + " ";
        }

        if (media >= 7.0) {
            aprovado = true;
            return true;
        } else {
            aprovado = false;
            return false;
        }
    }

   @Override public String toString() {
            return disciplina + " " + horas + " " + media + " " + listaString.trim();
        }
        }


