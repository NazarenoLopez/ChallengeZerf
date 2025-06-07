# Zerf - Challenge Dev

Sistema de archivos virtual implementado en Java que simula un sistema de archivos básico con comandos similares a los de Unix/Linux.

## Características

- Creación de directorios (`mkdir`)
- Creación de archivos (`touch`)
- Navegación entre directorios (`cd`)
- Listado de contenido (`ls`)
- Visualización de ruta actual (`pwd`)
- Estructura jerárquica de archivos y directorios

## Requisitos

- Java 21 o superior
- Maven 3.8.0 o superior
- IDE compatible con Java 21 

## Instalación

1. Clona el repositorio:
```bash
git clone https://github.com/NazarenoLopez/ChallengeZerf.git
cd zerf
```

2. Compila el proyecto:
```bash
mvn clean install
```

## Ejecución

Para ejecutar el proyecto:

```bash
mvn exec:java
```

## Comandos Disponibles

- `mkdir <nombre>`: Crea un nuevo directorio
- `touch <nombre>`: Crea un nuevo archivo
- `cd <ruta>`: Cambia al directorio especificado
  - `cd ..`: Navega al directorio padre
  - `cd `: Navega al directorio raíz
  - `cd carpeta1/carpeta2`: Navega a través de múltiples niveles de directorios
- `ls`: Lista el contenido del directorio actual
- `pwd`: Muestra la ruta actual
- `exit`: Finaliza el programa

## Testing

El proyecto incluye pruebas unitarias para todas las funcionalidades principales. Para ejecutar las pruebas:

```bash
mvn test
```

## CI/CD

El proyecto incluye un workflow de GitHub Actions que:
- Se ejecuta automáticamente en cada push y pull request
- Compila el proyecto
- Ejecuta las pruebas
