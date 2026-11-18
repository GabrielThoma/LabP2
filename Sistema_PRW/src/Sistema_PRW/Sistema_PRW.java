package Sistema_PRW;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Sistema_PRW {

    private HashMap<String, Cliente> clientes = new HashMap<>();
    private LinkedHashMap<String, Restaurante> restaurantes = new LinkedHashMap<>();

    public boolean adicionarRestaurante(String nome, String prato) {
        if (nome == null || nome.isBlank() || prato == null || prato.isBlank()){
            return false;
        }
        if (restaurantes.size() >= 50 || restaurantes.containsKey(nome)) {
            return false;
        }
        Restaurante r = new Restaurante(nome, prato);
        restaurantes.put(nome, r);
        return true;

    }

    public boolean adicionarCliente(String nome, String email) {
        if (nome == null || nome.isBlank() || email == null || email.isBlank()) {
            return false;
        }
        if (clientes.size() >= 100 || clientes.containsKey(email)) {
            return false;
        }
        Cliente c = new Cliente(nome, email);
        clientes.put(email, c);
        return true;

    }

    public void visitarRestaurante(String emailCliente, String nomeRestaurante) {
        visitarRestaurante(emailCliente, nomeRestaurante, null);
    }

    public void visitarRestaurante(String emailCliente, String nomeRestaurante, String comentario) {
        Cliente c = clientes.get(emailCliente);
        Restaurante r = restaurantes.get(nomeRestaurante);
        if (c == null || r == null) {
            return;
        }
        r.addCliente(c);
        c.registrarVisita();
        r.getLivro().addVisita(LocalDate.now(), c, comentario);
    }

    public double obtemGastoCliente(String emailCliente) {
        Cliente c = clientes.get(emailCliente);
        if (c == null) {
            return 0.0;
        }
        return c.getGastos();
    }

    public String[] listarClientesRestaurante(String nomeRestaurante) {
        Restaurante r = restaurantes.get(nomeRestaurante);
        if (r == null) {
            return new String[0];
        }
        return r.getClientes();
    }

    public String votarPratoPreferido(String emailCliente, String nomeRestaurante) {
        Cliente c = clientes.get(emailCliente);
        Restaurante r = restaurantes.get(nomeRestaurante);

        if (c == null || r == null || !r.podeVotar(c)) {
            return "Voto não registrado";
        }
        Restaurante restauranteAnterior = c.getRestauranteFavorito();
        if (restauranteAnterior != null) {
            restauranteAnterior.removerVoto();
        }
        r.addVoto();
        c.setRestauranteFavorito(r);
        return "Voto registrado com sucesso!";
    }

    public String melhorPrato() {
        int maisVotos = -1;
        Restaurante campeao = null;
        for (Restaurante r : restaurantes.values()) {
            if (r.getQtdVotos() > maisVotos) {
                maisVotos = r.getQtdVotos();
                campeao = r;
            }
        }
        if (campeao == null) {
            return "";
        }
            return "Melhor prato: " + campeao.getPrato() + " Restaurante: " + campeao.getNome();
        }

    public String[] listarLivroVisitas(String nomeRestaurante) {
        Restaurante r = restaurantes.get(nomeRestaurante);
        if (r == null) {
            return new String[0];
        }
        return r.getLivro().listar();
    }

    public String[] listarLivroVisitas(String nomeRestaurante, int numRecentes) {
        Restaurante r = restaurantes.get(nomeRestaurante);
        if (r == null) {
            return new String[0];
        }
        return r.getLivro().listar(numRecentes);
    }
}


