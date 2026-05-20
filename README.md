# JuegoLucha - Patrones de Diseño

![Java CI with Maven](https://github.com/pinedajhon247-debug/juego-lucha-patrones/actions/workflows/ci.yml/badge.svg)

## Descripción
Juego de lucha por turnos en Java que aplica patrones de diseño estructurales y creacionales.

## Integrantes
- Sebastian Ampudia
- Yeison Estiven Montaño
- Jhon Alexander Pineda

## Patrones Implementados

### 1. Decorator (Estructural)
- FuerzaDecorator: +10 de daño
- ArmaduraDecorator: reduce 5 puntos de daño
- VenenoDecorator: +5 de daño extra

### 2. Factory Method (Creacional)
- GuerreroFactory: crea Guerrero con Armadura y Fuerza
- AsesinFactory: crea Asesino con Veneno
- MagoFactory: crea Mago con Fuerza y Veneno

## Pruebas
- 14 tests con JUnit 5 y Mockito
- Cobertura con JaCoCo
- CI con GitHub Actions

## Cómo ejecutar
mvn clean compile
mvn test
mvn exec:java -Dexec.mainClass="com.juego.juego.JuegoLucha"