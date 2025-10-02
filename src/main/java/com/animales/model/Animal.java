package com.animales.model;

/**
 * Clase abstracta Animal - Base de la jerarquía
 */
public abstract class Animal {
    
    private int tamanio;
    private float peso;
    private String color;
    
    // Constructor
    public Animal(int tamanio, float peso, String color) {
        this.tamanio = tamanio;
        this.peso = peso;
        this.color = color;
    }
    
    // Métodos abstractos (deben implementarse en subclases)
    public abstract void comer();
    public abstract void respirar();
    
    // Método toString para representación del objeto
    @Override
    public String toString() {
        return String.format("%s [tamaño=%dcm, peso=%.2fkg, color=%s]",
                this.getClass().getSimpleName(), tamanio, peso, color);
    }
    
    // Getters y Setters
    public int getTamanio() {
        return tamanio;
    }
    
    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
    
    public float getPeso() {
        return peso;
    }
    
    public void setPeso(float peso) {
        this.peso = peso;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
}