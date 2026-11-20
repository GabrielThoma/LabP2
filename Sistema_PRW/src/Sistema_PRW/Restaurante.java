package Sistema_PRW;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Restaurante {

    private LinkedHashSet<Cliente> clientes = new LinkedHashSet<>();
    private final LivroDeVisitas livro = new LivroDeVisitas();
    private final String nome;
    private final String prato;
    private final double VALOR = 89.90;
    private int qtdVotos;

    public Restaurante(String nome, String prato) {
        this.prato = prato;
        this.nome = nome;
            }

    public void addVoto(){
        qtdVotos++;
       }

    public void addCliente(Cliente c){
        clientes.add(c);
        }

    public String getPrato(){
        return prato;
     }

    public boolean podeVotar(Cliente cliente){
        return clientes.contains(cliente);
        }

    public int getQtdVotos() {
        return qtdVotos;
    }



    public String getNome() {
        return nome;
    }

    public LivroDeVisitas getLivro(){
        return livro;
    }

    public void removerVoto(){
        if (qtdVotos >0) {
            qtdVotos--;
        }
    }
    public int getTotalVisitas() {
        return livro.getTotalVisitas();
    }

    public int getQtdClientes() {
        return clientes.size();
    }


    public double getReceita() {
        return getTotalVisitas() * VALOR;
    }

    public LinkedHashSet<Cliente> getListaClientes() {
        return clientes;
    }

    public String[] getClientes() {
        String[] resultado = new String[clientes.size()];
        int i = 0;
        for (Cliente c : clientes) {
            String linha = "Cliente: " + c.getNome();
            if (c.getRestauranteFavorito() == this) {
                linha += ", Prato preferido da casa";
            }
            resultado[i++] = linha;
        }
        return resultado;
    }
}







