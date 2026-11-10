package Sistema_PRW;

public class Restaurante {

    private Cliente[] clientes = new Cliente[100];
    private String nome;
    private String prato;
    private double valor = 89.90;

    public Restaurante(String prato, String nome) {
        this.prato = prato;
        this.nome = nome;
    }
}
