package com.animales.model;

// ==== AVE ====
public class Ave extends Animal {
    
    public Ave(int tamanio, float peso, String color) {
        super(tamanio, peso, color);
    }
    
    @Override
    public void respirar() {
        System.out.println(this.getClass().getSimpleName() + " respira por pulmones y sacos aéreos");
    }
    
    @Override
    public void comer() {
        System.out.println(this.getClass().getSimpleName() + " come con su pico");
    }
}