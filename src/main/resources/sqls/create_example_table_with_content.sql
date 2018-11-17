-- create table example_users(
--   id bigserial primary key,
--   name varchar(30) not null
-- );
-- insert into example_users(name)
--     values ('emil');
-- insert into example_users(name)
--     values ('ramon');

INSERT INTO users(login, password,role,customer_id)
VALUES ('ramon','ramon','ADMIN',null) ;

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

INSERT INTO products(name, unit, producent, stock, status, price, description,currency_id,platform_id,category_id)
VALUES ('dupa', 'kg', 'Dupsko', 20, '1', 1.0, '1',1,1,1);

INSERT INTO products(name, unit, producent, stock, status, price, description,currency_id,platform_id,category_id)
VALUES ('test', 'kg', 'Dupsko', 20, '1', 1.0, '1',1,1,1);

INSERT INTO products(name, unit, producent, stock, status, price, description,currency_id,platform_id,category_id)
VALUES ('karta', 'kg', 'Dupsko', 20, '1', 1.0, '1',1,1,1);

INSERT INTO products(name, unit, producent, stock, status, price, description,currency_id,platform_id,category_id)
VALUES ('emil ma małego', 'kg', 'Dupsko', 20, '1', 1.0, '1',1,1,1);
