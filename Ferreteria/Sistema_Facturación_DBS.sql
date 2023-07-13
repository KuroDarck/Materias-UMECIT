-- Eliminación de la Base de Datos si Existe
DROP DATABASE IF EXISTS Sistema_Facturación;

-- Creación de la base de Datos
CREATE DATABASE Sistema_Facturación CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci;

-- Utilización de la base de datos
USE Sistema_Facturación;

-- Tabla 1
CREATE TABLE tcategorias (
  cod_categoria INT NOT NULL AUTO_INCREMENT,
  txt_desc_categoria VARCHAR(255) NOT NULL,
  PRIMARY KEY (cod_categoria)
);

-- Tabla 2
CREATE TABLE tproductos (
  cod_producto INT NOT NULL AUTO_INCREMENT,
  cod_categoria INT,
  txt_desc_producto VARCHAR(255),
  cod_marca INT,
  fecha_fabricacion DATE,
  fecha_expiracion DATE,
  nro_lote VARCHAR(50),
  codigo_barra VARCHAR(50),
  PRIMARY KEY (cod_producto),
  FOREIGN KEY (cod_categoria) REFERENCES tcategorias(cod_categoria)
);

-- Tabla 3
CREATE TABLE Factura_detalle (
  nro_factura INT NOT NULL AUTO_INCREMENT,
  cod_categoria INT NOT NULL,
  cod_producto INT NOT NULL,
  imp_precio_preliminar NUMERIC(18,2) NOT NULL,
  imp_impuestos NUMERIC(18,2) NOT NULL,
  imp_recargo NUMERIC(18,2) NOT NULL,
  imp_descuento NUMERIC(18,2) NOT NULL,
  imp_total_pagar NUMERIC(18,2) NOT NULL,
  PRIMARY KEY (nro_factura),
  FOREIGN KEY (cod_categoria) REFERENCES tcategorias(cod_categoria),
  FOREIGN KEY (cod_producto) REFERENCES tproductos(cod_producto)
);

-- Tabla 4
CREATE TABLE Factura_Header (
  cod_cliente INT NOT NULL AUTO_INCREMENT,
  nro_factura INT,
  imp_precio_preliminar NUMERIC(18,2) NOT NULL,
  imp_impuestos NUMERIC(18,2) NOT NULL,
  imp_recargo NUMERIC(18,2) NOT NULL,
  imp_descuento NUMERIC(18,2) NOT NULL,
  PRIMARY KEY (cod_cliente),
  FOREIGN KEY (nro_factura) REFERENCES Factura_detalle(nro_factura)
);

-- Insertar datos ficticios en las tablas
-- Insertar datos en tcategorias
INSERT INTO tcategorias (txt_desc_categoria) VALUES
  ('Electrónica'),
  ('Ropa'),
  ('Hogar'),
  ('Alimentación'),
  ('Belleza'),
  ('Juguetes'),
  ('Deportes'),
  ('Libros'),
  ('Mascotas'),
  ('Automóviles');
  
  -- Insertar datos en tproductos
INSERT INTO tproductos (cod_categoria, txt_desc_producto, cod_marca, fecha_fabricacion, fecha_expiracion, nro_lote, codigo_barra) VALUES
  (1, 'Producto 1', 123, '2022-01-01', '2022-12-31', 'L123', '123456789012'),
  (2, 'Producto 2', 456, '2022-02-01', '2022-12-31', 'L456', '234567890123'),
  (3, 'Producto 3', 789, '2022-03-01', '2022-12-31', 'L789', '345678901234'),
  (4, 'Producto 4', 101, '2022-04-01', '2022-12-31', 'L101', '456789012345'),
  (5, 'Producto 5', 222, '2022-05-01', '2022-12-31', 'L222', '567890123456'),
  (6, 'Producto 6', 333, '2022-06-01', '2022-12-31', 'L333', '678901234567'),
  (7, 'Producto 7', 444, '2022-07-01', '2022-12-31', 'L444', '789012345678'),
  (8, 'Producto 8', 555, '2022-08-01', '2022-12-31', 'L555', '890123456789'),
  (9, 'Producto 9', 666, '2022-09-01', '2022-12-31', 'L666', '901234567890'),
  (10, 'Producto 10', 777, '2022-10-01', '2022-12-31', 'L777', '012345678901');
  
 -- Datos para la tabla Factura_detalle
INSERT INTO Factura_detalle (cod_categoria, cod_producto, imp_precio_preliminar, imp_impuestos, imp_recargo, imp_descuento, imp_total_pagar) VALUES
(1, 1, 1000.00, 150.00, 0.10, 100.00, 1050.00),
(2, 2, 50.00, 7.50, 0.99, 5.00, 52.50),
(3, 3, 10.00, 1.50, 0.99, 1.00, 11.50),
(4, 4, 200.00, 30.00, 2.00, 20.00, 210.00),
(5, 5, 30.00, 4.50, 0.99, 0.80, 34.50),
(6, 6, 20.00, 3.00, 0.99, 2.00, 21.00),
(7, 7, 50.00, 7.50, 0.99, 0.70, 57.50),
(8, 8, 15.00, 2.25, 0.90, 1.00, 16.25),
(9, 9, 25.00, 3.75, 0.90, 3.00, 28.75),
(10, 10, 50.00, 7.50, 1.00, 5.00, 52.50);

-- Datos para la tabla Factura_Header
INSERT INTO Factura_Header (nro_factura, imp_precio_preliminar, imp_impuestos, imp_recargo, imp_descuento) VALUES
(1, 1050.00, 157.50, 1.34, 105.00),
(2, 52.50, 7.88, 1.00, 5.25),
(3, 11.50, 1.73, 0.90, 1.20),
(4, 210.00, 31.50, 2.00, 21.00),
(5, 34.50, 5.18, 0.89, 3.40),
(6, 21.00, 3.15, 0.97, 2.10),
(7, 57.50, 8.63, 1.80, 1.00),
(8, 16.25, 2.44, 1.50, 1.63),
(9, 28.75, 4.31, 0.98, 1.90),
(10, 52.50, 7.88, 2.50, 5.25);
  

