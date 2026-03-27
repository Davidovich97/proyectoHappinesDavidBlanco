CREATE DATABASE IF NOT EXISTS Happiness;
USE Happiness;

/*Creación de tablas*/
CREATE TABLE Usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(60) NOT NULL,
    email VARCHAR(60) UNIQUE NOT NULL,
    password VARCHAR(60) NOT NULL
);

CREATE TABLE Eventos (
    id INT PRIMARY KEY,
    fecha DATE NOT NULL,
    titulo VARCHAR(150) NOT NULL,
    ubicacion VARCHAR(80) NOT NULL,
    descripcion VARCHAR(1000)
);
ALTER TABLE Eventos MODIFY id INT NOT NULL; /*Modificamos y eliminamos que los eventos sea autonumerico*/
CREATE TABLE Galerias (
	id INT AUTO_INCREMENT PRIMARY KEY,
	titulo VARCHAR(80) NOT NULL,
    id_Evento INT NOT NULL,
    CONSTRAINT fk_evento_galeria FOREIGN KEY (id_Evento) REFERENCES Eventos(id) ON DELETE CASCADE
);

CREATE TABLE Imagenes_Galeria (
	id INT AUTO_INCREMENT PRIMARy KEY,
    titulo VARCHAR(80) NOT NULL,
    imagen VARCHAR(100) NOT NULL,
    id_Galeria INT NOT NULL,
    CONSTRAINT fk_galeria_imagen FOREIGN KEY (id_Galeria) REFERENCES Galerias(id) ON DELETE CASCADE


);
RENAME TABLE Imagenes_Galeria TO Imagenes_Galerias; /*Renombramos la tabla para ponerla en plural*/

CREATE TABLE Favoritos (
	id_Usuario INT NOT NULL,
    id_Evento INT NOT NULL,
	PRIMARY KEY (id_Usuario, id_Evento),
    CONSTRAINT fk_usuario_favorito FOREIGN KEY (id_Usuario) REFERENCES Usuarios(id) ON DELETE CASCADE,
    CONSTRAINT fk_evento_favorito FOREIGN KEY (id_Evento) REFERENCES Eventos(id) ON DELETE CASCADE
);

/*Insertamos los 3 Usuarios en su tabla*/
INSERT INTO Usuarios (id, nombre, email, password) VALUES 
(1, 'Juanito Blanco', 'primerusuario@gmail.com', '1234'),
(2, 'Elena Martínez', 'elena.mtnez@gmail.com', 'elena2026'),
(3, 'Carlos Terol', 'c.terol@outlook.com', 'charli99');


/*Insertamos los eventos que habiamos puesto en la clase main de Java para poder ejecutar los case del menú, empieza en 0
porque el de jave empieza en 0*/
INSERT INTO Eventos (id, fecha, titulo, ubicacion, descripcion) VALUES 
(0, '2026-01-01', 'Concierto Año Nuevo', 'Teatro Real', 'Música clásica'),
(1, '2026-01-12', 'Cine de Invierno', 'Cines Callao', 'Ciclo de cine'),
(2, '2026-01-24', 'Expo Arte', 'Museo Prado', 'Arte moderno'),
(3, '2026-06-05', 'Festival Rock', 'Estadio', 'Rock al aire libre'),
(4, '2026-06-15', 'Teatro Verano', 'Plaza Mayor', 'Comedia'),
(5, '2026-06-25', 'Danza Moderna', 'Auditorio', 'Espectáculo danza');
