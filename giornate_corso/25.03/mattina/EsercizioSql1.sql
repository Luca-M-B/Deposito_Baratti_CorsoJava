-- esercizio 1
SELECT *
FROM products
WHERE buyprice > 50;

-- esercizio 2
SELECT *
FROM orders
ORDER BY orderDate DESC;

-- esercizo 3
UPDATE products
SET buyPrice = buyPrice * 1.1;

-- esercizio 4
INSERT INTO customers 
    (customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, city, country) 
VALUES 
    (497, 'Pippo Studios', 'Rossi', 'Pippo', '+39 1234567890', 'Via da qui 99', 'Roma', 'Italy');

-- esercizio 5
-- per eliminare i record della tabella 'orders' devo prima cercare ed eliminare tali record nella tabella 'orderdetails' 
-- perchè la colonna 'orderNumber' in 'orderdetails' è chiave esterna che punta alla medesima colonna della tabella 'orders'
DELETE FROM orderdetails 
WHERE orderNumber IN (
    SELECT orderNumber 
    FROM orders 
    WHERE status = 'Cancelled'
);

DELETE FROM orders          -- solo qui posso eliminare i record da 'orders'
WHERE status = 'Cancelled';


CREATE TABLE orders_backup AS -- creo due tabelle identiche a quelle di partenza per non avere problemi futuri
SELECT * FROM orders;

CREATE TABLE orderdetails_backup AS 
SELECT * FROM orderdetails;

-- esercizio 6
SELECT *
FROM customers
WHERE customerName LIKE 's%' 
  AND state = 'CA'; -- CA perchè California non esiste