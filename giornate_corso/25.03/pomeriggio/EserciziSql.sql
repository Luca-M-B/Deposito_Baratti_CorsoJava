-- esercizio 1
SELECT city.Name AS Citta, country.Name AS Nazione, countrylanguage.Language AS Lingua
FROM city
JOIN country ON city.CountryCode = country.Code
JOIN countrylanguage ON country.Code = countrylanguage.CountryCode;


-- esercizio 2
SELECT country.Name AS Nazione, COUNT(city.ID) AS NumeroCitta -- con COUNT ottengo il numero di record per city.id
FROM country
LEFT JOIN city ON country.Code = city.CountryCode -- senza left non avrei le nazioni con zero citta
GROUP BY country.Name -- posso aggiungere anche country.Code per non avere chiavi primarie duplciate
ORDER BY NumeroCitta DESC;


-- esercizio 3
SELECT country.Name AS Nazione, country.LifeExpectancy AS Aspettativa, country.GovernmentForm AS FormaGoverno, 
    countrylanguage.Language AS Lingua
FROM country
JOIN countrylanguage ON country.Code = countrylanguage.CountryCode
WHERE country.GovernmentForm LIKE '%republic%' 
AND country.LifeExpectancy > 70;


-- esercizio 4
SELECT customers.customerName, payments.paymentDate, payments.amount
FROM customers
JOIN payments
ON customers.customerNumber = payments.customerNumber
ORDER BY payments.paymentDate DESC;


-- esercizio 5
-- utilizzando JOIN
SELECT customers.customerNumber, customers.customerName, orders.orderNumber
FROM customers
LEFT JOIN orders ON customers.customerNumber = orders.customerNumber
WHERE orders.orderNumber IS NULL;
-- utilizzando SUBQUERY
SELECT customers.customerNumber AS customer_id, customers.customerName
FROM customers
WHERE customerNumber NOT IN (SELECT customerNumber FROM orders);


-- esercizio 6
SELECT employees.firstName AS NomeDipendente, employees.lastName AS CognomeDipendente, -- e.
    employees.firstName AS NomeSuperiore, employees.lastName -- m.
FROM employees -- e.
LESFT JOIN employees -- e.
ON employees.reportsTo = employees.employeeNumber; -- e.    = m.

-- esercizio 7
SELECT customers.customerNumber,  customers.customerName, 
    COUNT(orders.orderNumber) AS numeroTotaleOrdini, SUM(payments.amount) AS valoreTotaleSpeso
FROM customers
LEFT JOIN orders ON customers.customerNumber = orders.customerNumber
LEFT JOIN payments ON customers.customerNumber = payments.customerNumber
GROUP BY customers.customerNumber, customers.customerName;