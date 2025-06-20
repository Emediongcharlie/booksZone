CREATE TABLE seller (
                        id SERIAL PRIMARY KEY,
                        first_name VARCHAR(50) NOT NULL,
                        last_name VARCHAR(50) NOT NULL,
                        email VARCHAR(50) UNIQUE NOT NULL,
                        password VARCHAR(50) NOT NULL,
                        phone_number VARCHAR(11),
                        book_shop_name VARCHAR(50),
                        payment_status VARCHAR(50),

                        customer_id INTEGER,
                        CONSTRAINT fk_customer
                            FOREIGN KEY (customer_id)
                                REFERENCES customer(id)
                                ON DELETE SET NULL
);