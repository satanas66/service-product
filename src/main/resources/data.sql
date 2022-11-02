CREATE TABLE tbl_product_detail (id BIGINT AUTO_INCREMENT  PRIMARY KEY, name VARCHAR(250), price DOUBLE, availability BIT);

INSERT INTO tbl_product_detail (id, name, price, availability) VALUES ('1', 'Boligrafo negro', '1.0', TRUE);
INSERT INTO tbl_product_detail (id, name, price, availability) VALUES ('2', 'Boligrafos azul', '1.0', TRUE);
INSERT INTO tbl_product_detail (id, name, price, availability) VALUES ('3', 'Boligrafos rojo', '1.0', TRUE);