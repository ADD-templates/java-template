package com.animales.model;

public class Rana extends Anfibio {
    
    public Rana(int tamanio, float peso, String color) {
        super(tamanio, peso, color);
    }
    
    public void saltar() {
        System.out.println("La rana salta con sus patas traseras");
    }
}