package com.animales.model;

public class Perro extends Mamifero {
    
    public Perro(int tamanio, float peso, String color) {
        super(tamanio, peso, color);
    }
    
    @Override
    public void comer() {
        System.out.println("El perro come carne y otros alimentos");
    }
    
    public void ladrar() {
        System.out.println("¡Guau guau!");
    }
}