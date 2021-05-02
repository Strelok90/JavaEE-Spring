

CREATE TABLE product (id bigserial PRIMARY KEY , title VARCHAR(255),description VARCHAR(255), price int);

INSERT INTO product (title, description, price) values
('MacBook', 'Power', 3000),
('iPhone', 'Very best', 1000),
('iPad', 'More size', 2000)
