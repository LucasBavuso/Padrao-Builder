package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PizzaBuilderTest {

    @Test
    @DisplayName("Deve construir uma pizza completa com todos os opcionais")
    public void deveConstruirPizzaCompleta() {
        Pizza pizza = new PizzaBuilder()
                        .tamanho("Família")
                        .massa("Pan")
                        .comBordaRecheada()
                        .adicionarIngrediente("Muçarela")
                        .adicionarIngrediente("Bacon")
                        .adicionarIngrediente("Azeitona")
                        .build();

        assertAll("Verificando atributos da pizza completa",
            () -> assertNotNull(pizza, "A pizza não deveria ser nula"),
            () -> assertTrue(pizza.toString().contains("Família"), "Deveria ter o tamanho Família"),
            () -> assertTrue(pizza.toString().contains("Pan"), "Deveria ter massa Pan"),
            () -> assertTrue(pizza.toString().contains("Borda: Sim"), "Deveria ter borda recheada"),
            () -> assertTrue(pizza.toString().contains("Bacon"), "Deveria conter Bacon nos ingredientes")
        );
    }

    @Test
    @DisplayName("Deve construir uma pizza básica apenas com o essencial")
    public void deveConstruirPizzaBasica() {
        Pizza pizza = new PizzaBuilder()
                        .tamanho("Média")
                        .massa("Fina")
                        .build();

        assertAll("Verificando pizza básica",
            () -> assertTrue(pizza.toString().contains("Média")),
            () -> assertTrue(pizza.toString().contains("Fina")),
            () -> assertTrue(pizza.toString().contains("Borda: Não"), "Pizza básica não deve ter borda recheada por padrão"),
            () -> assertTrue(pizza.toString().contains("ingredientes: []"))
        );
    }

    @Test
    @DisplayName("Deve permitir a criação de múltiplas pizzas independentes com o mesmo Builder")
    public void deveGarantirIndependenciaDasPizzas() {
        PizzaBuilder builder = new PizzaBuilder();

        Pizza pizza1 = builder.tamanho("Pequena").build();
        
        Pizza pizza2 = new PizzaBuilder().tamanho("Grande").build();

        assertNotEquals(pizza1.toString(), pizza2.toString());
    }

    @Test
    @DisplayName("Deve validar se a pizza mantém a ordem de adição dos ingredientes")
    public void deveManterOrdemDosIngredientes() {
        Pizza pizza = new PizzaBuilder()
                        .adicionarIngrediente("Primeiro")
                        .adicionarIngrediente("Segundo")
                        .build();

        String representacao = pizza.toString();
        int indexPrimeiro = representacao.indexOf("Primeiro");
        int indexSegundo = representacao.indexOf("Segundo");

        assertTrue(indexPrimeiro < indexSegundo, "A ordem dos ingredientes deve ser preservada");
    }
}