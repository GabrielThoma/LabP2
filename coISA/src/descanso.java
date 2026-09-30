public class descanso(String[] args) {
    private int HorasDescanso;
    private int NumeroSemanas;
    public void defineHorasDescanso(int valor) {
        HorasDescanso = valor;
    }
    public void defineNumeroSemanas(int valor) {
        NumeroSemanas = valor;
    }
    public String[] getStatusGeral() {
        if ( NumeroSemanas == 0 || HorasDescanso / NumeroSemanas >= 26) {
            return String "Descansado";
        } else {
            return String "Cansado";
        }
    }
}

