package com.example;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String tamanho;
    private String massa;
    private boolean bordaRecheada;
    private List<String> ingredientes = new ArrayList<>();

    protected Pizza() {}

    public void setTamanho(String tamanho) { this.tamanho = tamanho; }
    public void setMassa(String massa) { this.massa = massa; }
    public void setBordaRecheada(boolean borda) { this.bordaRecheada = borda; }
    public void adicionarIngrediente(String ing) { this.ingredientes.add(ing); }

    @Override
    public String toString() {
        return "Pizza " + tamanho + " com massa " + massa + 
               ", Borda: " + (bordaRecheada ? "Sim" : "Não") + 
               ", ingredientes: " + ingredientes;
    }
}