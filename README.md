# api-performance-demo

```
DB-SCHEMA

CREATE TABLE `category` (
  `id` bigint PRIMARY KEY,
  `name` varchar(255),
  `type` varchar(255),
  `status` varchar(255)
);

CREATE TABLE `products` (
  `id` bigint PRIMARY KEY,
  `category_id` bigint,
  `name` varchar(255),
  `description` text,
  `status` varchar(255)
);

CREATE TABLE `price` (
  `id` bigint PRIMARY KEY,
  `product_id` bigint,
  `price` double,
  `valid_from` timestamp,
  `valid_to` timestamp,
  `status` varchar(255)
);

CREATE TABLE `inventory` (
  `id` bigint PRIMARY KEY,
  `product_id` bigint,
  `warehouse_id` bigint,
  `available_quantity` integer,
  `reserved_quantity` integer,
  `status` varchar(255)
);

ALTER TABLE `inventory` ADD FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);

ALTER TABLE `products` ADD FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

ALTER TABLE `price` ADD FOREIGN KEY (`product_id`) REFERENCES `products` (`id`);


-- Insert data into category table
INSERT INTO `category` (`id`, `name`, `type`, `status`) VALUES
(1, 'Electronics', 'Goods', 'active'),
(2, 'Clothing', 'Goods', 'active'),
(3, 'Home Appliances', 'Goods', 'active');

-- Insert data into products table
INSERT INTO `products` (`id`, `category_id`, `name`, `description`, `status`) VALUES
(1, 1, 'Smartphone', 'Latest smartphone with high-speed performance', 'active'),
(2, 1, 'Laptop', '15-inch laptop with 8GB RAM, 256GB SSD', 'active'),
(3, 2, 'Jacket', 'Waterproof jacket for outdoor activities', 'active'),
(4, 3, 'Air Conditioner', '1.5 ton AC with energy-efficient cooling', 'active');

-- Insert data into price table
INSERT INTO `price` (`id`, `product_id`, `price`, `valid_from`, `valid_to`, `status`) VALUES
(1, 1, 699.99, NOW(), DATE_ADD(NOW(), INTERVAL 1 YEAR), 'active'),
(2, 2, 1299.99, NOW(), DATE_ADD(NOW(), INTERVAL 1 YEAR), 'active'),
(3, 3, 59.99, NOW(), DATE_ADD(NOW(), INTERVAL 1 YEAR), 'active'),
(4, 4, 299.99, NOW(), DATE_ADD(NOW(), INTERVAL 1 YEAR), 'active');

-- Insert data into inventory table
INSERT INTO `inventory` (`id`, `product_id`, `warehouse_id`, `available_quantity`, `reserved_quantity`, `status`) VALUES
(1, 1, 1, 100, 10, 'available'),
(2, 2, 1, 50, 5, 'available'),
(3, 3, 2, 200, 20, 'available'),
(4, 4, 3, 30, 2, 'available');


-- fetch data from table
SELECT * from products p ;

SELECT * FROM category c ;

SELECT * FROM inventory i ;

SELECT * FROM price p ;
```
