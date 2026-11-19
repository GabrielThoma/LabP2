package Sistema_PRW;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;



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

    public String gerarRelatorioGeral() {
        int qtdRestaurantes = restaurantes.size();
        int totalVisitas = 0;
        int totalVisitantes = 0;
        int maior = 0;

        for (Restaurante r : restaurantes.values()) {
            totalVisitas += r.getTotalVisitas();
            totalVisitantes += r.getQtdClientes();
            if (r.getTotalVisitas() > maior) {
                maior = r.getTotalVisitas();
            }
        }

        String texto = "Relatório Geral Paraíba Restaurant Week\n\n";
        texto += "(1) Restaurantes participantes : " + qtdRestaurantes + "\n";
        texto += "(2) Clientes participantes : " + clientes.size() + "\n\n";

        String nomes = "";
        if (maior == 0) {
            nomes = "nenhum restaurante foi visitado";
        } else {
            for (Restaurante r : restaurantes.values()) {
                if (r.getTotalVisitas() == maior) {
                    if (!nomes.equals("")) {
                        nomes += ", ";
                    }
                    nomes += r.getNome();
                }
            }
        }
        texto += "(5) Restaurante mais visitado: " + nomes + "\n\n";

        double mediaVisitantes = 0;
        double mediaVisitas = 0;
        if (qtdRestaurantes > 0) {
            mediaVisitantes = (double) totalVisitantes / qtdRestaurantes;
            mediaVisitas = (double) totalVisitas / qtdRestaurantes;
        }
        texto += "(3) Número médio de visitantes dos restaurantes: " + String.format("%.2f", mediaVisitantes) + "\n";
        texto += "(4) Número médio de visitas nos restaurantes: " + String.format("%.2f", mediaVisitas) + "\n\n";

        for (Restaurante r : restaurantes.values()) {
            double partVisitas = 0;
            double partVisitantes = 0;
            if (totalVisitas > 0) {
                partVisitas = (double) r.getTotalVisitas() / totalVisitas * 100;
            }
            if (totalVisitantes > 0) {
                partVisitantes = (double) r.getQtdClientes() / totalVisitantes * 100;
            }
            texto += "(6) Participação de Visitas (" + r.getNome() + "): " + String.format("%.2f", partVisitas) + "%\n";
            texto += "(7) Participação de Visitantes (" + r.getNome() + "): " + String.format("%.2f", partVisitantes) + "%\n";
        }
        return texto;
    }

    public String gerarRelatorioFinanceiro() {
        double receitaTotal = 0;
        for (Restaurante r : restaurantes.values()) {
            receitaTotal += r.getReceita();
        }

        double mediaPorRestaurante = 0;
        double mediaPorCliente = 0;
        if (restaurantes.size() > 0) {
            mediaPorRestaurante = receitaTotal / restaurantes.size();
        }
        if (clientes.size() > 0) {
            mediaPorCliente = receitaTotal / clientes.size();
        }

        String texto = "Relatório Financeiro Paraíba Restaurant Week\n\n";
        texto += "Receita total do evento: R$ " + String.format("%.2f", receitaTotal) + "\n";
        texto += "Média de receita por restaurante: R$ " + String.format("%.2f", mediaPorRestaurante) + "\n";
        texto += "Média de gastos por cliente: R$ " + String.format("%.2f", mediaPorCliente) + "\n";
        return texto;
    }

    public String gerarRelatorioEngajamento() {
        String texto = "Relatório de Engajamento Paraíba Restaurant Week\n\n";
        for (Restaurante r : restaurantes.values()) {
            for (Cliente c : r.getListaClientes()) {
                int vezes = r.getLivro().contarVisitas(c);
                texto += "Cliente: " + c.getNome() + " | Restaurante: " + r.getNome() + " | Visitas: " + vezes + "\n";
            }
        }
        return texto;
    }
}








