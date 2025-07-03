CREATE TABLE products (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          product_name VARCHAR(255) NOT NULL,
                          product_description VARCHAR(255) NOT NULL,
                          product_price INT,
                          product_quantity INT NOT NULL,
                          book_shop_name VARCHAR(255) NOT NULL,
                          authors_name VARCHAR(255)
);
