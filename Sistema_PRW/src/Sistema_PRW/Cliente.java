package Sistema_PRW;

import java.util.ArrayList;

public class Cliente {

    String nome;
    String email;
    String pratoFav = "Prato preferido não definido";
    double gastos = 0.0;
    ArrayList<Restaurante> restaurantesVisitados = new ArrayList<Restaurante>();


    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public void setPratoFav(String pratoFav){
        this.pratoFav = pratoFav;
    }

    public String votarNoRestaurante(Restaurante restaurante){
        if (restaurante.podeVotar()){
            restaurante.addVoto();
            return "Voto registrado com sucesso!";
        }
    }

    public String getPratoFav(){
        return pratoFav;
    }

    public String getNome() {
        return nome;
    }
}
