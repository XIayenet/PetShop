IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'PetShop')
BEGIN
  CREATE DATABASE PetShop;
END;
GO

USE PetShop;

CREATE TABLE [User] (
    UserID INT PRIMARY KEY IDENTITY(1,1),
    Username NVARCHAR(50) UNIQUE NOT NULL,
    Pass NVARCHAR(255) NOT NULL, 
    Role NVARCHAR(20) NOT NULL CHECK (Role IN ('Customer', 'Manager')),
    CreatedAt DATETIME DEFAULT GETDATE()
);

-- Create Customer Table (Linked to User)
CREATE TABLE Customer (
    CustomerID INT PRIMARY KEY IDENTITY(1,1),
    UserID INT UNIQUE,  -- One-to-one link to User table
    FirstName NVARCHAR(50) NOT NULL,
    LastName NVARCHAR(50),
    PhoneNumber NVARCHAR(15),
    Email NVARCHAR(100),
    Address NVARCHAR(255),
    FOREIGN KEY (UserID) REFERENCES [User](UserID)
);

CREATE TABLE Product (
    ProductID INT PRIMARY KEY IDENTITY(1,1),
    ProductName NVARCHAR(100) NOT NULL,
    Description NVARCHAR(255),
    Price DECIMAL(10, 2) NOT NULL,
    StockQuantity INT NOT NULL
);

CREATE TABLE Service (
    ServiceID INT PRIMARY KEY IDENTITY(1,1),
    ServiceName NVARCHAR(100) NOT NULL, -- e.g., Grooming, Training
    Description NVARCHAR(255),
    Price DECIMAL(10, 2) NOT NULL
);

CREATE TABLE Sale (
    SaleID INT PRIMARY KEY IDENTITY(1,1),
    CustomerID INT NOT NULL,
    ProductID INT,
	ServiceID INT,
    SaleDate DATETIME NOT NULL,
    Quantity INT,
    TotalPrice DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),
    FOREIGN KEY (ProductID) REFERENCES Product(ProductID),
	FOREIGN KEY (ServiceID) REFERENCES Service(ServiceID)
);

CREATE TABLE Tag (
    TagID INT PRIMARY KEY IDENTITY(1,1),
    TagName NVARCHAR(50) UNIQUE NOT NULL,
    Description NVARCHAR(255),
    ParentTagID INT NULL, -- For hierarchical tags (e.g., "Dog Food" to "Dry Dog Food")
    UsageCount INT DEFAULT 0, -- Track popularity for auto-suggestions
    FOREIGN KEY (ParentTagID) REFERENCES Tag(TagID)
);

CREATE TABLE ProductTag (
    ProductID INT NOT NULL,
    TagID INT NOT NULL,
    PRIMARY KEY (ProductID, TagID),
    FOREIGN KEY (ProductID) REFERENCES Product(ProductID),
    FOREIGN KEY (TagID) REFERENCES Tag(TagID)
);

