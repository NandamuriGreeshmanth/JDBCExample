DELIMITER //

CREATE PROCEDURE insert_employee(
    IN name VARCHAR(100),
    IN dept VARCHAR(100),
    IN desig VARCHAR(100),
    IN email VARCHAR(100),
    IN salary DOUBLE
)
BEGIN
    INSERT INTO employee (name, dept, designation, email, salary)
    VALUES (name, dept, desig, email, salary);
END //

DELIMITER ;