INSERT INTO TB_CATEGORY (name, description, created_at) VALUES('Eletrônicos', 'Produtos de informática',current_timestamp);
INSERT INTO TB_CATEGORY (name, description, created_at) VALUES('Livros', 'Livros de programação',current_timestamp);
INSERT INTO TB_CATEGORY (name, description, created_at) VALUES('Computadores', 'Computadores de mesa',current_timestamp);
INSERT INTO TB_CATEGORY (name, description, created_at) VALUES('Periféricos', 'Mouse, teclado, monitor',current_timestamp);
INSERT INTO TB_CATEGORY (name, description, created_at) VALUES('Jogos', 'Jogos de vídeo game',current_timestamp);
INSERT INTO TB_CATEGORY (name, description, created_at) VALUES('Celulares', 'Celulares e smartphones',current_timestamp);
INSERT INTO TB_CATEGORY (name, description, created_at) VALUES('Câmeras', 'Câmeras fotográficas',current_timestamp);
INSERT INTO TB_CATEGORY (name, description, created_at) VALUES('Acessórios', 'Acessórios para celulares',current_timestamp);
INSERT INTO TB_CATEGORY (name, description, created_at) VALUES('Tablets', 'Tablets e iPads',current_timestamp);
INSERT INTO TB_CATEGORY (name, description, created_at) VALUES('Eletrodomésticos', 'Eletrodomésticos',current_timestamp);
INSERT INTO TB_CATEGORY (name, description, created_at) VALUES('Móveis', 'Móveis para casa',current_timestamp);

INSERT INTO TB_SUPPLIER (name) VALUES('Fornecedor 1');
INSERT INTO TB_SUPPLIER (name) VALUES('Fornecedor 2');
INSERT INTO TB_SUPPLIER (name) VALUES('Fornecedor 3');
INSERT INTO TB_SUPPLIER (name) VALUES('Fornecedor 4');
INSERT INTO TB_SUPPLIER (name) VALUES('Fornecedor 5');
INSERT INTO TB_SUPPLIER (name) VALUES('Fornecedor 6');
INSERT INTO TB_SUPPLIER (name) VALUES('Fornecedor 7');
INSERT INTO TB_SUPPLIER (name) VALUES('Fornecedor 8');
INSERT INTO TB_SUPPLIER (name) VALUES('Fornecedor 9');
INSERT INTO TB_SUPPLIER (name) VALUES('Fornecedor 10');

INSERT INTO TB_PRODUCT (name, description, price,quantity,fk_category,fk_supplier) VALUES('Computador', 'Computador Dell', 2000.00, 10, 3, 1);
INSERT INTO TB_PRODUCT (name, description, price,quantity,fk_category,fk_supplier) VALUES('Mouse', 'Mouse sem fio', 80.00, 20, 4, 2);
INSERT INTO TB_PRODUCT (name, description, price,quantity,fk_category,fk_supplier) VALUES('HD Externo', 'HD Externo 1TB', 180.00, 15, 4, 3);
INSERT INTO TB_PRODUCT (name, description, price,quantity,fk_category,fk_supplier) VALUES('Notebook', 'Notebook Lenovo', 3500.00, 5, 3, 4);
INSERT INTO TB_PRODUCT (name, description, price,quantity,fk_category,fk_supplier) VALUES('Impressora', 'Impressora HP Multifuncional', 450.00, 12, 4, 5);
INSERT INTO TB_PRODUCT (name, description, price,quantity,fk_category,fk_supplier) VALUES('Videogame', 'Videogame XBox One', 700.00, 2, 5, 6);
INSERT INTO TB_PRODUCT (name, description, price,quantity,fk_category,fk_supplier) VALUES('Smartphone', 'Smartphone Samsung', 1000.00, 18, 6, 7);
INSERT INTO TB_PRODUCT (name, description, price,quantity,fk_category,fk_supplier) VALUES('Tablet', 'Tablet Samsung', 1300.00, 7, 10, 8);
INSERT INTO TB_PRODUCT (name, description, price,quantity,fk_category,fk_supplier) VALUES('Câmera', 'Câmera Canon', 700.00, 3, 7, 9);
INSERT INTO TB_PRODUCT (name, description, price,quantity,fk_category,fk_supplier) VALUES('Microondas', 'Microondas LG', 500.00, 9, 11, 10);



