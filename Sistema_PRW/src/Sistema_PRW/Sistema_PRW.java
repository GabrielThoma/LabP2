package Sistema_PRW;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Sistema_PRW {

    HashMap<String, Cliente> clientes = new HashMap<>();
    LinkedHashMap<String, Restaurante> restaurantes = new LinkedHashMap<>();

    public boolean adicionarRestaurante(String prato, String nome) {
        if (restaurantes.containsKey(nome)){
            return false;
        }
        Restaurante r = new Restaurante(nome, prato);
        restaurantes.put(nome, r);
        return true;

    }

    public boolean adicionarCliente(String nome, String email) {
        if (clientes.containsKey(nome)) {
            return false;
        }
        Cliente c = new Cliente(nome, email);
        clientes.put(nome, c);
        return true;

    }

    public void visitarRestaurante(String emailCliente, String nomeRestaurante) {
        Cliente c = clientes.get(emailCliente);
        Restaurante r = restaurantes.get(nomeRestaurante);
        c.addRestaurante(r);
        r.addCliente(c);

    }

    public void visitarRestaurante(String emailCliente, String nomeRestaurante, String comentario) {


    }

    public double obtemGastoCliente(String emailCliente) {
        return clientes.get(emailCliente).getGastos();
    }

    public String[] listarClientesRestaurante(String nomeRestaurante) {
        return restaurantes.get(nomeRestaurante).getClientes();

    }

    public String votarPratoPreferido(String emailCliente, String nomeRestaurante) {
        Cliente c = clientes.get(emailCliente);
        Restaurante r = restaurantes.get(nomeRestaurante);

        if (r.podeVotar(c)){
            r.addVoto();
            return "Voto registrado com sucesso!";
        }
        return "Voto não registrado.";
    }

    public String melhorPrato() {
        int maisVotos = 0;
        String restauranteMaisVotado = "";
        for (Restaurante r : restaurantes.values()){
            if (r.getQtdVotos() > maisVotos){
                maisVotos = r.getQtdVotos();
                restauranteMaisVotado = r.getNome();
            }
        } return restauranteMaisVotado;
    }

    public String[] listarLivroVisitas(String nomeRestaurante) {

    }
}

