-- ============================================
-- Script SQL — Taller Integrador POO + AWS
-- Base de datos: poo_cafeteria
-- ============================================

USE poo_cafeteria;

-- Tabla Producto: entidad principal del dominio Cafetería
CREATE TABLE IF NOT EXISTS producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio INT NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    stock INT NOT NULL DEFAULT 0
);

-- Datos de prueba
INSERT INTO producto (nombre, precio, categoria, stock) VALUES
    ('Café Americano', 1500, 'Bebida caliente', 50),
    ('Cappuccino', 2200, 'Bebida caliente', 30),
    ('Jugo Natural', 1800, 'Bebida fría', 20),
    ('Sándwich Italiano', 3500, 'Comida', 15),
    ('Muffin Chocolate', 1200, 'Repostería', 25);
