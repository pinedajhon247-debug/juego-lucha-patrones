# JuegoLucha - Patrones de Diseño

## Descripción
Juego de lucha por turnos en Java que aplica patrones de diseño estructurales y creacionales como refinamiento arquitectónico.

## Integrantes
- Sebastian Ampudia
- Yeison Estiven Montaño
- Jhon Alexander Pineda

## Patrones de Diseño Implementados

### 1. Patrón Decorator (Estructural)
Permite agregar habilidades a los personajes sin modificar su clase base.
- `FuerzaDecorator` → +10 de daño por ataque
- `ArmaduraDecorator` → reduce 5 puntos de daño recibido
- `VenenoDecorator` → +5 puntos de daño extra por veneno

### 2. Patrón Factory Method (Creacional)
Permite crear diferentes tipos de personajes de forma centralizada.
- `PersonajeFactory` → crea Guerrero, Asesino o Mago

## Estructura del Proyecto
