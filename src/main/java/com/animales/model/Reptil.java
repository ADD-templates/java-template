package com.animales.model;

// ==== REPTIL ====
public class Reptil extends Animal {
    
    public Reptil(int tamanio, float peso, String color) {
        super(tamanio, peso, color);
    }
    
    @Override
    public void respirar() {
        System.out.println(this.getClass().getSimpleName() + " respira por pulmones");
    }
    
    @Override
    public void comer() {
        System.out.println(this.getClass().getSimpleName() + " come y traga entero");
    }
}