package com.animales.model;

public class Lagarto extends Reptil {
    
    public Lagarto(int tamanio, float peso, String color) {
        super(tamanio, peso, color);
    }
    
    public void tomarSol() {
        System.out.println("El lagarto toma el sol para regular su temperatura");
    }
}