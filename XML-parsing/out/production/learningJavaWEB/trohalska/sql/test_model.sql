-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema test
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema test
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `test` DEFAULT CHARACTER SET utf8 ;
USE `test` ;
DROP SCHEMA test;
-- -----------------------------------------------------
-- Table `test`.`category`
-- -----------------------------------------------------

DROP TABLE IF EXISTS tabl_name;

/*  Comment */
CREATE TABLE IF NOT EXISTS `test`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` VARCHAR(255) NOT NULL UNIQUE,
  `description` VARCHAR(1024) NULL, -- Comment
  `parent_id` INT NULL,
--   PRIMARY KEY (`id`),
  INDEX `fk_category_category1_idx` (`parent_id` ASC) VISIBLE,
  CONSTRAINT `fk_category_category1`
    FOREIGN KEY (`parent_id`)
    REFERENCES `test`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `test`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `price` DOUBLE UNSIGNED NOT NULL DEFAULT 0,
  `amount` INT UNSIGNED NOT NULL DEFAULT 0,
  `description` VARCHAR(1024) NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_product_category1_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `fk_product_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `test`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`role` (
  `id` INT ZEROFILL NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(10245) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `role_id` INT ZEROFILL NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_account_role1_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `fk_account_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `test`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `test`.`status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`status` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` ENUM("NEW", "IN PROGRESS") NOT NULL,
  `description` VARCHAR(1024) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test`.`receipt`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`receipt` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `account_id` INT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `status_id` INT NOT NULL,
  `approved_by_id` INT NULL,
  `total` DOUBLE NULL,
  INDEX `fk_receipt_account_idx` (`account_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  INDEX `fk_receipt_status1_idx` (`status_id` ASC) VISIBLE,
  INDEX `fk_receipt_account1_idx` (`approved_by_id` ASC) VISIBLE,
  CONSTRAINT `fk_receipt_account`
    FOREIGN KEY (`account_id`)
    REFERENCES `test`.`account` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_receipt_status1`
    FOREIGN KEY (`status_id`)
    REFERENCES `test`.`status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_receipt_account1`
    FOREIGN KEY (`approved_by_id`)
    REFERENCES `test`.`account` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `test`.`receipt_has_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`receipt_has_product` (
  `receipt_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `price` DOUBLE UNSIGNED NOT NULL,
  `count` INT UNSIGNED NOT NULL,
  `create_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP(),
  `last_update` DATETIME NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
  PRIMARY KEY (`receipt_id`, `product_id`),
  INDEX `fk_receipt_has_product_product1_idx` (`product_id` ASC) VISIBLE,
  INDEX `fk_receipt_has_product_receipt1_idx` (`receipt_id` ASC) VISIBLE,
  CONSTRAINT `fk_receipt_has_product_receipt1`
    FOREIGN KEY (`receipt_id`)
    REFERENCES `test`.`receipt` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_receipt_has_product_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `test`.`product` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `test`.`account_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test`.`account_details` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  `age` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_account_details_accoint_id`
    FOREIGN KEY (`id`)
    REFERENCES `test`.`account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
