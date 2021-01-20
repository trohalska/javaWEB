CREATE DATABASE IF NOT EXISTS shop;
USE shop;

-- simply removing the foreign key will not remove the related index
-- ALTER TABLE delivery
--   DROP FOREIGN KEY fk_delivery_receipt_id ;

-- SET @old_unique_checks=@@unique_checks, @@unique_checks=0;
-- SET @old_foreign_key_checks = @@foreign_key_checks, @@foreign_key_checks = 0;
DROP TABLE IF EXISTS delivery;
DROP TABLE IF EXISTS receipt_has_product;
DROP TABLE IF EXISTS receipt;
DROP TABLE IF EXISTS account_details;
DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS status;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS category;
-- SET @@foreign_key_checks = @old_foreign_key_checks;
-- SET @@unique_checks = @old_unique_checks;

CREATE TABLE role (
    id serial PRIMARY KEY,
    name VARCHAR(32) NOT NULL UNIQUE,
    description VARCHAR(1024)
--  ,
-- 	PRIMARY KEY pk_role_id (id),
--  UNIQUE KEY uq_role_name (name)
);

CREATE TABLE account (
    id serial PRIMARY KEY,
    login VARCHAR(32) NOT NULL UNIQUE,
    password VARCHAR(32) NOT NULL,
    role_id INT NOT NULL,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--     last_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
--     PRIMARY KEY pk_account_id (id),
--     UNIQUE KEY uq_account_login (login),
    FOREIGN KEY (role_id)
        REFERENCES role (id)
--     CONSTRAINT fk_account_role_id FOREIGN KEY (role_id)
--         REFERENCES role (id)
--         ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE account_details (
    id INT NOT NULL,
    description VARCHAR(1024),
    -- ... other fields
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY pk_account_details_id (id),
    CONSTRAINT fk_account_details_account_id FOREIGN KEY (id)
        REFERENCES account (id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE category (
    id INT AUTO_INCREMENT,
    name VARCHAR(32) NOT NULL,
    parent_id INT,
    description VARCHAR(1024),
    PRIMARY KEY pk_category_id (id),
    UNIQUE KEY uq_category_name (name),
    CONSTRAINT fk_category_parent_id FOREIGN KEY (parent_id)
        REFERENCES category (id)
        ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE product (
    id INT AUTO_INCREMENT,
    name VARCHAR(64) NOT NULL,
    description VARCHAR(1024),
    amount INT UNSIGNED NOT NULL,
    price DOUBLE NOT NULL,
    category_id INT,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY pk_product_id (id),
    UNIQUE KEY uq_product_name (name),
    CONSTRAINT ck_product_price CHECK (price >= 0),
    INDEX ix_product_price_amount (amount, price),
    CONSTRAINT fk_product_category_id FOREIGN KEY (category_id)
        REFERENCES category (id)
        ON UPDATE CASCADE ON DELETE SET NULL
);

CREATE TABLE status (
    id INT AUTO_INCREMENT,
    name VARCHAR(32) NOT NULL,
    description VARCHAR(1024),
    PRIMARY KEY pk_status_id (id),
    UNIQUE KEY uq_status_name (name)
);

CREATE TABLE receipt (
    id INT AUTO_INCREMENT,
    total DOUBLE,
    account_id INT,
    aproved_by_id INT,
    status_id INT NOT NULL,
    description VARCHAR(1024),
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY pk_product_id (id),
    CONSTRAINT ch_total CHECK (total >= 0),
    CONSTRAINT fk_receipt_account_id FOREIGN KEY (account_id)
        REFERENCES account (id) 
        ON UPDATE CASCADE ON DELETE SET NULL,
    CONSTRAINT fk_receipt_account_id2 FOREIGN KEY (aproved_by_id)
        REFERENCES account (id) 
        ON UPDATE CASCADE ON DELETE SET NULL,
    CONSTRAINT fk_receipt_status_id FOREIGN KEY (status_id)
        REFERENCES status (id) 
        ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE receipt_has_product (
    receipt_id INT,
    product_id INT,
    count INT UNSIGNED NOT NULL DEFAULT 1,
    price DOUBLE NOT NULL DEFAULT 0,
    PRIMARY KEY (receipt_id , product_id),
    CONSTRAINT ck_receipt_has_product_price CHECK (price >= 0),
    CONSTRAINT fk_receipt_has_product_receipt_id FOREIGN KEY (receipt_id)
        REFERENCES receipt (id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_receipt_has_product_product_id FOREIGN KEY (product_id)
        REFERENCES product (id)
        ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE delivery (
    id INT,
    description VARCHAR(1024),
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY pk_delivery_id (id),
    CONSTRAINT fk_delivery_receipt_id FOREIGN KEY (id)
        REFERENCES receipt (id) 
        ON UPDATE CASCADE ON DELETE CASCADE
);

-- -----------------------------------------------------
-- Inserts
-- -----------------------------------------------------
-- SET @old_autocommit = @@autocommit, @@autocommit = 0;
-- START TRANSACTION;

-- role
INSERT INTO role (id, name) VALUES(DEFAULT, 'admin');
INSERT INTO role (id, name) VALUES(DEFAULT, 'operator');
INSERT INTO role (id, name) VALUES(DEFAULT, 'customer');

-- account
SET @text = 'admin';
INSERT INTO account (id, login, password, role_id) VALUES(DEFAULT, @text, @text, (SELECT id FROM role WHERE name = @text));
SET @text = 'operator';
INSERT INTO account (id, login, password, role_id) VALUES(DEFAULT, @text, @text, (SELECT id FROM role WHERE name = @text));
SET @text = 'customer';
INSERT INTO account (id, login, password, role_id) VALUES(DEFAULT, @text, @text, (SELECT id FROM role WHERE name = @text));

-- category
INSERT INTO category (id, name, parent_id) VALUES(1, 'Category 0.1', NULL);
INSERT INTO category (id, name, parent_id) VALUES(2, 'Category 0.2', NULL);
INSERT INTO category (id, name, parent_id) VALUES(3, 'Category 0.1.1', 1);
INSERT INTO category (id, name, parent_id) VALUES(4, 'Category 0.1.2', 1);
INSERT INTO category (id, name, parent_id) VALUES(5, 'Category 0.2.1', 2);
INSERT INTO category (id, name, parent_id) VALUES(6, 'Category 0.2.2', 2);

-- product
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'candy', 5, 5.0, 2);
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'scooter', 7, 7.0, 4);
INSERT INTO product (id, name, amount, price, category_id) VALUES(DEFAULT, 'airplan', 9, 9.0, 4);

-- status
INSERT INTO status (id, name) VALUES(DEFAULT, 'new');
INSERT INTO status (id, name) VALUES(DEFAULT, 'aprooved');
INSERT INTO status (id, name) VALUES(DEFAULT, 'paid');
INSERT INTO status (id, name) VALUES(DEFAULT, 'closed');

-- COMMIT;
-- SET @@autocommit = @old_autocommit;
