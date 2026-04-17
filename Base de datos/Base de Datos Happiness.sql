CREATE DATABASE IF NOT EXISTS Happiness;
USE Happiness;

/*Creacion de tablas*/



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

CREATE TABLE Galerias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(80) NOT NULL,
    id_Evento INT NOT NULL,
    CONSTRAINT fk_evento_galeria FOREIGN KEY (id_Evento) REFERENCES Eventos(id) ON DELETE CASCADE
);

CREATE TABLE Imagenes_Galerias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(80) NOT NULL,
    imagen VARCHAR(100) NOT NULL,
    id_Galeria INT NOT NULL,
    CONSTRAINT fk_galeria_imagen FOREIGN KEY (id_Galeria) REFERENCES Galerias(id) ON DELETE CASCADE
);

CREATE TABLE Favoritos (
    correo_usuario VARCHAR(60) NOT NULL,
    id_Evento INT NOT NULL,
    PRIMARY KEY (correo_usuario, id_Evento),
    CONSTRAINT fk_email_usuario_favorito FOREIGN KEY (correo_usuario) REFERENCES Usuarios(email) ON DELETE CASCADE,
    CONSTRAINT fk_evento_favorito FOREIGN KEY (id_Evento) REFERENCES Eventos(id) ON DELETE CASCADE
);


/*Insercción de datos*/

INSERT INTO Usuarios (nombre, email, password) VALUES 
('Juanito Blanco', 'primerusuario@gmail.com', '1234'),
('Elena Martínez', 'elena.mtnez@gmail.com', 'elena2026'),
('Carlos Terol', 'c.terol@outlook.com', 'charli99');

INSERT INTO Eventos (id, fecha, titulo, ubicacion, descripcion) VALUES 
(0, '2026-01-01', 'Concierto de Año Nuevo OSPA', 'Auditorio Príncipe Felipe, Oviedo', 'Concierto de la Orquesta Sinfónica del Principado de Asturias.'),
(1, '2026-01-12', 'Ciclo de Cine Clásico', 'Centro Niemeyer, Avilés', 'Proyección de grandes clásicos en versión original subtitulada.'),
(2, '2026-01-24', 'Expo: Tesoros de la mar', 'Museo del Jurásico (MUJA), Colunga', 'Exposición temporal sobre fósiles marinos hallados en la costa asturiana.'),
(3, '2026-06-05', 'Metrópoli Gijón Preview', 'Recinto Ferial de Gijón', 'Avance del festival de cultura pop y entretenimiento.'),
(4, '2026-06-15', 'Teatro: Comedia en el Campoamor', 'Teatro Campoamor, Oviedo', 'Obra de teatro humorística con actores locales.'),
(5, '2026-06-25', 'Noche de Danza en el Puerto', 'Puerto Deportivo, Gijón', 'Espectáculo de danza contemporánea frente al mar.');


INSERT INTO Galerias (titulo, id_Evento) VALUES 
('Fotos Concierto Oviedo', 0),
('Capturas Ciclo Niemeyer', 1),
('Imágenes Expo Marítima', 2);

INSERT INTO Imagenes_Galerias (titulo, imagen, id_Galeria) VALUES 
('Violines OSPA', 'ospa1.jpg', 1), 
('Director de Orquesta', 'ospa2.jpg', 1), 
('Público Auditorio', 'ospa3.jpg', 1),
('Entrada Niemeyer', 'cine_aviles1.jpg', 2), 
('Sala Proyección', 'cine_aviles2.jpg', 2),
 ('Cartel Ciclo', 'cine_aviles3.jpg', 2),
('Fósil Ammonite', 'muja1.jpg', 3), 
('Réplica Dinosaurio', 'muja2.jpg', 3),
 ('Costa de Colunga', 'muja3.jpg', 3);
 


INSERT INTO Favoritos (correo_usuario, id_Evento) VALUES 
('primerusuario@gmail.com', 0), ('primerusuario@gmail.com', 1), ('primerusuario@gmail.com', 3),
('elena.mtnez@gmail.com', 1), ('elena.mtnez@gmail.com', 2), ('elena.mtnez@gmail.com', 4),
('c.terol@outlook.com', 0), ('c.terol@outlook.com', 2), ('c.terol@outlook.com', 5);

/*VISTAS*/

CREATE VIEW Vista_Galerias_Pasadas AS
SELECT Galerias.* FROM Galerias
JOIN Eventos ON Galerias.id_Evento = Eventos.id
WHERE Eventos.fecha < '2026-02-28';

-- Todos los eventos favoritos del primer usuario
CREATE VIEW Vista_Favoritos_Juanito AS
SELECT Eventos.* FROM Eventos
JOIN Favoritos ON Eventos.id = Favoritos.id_Evento
WHERE Favoritos.correo_usuario = 'primerusuario@gmail.com';

-- Todas las imágenes del evento del 12-01-2026
CREATE VIEW Vista_Imagenes_Cine AS
SELECT Imagenes_Galerias.* FROM Imagenes_Galerias
JOIN Galerias ON Imagenes_Galerias.id_Galeria = Galerias.id
WHERE Galerias.id_Evento = 1;

-- Eventos favoritos del usuario 2 posteriores al 28-02-2026
CREATE VIEW Vista_Favoritos_Futuros_Elena AS
SELECT Eventos.* FROM Eventos
JOIN Favoritos ON Eventos.id = Favoritos.id_Evento
WHERE Favoritos.correo_usuario = 'elena.mtnez@gmail.com' 
AND Eventos.fecha > '2026-02-28';