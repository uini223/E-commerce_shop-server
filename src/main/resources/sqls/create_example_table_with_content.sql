INSERT INTO users(login, password,role)
VALUES ('ramon','ramon','ADMIN') ;

INSERT INTO users(login, password,role)
VALUES ('emil','emil','ADMIN') ;

INSERT INTO locations(city,street,post_code,phone_number)
VALUES ('dupsko','dupna','0','123123123');

INSERT INTO shops(name, owner_name)
VALUES ('gowny sklep','ramon');

INSERT INTO platforms(name, status, shop_id, location_id)
VALUES ('dupa_platform','active',1,1);

INSERT INTO currencies
VALUES (1, 'złoty', 'PLN', 1.0);

INSERT INTO categories(name,description)
VALUES ('gowna','gunfo');

INSERT INTO categories(name,description)
VALUES ('nie guwna','fajna nazwa kategorii');

INSERT INTO products(name, unit, producent, stock, status, price, description,currency_id,platform_id,category_id)
VALUES ('dupa', 'kg', 'Dupsko', 20, '1', 1.0, '1',1,1,1);

INSERT INTO products(name, unit, producent, stock, status, price, description,currency_id,platform_id,category_id)
VALUES ('test', 'kg', 'Dupsko', 20, '1', 1.0, '1',1,1,1);

INSERT INTO products(name, unit, producent, stock, status, price, description,currency_id,platform_id,category_id)
VALUES ('karta', 'kg', 'Dupsko', 20, '1', 1.0, '1',1,1,1);

INSERT INTO products(name, unit, producent, stock, status, price, description,currency_id,platform_id,category_id)
VALUES ('emil ma dużego :)', 'kg', 'Dupsko', 20, '1', 1.0, '1',1,1,2);
