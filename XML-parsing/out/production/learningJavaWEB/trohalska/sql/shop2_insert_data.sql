USE shop;
-- SET @old_autocommit = @@autocommit, @@autocommit = 0;
-- START TRANSACTION;

INSERT INTO account (login, password, role_id) VALUES('Emma', 'Emma', (SELECT id FROM role WHERE name = 'customer'));
INSERT INTO account (login, password, role_id) VALUES('Olivia', 'Olivia', (SELECT id FROM role WHERE name = 'customer'));
INSERT INTO account (login, password, role_id) VALUES('Ava', 'Ava', (SELECT id FROM role WHERE name = 'customer'));
INSERT INTO account (login, password, role_id) VALUES('Isabella', 'Isabella', (SELECT id FROM role WHERE name = 'customer'));
INSERT INTO account (login, password, role_id) VALUES('Sophia', 'Sophia', (SELECT id FROM role WHERE name = 'customer'));
INSERT INTO account (login, password, role_id) VALUES('Charlotte', 'Charlotte', (SELECT id FROM role WHERE name = 'customer'));
INSERT INTO account (login, password, role_id) VALUES('Mia', 'Mia', (SELECT id FROM role WHERE name = 'customer'));
INSERT INTO account (login, password, role_id) VALUES('Amelia', 'Amelia', (SELECT id FROM role WHERE name = 'customer'));
INSERT INTO account (login, password, role_id) VALUES('Harper', 'Harper', (SELECT id FROM role WHERE name = 'customer'));
INSERT INTO account (login, password, role_id) VALUES('Evelyn', 'Evelyn', (SELECT id FROM role WHERE name = 'customer'));
INSERT INTO account (login, password, role_id) VALUES('Liam', 'Liam', (SELECT id FROM role WHERE name = 'customer'));
INSERT INTO account (login, password, role_id) VALUES('Noah', 'Noah', (SELECT id FROM role WHERE name = 'customer'));
INSERT INTO account (login, password, role_id) VALUES('William', 'William', (SELECT id FROM role WHERE name = 'customer'));
INSERT INTO account (login, password, role_id) VALUES('James', 'James', (SELECT id FROM role WHERE name = 'customer'));
INSERT INTO account (login, password, role_id) VALUES('Oliver', 'Oliver', (SELECT id FROM role WHERE name = 'customer'));
INSERT INTO account (login, password, role_id) VALUES('Benjami', 'Benjami', (SELECT id FROM role WHERE name = 'customer'));
INSERT INTO account (login, password, role_id) VALUES('Elijah', 'Elijah', (SELECT id FROM role WHERE name = 'customer'));
INSERT INTO account (login, password, role_id) VALUES('Lucas', 'Lucas', (SELECT id FROM role WHERE name = 'customer'));
INSERT INTO account (login, password, role_id) VALUES('Mason', 'Mason', (SELECT id FROM role WHERE name = 'customer'));
INSERT INTO account (login, password, role_id) VALUES('Logan', 'Logan', (SELECT id FROM role WHERE name = 'customer'));


INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Portable Blender', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Spider Nail Gel', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Wireless Phone Chargers', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Face Shield', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Phone Lenses', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Inflatable Pet Collars', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Eyeshadow Stamp', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Strapless Backless Bra', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Child Wrist Leash', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Front Facing Baby Carrier', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Car Phone Holder', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Home Security IP Camera', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Wifi Repeater', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Drone Camera', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Posture Corrector', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Electric Soldering Iron Gun', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Pump Wedge Locksmith', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Bohemian Earrings', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Manicure Milling Drill Bit', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Flexible Garden Hose', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'One Piece Swimsuit', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Fly Fishing Quick Knot Tool', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Breathable Mesh Running Shoes', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Waterproof Eyebrow Liner', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Non-contact Infrared Thermometer', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Cat Massage Comb', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Portable Electric Ionic Hairbrush', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'PVC Inflatable Beer Pong Ball Table', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Home Ice Cream Makers', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Beach Towels', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Baby Kids Water Play Mat', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Pocket Scarves', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Winter Coats', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Shoe Dryer', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Touchscreen Gloves', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Waterproof Pants', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Bear Claws', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Hiking Backpacks', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Minimalist Wallets', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Waterproof Shoe Cover', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Hooded Raincoats', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Cable Chompers', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Plush Blankets', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Portable Car Vacuum', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Baby Swings', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Matcha Tea', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Eyebrow Razor', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Seat Cushions', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Phone Tripod', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'Portable Solar Panels', 5, FLOOR(1 + RAND( ) * 20), FLOOR(3 + RAND( ) * 4));

DELIMITER //
CREATE PROCEDURE receipt_inserts()
BEGIN
	DECLARE i INT DEFAULT 20;
    WHILE i > 0 DO
		INSERT INTO receipt (total, account_id, status_id) VALUES (0, FLOOR( 4 + RAND( ) * 17), FLOOR(1 + RAND( ) * 4));
		SET @product_id = FLOOR(1 + RAND( ) * 53);
		INSERT INTO receipt_has_product (receipt_id, product_id, count, price) 
			VALUES (last_insert_id(), @product_id, FLOOR(1 + RAND( ) * 3), (SELECT price FROM product WHERE id = @product_id));
		SET i = i - 1;
	END WHILE;
END//
DELIMITER ;
CALL receipt_inserts;
DROP PROCEDURE receipt_inserts;

-- without account
INSERT INTO receipt (total, account_id, status_id) VALUES (0, NULL, 1);
SET @product_id = FLOOR(1 + RAND( ) * 53);
INSERT INTO receipt_has_product (receipt_id, product_id, count, price) 
	VALUES (last_insert_id(), @product_id, FLOOR(1 + RAND( ) * 3), (SELECT price FROM product WHERE id = @product_id));
INSERT INTO receipt (total, account_id, status_id) VALUES (0, NULL, 1);
SET @product_id = FLOOR(1 + RAND( ) * 53);
INSERT INTO receipt_has_product (receipt_id, product_id, count, price) 
	VALUES (last_insert_id(), @product_id, FLOOR(1 + RAND( ) * 3), (SELECT price FROM product WHERE id = @product_id));
INSERT INTO receipt (total, account_id, status_id) VALUES (0, NULL, 1);
SET @product_id = FLOOR(1 + RAND( ) * 53);
INSERT INTO receipt_has_product (receipt_id, product_id, count, price) 
	VALUES (last_insert_id(), @product_id, FLOOR(1 + RAND( ) * 3), (SELECT price FROM product WHERE id = @product_id));


UPDATE receipt 
SET 
    total = (SELECT 
            SUM(product.price * receipt_has_product.count)
        FROM
            receipt_has_product,
            product
        WHERE
            product.id = product_id
                AND receipt.id = receipt_id);
-- WHERE
--     total = 0;
    
-- COMMIT;
-- SET @@autocommit = @old_autocommit;
