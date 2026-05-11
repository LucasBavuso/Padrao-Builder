package com.example;

public class PizzaBuilder {
    private Pizza pizza;

    public PizzaBuilder() {
        this.pizza = new Pizza();
    }

    public PizzaBuilder tamanho(String tamanho) {
        pizza.setTamanho(tamanho);
        return this;
    }

    public PizzaBuilder massa(String massa) {
        pizza.setMassa(massa);
        return this;
    }

    public PizzaBuilder comBordaRecheada() {
        pizza.setBordaRecheada(true);
        return this;
    }

    public PizzaBuilder adicionarIngrediente(String ingrediente) {
        pizza.adicionarIngrediente(ingrediente);
        return this;
    }

    public Pizza build() {
        return this.pizza;
    }
}