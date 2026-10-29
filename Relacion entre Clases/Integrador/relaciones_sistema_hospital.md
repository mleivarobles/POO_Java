# Relaciones en el Sistema de Hospital

| Relación       | UML   | Clases                              | Descripción                          |
|----------------|-------|-------------------------------------|--------------------------------------|
| Composición    | ◆——   | Paciente ◆—— HistorialMedico        | Paciente CREA su historial (new interno) |
| Composición    | ◆——   | HistorialMedico ◆—— RegistroConsulta | Historial CREA sus registros (new interno) |
| Agregación     | ◇——   | Hospital ◇—— Doctor                 | Hospital TIENE doctores (no los crea) |
| Asociación     | ——    | Paciente —— Doctor                  | Se conocen (se asignan mutuamente)   |
| Dependencia    | - -►  | Paciente - -► Recetario             | Uso temporal al generar receta       |

### ¿Cómo identificar cada una?

| Pregunta clave                                      | Relación      |
|-----------------------------------------------------|---------------|
| ¿Solo lo usa en un método, sin guardarlo?            | Dependencia   |
| ¿Lo guarda, pero se conocen de igual a igual?        | Asociación    |
| ¿Lo guarda y es parte del todo, pero vive sin él?    | Agregación    |
| ¿Lo guarda, es parte del todo y muere con él?        | Composición   |

### ¿Quién hace el `new`?

| Relación      | ¿Quién crea el objeto?         | ¿Es atributo? |
|---------------|--------------------------------|---------------|
| Composición   | El todo (internamente)         | Sí            |
| Agregación    | El Main / externo              | Sí            |
| Asociación    | El Main / externo              | Sí            |
| Dependencia   | Nadie lo guarda                | No            |
