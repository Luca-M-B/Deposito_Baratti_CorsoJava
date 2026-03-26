-- DATABASE MUSIC --
DROP DATABASE IF EXISTS festival_musicale;

CREATE DATABASE festival_musicale;

USE festival_musicale;

-- Palchi
CREATE TABLE
    Palco (
        id_palco INT AUTO_INCREMENT PRIMARY KEY,
        nome VARCHAR(100) NOT NULL UNIQUE,
        capienza INT NOT NULL CHECK (capienza > 0),
        tipo ENUM (
            'principale',
            'secondario',
            'acustico',
            'elettronico'
        ) NOT NULL,
        copertura ENUM ('aperto', 'coperto') NOT NULL DEFAULT 'aperto'
    );

-- Artisti (singoli o band)
CREATE TABLE
    Artista (
        id_artista INT AUTO_INCREMENT PRIMARY KEY,
        nome VARCHAR(150) NOT NULL,
        tipo ENUM ('singolo', 'band') NOT NULL,
        genere VARCHAR(80),
        nazionalita VARCHAR(80),
        cachet DECIMAL(10, 2) NOT NULL CHECK (cachet >= 0)
    );

-- Performance
CREATE TABLE
    Performance (
        id_performance INT AUTO_INCREMENT PRIMARY KEY,
        id_artista INT NOT NULL,
        id_palco INT NOT NULL,
        data_esibizione DATE NOT NULL,
        ora_inizio TIME NOT NULL,
        ora_fine TIME NOT NULL,
        durata_min INT GENERATED ALWAYS AS (TIMESTAMPDIFF (MINUTE, ora_inizio, ora_fine)) STORED,
        CONSTRAINT fk_perf_artista FOREIGN KEY (id_artista) REFERENCES Artista (id_artista) ON DELETE CASCADE,
        CONSTRAINT fk_perf_palco FOREIGN KEY (id_palco) REFERENCES Palco (id_palco) ON DELETE RESTRICT,
        CONSTRAINT chk_orario CHECK (ora_fine > ora_inizio)
    );

-- Spettatori
CREATE TABLE
    Spettatore (
        id_spettatore INT AUTO_INCREMENT PRIMARY KEY,
        nome VARCHAR(100) NOT NULL,
        cognome VARCHAR(100) NOT NULL,
        email VARCHAR(150) NOT NULL UNIQUE,
        telefono VARCHAR(20),
        data_nascita DATE
    );

-- Biglietti
CREATE TABLE
    Biglietto (
        id_biglietto INT AUTO_INCREMENT PRIMARY KEY,
        id_performance INT NOT NULL,
        id_spettatore INT NOT NULL,
        prezzo DECIMAL(8, 2) NOT NULL CHECK (prezzo >= 0),
        tipo_posto ENUM ('standard', 'vip', 'golden_circle') NOT NULL DEFAULT 'standard',
        CONSTRAINT fk_big_performance FOREIGN KEY (id_performance) REFERENCES Performance (id_performance) ON DELETE CASCADE,
        CONSTRAINT fk_big_spettatore FOREIGN KEY (id_spettatore) REFERENCES Spettatore (id_spettatore) ON DELETE CASCADE,
        CONSTRAINT uq_big UNIQUE (id_performance, id_spettatore)
    );

-- Pagamenti
CREATE TABLE
    Pagamento (
        id_pagamento INT AUTO_INCREMENT PRIMARY KEY,
        id_biglietto INT NOT NULL UNIQUE,
        importo DECIMAL(8, 2) NOT NULL CHECK (importo >= 0),
        metodo ENUM ('carta', 'contanti', 'bonifico', 'paypal') NOT NULL,
        data_pagamento DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
        stato ENUM ('completato', 'in_attesa', 'fallito') NOT NULL DEFAULT 'completato',
        CONSTRAINT fk_pag_biglietto FOREIGN KEY (id_biglietto) REFERENCES Biglietto (id_biglietto) ON DELETE CASCADE
    );

-- Sponsor
CREATE TABLE
    Sponsor (
        id_sponsor INT AUTO_INCREMENT PRIMARY KEY,
        nome VARCHAR(150) NOT NULL UNIQUE,
        settore VARCHAR(100),
        budget DECIMAL(12, 2) CHECK (budget >= 0),
        contatto VARCHAR(150)
    );

-- Sponsorizzazioni (Sponsor - Performance N-M)
CREATE TABLE
    Sponsorizzazione (
        id_sponsor INT NOT NULL,
        id_performance INT NOT NULL,
        importo DECIMAL(10, 2) NOT NULL CHECK (importo > 0),
        PRIMARY KEY (id_sponsor, id_performance),
        CONSTRAINT fk_spon_sponsor FOREIGN KEY (id_sponsor) REFERENCES Sponsor (id_sponsor) ON DELETE CASCADE,
        CONSTRAINT fk_spon_performance FOREIGN KEY (id_performance) REFERENCES Performance (id_performance) ON DELETE CASCADE
    );

-- Collaborazioni tra artisti (N-M auto-referenziale)
CREATE TABLE
    Collaborazione (
        id_artista1 INT NOT NULL,
        id_artista2 INT NOT NULL,
        tipo VARCHAR(100),
        anno YEAR,
        PRIMARY KEY (id_artista1, id_artista2),
        CONSTRAINT fk_collab_a1 FOREIGN KEY (id_artista1) REFERENCES Artista (id_artista) ON DELETE CASCADE,
        CONSTRAINT fk_collab_a2 FOREIGN KEY (id_artista2) REFERENCES Artista (id_artista) ON DELETE CASCADE,
        CONSTRAINT chk_collab_diversi CHECK (id_artista1 <> id_artista2)
    );

-- Staff tecnico
CREATE TABLE
    Staff (
        id_staff INT AUTO_INCREMENT PRIMARY KEY,
        nome VARCHAR(100) NOT NULL,
        cognome VARCHAR(100) NOT NULL,
        ruolo ENUM (
            'fonico',
            'luci',
            'sicurezza',
            'logistica',
            'regia'
        ) NOT NULL,
        email VARCHAR(150) UNIQUE,
        tariffa DECIMAL(8, 2) CHECK (tariffa >= 0)
    );

-- Assegnazione Staff - Palco
CREATE TABLE
    AssegnazioneStaff (
        id_staff INT NOT NULL,
        id_palco INT NOT NULL,
        data DATE NOT NULL,
        ore_lavorate DECIMAL(4, 1) CHECK (ore_lavorate > 0),
        PRIMARY KEY (id_staff, id_palco, data),
        CONSTRAINT fk_as_staff FOREIGN KEY (id_staff) REFERENCES Staff (id_staff) ON DELETE CASCADE,
        CONSTRAINT fk_as_palco FOREIGN KEY (id_palco) REFERENCES Palco (id_palco) ON DELETE CASCADE
    );

-- POPOLAMENTO DATI
USE festival_musicale;

-- 1. Palchi
INSERT INTO
    Palco (id_palco, nome, capienza, tipo, copertura)
VALUES
    (
        1,
        'Main Stage Horizon',
        50000,
        'principale',
        'aperto'
    ),
    (
        2,
        'Electric Jungle',
        15000,
        'elettronico',
        'coperto'
    ),
    (3, 'Acoustic Garden', 5000, 'acustico', 'aperto'),
    (
        4,
        'Underground Shelter',
        8000,
        'secondario',
        'coperto'
    );

-- 2. Artisti
INSERT INTO
    Artista (
        id_artista,
        nome,
        tipo,
        genere,
        nazionalita,
        cachet
    )
VALUES
    (
        1,
        'The Cosmic Echoes',
        'band',
        'Rock Alternativo',
        'UK',
        75000.00
    ),
    (
        2,
        'Elena Rossi',
        'singolo',
        'Pop',
        'Italia',
        25000.00
    ),
    (
        3,
        'DJ Technoise',
        'singolo',
        'Techno',
        'Germania',
        12000.00
    ),
    (
        4,
        'Midnight Jazz Trio',
        'band',
        'Jazz',
        'USA',
        8500.00
    ),
    (
        5,
        'Luna & The Stars',
        'band',
        'Indie',
        'Francia',
        15000.00
    );

-- 3. Performance (ORARI CORRETTI PER IL CHECK CONSTRAINT)
INSERT INTO
    Performance (
        id_performance,
        id_artista,
        id_palco,
        data_esibizione,
        ora_inizio,
        ora_fine
    )
VALUES
    (1, 1, 1, '2026-07-15', '21:30:00', '23:30:00'),
    (2, 2, 1, '2026-07-15', '19:00:00', '20:30:00'),
    (3, 3, 2, '2026-07-16', '21:00:00', '23:59:00'),
    (4, 4, 3, '2026-07-16', '18:00:00', '19:30:00'),
    (5, 5, 4, '2026-07-17', '20:00:00', '21:30:00');

-- 4. Spettatori
INSERT INTO
    Spettatore (
        id_spettatore,
        nome,
        cognome,
        email,
        telefono,
        data_nascita
    )
VALUES
    (
        1,
        'Marco',
        'Verdi',
        'marco.verdi@email.it',
        '3331234567',
        '1995-05-12'
    ),
    (
        2,
        'Giulia',
        'Bianchi',
        'g.bianchi@gmail.com',
        '3409876543',
        '2001-11-20'
    ),
    (
        3,
        'Luca',
        'Rossi',
        'l.rossi@outlook.com',
        NULL,
        '1988-02-28'
    ),
    (
        4,
        'Anna',
        'Neri',
        'anna.neri@fastwebnet.it',
        '3291122334',
        '1999-07-15'
    );

-- 5. Biglietti (ORA GLI ID PERFORMANCE ESISTONO)
INSERT INTO
    Biglietto (
        id_biglietto,
        id_performance,
        id_spettatore,
        prezzo,
        tipo_posto
    )
VALUES
    (1, 1, 1, 85.50, 'golden_circle'),
    (2, 1, 2, 50.00, 'standard'),
    (3, 2, 2, 45.00, 'standard'),
    (4, 3, 3, 120.00, 'vip'),
    (5, 5, 4, 35.00, 'standard');

-- 6. Pagamenti
INSERT INTO
    Pagamento (id_biglietto, importo, metodo, stato)
VALUES
    (1, 85.50, 'carta', 'completato'),
    (2, 50.00, 'paypal', 'completato'),
    (3, 45.00, 'carta', 'completato'),
    (4, 120.00, 'bonifico', 'completato'),
    (5, 35.00, 'contanti', 'completato');

-- 7. Sponsor e Collaborazioni
INSERT INTO
    Sponsor (id_sponsor, nome, settore, budget)
VALUES
    (1, 'Tech-Bev', 'Beverage', 100000.00);

INSERT INTO
    Sponsorizzazione (id_sponsor, id_performance, importo)
VALUES
    (1, 1, 15000.00);

INSERT INTO
    Collaborazione (id_artista1, id_artista2, tipo, anno)
VALUES
    (1, 5, 'Album', 2025);

-- 8. Staff tecnico
INSERT INTO
    Staff (id_staff, nome, cognome, ruolo, email, tariffa)
VALUES
    (
        1,
        'Roberto',
        'Tecnico',
        'fonico',
        'roberto.sound@festival.com',
        350.00
    ),
    (
        2,
        'Sara',
        'Luci',
        'luci',
        'sara.light@festival.com',
        300.00
    ),
    (
        3,
        'Giovanni',
        'Sicuri',
        'sicurezza',
        'giovanni.s@festival.com',
        200.00
    ),
    (
        4,
        'Marta',
        'Regia',
        'regia',
        'marta.director@festival.com',
        450.00
    ),
    (
        5,
        'Alessio',
        'Trasporti',
        'logistica',
        'alessio.log@festival.com',
        250.00
    );

-- 9. Assegnazione Staff
INSERT INTO
    AssegnazioneStaff (id_staff, id_palco, data, ore_lavorate)
VALUES
    (1, 1, '2026-07-15', 8.5), -- Roberto al Main Stage il 15 Luglio
    (2, 1, '2026-07-15', 10.0), -- Sara al Main Stage il 15 Luglio
    (3, 2, '2026-07-16', 12.0), -- Giovanni all'Electric Jungle il 16 Luglio
    (4, 1, '2026-07-15', 6.0), -- Marta in Regia al Main Stage
    (5, 4, '2026-07-17', 5.0);

-- Alessio alla logistica dell'Underground
-- Performance 3 è il 2026-07-16
INSERT INTO
    Sponsorizzazione (id_sponsor, id_performance, importo)
VALUES
    (1, 3, 5000.00);

-- Performance 5 è il 2026-07-17
INSERT INTO
    Sponsorizzazione (id_sponsor, id_performance, importo)
VALUES
    (1, 5, 7000.00);

INSERT INTO
    Performance (
        id_artista,
        id_palco,
        data_esibizione,
        ora_inizio,
        ora_fine
    )
VALUES
    (2, 2, '2026-07-16', '18:00:00', '19:00:00'),
    (2, 3, '2026-07-17', '17:00:00', '18:00:00');

INSERT INTO
    Collaborazione (id_artista1, id_artista2, tipo, anno)
VALUES
    (2, 3, 'Singolo', 2026),
    (2, 4, 'Tour', 2026);

INSERT INTO
    Biglietto (id_performance, id_spettatore, prezzo, tipo_posto)
VALUES
    (6, 1, 150.00, 'vip'),
    (7, 3, 200.00, 'golden_circle');