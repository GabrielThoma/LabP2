public class descanso {
    private int HorasDescanso;
    private int NumeroSemanas;
    public void defineHorasDescanso(int valor) {
        HorasDescanso = valor;
    }
    public void defineNumeroSemanas(int valor) {
        NumeroSemanas = valor;
    }
    public String[] getStatusGeral() {
        if ( HorasDescanso / NumeroSemanas >= 26) {
            return new String[]{"Descansado"};
        } else {
            return new String[]{"Cansado"};
        }
    }
}

