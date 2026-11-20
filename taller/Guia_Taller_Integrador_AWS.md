# Guía Paso a Paso — Taller Integrador POO + AWS

**PRE-24067 · Programación Orientada a Objetos · 2026**  
**Universidad Miguel de Cervantes · Ingeniería en Informática**  
**Docente:** Prof. Mario Leiva  
**Fecha:** Sábado 21 de noviembre de 2026

---

## Arquitectura del taller

```
VS Code (tu notebook) ──SSH──► EC2 (Amazon Linux) ──JDBC──► RDS (MySQL 8)
      tu IDE                    tu código Java               tu base de datos
```

Trabajarás en VS Code conectado remotamente al EC2 mediante SSH. El código Java se ejecuta en el EC2 y se conecta al RDS que está en la misma red (VPC). Todo ocurre en la nube de AWS Academy.

---

## Prerrequisitos

Antes de la sesión debes tener:

- VS Code instalado en tu notebook
- Extensión **Remote - SSH** instalada en VS Code
- Acceso a tu repositorio del proyecto semestral en GitHub
- Acceso al curso Learner Lab en Canvas (invitación aceptada)

---

## Paso 1 — Iniciar el Learner Lab

1. Entra a Canvas → curso **Learner Lab**.
2. Haz clic en **Start Lab**.
3. Espera a que el indicador cambie de 🔴 rojo a 🟢 verde (puede tomar 1-2 minutos).
4. Haz clic en **AWS** para abrir la consola de administración.
5. Verifica que estés en la región **N. Virginia (us-east-1)** (esquina superior derecha).

> **Importante:** el lab tiene una duración de 4 horas. Si expira, puedes reiniciarlo, pero la IP pública del EC2 puede cambiar.

---

## Paso 2 — Crear la instancia EC2

1. En la consola AWS, busca **EC2** en la barra superior y entra al servicio.
2. Haz clic en **Launch instance** (botón naranja).
3. Configura:

| Campo | Valor |
|-------|-------|
| **Name** | `poo-server` |
| **AMI** | Amazon Linux 2023 (Free tier eligible, viene por defecto) |
| **Instance type** | `t2.micro` (Free tier eligible) |
| **Key pair** | `vockey` (viene precreada en Learner Lab) |

4. En **Network settings**, deja la VPC por defecto. Verifica que **Auto-assign public IP** esté en **Enable**.
5. En **Storage**, deja 8 GiB gp3 (por defecto).
6. Haz clic en **Launch instance**.
7. Espera a que el estado sea **Running** y los status checks muestren **2/2 checks passed**.
8. Haz clic en tu instancia y anota:
   - **Public IPv4 address** → la necesitas para conectar VS Code
   - **Security Group ID** → lo necesitas para configurar el RDS

---

## Paso 3 — Descargar la clave PEM

1. Vuelve a Canvas → Learner Lab.
2. Haz clic en **AWS Details**.
3. Descarga el archivo PEM (puede llamarse `labsuser.pem` o `vockey.pem`).
4. Guárdalo en una ruta simple, por ejemplo: `C:\Users\TuUsuario\.ssh\labsuser.pem`

> **Nota Windows:** si al conectar te da error de permisos con la key, ve a Propiedades del archivo → Seguridad → Avanzado → deshabilita la herencia y deja solo tu usuario con permisos de lectura.

---

## Paso 4 — Conectar VS Code al EC2

1. Abre VS Code.
2. Presiona `F1` → escribe **Remote-SSH: Open SSH Configuration File** → selecciona `C:\Users\TuUsuario\.ssh\config`.
3. Agrega la siguiente configuración (reemplaza los valores):

```
Host poo-server
  HostName <Public IPv4 de tu EC2>
  User ec2-user
  IdentityFile C:\Users\TuUsuario\.ssh\labsuser.pem
```

4. Guarda el archivo.
5. `F1` → **Remote-SSH: Connect to Host** → selecciona **poo-server**.
6. Se abre una nueva ventana de VS Code. La primera vez te pedirá seleccionar el sistema operativo → elige **Linux**.
7. Espera a que se instale el servidor remoto. Una vez conectado, verás en la esquina inferior izquierda en verde: **SSH: poo-server**.
8. Abre una terminal (`Ctrl+ñ` o Terminal → New Terminal) y verifica:

```bash
whoami
```

Debe mostrar `ec2-user`.

> **Si el lab se reinicia** y la IP cambia, solo necesitas actualizar el `HostName` en el archivo config y reconectar. La clave PEM no cambia.

---

## Paso 5 — Preparar el entorno en el EC2

Desde la terminal de VS Code (ya conectado al EC2), ejecuta:

### Instalar Java 17 y Git

```bash
sudo yum update -y
sudo yum install java-17-amazon-corretto-devel git -y
```

Verifica:

```bash
java -version
javac -version
git --version
```

### Descargar el driver JDBC de MySQL

```bash
mkdir ~/taller && cd ~/taller
wget https://repo1.maven.org/maven2/com/mysql/mysql-connector-j/8.3.0/mysql-connector-j-8.3.0.jar
ls -l mysql-connector-j-8.3.0.jar
```

### Clonar tu repositorio del proyecto

```bash
git clone https://github.com/tu-usuario/tu-repositorio.git
```

---

## Paso 6 — Crear la instancia RDS (MySQL)

> **Este paso lo realiza el docente.** Los datos de conexión se proporcionarán al inicio de la sesión.

El docente creará una instancia RDS MySQL compartida. Recibirás:

- **Endpoint** (host de conexión)
- **Puerto:** 3306
- **Usuario y contraseña**

Cada grupo debe crear su propia base de datos con la convención: `poo_[nombre-proyecto]`

Ejemplos: `poo_pizzeria`, `poo_biblioteca`, `poo_muebleria`, `poo_taller_mecanico`

---

## Paso 7 — Instalar cliente MySQL y probar conexión

Desde la terminal del EC2:

### Instalar el cliente MySQL

```bash
sudo yum install mariadb105 -y
```

### Conectar al RDS

```bash
mysql -h [endpoint proporcionado por el docente] -P 3306 -u admin -p
```

Ingresa la contraseña cuando la pida. Si ves el prompt `MySQL>`, la conexión es exitosa.

### Crear tu base de datos

```sql
CREATE DATABASE poo_[nombre-proyecto];
SHOW DATABASES;
USE poo_[nombre-proyecto];
```

Verifica que tu base de datos aparezca en la lista y luego sal con `exit`.

---

## Paso 8 — Crear la tabla y datos de prueba

El docente entregará un script SQL de ejemplo basado en la Cafetería. Debes adaptarlo a la entidad de tu proyecto.

### Ejemplo: cafeteria.sql

```sql
USE poo_cafeteria;

CREATE TABLE IF NOT EXISTS producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio INT NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    stock INT NOT NULL DEFAULT 0
);

INSERT INTO producto (nombre, precio, categoria, stock) VALUES
    ('Café Americano', 1500, 'Bebida caliente', 50),
    ('Cappuccino', 2200, 'Bebida caliente', 30),
    ('Jugo Natural', 1800, 'Bebida fría', 20),
    ('Sándwich Italiano', 3500, 'Comida', 15),
    ('Muffin Chocolate', 1200, 'Repostería', 25);
```

### Ejecutar el script

```bash
mysql -h [endpoint] -u admin -p < cafeteria.sql
```

### Verificar

```bash
mysql -h [endpoint] -u admin -p -e "SELECT * FROM poo_cafeteria.producto;"
```

Debes ver los 5 productos insertados.

---

## Paso 9 — Compilar y ejecutar el código Java

El docente entregará los archivos de ejemplo:

- `ConexionBD.java` — Clase de conexión JDBC (SRP)
- `Producto.java` — Entidad del dominio
- `ProductoDAO.java` — Interfaz CRUD (DIP, OCP)
- `ProductoDAOImpl.java` — Implementación JDBC con PreparedStatement
- `Main.java` — Demuestra las 4 operaciones

### Configurar la conexión

Abre `ConexionBD.java` y completa los datos proporcionados por el docente:

```java
private static final String HOST = "[endpoint proporcionado por el docente]";
private static final String BASE_DATOS = "poo_[nombre-proyecto]";
private static final String USUARIO = "admin";
private static final String PASSWORD = "[contraseña proporcionada por el docente]";
```

### Compilar

```bash
javac -cp mysql-connector-j-8.3.0.jar:. *.java
```

### Ejecutar

```bash
java -cp mysql-connector-j-8.3.0.jar:. Main
```

Debes ver la salida de las 4 operaciones: CREATE, READ, UPDATE y DELETE.

### Verificar en la base de datos

```bash
mysql -h [endpoint] -u admin -p -e "SELECT * FROM poo_[nombre-proyecto].producto;"
```

Confirma que los cambios del CRUD se reflejan en la tabla.

---

## Paso 10 — Adaptar a conexión local (para la entrega final)

Para la entrega del 03/12, el código debe funcionar contra una base de datos MySQL local. Solo cambia una línea en `ConexionBD.java`:

```java
// Comentar la línea de AWS:
// private static final String HOST = "[endpoint RDS]";

// Descomentar la línea local:
private static final String HOST = "localhost";
```

También ajusta el usuario y contraseña a los de tu MySQL local.

No olvides crear la misma tabla en tu MySQL local antes de probar.

---

## Resumen de comandos

| Acción | Comando |
|--------|---------|
| Instalar Java y Git | `sudo yum install java-17-amazon-corretto-devel git -y` |
| Descargar driver JDBC | `wget https://repo1.maven.org/maven2/com/mysql/mysql-connector-j/8.3.0/mysql-connector-j-8.3.0.jar` |
| Instalar cliente MySQL | `sudo yum install mariadb105 -y` |
| Conectar al RDS | `mysql -h [endpoint] -u admin -p` |
| Ejecutar script SQL | `mysql -h [endpoint] -u admin -p < script.sql` |
| Compilar Java | `javac -cp mysql-connector-j-8.3.0.jar:. *.java` |
| Ejecutar Java | `java -cp mysql-connector-j-8.3.0.jar:. Main` |

---

## Troubleshooting

**VS Code no conecta al EC2:**
- Verifica que la IP pública no haya cambiado (revisa la consola EC2)
- Verifica que el archivo PEM esté en la ruta correcta
- En Windows: revisa los permisos del archivo PEM

**Error de conexión a MySQL:**
- Verifica que el Security Group del RDS permita tráfico en el puerto 3306
- Verifica que el endpoint, usuario y contraseña sean correctos
- Prueba primero con el cliente `mysql` antes de probar con Java

**Error al compilar Java:**
- Verifica que el archivo `mysql-connector-j-8.3.0.jar` esté en el mismo directorio
- Usa `-cp mysql-connector-j-8.3.0.jar:.` tanto al compilar como al ejecutar

**El lab expiró:**
- Reinicia desde Canvas → Start Lab
- La IP del EC2 puede cambiar; actualiza el config SSH
- La clave PEM no cambia
- Java, Git y los archivos se mantienen en el EC2
