-- Renombrar la base de datos
CREATE DATABASE IF NOT EXISTS nachdb;

-- Copiar datos de imsysdb a nachdb (asumiendo que están en el mismo servidor)
-- Este proceso debe hacerse tabla por tabla para mantener las relaciones

-- Ejemplo para la tabla USUARIO:
INSERT INTO nachdb.USUARIO 
SELECT * FROM imsysdb.USUARIO;

-- Actualizar referencias en las tablas
ALTER TABLE nachdb.USUARIO
RENAME COLUMN imsys_id TO nach_id;

-- Actualizar nombres de secuencias si existen
ALTER TABLE nachdb.USUARIO
MODIFY COLUMN id BIGINT AUTO_INCREMENT;