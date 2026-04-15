-- ESERCIZIO 1

-- recuperare dal database world la lingua e la nazione di ogni città
SELECT city.Name AS citta, country.Name AS nazione, countrylanguage.Language AS lingua
FROM city
JOIN country ON city.CountryCode = country.Code
JOIN countrylanguage ON country.Code = countrylanguage.CountryCode;

-- recuperare il numero di città per nazione e mostrare anche il nome della nazione. Ordinare per numero di città
SELECT country.Name AS nazione, COUNT(city.ID) AS numero_citta
FROM country
LEFT JOIN city ON country.Code = city.CountryCode
GROUP BY country.Code, country.Name
ORDER BY numero_citta ASC;

-- recuperare la liste delle repubbliche con aspettativa di vita maggiore di 70anni. Mostrare anche la lingua parlata
SELECT country.Name AS nazione, country.LifeExpectancy AS aspettativa, country.GovernmentForm AS forma_governo, 
    countrylanguage.Language AS lingua
FROM country
JOIN countrylanguage ON country.Code = countrylanguage.CountryCode
WHERE country.GovernmentForm LIKE '%republic%' 
AND country.LifeExpectancy > 70;

-- Ottenere una lista unica di città con popolazione > 5 milioni e mostrare capitali dei paesi Utilizzando UNION
-- Parte 1: Città con popolazione superiore a 5 milioni
SELECT city.Name AS nome_citta, 'Metropoli' AS metropoli
FROM city
WHERE city.Population > 5000000
UNION
SELECT city.Name AS nome_citta, 'Capitale' AS capitale
FROM city
JOIN country ON city.ID = country.Capital;


-- ESERCIZIO 2

-- recuperare dal database world le lingue parlate per nazione con la rispettiva percentuale di utilizzo
SELECT country.Name AS Nazione, countrylanguage.Language AS Lingua, countrylanguage.Percentage AS Percentuale
FROM country
JOIN countrylanguage ON country.Code = countrylanguage.CountryCode
ORDER BY country.Name ASC, countrylanguage.Percentage DESC;

-- recuperare dal database WORLD le nazioni e la percentuale della lingua più parlata
SELECT country.Name AS Nazione, countrylanguage.Language AS Lingua, MAX(countrylanguage.Percentage) AS PercentualeMassima
FROM country
JOIN countrylanguage ON country.Code = countrylanguage.CountryCode
GROUP BY country.Name
ORDER BY PercentualeMassima DESC;

-- unire gli ultimi due esercizi utilizzando subquery per mostrare la lingua piu parlata di una nazione con la sua percentuale
SELECT country.Name AS nazione, countrylanguage.Language AS LinguaPiuParlata, countrylanguage.Percentage AS percentuale
FROM country
JOIN countrylanguage ON country.Code = countrylanguage.CountryCode
WHERE countrylanguage.Percentage = (
        SELECT MAX(countrylanguage.Percentage) 
        FROM countrylanguage
        WHERE countrylanguage.CountryCode = country.Code
    )
ORDER BY countrylanguage.Percentage DESC;


-- ESERCIZIO 3

-- scrivere e mostrare con JDBC una query che vada a prendere le nazioni mostrando come riposta se hanno o meno una superfice di
-- 100.000 e se hanno registrato un IndepYear, se è presente l'anno va mostrato altrimenti si indica che non è presente
SELECT country.Name AS Nazione,
CASE 
WHEN country.SurfaceArea >= 100000 THEN 'Superficie >= 100.000'
ELSE 'Superficie < 100.000'
END AS Stato_Superficie,
CASE 
WHEN country.IndepYear IS NOT NULL THEN CAST(country.IndepYear AS CHAR)
ELSE 'Non presente'
END AS Anno_Indipendenza
FROM country;

-- recuperare e mostrare le città con il codice della nazione che indica l'utente. Inoltre l'utente può decidere:
-- l'ordine con cui ordinare le città in maniera decrescente o meno
-- se filtrare le città per un minimo di popolazione
-- se mostrare il nome della nazione a cui fa riferimento il code
SELECT city.Name AS Citta, city.Population AS Popolazione, city.CountryCode AS Codice, country.Name AS NomeNazione
FROM city
JOIN country ON city.CountryCode = country.Code 
WHERE city.CountryCode = 'ITA' -- filtro 1
AND city.Population > 100000 -- filtro 2
ORDER BY city.Population DESC; -- filtro 3


-- ESERCIZIO 4

-- Creare una view di city del database world su una query che mostra le città italiane.

CREATE VIEW view_citta_italiane AS
SELECT *
FROM city
WHERE CountryCode = 'ITA';
-- Su questa VIEW eseguire una query che mostra solo le città con una popolazione inferiore ai 100k.
SELECT Name, Population
FROM view_citta_italiane
WHERE Population < 100000
ORDER BY Population DESC;
-- Ripetere utilizzando WITH citta_italiane AS (...)
WITH citta_italiane AS (SELECT *
    FROM city
    WHERE CountryCode = 'ITA'
)
SELECT Name, Population
FROM citta_italiane
WHERE Population < 100000
ORDER BY Population DESC;