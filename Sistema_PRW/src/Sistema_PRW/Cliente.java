package Sistema_PRW;

public class Cliente {

    String nome;
    String email;
    String pratoFav = "Prato preferido não definido";
    double gastos = 0.0;
    Restaurante[] restaurantesVisitados = new Restaurante[100];


    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
}
