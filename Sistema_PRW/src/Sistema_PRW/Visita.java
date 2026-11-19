package Sistema_PRW;

import java.time.LocalDate;

public class Visita {

    private LocalDate data;
    private Cliente cliente;
    private String comentario;

    public Visita(LocalDate data, Cliente c, String comentario) {
        this.data = data;
        this.cliente = c;
        this.comentario = comentario;
    }

    public LocalDate getData() {
        return data;
        }

    public String getComentario() {
        return comentario;
      }

    public Cliente getCliente() {
        return cliente;
            }

    public String listarInfos() {
        String info = "Cliente: " + cliente.getNome() + " | Data: " + data;
        if (comentario != null && !comentario.isBlank()) {
            info += " | Comentário: " + comentario;
        }
        return info;
      }
    }





