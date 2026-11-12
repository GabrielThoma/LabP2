package Sistema_PRW;

import java.util.HashMap;

public class Sistema_PRW {

    HashMap<String, Cliente> clientes = new HashMap<>();
    HashMap<String, Restaurante> restaurantes = new HashMap<>();

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

    }

    public void visitarRestaurante(String emailCliente, String nomeRestaurante, String comentario) {

    }

    public double obtemGastoCliente(String emailCliente) {

    }

    public String[] listarClientesRestaurante(String nomeRestaurante) {

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

    }

    public String[] listarLivroVisitas(String nomeRestaurante) {

    }
}

