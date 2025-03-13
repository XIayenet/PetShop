INSERT INTO Tag (TagName, Description, ParentTagID, UsageCount) VALUES
('Pet Food', 'Food for pets', NULL, 0),
('Dog Food', 'Food specifically for dogs', 1, 0),
('Cat Food', 'Food specifically for cats', 1, 0),
('Toys', 'Pet toys', NULL, 0),
('Dog Toys', 'Toys for dogs', 4, 0),
('Cat Toys', 'Toys for cats', 4, 0);

INSERT INTO Product (ProductName, Description, Price, StockQuantity, Image) VALUES
('Premium Dog Food', 'High-quality food for dogs', 20.00, 100, 'https://i.ibb.co/r2vSS6BT/item12.jpg'),
('Feline Delight Cat Food', 'Special cat food', 15.00, 50, 'https://i.ibb.co/8qg64vN/item13.jpg'),
('Squeaky Dog Toy', 'Fun toy for dogs', 5.00, 200, 'https://i.ibb.co/tPYjvkPR/blog-lg1.jpg'),
('Feather Cat Toy', 'Toy for cats', 3.00, 150, 'https://i.ibb.co/gFPx4MBk/item5.jpg');

INSERT INTO ProductTag (ProductID, TagID) VALUES
(1, 2), -- Premium Dog Food has Dog Food tag
(1, 1), -- also has Pet Food tag
(2, 3), -- Feline Delight Cat Food has Cat Food tag
(2, 1), -- also has Pet Food tag
(3, 5), -- Squeaky Dog Toy has Dog Toys tag
(3, 4), -- also has Toys tag
(4, 6), -- Feather Cat Toy has Cat Toys tag
(4, 4); -- also has Toys tag