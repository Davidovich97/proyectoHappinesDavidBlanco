CREATE DATABASE IF NOT EXISTS Happiness;
USE Happiness;

CREATE TABLE Usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(60) NOT NULL,
    email VARCHAR(60) UNIQUE NOT NULL,
    password VARCHAR(60) NOT NULL
);

CREATE TABLE Eventos (
    id INT AUTO_INCREMENT PRIMARY KEY,
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

CREATE TABLE Imagenes_Galeria (
	id INT AUTO_INCREMENT PRIMARy KEY,
    titulo VARCHAR(80) NOT NULL,
    imagen VARCHAR(100) NOT NULL,
    id_Galeria INT NOT NULL,
    CONSTRAINT fk_galeria_imagen FOREIGN KEY (id_Galeria) REFERENCES Galerias(id) ON DELETE CASCADE


);

CREATE TABLE Favoritos (
	id_Usuario INT NOT NULL,
    id_Evento INT NOT NULL,
	PRIMARY KEY (id_Usuario, id_Evento),
    CONSTRAINT fk_usuario_favorito FOREIGN KEY (id_Usuario) REFERENCES Usuarios(id) ON DELETE CASCADE,
    CONSTRAINT fk_evento_favorito FOREIGN KEY (id_Evento) REFERENCES Eventos(id) ON DELETE CASCADE
);