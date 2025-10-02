package com.animales.model;

public class Paloma extends Ave implements Volador {
    
    public Paloma(int tamanio, float peso, String color) {
        super(tamanio, peso, color);
    }
    
    @Override
    public void volar() {
        System.out.println("La paloma vuela batiendo sus alas");
    }
}
