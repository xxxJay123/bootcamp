-- 28 Aug
-- Topic: UNION ALL
select * from orders
union all
select * from orders 
union all
select 1000, 10000, 2 from dual
;
-- UNION (Remove Duplicates)
select * from orders
union
select * from orders
UNION ALL
select * from orders -- 6
;
INSERT INTO ORDERS VALUES (5, 550, 2);
SELECT * FROM ORDERS;

-- Topic: View
DROP VIEW VCUSTOMER_ORDERS;

CREATE VIEW VCUSTOMER_ORDERS
AS
SELECT C.ID, C.NAME, O.AMOUNT
FROM CUSTOMERS C, ORDERS O
WHERE C.ID = O.CUSTOMER_ID
;

SELECT * FROM VCUSTOMER_ORDERS;

-- Topic: Materialized View
CREATE TABLE CUSTOMERS (
	ID SERIAL PRIMARY KEY,
	NAME VARCHAR(50)
);

CREATE TABLE ORDERS (
	ID SERIAL PRIMARY KEY, -- Serial -> Integer
	AMOUNT DECIMAL(10, 2) NOT NULL,
	CUSTOMER_ID SERIAL NOT NULL,
	FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMERS(ID)
);

insert into customers values (1, 'John');
insert into customers (name) values ('Peter');
select * from customers

insert into orders values (1, 2000000, 1);
commit;
REFRESH MATERIALIZED VIEW LARGE_ORDERS;

CREATE MATERIALIZED VIEW LARGE_ORDERS
AS
SELECT C.ID, O.AMOUNT
FROM CUSTOMERS C, ORDERS O
WHERE C.ID = O.CUSTOMER_ID
AND O.AMOUNT > 100000
;

SELECT * FROM LARGE_ORDERS;

-- Topic: Stored Procedures
-- CREATE CUSTOMER_ORDER_REPORT
CREATE TABLE CUSTOMER_ORDER_REPORT (
	CUSTOMER_ID INT PRIMARY KEY,
    ORDER_AVG_AMT DECIMAL(10,2) NOT NULL
);

-- DROP PROCEDURE INSERT_RESULT
DROP PROCEDURE INSERT_RESULT;

-- CREATE PROCEDURE INSERT_RESULT
DELIMITER //
CREATE PROCEDURE INSERT_RESULT()
BEGIN
	DECLARE done INT DEFAULT FALSE;
	DECLARE RES_AVG_AMT DECIMAL(10,2);
    DECLARE cust_id INT;
	
    -- Declare and open the cursor
    DECLARE customer_cursor CURSOR FOR
		SELECT C.ID
		FROM customers c;
        
	-- Declare handler for when no more rows are available
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
	
    -- Clear all report data
    DELETE FROM CUSTOMER_ORDER_REPORT;
    
    OPEN customer_cursor;
	read_loop: LOOP
		FETCH customer_cursor INTO cust_id;
        IF done THEN
			LEAVE read_loop;
		END IF;
		-- Call another Procedure CALC_AVG_AMOUNT
		CALL CALC_AVG_AMOUNT(cust_id, RES_AVG_AMT);
        -- INESRT TO RESULT TABLE
        INSERT INTO CUSTOMER_ORDER_REPORT (CUSTOMER_ID, ORDER_AVG_AMT)
        VALUES (cust_id, RES_AVG_AMT);
	END LOOP read_loop;
    CLOSE customer_cursor;
END;
//
DELIMITER ;

-- DROP PROCEDURE CALC_AVG_AMOUNT
DROP PROCEDURE CALC_AVG_AMOUNT;
-- CREATE PROCEDURE CALC_AVG_AMOUNT
DELIMITER //
CREATE PROCEDURE CALC_AVG_AMOUNT(IN I_CUSTOMER_ID INTEGER, OUT O_AVG_AMT DECIMAL(10,2))
BEGIN	
		DECLARE done INT DEFAULT FALSE;
		DECLARE cust_id INT;
        DECLARE avg_amount DECIMAL(10,2);
        
        -- Declare and open the cursor
		DECLARE calc_cursor CURSOR FOR
			SELECT c.id, ROUND(COALESCE((SUM(o.amount) / count(1)),0),2) as avg_order_amt
			FROM customers c LEFT JOIN orders o ON c.id = o.customer_id
            WHERE c.id = I_CUSTOMER_ID
            GROUP BY c.id;
		-- Declare handler for when no more rows are available
		DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
		
        -- Open the cursor
		OPEN calc_cursor;
		read_loop: LOOP
			FETCH calc_cursor INTO cust_id, avg_amount;
			IF done THEN
				LEAVE read_loop;
			END IF;
			-- SET OUTPUT AVERAGE AMOUNT
            SET O_AVG_AMT = avg_amount;
		END LOOP read_loop;
        CLOSE calc_cursor;
END;
//
DELIMITER ;

-- Call the Procedure INSERT_RESULT()
CALL SYS.INSERT_RESULT();

-- Topic: TABLE TRIGGER - Prepare a column
ALTER TABLE CUSTOMERS ADD ORDER_COUNT INT;
DROP TRIGGER TRIGGER_COUNT_ORDER

-- TABLE TRIGGER
DELIMITER //
CREATE TRIGGER TRIGGER_COUNT_ORDER
AFTER INSERT ON ORDERS
FOR EACH ROW
BEGIN
	UPDATE CUSTOMERS
    SET ORDER_COUNT = coalesce(ORDER_COUNT, 0) + 1
    WHERE ID = NEW.CUSTOMER_ID; -- ORDER
    -- NEW.AMOUNT, NEW.ID
END;
// 
DELIMITER ;