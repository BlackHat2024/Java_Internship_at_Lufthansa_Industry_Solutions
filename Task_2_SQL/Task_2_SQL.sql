/*Query 1*/

SELECT sub.a,MAX(sub.b) 
FROM (
SELECT c.customerName AS a ,COUNT(o.orderNumber) AS b 
FROM (customers AS c 
INNER JOIN orders AS o 
ON c.customerNumber=o.customerNumber) 
GROUP BY c.customerNumber
ORDER BY b DESC) AS sub;


/*Query 2*/

SELECT c.customerName,od.* 
FROM customers AS c  
INNER JOIN orders AS o 
INNER JOIN orderdetails AS od 
ON c.customerNumber=o.customerNumber 
AND o.orderNumber=od.orderNumber 
AND c.country="Germany" ;


/*Query 3*/

SELECT e.firstName, e.lastName , SUM(p.amount) 
FROM((employees AS e 
INNER JOIN customers AS c 
ON e.employeeNumber=c.salesRepEmployeeNumber )
INNER JOIN payments AS p 
ON c.customerNumber=p.customerNumber )
GROUP BY e.employeeNumber;


/*Query 4*/

SELECT p.productName , o.orderdate 
FROM ((products AS p 
INNER JOIN orderdetails AS od 
ON p.productCode=od.productCode)
INNER JOIN  orders AS o 
ON od.orderNumber=o.orderNumber ) 
WHERE o.orderDate 
BETWEEN '2004-12-01' AND '2004-12-31';


/*Query 5*/

DROP TABLE employeedetails;

CREATE TABLE employeedetails (
	employeeNumber INT,
	bankAccount VARCHAR(50) NOT NULL,
	address VARCHAR(50) NOT NULL,
	phoneNumber INT NOT NULL,
	personalEmail VARCHAR(50) NOT NULL,
    PRIMARY KEY(bankAccount),
    CONSTRAINT FK_employeeNumber FOREIGN KEY (employeeNumber)
    REFERENCES employees(employeeNumber)
    );

INSERT INTO employeedetails (employeeNumber,bankAccount, address, phoneNumber, personalEmail)
VALUES ((SELECT employeeNumber FROM employees WHERE employeeNumber=1002),'AL02394029', 'Tirane', '06952554', 'dm2024@gmail.com');

SELECT * FROM employeedetails;