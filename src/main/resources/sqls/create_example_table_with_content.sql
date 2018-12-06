INSERT INTO users(login, password,role)
VALUES ('ramon','ramon','ADMIN') ;

INSERT INTO users(login, password,role)
VALUES ('emil','emil','ADMIN') ;

INSERT INTO locations(city,street,post_code,phone_number)
VALUES ('Poznan','Ulica','0','123123123');

INSERT INTO shops(name, owner_name)
VALUES ('Bookstore','ramon');

INSERT INTO platforms(name, status, shop_id, location_id)
VALUES ('Main Platform','active',1,1);

INSERT INTO currencies
VALUES (1, 'złoty', 'PLN', 1.0);

INSERT INTO categories(name,description)
VALUES ('Belles-lettres','');

INSERT INTO categories(name,description)
VALUES ('Psychological','');

INSERT INTO categories(name,description)
VALUES ('Fantasy','');

INSERT INTO products(name, unit, producent, stock, status, price, description,currency_id,platform_id,category_id)
VALUES ('Murakami - Norwegian Wood', 'szt', 'Book Publisher', 20, '1', 1.0, '1',1,1,1);

INSERT INTO products(name, unit, producent, stock, status, price, description,currency_id,platform_id,category_id)
VALUES ('Dostoevsky - Brothers Karamazhow', 'kg', 'Book Publisher', 20, '1', 1.0, '1',1,1,2);

INSERT INTO products(name, unit, producent, stock, status, price, description,currency_id,platform_id,category_id)
VALUES ('Dostoevsky - Idiot', 'szt', 'Book Publisher', 20, '1', 1.0, '1',1,1,2);

INSERT INTO products(name, unit, producent, stock, status, price, description,currency_id,platform_id,category_id)
VALUES ('Dick - Blade Runner', 'szt', 'Book Publisher', 20, '1', 1.0, '1',1,1,3);
