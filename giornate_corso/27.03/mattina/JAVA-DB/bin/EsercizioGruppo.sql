CREATE DATABASE scuola;

CREATE TABLE
    Materia (
        id_materia INT AUTO_INCREMENT PRIMARY KEY,
        nome VARCHAR(50) NOT NULL
    );

CREATE TABLE
    Classe (
        id_classe INT AUTO_INCREMENT PRIMARY KEY,
        grado INT NOT NULL (grado BETWEEN 1 AND 5), -- check da 1 a 5
        sezione CHAR(1) NOT NULL
    );

CREATE TABLE
    Voto (
        id_voto INT AUTO_INCREMENT PRIMARY KEY,
        valore DECIMAL(2, 2) NOT NULL (valore BETWEEN 1 AND 10), -- check voto da 1 a 10
        id_studente INT NOT NULL,
        id_materia INT NOT NULL,
        FOREIGN KEY (id_studente) REFERENCES Studente (id_studente) ON DELETE CASCADE,
        FOREIGN KEY (id_materia) REFERENCES Materia (id_materia) ON DELETE CASCADE
    );

CREATE TABLE
    Studente (
        id_studente INT AUTO_INCREMENT PRIMARY KEY,
        nome VARCHAR(50) NOT NULL,
        cognome VARCHAR(50) NOT NULL,
        id_classe INT,
        FOREIGN KEY (id_classe) REFERENCES Classe (id_classe) ON DELETE CASCADE
    );

---------------------------------------------------------------------------------------------
-- POPOLAMENTO TABELLE
INSERT INTO
    Materia (nome)
VALUES
    ('Italiano'),
    ('Matematica'),
    ('Storia'),
    ('Inglese'),
    ('Scienze');

INSERT INTO
    Classe (grado, sezione)
VALUES
    (1, 'A'),
    (2, 'A'),
    (3, 'A'),
    (4, 'A'),
    (5, 'A');

INSERT INTO
    Studente (nome, cognome, id_classe)
VALUES
    -- Classe 1
    ('Luca', 'Rossi', 1),
    ('Marco', 'Bianchi', 1),
    ('Giulia', 'Verdi', 1),
    ('Anna', 'Ferrari', 1),
    ('Paolo', 'Romano', 1),
    ('Sara', 'Gallo', 1),
    ('Davide', 'Costa', 1),
    ('Elena', 'Fontana', 1),
    ('Simone', 'Moretti', 1),
    ('Chiara', 'Barbieri', 1),
    -- Classe 2
    ('Luca', 'Riva', 2),
    ('Marco', 'Testa', 2),
    ('Giulia', 'Greco', 2),
    ('Anna', 'Martini', 2),
    ('Paolo', 'Conti', 2),
    ('Sara', 'De Luca', 2),
    ('Davide', 'Marini', 2),
    ('Elena', 'Giordano', 2),
    ('Simone', 'Lombardi', 2),
    ('Chiara', 'Serra', 2),
    -- Classe 3
    ('Luca', 'Fabbri', 3),
    ('Marco', 'Longo', 3),
    ('Giulia', 'Gentile', 3),
    ('Anna', 'Leone', 3),
    ('Paolo', 'Villa', 3),
    ('Sara', 'Grassi', 3),
    ('Davide', 'Silvestri', 3),
    ('Elena', 'Farina', 3),
    ('Simone', 'Caruso', 3),
    ('Chiara', 'Ferraro', 3),
    -- Classe 4
    ('Luca', 'Colombo', 4),
    ('Marco', 'De Santis', 4),
    ('Giulia', 'Rizzo', 4),
    ('Anna', 'Parisi', 4),
    ('Paolo', 'Vitali', 4),
    ('Sara', 'Pellegrini', 4),
    ('Davide', 'Messina', 4),
    ('Elena', 'Orlando', 4),
    ('Simone', 'Gatti', 4),
    ('Chiara', 'Amato', 4),
    -- Classe 5
    ('Luca', 'Fiore', 5),
    ('Marco', 'Cattaneo', 5),
    ('Giulia', 'Bellini', 5),
    ('Anna', 'Sanna', 5),
    ('Paolo', 'Bianco', 5),
    ('Sara', 'Monti', 5),
    ('Davide', 'Marchetti', 5),
    ('Elena', 'Valentini', 5),
    ('Simone', 'Basile', 5),
    ('Chiara', 'Neri', 5);

INSERT INTO
    Voto (valore, id_studente, id_materia)
VALUES
    -- Studente 1
    (8.50, 1, 1),
    (7.00, 1, 2),
    (6.50, 1, 3),
    -- Studente 2
    (9.00, 2, 1),
    (8.00, 2, 2),
    (7.50, 2, 5),
    -- Studente 3 (pochi voti)
    (6.00, 3, 2),
    -- Studente 4 (tutte le materie)
    (7.00, 4, 1),
    (7.50, 4, 2),
    (6.00, 4, 3),
    (8.00, 4, 4),
    (7.00, 4, 5),
    -- Studente 5 (nessun voto → OK)
    -- Studente 6
    (8.00, 6, 3),
    (9.00, 6, 4),
    -- Studente 7
    (5.50, 7, 2),
    (6.50, 7, 3),
    -- Studente 8
    (7.00, 8, 1),
    (7.50, 8, 2),
    (8.00, 8, 3),
    -- Studente 9
    (6.00, 9, 4),
    -- Studente 10
    (9.50, 10, 1),
    (8.50, 10, 5),
    -- Studenti classe 2 (sample)
    (7.00, 11, 1),
    (6.50, 11, 2),
    (8.00, 12, 3),
    (7.50, 12, 4),
    (6.00, 13, 2),
    (9.00, 14, 1),
    (8.50, 14, 2),
    (7.00, 14, 3),
    (7.50, 15, 5),
    -- altri esempi sparsi
    (6.50, 20, 1),
    (7.00, 20, 2),
    (8.00, 25, 3),
    (8.50, 25, 4),
    (5.50, 30, 2),
    (9.00, 35, 1),
    (9.50, 35, 2),
    (8.50, 35, 3),
    (6.00, 40, 4),
    (7.50, 45, 5),
    (8.00, 50, 1),
    (7.00, 50, 2);