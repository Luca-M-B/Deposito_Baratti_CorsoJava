CREATE DATABASE circolo_sportivo;
USE circolo_sportivo;


CREATE TABLE iscritto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    cognome VARCHAR(50),
    email VARCHAR(100),
    telefono VARCHAR(20)
);

CREATE TABLE insegnante (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    cognome VARCHAR(50)
);

CREATE TABLE corso (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100)
);

CREATE TABLE giorno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(20)
);

CREATE TABLE iscrizione (
    id_iscritto INT,
    id_corso INT,
    data_iscrizione DATE,

    PRIMARY KEY (id_iscritto, id_corso),

    FOREIGN KEY (id_iscritto) REFERENCES iscritto(id),
    FOREIGN KEY (id_corso) REFERENCES corso(id)
);

CREATE TABLE planning (
    id_corso INT,
    id_giorno INT,
    id_insegnante INT,
    orario TIME,

    PRIMARY KEY (id_corso, id_giorno, id_insegnante, orario),

    FOREIGN KEY (id_corso) REFERENCES corso(id),
    FOREIGN KEY (id_giorno) REFERENCES giorno(id),
    FOREIGN KEY (id_insegnante) REFERENCES insegnante(id)
);


INSERT INTO iscritto (nome, cognome, email, telefono) VALUES
('Mario', 'Rossi', 'mario.rossi@email.it', '3331234567'),
('Laura', 'Bianchi', 'laura.b@email.com', '3479876543'),
('Luca', 'Verdi', 'luca.verdi@provider.it', '3201122334'),
('Giulia', 'Neri', 'g.neri@gmail.com', '3395566778'),
('Marco', 'Gialli', 'm.gialli@libero.it', '3450001122');

INSERT INTO insegnante (nome, cognome) VALUES
('Roberto', 'Santi'),
('Elena', 'Rizzo'),
('Fabio', 'Valli'),
('Sara', 'Monti'),
('Paolo', 'Bruni');

INSERT INTO corso (nome) VALUES
('Yoga'),
('Crossfit'),
('Pilates'),
('Nuoto'),
('Tennis'),
('Sala_pesi');

INSERT INTO giorno (nome) VALUES
('Lunedì'),
('Martedì'),
('Mercoledì'),
('Giovedì'),
('Venerdì'),
('Sabato'),
('Domenica');


INSERT INTO iscrizione (id_iscritto, id_corso, data_iscrizione) VALUES
(1, 1, '2024-01-10'),
(2, 1, '2024-01-12'),
(3, 2, '2024-01-15'),
(4, 3, '2024-01-20'),
(5, 5, '2024-01-25');

INSERT INTO planning (id_corso, id_giorno, id_insegnante, orario) VALUES
(1, 1, 1, '09:00:00'),
(2, 2, 2, '18:30:00'),
(3, 3, 3, '10:00:00'),
(4, 4, 4, '15:00:00'),
(5, 5, 5, '17:00:00');

SELECT c.nome AS Corso, g.nome AS Giorno, p.orario, i.cognome AS Insegnante
FROM planning p
JOIN corso c ON p.id_corso = c.id
JOIN giorno g ON p.id_giorno = g.id
JOIN insegnante i ON p.id_insegnante = i.id;