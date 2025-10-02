# Dockerfile para aplicación Java standalone con GUI
FROM openjdk:17-jdk-slim

# Instalar Maven Y bibliotecas para GUI
RUN apt-get update && \
    apt-get install -y \
    maven \
    libxext6 \
    libxrender1 \
    libxtst6 \
    libxi6 \
    xauth \
    x11-apps && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Crear directorio de trabajo
WORKDIR /app

# Crear usuario para desarrollo
RUN useradd -m -u 1000 developer && \
    chown -R developer:developer /app

# Cambiar a usuario developer
USER developer

# Crear directorio para repositorio Maven local
RUN mkdir -p /home/developer/.m2/repository

# Variables de entorno para GUI
ENV DISPLAY=:0

# Comando por defecto
CMD ["bash"]