
DROP TABLE IF EXISTS cliente_direccion;
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS cod_pos;

--
-- TABLE: cod_pos
--
--

CREATE TABLE cod_pos (
  cp INT PRIMARY KEY,
  localidad VARCHAR(120) NOT NULL
);


--
-- TABLE: clientes
--
--
CREATE TABLE cliente (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(40) NOT NULL ,
  apellidos VARCHAR(100) NOT NULL ,
  dni INT NOT NULL
);


--
-- TABLE: cliente_direccion
--
--

CREATE TABLE cliente_direccion (
  id_direccion INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100),
  id_cliente int REFERENCES cliente(id) ON UPDATE CASCADE ON DELETE CASCADE,
  nombre_via VARCHAR(150) NOT NULL ,
  cp int REFERENCES cod_pos(cp) ON UPDATE CASCADE ON DELETE SET NULL
);


INSERT INTO `cliente` (`id`, `nombre`, `apellidos`, `dni`) VALUES
(1, 'Pepe', 'Perez Martinez', 12345678),
(2, 'Miguel Angel', 'Gutierrez Garcia', 87654321)
(3, 'Juan', 'Sin Miedo', 11223344);

INSERT INTO `cod_pos` (`cp`, `localidad`) VALUES
(23005, 'Jaén'),
(23008, 'Jaén'),
(29000, 'Málaga');

INSERT INTO `cliente_direccion` (`nombre`, `id_direccion`, `id_cliente`, `nombre_via`, `cp`) VALUES
('Mi casa', 1, 1, 'Paseo de la Estación 44', 23008),
('Casa', 2, 2, 'Rue del Percebe 13', 23005),
('Playa', 3, 2, 'Rue del Percebe 13', 29000),
('Oficina', 1, 3, 'Avenida de Andalucia S/N', 29000);

