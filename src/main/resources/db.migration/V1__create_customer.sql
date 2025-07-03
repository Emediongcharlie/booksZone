CREATE TABLE customer (
                        id SERIAL PRIMARY KEY,
                        first_name VARCHAR(50) NOT NULL,
                        last_name VARCHAR(50) NOT NULL,
                        email VARCHAR(50) UNIQUE NOT NULL,
                        password VARCHAR(50) NOT NULL,
                        phone_number VARCHAR(11),

                        customer_id INTEGER,
                        CONSTRAINT fk_seller
                            FOREIGN KEY (customer_id)
                                REFERENCES seller(id)
                                ON DELETE SET NULL
);