public class descanso {
    private int HorasDescanso;
    private int NumeroSemanas;
    public void defineHorasDescanso(int valor) {
        this.HorasDescanso = valor;
    }
    public void defineNumeroSemanas(int valor) {
        this.NumeroSemanas = valor;
    }
    public String getStatusGeral() {
        if (this.NumeroSemanas <= 0) {
            return "cansado";
        }

        if ( this.HorasDescanso / this.NumeroSemanas >= 26) {
            return "Descansado";
        } else {
            return "Cansado";
        }
    }
}

