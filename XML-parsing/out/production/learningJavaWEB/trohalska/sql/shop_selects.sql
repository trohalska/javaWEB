USE shop;
DESCRIBE account;

DROP TABLE IF EXISTS t1;
DROP TABLE IF EXISTS t2;
CREATE TABLE t1 SELECT 1 as a, 2 as b UNION SELECT * FROM (VALUES ROW(3,4), ROW(5,6)) AS v;
CREATE TABLE t2 SELECT 7 as c, 2 as b UNION SELECT * FROM (VALUES ROW(9,4), ROW(11,6)) AS v;
SELECT * FROM t1,t2;
SELECT a,t1.b,c FROM t1,t2 WHERE t1.b=t2.b;

SELECT * FROM product LIMIT 5 OFFSET 3; 
SELECT * FROM product ORDER BY name LIMIT 5,5; 
SELECT * FROM product ORDER BY name, price;
SELECT name n, price p, (SELECT 1) a FROM product;

SELECT SUM(price * amount) AS sum_price FROM product;
SELECT SUM(DISTINCT price) AS sum_price FROM product;

SELECT 
    SUM(price * count) total
FROM
    receipt_has_product;


-- WHERE

SELECT 
    receipt.id rid, total, count, receipt_has_product.price, name
FROM
    receipt, receipt_has_product, product
WHERE
    receipt_id = receipt.id AND product_id = product.id;

-- !!! operator precedence
SELECT * FROM product WHERE name LIKE 'C%' OR name LIKE 'B%' AND price < 10 ;
SELECT * FROM product WHERE (name LIKE 'C%' OR name LIKE 'B%') AND price < 10 ;

SELECT * FROM account WHERE role_id = ALL (SELECT id FROM role WHERE name = 'customer') ;
SELECT * FROM account WHERE role_id IN (SELECT id FROM role WHERE name = 'customer') ;
SELECT * FROM account WHERE role_id <> ANY (SELECT id FROM role WHERE name = 'customer') ;
SELECT * FROM receipt WHERE status_id IN (SELECT id FROM status WHERE id >= 3);

SELECT 
    login, password
FROM
    account
WHERE
    login LIKE '%A'
ORDER BY login;

-- 
SELECT 
    login, password
FROM
    account
WHERE
    login RLIKE '.*A$' -- ends with 'a' or 'A'
ORDER BY login;


-- JOIN TABLES WITH WHERE
SELECT * FROM account, receipt WHERE account.id = receipt.account_id;


SELECT 
    account.login, receipt.id, total
FROM
    account,
    receipt
WHERE
    receipt.account_id = account.id
ORDER BY login;

-- JOIN
SELECT 
    account.login, receipt.id receipt_id, total
FROM
    account
RIGHT JOIN 
    receipt ON account.id = receipt.account_id
WHERE  account.role_id IN (SELECT id FROM role WHERE role.name = 'customer')
ORDER BY login;
-- LIMIT 5, 8;

-- CROSS JOIN  -- Cartesian product of sets
SELECT 
    account.login, receipt.id receipt_id
FROM
    account
CROSS JOIN 
    receipt 
WHERE  account.role_id IN (SELECT id FROM role WHERE role.name = 'customer')
ORDER BY login;
-- Cartesian product of sets;
SELECT login, receipt.id receipt_id FROM account, receipt;

-- UNION
SELECT 
    account.login name, account.login
FROM
    account 
UNION 
SELECT 
  concat('      ', CONVERT( receipt.id , CHAR)) name, 
  (SELECT account.login FROM account WHERE account.id=receipt.account_id) login
FROM
    receipt
ORDER BY login;
    
-- UNION
SELECT 
    account.login name,
    (SELECT 
            SUM(receipt.total)
        FROM
            receipt
        WHERE
            receipt.account_id = account.id) total, -- total for account
    account.login
FROM
    account 
UNION SELECT 
    CONCAT('No ', receipt.id, ' from ', receipt.create_date) name,
    total,  -- total for receipt
    IFNULL((SELECT 
                    account.login
                FROM
                    account
                WHERE
                    account.id = receipt.account_id),
            'UNKNOWN') login
FROM
    receipt
ORDER BY login ASC , total DESC;


-- ------------------------------------------
-- Aggregation
-- ------------------------------------------
SELECT count(parent_id) FROM category;
SELECT sum(price) FROM product;

SELECT * FROM status;

-- GROUP BY
SELECT 
    login, SUM(receipt.total) total, COUNT(receipt.id) count
FROM
    receipt,
    account
WHERE
    account.id = account_id
        AND receipt.status_id BETWEEN 3 AND 4
GROUP BY account_id
HAVING total >= 40
ORDER BY total, login;


SELECT * FROM receipt ORDER BY status_id DESC;

-- GROUP BY
SELECT 
    IFNULL(login, 'unknown') login,
    SUM(receipt.total) total,
    COUNT(receipt.id) count
FROM
    receipt
        LEFT JOIN
    account ON account.id = account_id
WHERE
    receipt.status_id BETWEEN 3 AND 4
GROUP BY account_id
HAVING total >= 10
ORDER BY total , login;

-- GROUP BY
SELECT 
    category.name, COUNT(category_id) count
FROM
    category,
    receipt_has_product, product
WHERE
    category.id = category_id AND product.id = product_id
GROUP BY category.name
ORDER BY category.name;

-- verification query
SELECT 
    category.name, product.name product_name, receipt_id
FROM
	category, product, receipt_has_product
WHERE 
	category_id = category.id AND receipt_has_product.product_id = product.id
ORDER BY category.name;


SELECT * FROM receipt, receipt_has_product WHERE receipt.id = receipt_id AND description LIKE '%s%';