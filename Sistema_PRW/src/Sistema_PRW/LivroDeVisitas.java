package Sistema_PRW;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class LivroDeVisitas {

    private Restaurante restaurante;
    private HashSet<Cliente> clientes = new HashSet<>();
    private HashMap<Cliente, LocalDate> datas = new HashMap<>();
    private HashMap<Cliente, String> comentarios = new HashMap<>();

    public LivroDeVisitas(Restaurante r, LocalDate d, Cliente c){
        this.restaurante = r;
        datas.put(c,d);
    }

    public LivroDeVisitas(Restaurante r, LocalDate d, Cliente c, String comentario){
        this.restaurante = r;
        datas.put(c,d);
        comentarios.put(c,comentario);
    }

    public void addCliente(Cliente c) {
        clientes.add(c);
    }

    public void addData(Cliente c, LocalDate data){
        this.datas.put(c, data);
    }

    public void addComentario(Cliente c, String comentario) {
        this.comentarios.put(c, comentario);
    }

    public String listarInfos() {
        for (Cliente c : clientes) {
            System.out.println("Cliente:" + c + "\n Data:" + datas.get(c) + "Comentário: " + comentarios.get(c));
        }
        return "Todos os dados.";
    }
}
