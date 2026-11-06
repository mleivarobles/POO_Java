```markdown
# Clase 13 — Principios de Diseño OO

Ejemplo integrador: Cafetería Universitaria aplicando SRP, OCP y DIP paso a paso.

## Estructura del proyecto

```
Clase13/
├── Antes/
│   ├── Bebida.java              # Viola SRP, OCP y DIP
│   ├── PedidoCafeteria.java     # Acoplado a Bebida (concreto)
│   └── Main.java
│
└── Despues/
    ├── Paso1_SRP/               # Separar responsabilidades
    │   ├── Bebida.java
    │   ├── GeneradorBoleta.java
    │   ├── NotificadorMeson.java
    │   └── Main.java
    │
    ├── Paso2_OCP/               # Extender sin modificar
    │   ├── Bebida.java          # Ahora es abstracta
    │   ├── Cafe.java
    │   ├── Te.java
    │   ├── Chocolate.java
    │   └── Main.java
    │
    └── Paso3_DIP/               # Depender de abstracciones
        ├── Vendible.java        # Interfaz
        ├── Bebida.java          # Abstracta, implements Vendible
        ├── Cafe.java
        ├── Te.java
        ├── Chocolate.java
        ├── Snack.java           # También implements Vendible
        ├── PedidoCafeteria.java # Usa Vendible[], no Bebida[]
        ├── GeneradorBoleta.java
        ├── NotificadorMeson.java
        └── Main.java
```

## Cómo compilar y ejecutar

Todos los comandos se ejecutan desde la carpeta `Clase13`.

### Antes (la versión que viola los 3 principios)

```bash
javac Antes/*.java
java -cp Antes Main
```

### Paso 1 — SRP

```bash
javac Despues/Paso1_SRP/*.java
java -cp Despues Paso1_SRP.Main
```

### Paso 2 — OCP

```bash
javac Despues/Paso2_OCP/*.java
java -cp Despues Paso2_OCP.Main
```

### Paso 3 — DIP (ejemplo completo)

```bash
javac Despues/Paso3_DIP/*.java
java -cp Despues Paso3_DIP.Main
```

## Resumen de los principios

| Principio | Pregunta clave | Señal de violación |
|-----------|---------------|-------------------|
| **SRP** | ¿Cuántas razones tiene esta clase para cambiar? | Necesitas "y" para describir lo que hace |
| **OCP** | ¿Puedo agregar un tipo nuevo sin tocar lo existente? | Cadenas if-else que preguntan por tipo |
| **DIP** | ¿Dependo de una abstracción o de algo concreto? | Variables declaradas como tipo concreto |
```