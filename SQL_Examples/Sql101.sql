CREATE TABLE CUSTOMER(
   CUSTOMERID NUMERIC NOT NULL ,
   CUSTOMERNAME VARCHAR(30),
   CUSTOMEREMAIL VARCHAR(30),
   HANDPHONE NUMERIC,
   PRIMARY KEY ( CUSTOMERID )
   );
   
 ----------------------
   
Select * from gpant.CUSTOMER;

CREATE PROCEDURE gpant.updatePhoneNumber(p_customerId numeric , p_phoneNumber numeric)
   BEGIN
   update customer set handPhone= p_phoneNumber where customerId = p_customerId;
   END 
   
DROP PROCEDURE gpant.updatePhoneNumber
   
CALL gpant.updatePhoneNumber(875,12345);

----------------------------------------

CREATE table gpant.VERIFYUSER (
    userName  VARCHAR(16) NOT NULL,
    passWord  VARCHAR(16) NOT NULL,
    roll VARCHAR(20),
    Primary key (userName)
);

INSERT INTO gpant.VERIFYUSER values("Gaurav","pant","Intern");