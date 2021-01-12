USE shop;
DROP TRIGGER IF EXISTS bi_receipt_has_product_update_total_amount;
DROP TRIGGER IF EXISTS ad_receipt_has_product_update_total_amount;

DELIMITER //
CREATE DEFINER = CURRENT_USER TRIGGER shop.bi_receipt_has_product_update_total_amount BEFORE INSERT ON receipt_has_product FOR EACH ROW
BEGIN
	DECLARE newamount int;
    
    SET NEW.price = (select price from product where id = NEW.product_id);
    SET newamount = (select product.amount from product where id = NEW.product_id) - NEW.count;
    IF (newamount < 0) THEN
		SIGNAL sqlstate '45001' set message_text = 'Not enough product!';
    END IF;
		
    UPDATE product SET product.amount = newamount WHERE id = NEW.product_id;
    -- (1)
    UPDATE receipt SET total = ifnull(total, 0) + NEW.price * NEW.count WHERE receipt.id = NEW.receipt_id;
    
    -- (2)
--     UPDATE receipt SET total = (SELECT SUM(price * count) + (NEW.price * NEW.count) FROM receipt_has_product WHERE receipt_id = NEW.receipt_id);
END//
DELIMITER ;

DELIMITER //
CREATE DEFINER = CURRENT_USER TRIGGER shop.ad_receipt_has_product_update_total_amount AFTER DELETE ON receipt_has_product FOR EACH ROW
BEGIN
    UPDATE product SET amount = amount + OLD.count WHERE id = OLD.product_id;
    -- (1)
    UPDATE receipt SET total = total - OLD.price * OLD.count WHERE receipt.id = OLD.receipt_id;
    
    -- (2)
--     UPDATE receipt SET total = (SELECT SUM(price * count) + (OLD.price * OLD.count) FROM receipt_has_product WHERE receipt_id = OLD.receipt_id);
END//
DELIMITER ;

-- test trigger
DELETE FROM receipt_has_product WHERE product_id = 1 AND receipt_id = 1;
INSERT INTO receipt_has_product (receipt_id, product_id, count) VALUES (1, 1, 2);
SELECT * FROM receipt, receipt_has_product WHERE receipt.id = 1 AND receipt.id = receipt_id;
-- UPDATE product SET product.amount = 5 WHERE id = 1;