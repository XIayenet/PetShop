IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'PetShop')
BEGIN
  CREATE DATABASE PetShop;
END;
GO

USE PetShop;

CREATE TABLE [User] (
    UserID INT PRIMARY KEY IDENTITY(1,1),
    Email NVARCHAR(50) UNIQUE NOT NULL,
    Pass NVARCHAR(255) NOT NULL, 
    Role NVARCHAR(20) NOT NULL CHECK (Role IN ('Customer', 'Manager')),
    CreatedAt DATETIME DEFAULT GETDATE(),
	State NVARCHAR(20) NOT NULL CHECK (State in ('Verified', 'Unverified'))
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
    StockQuantity INT NOT NULL,
	Image NVARCHAR(50)
);

CREATE TABLE Service (
    ServiceID INT PRIMARY KEY IDENTITY(1,1),
    ServiceName NVARCHAR(100) NOT NULL, -- e.g., Grooming, Training
    Description NVARCHAR(255),
    Price DECIMAL(10, 2) NOT NULL,
	Image NVARCHAR(50)
);

CREATE TABLE Sale (
    SaleID INT PRIMARY KEY IDENTITY(1,1),
    CustomerID INT NOT NULL,
    SaleDate DATETIME NOT NULL,
    TotalPrice DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)
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



-- Junction table for Products in a Sale
CREATE TABLE SaleProduct (
    SaleID INT NOT NULL,
    ProductID INT NOT NULL,
    Quantity INT NOT NULL CHECK (Quantity > 0), -- Products can have multiple quantities
    PRIMARY KEY (SaleID, ProductID),
    FOREIGN KEY (SaleID) REFERENCES Sale(SaleID),
    FOREIGN KEY (ProductID) REFERENCES Product(ProductID)
);

-- Junction table for Services in a Sale
CREATE TABLE SaleService (
    SaleID INT NOT NULL,
    ServiceID INT NOT NULL,
    Quantity INT NOT NULL CHECK (Quantity = 1), -- Services are added once per sale
    PRIMARY KEY (SaleID, ServiceID),
    FOREIGN KEY (SaleID) REFERENCES Sale(SaleID),
    FOREIGN KEY (ServiceID) REFERENCES Service(ServiceID)
);