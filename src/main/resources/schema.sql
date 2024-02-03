CREATE TABLE IF NOT EXISTS restaurants (
  id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name varchar(255) DEFAULT NULL,
  image_name VARCHAR(255),
  description text DEFAULT NULL,
  low_price int(11) DEFAULT NULL,
  high_price int(11) DEFAULT NULL,
  postal_code varchar(50) DEFAULT NULL,
  address varchar(255) DEFAULT NULL,
  opening_time time DEFAULT NULL,
  closed_time time DEFAULT NULL,
  seating_capacity int(11) DEFAULT NULL,
  created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
