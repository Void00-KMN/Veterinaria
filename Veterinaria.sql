----------------------------------------------
--               Veterinaria                --
----------------------------------------------

----Ejecuta cada bloque de forma consecutiva--

----------------
-->  Tablas  <--
----------------

--<Las entidades del sistema

CREATE TABLE clientes (
    id_cliente NUMBER(20) CONSTRAINT pk_cliente PRIMARY KEY,
    nombres VARCHAR2(30),
    apellidos VARCHAR2(30),
    telefono NUMBER(15),
    direccion VARCHAR2(30),
    dni NUMBER(8) UNIQUE
);

CREATE TABLE veterinarios (
    id_veterinario NUMBER(20) CONSTRAINT pk_veterinario PRIMARY KEY,
    nombres VARCHAR2(30),
    apellidos VARCHAR2(30),
    telefono NUMBER(15),
    direccion VARCHAR2(30),
    dni NUMBER(8) UNIQUE,
    sueldo NUMBER(8,2),
    cargo VARCHAR(30)
);

CREATE TABLE productos(
    id_producto NUMBER(20) CONSTRAINT pk_producto PRIMARY KEY,
    producto VARCHAR2(35),
    marca VARCHAR2(30),
    precio NUMBER(8,2),
    categoria VARCHAR(20)
);

CREATE TABLE mascotas_adopcion(
    id_mascota_adopcion NUMBER(20) CONSTRAINT pk_mascota_adopcion PRIMARY KEY,
    nombre VARCHAR2(30),
    especie VARCHAR2(15),
    raza VARCHAR2(25),
    edad NUMBER(2)
);

CREATE TABLE adopciones(
    id_adopcion NUMBER(20) CONSTRAINT pk_adopcion PRIMARY KEY,
    fecha_adopcion DATE DEFAULT (SYSDATE),
    id_cliente NUMBER(20),
    id_mascota_adopcion NUMBER(20),
    CONSTRAINT fk_cliente_adopciones FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
    CONSTRAINT fk_mascota_adopcion_adopciones FOREIGN KEY (id_mascota_adopcion) REFERENCES mascotas_adopcion(id_mascota_adopcion)
);

CREATE TABLE ventas(
    id_venta NUMBER(20) CONSTRAINT pk_venta PRIMARY KEY,
    fecha_venta DATE DEFAULT(SYSDATE),
    cantidad NUMBER(6),
    subtotal NUMBER(12,2),
    igv NUMBER(12,2), 
    total NUMBER(12,2),
    id_cliente NUMBER(20),
    id_producto NUMBER(20),
    CONSTRAINT fk_clientes_ventas FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
    CONSTRAINT fk_productos_ventas FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

CREATE TABLE mascotas (
    id_mascota NUMBER(20) CONSTRAINT pk_mascota PRIMARY KEY,
    nombre VARCHAR2(30),
    especie VARCHAR2(15),
    raza VARCHAR2(20),
    edad NUMBER(3),
    id_cliente NUMBER(20),
    CONSTRAINT fk_cliente_mascotas FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);

CREATE TABLE servicios (
    id_servicio NUMBER(20) PRIMARY KEY,
    fecha_servicio VARCHAR(20) DEFAULT(sysdate),
    tipo_servicio VARCHAR(20),
    id_mascota NUMBER(20),
    id_cliente NUMBER(20),
    id_veterinario NUMBER(20),
    CONSTRAINT fk_mascota_servicios FOREIGN KEY (id_mascota) REFERENCES mascotas(id_mascota),
    CONSTRAINT fk_cliente_servicios FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
    CONSTRAINT fk_veterinario_servicios FOREIGN KEY (id_veterinario) REFERENCES veterinarios(id_veterinario)
);
-------------------------------
-->  Secuencias y Triggers  <--
-------------------------------
--< Secuencias incrementales que se usaran en los id de cada tabla
--<Triggers que se ejecutan cuando se realiza un insert en cada tabla
--<Ejecute por cada tabla>--

--Clientes
CREATE SEQUENCE sq_clientes_id
                START WITH 1
                INCREMENT BY 1
                MAXVALUE 1000000
                NOCYCLE
                NOCACHE;

CREATE OR REPLACE TRIGGER trg_clientes_id
BEFORE INSERT ON clientes
FOR EACH ROW
BEGIN
    SELECT sq_clientes_id.NEXTVAL INTO :NEW.id_cliente FROM DUAL;
END;
---------------
--Veterinarios
CREATE SEQUENCE sq_veterinarios_id
                START WITH 1
                INCREMENT BY 1
                MAXVALUE 1000000
                NOCYCLE
                NOCACHE;

CREATE OR REPLACE TRIGGER trg_veterinarios_id
BEFORE INSERT ON veterinarios
FOR EACH ROW
BEGIN
    SELECT sq_veterinarios_id.NEXTVAL INTO :NEW.id_veterinario FROM DUAL;
END;
----------------
--Productos
CREATE SEQUENCE sq_productos_id
                START WITH 1
                INCREMENT BY 1
                MAXVALUE 1000000
                NOCYCLE
                NOCACHE;

CREATE OR REPLACE TRIGGER trg_productos_id
BEFORE INSERT ON productos
FOR EACH ROW
BEGIN
    SELECT sq_productos_id.NEXTVAL INTO :NEW.id_producto FROM DUAL;
END;
---------------
--Mascoptas_Adopcion
CREATE SEQUENCE sq_mascotas_adopcion_id
                START WITH 1
                INCREMENT BY 1
                MAXVALUE 1000000
                NOCYCLE
                NOCACHE;

CREATE OR REPLACE TRIGGER trg_mascotas_adopcion_id
BEFORE INSERT ON mascotas_adopcion
FOR EACH ROW
BEGIN
    SELECT sq_mascotas_adopcion_id.NEXTVAL INTO :NEW.id_mascota_adopcion FROM DUAL;
END;
--------------
--Adopciones
CREATE SEQUENCE sq_adopciones_id
                START WITH 1
                INCREMENT BY 1
                MAXVALUE 1000000
                NOCYCLE
                NOCACHE;

CREATE OR REPLACE TRIGGER trg_adopciones_id
BEFORE INSERT ON adopciones
FOR EACH ROW
BEGIN
    SELECT sq_adopciones_id.NEXTVAL INTO :NEW.id_adopcion FROM DUAL;
END;
---------------
--Ventas
CREATE SEQUENCE sq_ventas_id
                START WITH 1
                INCREMENT BY 1
                MAXVALUE 1000000
                NOCYCLE
                NOCACHE;

CREATE OR REPLACE TRIGGER trg_ventas_id
BEFORE INSERT ON ventas
FOR EACH ROW
BEGIN
    SELECT sq_ventas_id.NEXTVAL INTO :NEW.id_venta FROM DUAL;
END;
-----------------
--Mascotas
CREATE SEQUENCE sq_mascotas_id
                START WITH 1
                INCREMENT BY 1
                MAXVALUE 1000000
                NOCYCLE
                NOCACHE;

CREATE OR REPLACE TRIGGER trg_mascotas_id
BEFORE INSERT ON mascotas
FOR EACH ROW
BEGIN
    SELECT sq_mascotas_id.NEXTVAL INTO :NEW.id_mascota FROM DUAL;
END;
---------------
--Servicios
CREATE SEQUENCE sq_servicios_id
                START WITH 1
                INCREMENT BY 1
                MAXVALUE 1000000
                NOCYCLE
                NOCACHE;

CREATE OR REPLACE TRIGGER trg_servicios_id
BEFORE INSERT ON servicios
FOR EACH ROW
BEGIN
    SELECT sq_servicios_id.NEXTVAL INTO :NEW.id_servicio FROM DUAL;
END;

------------------------------------
-->  Procedimientos Almacenados  <--
------------------------------------
--< Procedimientos para insertar registros usando subconsultas >--
--< Ejecute por cada tabla >--

--Mascotas
CREATE OR REPLACE PROCEDURE proc_insertar_mascotas(
    nombre_m IN VARCHAR2,
    especie_m IN VARCHAR2,
    raza_m IN VARCHAR2,
    edad_m IN NUMBER,
    dni_c IN NUMBER)
AS
BEGIN
    INSERT INTO mascotas(nombre, especie, raza, edad, id_cliente)
    VALUES (nombre_m, especie_m, raza_m, edad_m,
           (SELECT id_cliente
            FROM clientes
            WHERE dni=dni_c));
    COMMIT;
END proc_insertar_mascotas;
----------------------
--Ventas
CREATE OR REPLACE PROCEDURE proc_insertar_ventas(
    dni_c IN NUMBER,
    codigo_p IN VARCHAR2,
    cantidad_v IN NUMBER)
AS
BEGIN
    INSERT INTO ventas(id_cliente, id_producto, cantidad, subtotal, igv, total)
    VALUES ((SELECT id_cliente
            FROM clientes
            WHERE dni=dni_c),
           (SELECT id_producto
            FROM productos
            WHERE id_producto=codigo_p),
            cantidad_v,
           (SELECT precio*cantidad_v
            FROM productos
            WHERE id_producto=codigo_p),
           (SELECT (precio*cantidad_v)*0.18
            FROM productos
            WHERE id_producto=codigo_p),
            (SELECT (precio*cantidad_v)+((precio*cantidad_v)*0.18)
            FROM productos
            WHERE id_producto=codigo_p));
    COMMIT;
END proc_insertar_ventas;
----------------------
--Adopciones
CREATE OR REPLACE PROCEDURE proc_insertar_adopciones(
    dni_c IN VARCHAR2,
    idmascota_a IN VARCHAR2)
AS
BEGIN
    INSERT INTO adopciones(id_cliente, id_mascota_adopcion)
    VALUES((SELECT id_cliente
            FROM clientes
            WHERE dni=dni_c),
           (SELECT id_mascota_adopcion
            FROM mascotas_adopcion
            WHERE id_mascota_adopcion=idmascota_a
            FETCH FIRST ROW ONLY));
    COMMIT;
END proc_insertar_adopciones;
----------------------
--Servicios
CREATE OR REPLACE PROCEDURE proc_insertar_servicios(
    tipo IN VARCHAR2,
    dni_c IN NUMBER,
    codigo_m IN NUMBER,
    codigo_v IN NUMBER)
AS
BEGIN 
    INSERT INTO servicios(tipo_servicio, id_cliente, id_mascota, id_veterinario)
    VALUES (tipo, 
           (SELECT id_cliente
            FROM clientes
            WHERE dni=dni_c),
           codigo_m, codigo_v);
    COMMIT;
END proc_insertar_servicios;

------------------------------------
-->            Vistas            <--
------------------------------------
--< Vistas para la muestra de registros de tablas unidas >--
--< Las vistas se actualizan automaticamente >--
--< Ejecutar todo junto >--

--Adopcion
CREATE OR REPLACE VIEW v_consultar_adopciones AS
SELECT a.id_adopcion, m.nombre, m.especie,
    a.fecha_adopcion,                                                           
    c.nombres, c.apellidos, c.dni
FROM adopciones a
JOIN mascotas_adopcion m
ON a.id_mascota_adopcion=m.id_mascota_adopcion
JOIN clientes c
ON a.id_cliente=c.id_cliente;
------------
--Ventas
CREATE OR REPLACE VIEW v_consultar_ventas AS
SELECT v.id_venta, v.fecha_venta, c.dni, c.nombres, p.producto, p.marca,
    p.precio, v.cantidad, v.subtotal, v.igv, v.total
FROM 
    ventas v
JOIN clientes c ON c.id_cliente=v.id_cliente
JOIN productos p ON p.id_producto=v.id_producto;
----------
--Mascotas
CREATE OR REPLACE VIEW v_consultar_mascotas AS
SELECT m.id_mascota, m.especie, m.nombre, m.edad,
    c.nombres, c.apellidos, c.dni, c.telefono
FROM mascotas m
JOIN clientes c ON m.id_cliente=c.id_cliente;
----------
--Servicios
CREATE OR REPLACE VIEW v_consultar_servicios AS
SELECT s.id_servicio, s.fecha_servicio, s.tipo_servicio,
    m.nombre, c.nombres, c.apellidos, c.telefono,
    v.nombres v_nombres, v.apellidos v_apellidos
FROM servicios s
JOIN mascotas m ON m.id_mascota=s.id_mascota
JOIN clientes c ON c.id_cliente=s.id_cliente
JOIN veterinarios v ON v.id_veterinario=s.id_veterinario;

------------------------------------
-->            Extra             <--
------------------------------------
---Drops
----------------------------------
DROP TABLE servicios;
DROP TABLE mascotas;
DROP TABLE ventas;
DROP TABLE adopciones;
DROP TABLE mascotas_adopcion;
DROP TABLE productos;
DROP TABLE veterinarios;
DROP TABLE clientes;

DROP SEQUENCE sq_servicios_id;
DROP SEQUENCE sq_mascotas_id;
DROP SEQUENCE sq_ventas_id;
DROP SEQUENCE sq_adopciones_id;
DROP SEQUENCE sq_mascotas_adopcion_id;
DROP SEQUENCE sq_productos_id;
DROP SEQUENCE sq_veterinarios_id;
DROP SEQUENCE sq_clientes_id;

DROP TRIGGER trg_servicios_id;
DROP TRIGGER trg_mascotas_id;
DROP TRIGGER trg_ventas_id;
DROP TRIGGER trg_adopciones_id;
DROP TRIGGER trg_mascotas_adopcion_id;
DROP TRIGGER trg_productos_id;
DROP TRIGGER trg_veterinarios_id;
DROP TRIGGER trg_clientes_id;

DROP PROCEDURE proc_insertar_mascotas;
DROP PROCEDURE proc_insertar_ventas;
DROP PROCEDURE proc_insertar_adopciones;
DROP PROCEDURE proc_insertar_servicios;

DROP VIEW v_consultar_adopciones;
DROP VIEW v_consultar_ventas;
DROP VIEW v_consultar_mascotas;
DROP VIEW v_consultar_servicios;
-----------------------------------