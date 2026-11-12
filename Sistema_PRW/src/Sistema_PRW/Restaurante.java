package Sistema_PRW;

import java.util.ArrayList;
import java.util.HashSet;

public class Restaurante {

    private HashSet<Cliente> clientes = new HashSet<>();
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
}
