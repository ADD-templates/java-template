package com.animales.model;

public class Elefante extends Mamifero {
    
    public Elefante(int tamanio, float peso, String color) {
        super(tamanio, peso, color);
    }
    
    @Override
    public void comer() {
        System.out.println("El elefante come hierbas y hojas con su trompa");
    }
}