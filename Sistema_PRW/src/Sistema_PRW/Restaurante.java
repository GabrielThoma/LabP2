package Sistema_PRW;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Restaurante {

    private LinkedHashSet<Cliente> clientes = new LinkedHashSet<>();
    private String nome;
    private String prato;
    private final double VALOR = 89.90;
    private int qtdVotos;

    public Restaurante(String prato, String nome) {
        this.prato = prato;
        this.nome = nome;
    }

    public void addVoto(){
        qtdVotos++;
    }

    public String[] getClientes(){
        int index = 0;
        String[] clientesArray = new String[clientes.size()];
        for (Cliente c : clientes){
            clientesArray[index] = c.getNome();
            index++;
        }
        return clientesArray;
    }

    public void addCliente(Cliente c){
        clientes.add(c);
    }

    public String getPrato(){
        return prato;
    }

    public void getCliente(Cliente cliente){
        if (cliente.getPratoFav().equals(prato)) {
            System.out.println("Cliente: " + cliente.getNome() + ", Prato preferido da casa" );
        }else{
            System.out.println("Cliente: " + cliente.getNome());
        }
    }
    public boolean podeVotar(Cliente cliente){
        if (clientes.contains(cliente)){
            return true;
        }
        return false;
    }

    public int getQtdVotos() {
        return qtdVotos;
    }

    public String getNome() {
        return nome;
    }
}
