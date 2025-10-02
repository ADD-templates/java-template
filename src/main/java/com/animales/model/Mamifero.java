package com.animales.model;

// ==== MAMIFERO ====
public abstract class Mamifero extends Animal {
    
    public Mamifero(int tamanio, float peso, String color) {
        super(tamanio, peso, color);
    }
    
    @Override
    public void respirar() {
        System.out.println(this.getClass().getSimpleName() + " respira por pulmones");
    }
}