# Tarea3Progra3

Maven + Librería Local + Validación de Expresiones + Ofuscación + Ingeniería Inversa

## Objetivo

En esta práctica se trabajó con dos proyectos dentro del mismo repositorio, aplicando gestión de dependencias con Maven, creación e instalación de una librería local, consumo de esa librería desde otro proyecto, implementación manual de una estructura de datos (pila), validación de expresiones algebraicas, ofuscación reproducible desde el pom.xml, ingeniería inversa de un JAR y pruebas funcionales desde consola.

## Estructura del repositorio

/umg.edu.gt.data-structure.stack  → Librería (estructura de pila)  
/stackHandler                     → Aplicación que consume la librería  
/evidencias                       → Capturas solicitadas  
README.md  

Ambos proyectos compilan desde consola utilizando Maven.

## Parte A – Dependencia Maven entre proyectos

Librería:
groupId: umg.edu.gt.data-structure  
artifactId: stack  
version: 1.0.0  

Instalación en repositorio local:

mvn clean install

Dependencia agregada en stackHandler:

<dependency>
    <groupId>umg.edu.gt.data-structure</groupId>
    <artifactId>stack</artifactId>
    <version>1.0.0</version>
</dependency>

Compilación del handler:

mvn clean package

## Parte B – Implementación funcional

Se implementó manualmente una estructura de datos tipo pila enlazada sin utilizar java.util.Stack.

Clases desarrolladas:
- Node
- MyStack
- SymbolValidator

Métodos adicionales implementados:
- getCount()
- length()
- getNodeInit()

Casos probados desde consola:

Caso válido:
(a+b) * [c-d] → true

Caso inválido:
([)] → false

Ejecución:
java -jar target/stackHandler-1.0.0-jar-with-dependencies.jar "(a+b) * [c-d]"

## Parte C – Ofuscación reproducible

Se utilizó ProGuard mediante un perfil Maven llamado "obfuscate".

Comando utilizado:

mvn clean package -Pobfuscate

Resultado en la librería:
- stack-1.0.0.jar
- stack-1.0.0-obfuscated.jar

Resultado en el handler:
- stackHandler-1.0.0-jar-with-dependencies.jar
- stackHandler-1.0.0-obfuscated.jar

## Parte D – Ingeniería Inversa

Se utilizó JD-GUI para decompilar el JAR ofuscado del handler.

Al analizar el código decompilado se observó que los nombres originales de clases y métodos fueron reemplazados por identificadores simples como “a”, “b” o “c”. Esto dificulta la lectura y comprensión del código, ya que se pierde la claridad semántica.

Aunque la lógica general puede identificarse, entender completamente el funcionamiento requiere mayor análisis.

Conclusión del análisis:
La ofuscación no impide completamente la ingeniería inversa, pero sí aumenta considerablemente la dificultad para comprender el código.

## Parte E – Prueba de regresión

Se ejecutó tanto el JAR normal como el JAR ofuscado:

java -jar target/stackHandler-1.0.0-jar-with-dependencies.jar "(a+b) * [c-d]"
java -jar target/stackHandler-1.0.0-obfuscated.jar "(a+b) * [c-d]"

Ambos produjeron exactamente la misma salida.

Conclusión:
La ofuscación no altera el comportamiento funcional del sistema. El programa sigue validando correctamente las expresiones algebraicas.

## Conclusión General

En esta práctica se logró integrar correctamente dos proyectos Maven dentro de un mismo repositorio, implementar una estructura de datos manual, configurar dependencias locales, aplicar ofuscación reproducible y realizar ingeniería inversa para evaluar el nivel de protección del código.

Se comprobó que la ofuscación mejora la protección básica del código sin afectar su funcionamiento.

## Carpeta evidencias

Contiene capturas de:
- Instalación de la librería
- Compilación exitosa
- JAR normal vs JAR ofuscado
- Código decompilado
- Prueba de regresión
