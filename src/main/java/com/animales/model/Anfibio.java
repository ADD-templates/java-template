package com.animales.model;

// ==== ANFIBIO ====
public class Anfibio extends Animal {
    
    public Anfibio(int tamanio, float peso, String color) {
        super(tamanio, peso, color);
    }
    
    @Override
    public void respirar() {
        System.out.println(this.getClass().getSimpleName() + " respira por pulmones y piel");
    }
    
    @Override
    public void comer() {
        System.out.println(this.getClass().getSimpleName() + " come insectos con su lengua");
    }
}