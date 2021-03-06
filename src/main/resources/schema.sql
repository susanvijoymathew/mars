CREATE TABLE Role(
    Id BIGINT NOT NULL AUTO_INCREMENT,
    Role varchar(10) NOT NULL UNIQUE,
    PRIMARY KEY(id)
);

CREATE TABLE User_Details(
    Id BIGINT NOT NULL AUTO_INCREMENT,
    Email_Address varchar(100) NOT NULL UNIQUE,
    First_Name varchar(100) NOT NULL,
    Last_Name varchar(50) NOT NULL,
    Role_Id BIGINT NOT NULL,
    Active VARCHAR(1) NOT NULL DEFAULT 'Y',
    PRIMARY KEY(id)
);

CREATE TABLE Area(
    Id BIGINT NOT NULL AUTO_INCREMENT,
    Name VARCHAR(50) NOT NULL,
    Type VARCHAR(15) NOT NULL,
    Level INT NOT NULL,
    Parent_Id BIGINT,
    PRIMARY KEY(id)
);

CREATE TABLE Product(
    Id BIGINT NOT NULL AUTO_INCREMENT,
    Name VARCHAR(50) NOT NULL,
    Category VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE Promotion(
    Id BIGINT NOT NULL AUTO_INCREMENT,
    Name VARCHAR(50) NOT NULL,
    Description VARCHAR(100),
    Area_Id BIGINT NOT NULL,
    Product_Id BIGINT NOT NULL,
    Start_Date DATE NOT NULL,
    End_Date DATE NOT NULL,
    Modified_Date DATE NOT NULL,
    Modified_User_Id BIGINT NOT NULL,
    PRIMARY KEY(id)
);

ALTER TABLE User_Details ADD FOREIGN KEY (Role_Id) REFERENCES Role(Id);
ALTER TABLE User_Details ADD CONSTRAINT UserActive CHECK(Active IN ('N', 'Y'));
ALTER TABLE Area ADD FOREIGN KEY (Parent_Id) REFERENCES Area(Id);
ALTER TABLE Promotion ADD FOREIGN KEY (Area_Id) REFERENCES Area(Id);
ALTER TABLE Promotion ADD FOREIGN KEY (Product_Id) REFERENCES Product(Id);
ALTER TABLE Promotion ADD FOREIGN KEY (Modified_User_Id) REFERENCES User_Details(Id);
