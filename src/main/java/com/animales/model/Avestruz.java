package com.animales.model;

public class Avestruz extends Ave {
    
    public Avestruz(int tamanio, float peso, String color) {
        super(tamanio, peso, color);
    }
    
    public void correr() {
        System.out.println("El avestruz corre a gran velocidad");
    }
}