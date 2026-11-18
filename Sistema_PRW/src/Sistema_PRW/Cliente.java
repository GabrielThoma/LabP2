package Sistema_PRW;

import java.util.ArrayList;
import java.util.Objects;

public class Cliente {

    private final String nome;
    private final String email;
    private Restaurante restauranteFavorito;
    private int qtdVisitas;
    private final double VALOR = 89.90;


    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public double getGastos() {
        return qtdVisitas * VALOR;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void registrarVisita() { qtdVisitas++; }

    public String getPratoFav(){
        if (restauranteFavorito == null) return "Prato preferido não definido";
        return restauranteFavorito.getPrato();
    }

    public void setRestauranteFavorito(Restaurante r){
        this.restauranteFavorito = r;
    }

    public Restaurante getRestauranteFavorito(){
        return restauranteFavorito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        return email.equals(((Cliente) o).email);
    }

    @Override
    public int hashCode() { return Objects.hash(email); }
}
