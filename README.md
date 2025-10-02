# 🐾 Animales POO - Proyecto de Práctica Java

Aplicación de consola para practicar conceptos de Programación Orientada a Objetos en Java.
Prototipo base para programas Java que se ejecuten en consola o en background

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

## 📚 Agregar GUI (javax