package Sistema_PRW;

import java.time.LocalDate;
import java.util.*;

public class LivroDeVisitas {

    private ArrayList<Visita> visitas = new ArrayList<>();


    public void addVisita(LocalDate data, Cliente c, String comentario){
        visitas.add(new Visita(data, c, comentario));
    }

    public String[] listar(){
        return listar(visitas.size());
        }

    public String[] listar(int n) {
        if (n < 0) n = 0;
        int inicio = Math.max(0, visitas.size() - n);
        String[] resultado = new String[visitas.size() - inicio];
        for (int i = inicio; i < visitas.size(); i++) {
            resultado[i - inicio] = visitas.get(i).listarInfos();
          }
        return resultado;
     }

    public int getTotalVisitas() {
        return visitas.size();
    }

    public int contarVisitas(Cliente c) {
        int contador = 0;
        for (Visita v : visitas) {
            if (v.getCliente().equals(c)) {
                contador++;
            }
        }
        return contador;
          }
    }





