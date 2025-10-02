package com.animales;

import com.animales.model.*;
import com.animales.gui.MainWindow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.swing.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal - Aplicación de consola para demostrar POO
 */
public class Main {
    
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static final List<Animal> animales = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        logger.info("Iniciando aplicación Animales POO");
        
        // Crear algunos animales de ejemplo
        inicializarAnimales();
        if (args.length > 0 && "--gui".equals(args[0])) {
            // Modo GUI
            SwingUtilities.invokeLater(() -> new MainWindow());
        } else {
            // Modo consola...
            ejecutarModoConsola();
        }

        scanner.close();
        logger.info("Aplicación terminada");
    }

    private static void ejecutarModoConsola() {
        // Lógica del modo consola aquí (si es necesario)
        boolean running = true;
        
        System.out.println("\n" +
                "╔══════════════════════════════════════╗\n" +
                "║   🐾 SISTEMA DE ANIMALES POO 🐾      ║\n" +
                "║        Práctica de Java POO          ║\n" +
                "╚══════════════════════════════════════╝\n");
        
        while (running) {
            mostrarMenu();
            System.out.print("👉 Selecciona una opción: ");
            
            try {
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir salto de línea
                
                switch (opcion) {
                    case 1:
                        listarAnimales();
                        break;
                    case 2:
                        crearAnimal();
                        break;
                    case 3:
                        probarComportamientos();
                        break;
                    case 4:
                        demostrarPolimorfismo();
                        break;
                    case 5:
                        demostrarHerencia();
                        break;
                    case 0:
                        System.out.println("\n👋 ¡Hasta luego!");
                        running = false;
                        break;
                    default:
                        System.out.println("❌ Opción no válida");
                }
                
            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
                scanner.nextLine(); // Limpiar buffer
            }
            
            if (running) {
                System.out.println("\n📱 Presiona Enter para continuar...");
                scanner.nextLine();
            }
        }
        
    }
    
    private static void inicializarAnimales() {
        animales.add(new Elefante(300, 5000f, "Gris"));
        animales.add(new Perro(60, 25f, "Café"));
        animales.add(new Paloma(20, 0.3f, "Blanco"));
        animales.add(new Avestruz(250, 150f, "Negro"));
        animales.add(new Lagarto(50, 2f, "Verde"));
        animales.add(new Rana(10, 0.05f, "Verde"));
    }
    
    private static void mostrarMenu() {
        System.out.println("\n" +
                "┌──────────────────────────────────────┐\n" +
                "│          MENÚ PRINCIPAL              │\n" +
                "├──────────────────────────────────────┤\n" +
                "│  1️⃣  Listar todos los animales       │\n" +
                "│  2️⃣  Crear nuevo animal              │\n" +
                "│  3️⃣  Probar comportamientos          │\n" +
                "│  4️⃣  Demostrar Polimorfismo          │\n" +
                "│  5️⃣  Demostrar Herencia              │\n" +
                "│  0️⃣  Salir                           │\n" +
                "└──────────────────────────────────────┘");
    }
    
    private static void listarAnimales() {
        System.out.println("\n📋 LISTA DE ANIMALES:");
        System.out.println("═".repeat(50));
        
        for (int i = 0; i < animales.size(); i++) {
            System.out.println((i + 1) + ". " + animales.get(i));
        }
    }
    
    private static void crearAnimal() {
        System.out.println("\n🆕 CREAR NUEVO ANIMAL");
        System.out.println("═".repeat(50));
        System.out.println("1. Elefante");
        System.out.println("2. Perro");
        System.out.println("3. Paloma");
        System.out.println("4. Avestruz");
        System.out.println("5. Lagarto");
        System.out.println("6. Rana");
        System.out.print("Tipo de animal: ");
        
        int tipo = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Tamaño (cm): ");
        int tamanio = scanner.nextInt();
        
        System.out.print("Peso (kg): ");
        float peso = scanner.nextFloat();
        scanner.nextLine();
        
        System.out.print("Color: ");
        String color = scanner.nextLine();
        
        Animal nuevoAnimal = null;
        
        switch (tipo) {
            case 1: nuevoAnimal = new Elefante(tamanio, peso, color); break;
            case 2: nuevoAnimal = new Perro(tamanio, peso, color); break;
            case 3: nuevoAnimal = new Paloma(tamanio, peso, color); break;
            case 4: nuevoAnimal = new Avestruz(tamanio, peso, color); break;
            case 5: nuevoAnimal = new Lagarto(tamanio, peso, color); break;
            case 6: nuevoAnimal = new Rana(tamanio, peso, color); break;
            default:
                System.out.println("❌ Tipo no válido");
                return;
        }
        
        animales.add(nuevoAnimal);
        System.out.println("✅ Animal creado: " + nuevoAnimal);
    }
    
    private static void probarComportamientos() {
        System.out.println("\n🎬 PROBANDO COMPORTAMIENTOS");
        System.out.println("═".repeat(50));
        
        for (Animal animal : animales) {
            System.out.println("\n" + animal);
            animal.comer();
            animal.respirar();
            
            // Probar métodos específicos
            if (animal instanceof Volador) {
                ((Volador) animal).volar();
            }
            
            if (animal instanceof Perro) {
                ((Perro) animal).ladrar();
            }
            
            if (animal instanceof Avestruz) {
                ((Avestruz) animal).correr();
            }
            
            if (animal instanceof Lagarto) {
                ((Lagarto) animal).tomarSol();
            }
            
            if (animal instanceof Rana) {
                ((Rana) animal).saltar();
            }
            
            System.out.println("─".repeat(40));
        }
    }
    
    private static void demostrarPolimorfismo() {
        System.out.println("\n🔄 DEMOSTRACIÓN DE POLIMORFISMO");
        System.out.println("═".repeat(50));
        System.out.println("Todos los animales pueden comer, aunque lo hacen diferente:\n");
        
        for (Animal animal : animales) {
            System.out.print("→ ");
            animal.comer();
        }
    }
    
    private static void demostrarHerencia() {
        System.out.println("\n🌳 DEMOSTRACIÓN DE HERENCIA");
        System.out.println("═".repeat(50));
        
        System.out.println("\n📊 Jerarquía de clases:");
        System.out.println("Animal (abstracta)");
        System.out.println("├── Mamifero");
        System.out.println("│   ├── Elefante");
        System.out.println("│   └── Perro");
        System.out.println("├── Ave");
        System.out.println("│   ├── Paloma (implementa Volador)");
        System.out.println("│   └── Avestruz");
        System.out.println("├── Reptil");
        System.out.println("│   └── Lagarto");
        System.out.println("└── Anfibio");
        System.out.println("    └── Rana");
        
        System.out.println("\n🔍 Comprobando instanceof:");
        Animal perro = new Perro(60, 25f, "Café");
        System.out.println("perro instanceof Animal: " + (perro instanceof Animal));
        System.out.println("perro instanceof Mamifero: " + (perro instanceof Mamifero));
        System.out.println("perro instanceof Perro: " + (perro instanceof Perro));
        System.out.println("perro instanceof Volador: " + (perro instanceof Volador));
    }
}