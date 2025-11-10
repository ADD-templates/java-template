# 🐾 Animales POO - Proyecto de Práctica Java

Aplicación de consola para practicar conceptos de Programación Orientada a Objetos en Java.

## 📋 Conceptos de POO Demostrados

- ✅ **Abstracción**: Clase abstracta `Animal`
- ✅ **Herencia**: Jerarquía de clases (Mamífero, Ave, Reptil, Anfibio)
- ✅ **Polimorfismo**: Diferentes implementaciones de `comer()` y `respirar()`
- ✅ **Encapsulación**: Atributos privados con getters/setters
- ✅ **Interfaces**: `Volador` implementado por `Paloma`

## 🚀 Inicio Rápido con Docker

### Prerrequisitos
- Docker Desktop o Docker Engine
- Docker Compose

### Levantar el Contenedor

```bash
# 1. Construir y levantar
docker-compose up --build

# 2. En otra terminal, entrar al contenedor
docker-compose exec app bash
```

## 📦 Compilación

### Dentro del Contenedor

```bash
# Compilar el proyecto
mvn clean compile

# Empaquetar JAR
mvn clean package
```

## ▶️ Ejecución

### Opción 1: Con Maven

```bash
mvn exec:java
```

### Opción 2: JAR Ejecutable

```bash
java -jar target/animales-java-1.0.0.jar
```

## 🧪 Testing

```bash
# Ejecutar tests
mvn test

# Con cobertura
mvn test jacoco:report
```

## 📁 Estructura del Proyecto

```
animales-java/
├── Dockerfile
├── docker-compose.yml
├── pom.xml
├── README.md
│
├── src/
│   ├── main/
│   │   ├── java/com/animales/
│   │   │   ├── Main.java                    # Clase principal
│   │   │   │
│   │   │   ├── model/                       # Modelos (clases POO)
│   │   │   │   ├── Animal.java              # Clase abstracta base
│   │   │   │   ├── Volador.java             # Interfaz
│   │   │   │   ├── Mamifero.java
│   │   │   │   ├── Ave.java
│   │   │   │   ├── Reptil.java
│   │   │   │   ├── Anfibio.java
│   │   │   │   ├── Elefante.java
│   │   │   │   ├── Perro.java
│   │   │   │   ├── Paloma.java
│   │   │   │   ├── Avestruz.java
│   │   │   │   ├── Lagarto.java
│   │   │   │   └── Rana.java
│   │   │   │
│   │   │   ├── service/                     # Servicios (lógica)
│   │   │   └── utils/                        # Utilidades
│   │   │
│   │   └── resources/
│   │       └── logback.xml                  # Configuración logging
│   │
│   └── test/
│       └── java/com/animales/               # Tests unitarios
│
└── target/                                  # Archivos compilados
```

## 🎯 Funcionalidades del Menú

1. **Listar animales**: Muestra todos los animales creados
2. **Crear nuevo animal**: Permite crear instancias de cualquier tipo
3. **Probar comportamientos**: Ejecuta métodos de cada animal
4. **Demostrar polimorfismo**: Muestra cómo diferentes clases implementan el mismo método
5. **Demostrar herencia**: Muestra la jerarquía de clases

## 🎨 Diagrama UML

```
           Animal (abstracta)
              |
    +---------+---------+---------+
    |         |         |         |
Mamifero    Ave     Reptil    Anfibio
    |         |         |         |
+---+---+  +--+--+      |         |
|       |  |     |      |         |
Elefante Perro Paloma Avestruz Lagarto Rana
                  |
              <<Volador>>
```

## 🔧 Comandos Útiles

```bash
# Compilar
mvn compile

# Ejecutar
mvn exec:java

# Crear JAR
mvn package

# Limpiar
mvn clean

# Ver dependencias
mvn dependency:tree

# Ejecutar tests
mvn test
```

## 📚 Agregar GUI (javax.swing) Más Adelante

Si quieres agregar interfaces gráficas posteriormente:

### 1. La dependencia de Swing ya está disponible

Swing viene incluido con el JDK, no necesitas agregar dependencias adicionales.

### 2. Crear una ventana simple

```java
// En src/main/java/com/animales/gui/MainWindow.java
package com.animales.gui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow() {
        setTitle("Sistema de Animales POO");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Agregar componentes...
        
        setVisible(true);
    }
}
```

### 3. Ejecutar con GUI

Modificar `Main.java` para aceptar argumento `--gui`:

```java
if (args.length > 0 && "--gui".equals(args[0])) {
    SwingUtilities.invokeLater(() -> new MainWindow());
} else {
    // Modo consola...
}
```

### 4. Para GUI en Docker

Necesitarás X11 forwarding (ya configurado en el Dockerfile):

```bash
# En WSL con WSLg (Windows 11), (debe hacerse ejecutado 'mvn clean package' previamente)
java -jar target/animales-java-1.0.0.jar --gui

# En WSL sin WSLg
export DISPLAY=:0
java -jar target/animales-java-1.0.0.jar --gui
```

## 🛠️ Desarrollo

### Hot Reload (Opcional)

Para recompilar automáticamente:

```bash
# Terminal 1: Watch de archivos
find src -name "*.java" | entr mvn compile

# Terminal 2: Ejecutar
mvn exec:java
```

### Logs

Los logs se escriben en consola usando Logback. Configuración en `src/main/resources/logback.xml`.

## 🐛 Troubleshooting

### Error: "Could not find or load main class"

```bash
mvn clean compile
mvn package
```

### Problemas con Maven en Docker

```bash
# Limpiar caché Maven
docker-compose down -v
docker-compose up --build
```

### GUI no se muestra en WSL

```bash
# WSL2 con WSLg (Windows 11): funciona automáticamente
# WSL2 sin WSLg: instalar servidor X11
sudo apt install xorg-dev
export DISPLAY=:0
```

## 📖 Recursos de Aprendizaje

- **Herencia**: La clase `Animal` es heredada por `Mamifero`, `Ave`, etc.
- **Polimorfismo**: El método `comer()` se comporta diferente en cada clase
- **Abstracción**: `Animal` es abstracta, no se puede instanciar directamente
- **Interfaces**: `Volador` define un contrato que `Paloma` implementa
- **Encapsulación**: Los atributos son privados, se accede por getters/setters

## 🤝 Contribuir

Este es un proyecto de práctica, siéntete libre de:
- Agregar más tipos de animales
- Implementar nuevas interfaces (Nadador, Terrestre, etc.)
- Crear más comportamientos
- Agregar GUI con Swing
- Escribir más tests

## 📝 Notas Importantes

- Este proyecto usa Java 17 (LTS)
- Maven maneja las dependencias automáticamente
- El repositorio Maven está aislado en un volumen Docker
- Los logs se guardan usando SLF4J + Logback

## 🎓 Conceptos Avanzados para Explorar

1. **Composición vs Herencia**: Agregar atributos tipo `Habitat`
2. **Design Patterns**: Implementar Factory, Strategy, Observer
3. **Generics**: Crear colecciones tipadas `List<Mamifero>`
4. **Streams**: Filtrar animales con Java Streams API
5. **Serialización**: Guardar/cargar animales desde archivo

---

**Versión**: 1.0.0  
**Java**: 21 LTS  
**Build Tool**: Maven 3.x